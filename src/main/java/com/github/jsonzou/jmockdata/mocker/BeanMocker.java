package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.MockerManager;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;
import java.lang.reflect.Field;
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

  public BeanMocker(final Class<?> clazz, final Type... genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
  }

  @Override
  public T mock(MockConfig mockConfig) {
    if (clazz.isArray()) {
      return (T) new ArrayMocker(clazz.getComponentType()).mock(mockConfig);
    } else if (Map.class.isAssignableFrom(clazz)) {
      return (T) new MapMocker(genericTypes).mock(mockConfig);
    } else if (Collection.class.isAssignableFrom(clazz)) {
      return (T) new CollectionMocker(clazz, genericTypes[0]).mock(mockConfig);
    }
    // 从缓存中取已经构造的Bean
    Map<String, Object> beanCache = mockConfig.getBeanCache();
    if (beanCache.containsKey(clazz.getName())) {
      return (T) beanCache.get(clazz.getName());
    }
    // 模拟Bean
    return mockBean(mockConfig);
  }

  private T mockBean(MockConfig mockConfig) {
    try {
      // 构造Bean
      T result = (T) clazz.newInstance();
      Map<String, Object> beanCache = mockConfig.getBeanCache();
      beanCache.put(clazz.getName(), result);
      // 从子对象向上依次模拟
      for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
        // 模拟有setter方法的字段
        for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
          Field field = entry.getKey();
          Method method = entry.getValue();
          Class<?> fieldClass = field.getType();
          Object value;
          // 判断是否有泛型参数
          if (ReflectionUtils.hasGeneric(fieldClass)) {
            // 模拟有泛型的数据
            Mocker mocker = MockerManager.getMocker(fieldClass);
            if (mocker == null) {
              mocker = new BeanMocker(fieldClass, ((ParameterizedType) field.getGenericType()).getActualTypeArguments());
            }
            value = mocker.mock(mockConfig);
          } else {
            value = JMockData.mock(fieldClass, mockConfig);
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
