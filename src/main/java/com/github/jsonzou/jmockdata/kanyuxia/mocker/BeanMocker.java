package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import com.github.jsonzou.jmockdata.kanyuxia.MockerManager;
import com.github.jsonzou.jmockdata.kanyuxia.utils.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Bean模拟器
 */
@SuppressWarnings("unchecked")
public class BeanMocker<T> implements Mocker<T> {

  private final Class<?> clazz;

  private final Type[] genericTypes;

  public BeanMocker(final Class<?> clazz, final Type... genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
  }

  @Override
  public T mockData(final MockConfig mockConfig) throws Exception {
    if (clazz.isArray()) {
      return (T) new ArrayMocker(clazz.getComponentType()).mockData(mockConfig);
    }
    if (Map.class.isAssignableFrom(clazz)) {
      return (T) new MapMocker(genericTypes).mockData(mockConfig);
    }
    if (List.class.isAssignableFrom(clazz)) {
      return (T) new ListMocker(genericTypes[0]).mockData(mockConfig);
    }
    if (Set.class.isAssignableFrom(clazz)) {
      return (T) new SetMocker(genericTypes[0]).mockData(mockConfig);
    }
    // 从缓存中取已经构造的Bean
    Map<String, Object> beanCache = mockConfig.getBeanCache();
    if (beanCache.containsKey(clazz.getName())) {
      return (T) beanCache.get(clazz.getName());
    }
    // 模拟Bean
    return mockBean(mockConfig);
  }

  private T mockBean(MockConfig mockConfig) throws Exception {
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
          Type[] types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
          Mocker mocker = MockerManager.getMocker(fieldClass);
          if (mocker == null) {
            mocker = new BeanMocker(fieldClass, types);
          }
          value = mocker.mockData(mockConfig);
        } else {
          value = JMock.mockData(fieldClass, mockConfig);
        }
        ReflectionUtils.setRefValue(result, method, value);
      }
    }
    return result;
  }
}
