package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map.Entry;

public class BeanMocker implements Mocker<Object> {

  private final Class clazz;

  BeanMocker(Class clazz) {
    this.clazz = clazz;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    try {
      // 从缓存中取已经构造的Bean，解决循环依赖问题
      // TODO 2018/1/20 这里解决了循环依赖问题，但是又会出现新的问题, 如List<A>，其中List中的A对象全是相同的。
      Object cacheBean = mockConfig.getBeanCacheObject(clazz.getName());
      if (cacheBean != null) {
        return cacheBean;
      }
      Object result = clazz.newInstance();
      mockConfig.addBeanCache(clazz.getName(), result);
      for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
        // 模拟有setter方法的字段
        for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
          Field field = entry.getKey();
          Method method = entry.getValue();
          Type genericType = field.getGenericType();
          Object value = new BaseMocker(genericType).mock(mockConfig);
          ReflectionUtils.setRefValue(result, method, value);
        }
      }
      return result;
    } catch (Exception e) {
      throw new MockException(e);
    }
  }
}
