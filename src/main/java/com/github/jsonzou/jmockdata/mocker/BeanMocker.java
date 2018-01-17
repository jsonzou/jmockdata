package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Bean模拟器
 */
@SuppressWarnings("unchecked")
public class BeanMocker<T> implements Mocker<T> {

  private Class<?> clazz;

  private Type[] genericTypes;

  public BeanMocker(Class<?> clazz, Type... genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
  }

  @Override
  public T mock(MockConfig mockConfig) {
    if (clazz.isArray()) {
      return (T) new ArrayMocker(clazz, genericTypes.length == 0 ? clazz.getComponentType() : genericTypes[0]).mock(mockConfig);
    } else if (Map.class.isAssignableFrom(clazz)) {
      return (T) new MapMocker(genericTypes).mock(mockConfig);
    } else if (Collection.class.isAssignableFrom(clazz)) {
      return (T) new CollectionMocker(clazz, genericTypes[0]).mock(mockConfig);
    }
    // 从缓存中取已经构造的Bean
    Object cacheBean = mockConfig.getCacheObject(clazz.getName());
    return cacheBean != null ? (T) cacheBean : mockBean(mockConfig);
  }

  private T mockBean(MockConfig mockConfig) {
    try {
      // 构造Bean
      T result = (T) clazz.newInstance();
      mockConfig.addCache(clazz.getName(), result);
      // 从子对象向上依次模拟
      for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
        // 模拟有setter方法的字段
        for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
          Field field = entry.getKey();
          Method method = entry.getValue();
          Class<?> fieldClass = field.getType();
          Object value;
          // 判断字段是否是Map or Collection
          if (Map.class.isAssignableFrom(fieldClass) || Collection.class.isAssignableFrom(fieldClass)) {
            Type[] types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
            Mocker mocker = new BeanMocker(fieldClass, types);
            value = mocker.mock(mockConfig);
            // 判断字段是否是数组
          } else if (fieldClass.isArray()) {
            Type componentType;
            Type type = field.getGenericType();
            // 字段是数组类型(一维数组)
            if (type instanceof GenericArrayType) {
              GenericArrayType arrayType = (GenericArrayType) type;
              componentType = arrayType.getGenericComponentType();
            } else {
              // 字段是多维数组
              componentType = ((Class) type).getComponentType();
            }
            value = new BeanMocker(fieldClass, componentType).mock(mockConfig);
          } else {
            value = JMockData.mock(fieldClass,mockConfig);
          }
          ReflectionUtils.setRefValue(result, method, value);
        }
      }
      return result;
    } catch (Exception e) {
      throw new MockException(e);
    }
  }
}
