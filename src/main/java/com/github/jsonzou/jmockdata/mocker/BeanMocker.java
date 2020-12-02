package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.*;
import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class BeanMocker implements Mocker<Object> {
  private Map<Class<?>, List<Field>> classFieldCache = new ConcurrentHashMap<>((int)((float)32 / 0.75F + 1.0F));
  private final Class clazz;

  BeanMocker(Class clazz) {
    this.clazz = clazz;
  }

  @Override
  public Object mock(DataConfig mockConfig) {

    try {
      // fixme 解决方案不够优雅
      if (mockConfig.globalConfig().isEnabledCircle()) {
        Object cacheBean = mockConfig.globalConfig().getcacheBean(clazz.getName());
        if (cacheBean != null) {
          return cacheBean;
        }
      }
      Object result = clazz.newInstance();
      mockConfig.globalConfig().cacheBean(clazz.getName(), result);
      /**
       * 是否配置排除整个类
       */
      if(mockConfig.globalConfig().isConfigExcludeMock(clazz)){
        return result;
      }
      setFieldValueByFieldAccessible(mockConfig, result);
      return result;
    } catch (Exception e) {
      throw new MockException(e);
    }
  }

  /**
   * 反射设置属性值
   * @param mockConfig
   * @param result
   * @throws IllegalAccessException
   */
  private void setFieldValueByFieldAccessible(DataConfig mockConfig, Object result) throws IllegalAccessException{
    for (Class<?> currentClass = clazz; isSupportMock(currentClass); currentClass = currentClass.getSuperclass()) {
      // 通过反射设置field的值
      for (Field field : getMockFields(currentClass, mockConfig)) {
        DataConfig fieldDataMockConfig = mockConfig.globalConfig().getDataConfig(currentClass,field.getName());
        Object value = null;

        BeanMockerInterceptor bi = mockConfig.globalConfig().getBeanMockerInterceptor(clazz);
        boolean unset = false;
        if(bi == null){
            value = new BaseMocker(field.getGenericType()).mock(fieldDataMockConfig);
        }else{
            Object fieldValue = bi.mock(clazz, field, result, fieldDataMockConfig);
            if(fieldValue == null){
              unset = true;
            }else if(fieldValue instanceof InterceptType){
              InterceptType interceptType = (InterceptType)fieldValue;
              if(InterceptType.MOCK == interceptType){
                value = new BaseMocker(field.getGenericType()).mock(fieldDataMockConfig);
                unset = false;
              }else if(InterceptType.UNMOCK == interceptType){
                unset = true;
              }
            }else{
              value = fieldValue;
              unset = false;
            }

        }
       if(unset){
         continue;
       }
       ReflectionUtils.setFieldValue(result, field, value);
      }
    }
  }

  public List<Field> getMockFields(Class<?>clazz, DataConfig mockConfig){
    List<Field> fields = classFieldCache.get(clazz);
    if(fields == null){
      Field[] dfields = clazz.getDeclaredFields();
      int size = 5 + dfields.length + (dfields.length / 10);
      fields = new ArrayList<>(size);
      for (Field field : dfields) {
        if(!isSupportMock(mockConfig, field)){
          continue;
        }
        field.setAccessible(true);
        fields.add(field);
      }
      classFieldCache.put(clazz, fields);
    }
    return fields;
  }
  private boolean isSupportMock(Class<?>clazz){
    boolean unSupport = clazz == Object.class
            || clazz.isInterface()
            || clazz.isEnum()
            || clazz.isAnnotation()
            || Modifier.isAbstract(clazz.getModifiers())
            || Modifier.isProtected(clazz.getModifiers())
            || Modifier.isPrivate(clazz.getModifiers())
            || Modifier.isInterface(clazz.getModifiers())
            || Modifier.isTransient(clazz.getModifiers())
            || Modifier.isFinal(clazz.getModifiers())
            || Modifier.isNative(clazz.getModifiers())
            || Modifier.isFinal(clazz.getModifiers());

    return !unSupport;

  }
  private boolean isSupportMock(DataConfig mockConfig, Field field){
    if (field.isAnnotationPresent(MockIgnore.class)) {
      return false;
    }
    boolean isUnSuppotModifier = Modifier.isFinal(field.getModifiers())
            || Modifier.isNative(field.getModifiers())
            || Modifier.isVolatile(field.getModifiers())
            || Modifier.isInterface(field.getModifiers())
            || Modifier.isTransient(field.getModifiers())
            || field.isSynthetic();
    if (isUnSuppotModifier) {
      return false;
    }
    if (!mockConfig.globalConfig().isEnabledStatic() && Modifier.isStatic(field.getModifiers())) {
      return false;
    }
    if (!mockConfig.globalConfig().isEnabledPublic() && Modifier.isPublic(field.getModifiers())) {
      return false;
    }
    if (!mockConfig.globalConfig().isEnabledProtected() && Modifier.isProtected(field.getModifiers())) {
      return false;
    }
    if (!mockConfig.globalConfig().isEnabledPrivate() && Modifier.isPrivate(field.getModifiers())) {
      return false;
    }

    if (field.getName() != null && field.getName().equalsIgnoreCase("serialVersionUID")) {
      return false;
    }

    /**
     * 是否配置排除这个属性
     */
    if(mockConfig.globalConfig().isConfigExcludeMock(clazz,field.getName())){
      return false;
    }

    return true;

  }

  /**
   * 内省设置属性值 - 已弃用
   * 内省方式对于有返回值的setter方法不适用
   * 内省方式不适用于无读写方法的类的模拟
   * @param mockConfig
   * @param result
   * @throws IntrospectionException
   * @throws ReflectiveOperationException
   */
  @Deprecated
  private void setFieldValueByIntrospector(DataConfig mockConfig, Object result) throws IntrospectionException, ReflectiveOperationException {
    for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
      // 模拟有setter方法的字段
      for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
        Field field = entry.getKey();
        if (field.isAnnotationPresent(MockIgnore.class)) {
          continue;
        }
        
        if (field.getName() != null && field.getName().equalsIgnoreCase("serialVersionUID")) {
          continue;
        }
        
        /**
         * 是否配置排除这个属性
         */
        if(mockConfig.globalConfig().isConfigExcludeMock(clazz,field.getName())){
           continue;
        }
        ReflectionUtils
            .setRefValue(result, entry.getValue(), new BaseMocker(field.getGenericType()).mock(mockConfig.globalConfig().getDataConfig(currentClass,field.getName())));
      }
    }
  }

}
