package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map.Entry;

public class BeanMocker implements Mocker<Object> {

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
    for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
      // 模拟有setter方法的字段
      for (Field field :currentClass.getDeclaredFields()) {
        if (field.isAnnotationPresent(MockIgnore.class)) {
          continue;
        }
        /**
         * 是否配置排除这个属性
         */
        if(mockConfig.globalConfig().isConfigExcludeMock(clazz,field.getName())){
          continue;
        }
        ReflectionUtils.setFieldValue(result, field, new BaseMocker(field.getGenericType()).mock(mockConfig.globalConfig().getDataConfig(currentClass,field.getName())));
      }
    }
  }

  /**
   * 内省设置属性值
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
