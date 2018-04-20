package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import com.github.jsonzou.jmockdata.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map.Entry;

public class BeanMocker implements Mocker<Object> {

  private final Class clazz;

  BeanMocker(Class clazz) {
    this.clazz = clazz;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    try {
      // fixme 解决方案不够优雅
      if (mockConfig.isEnabledCircle()) {
        Object cacheBean = mockConfig.getcacheBean(clazz.getName());
        if (cacheBean != null) {
          return cacheBean;
        }
      }
      Object result = clazz.newInstance();
      mockConfig.cacheBean(clazz.getName(), result);
      for (Class<?> currentClass = clazz; currentClass != Object.class; currentClass = currentClass.getSuperclass()) {
        // 模拟有setter方法的字段
        for (Entry<Field, Method> entry : ReflectionUtils.fieldAndSetterMethod(currentClass).entrySet()) {
          Field field = entry.getKey();
          if (field.isAnnotationPresent(MockIgnore.class)) {
            continue;
          }
          ReflectionUtils
              .setRefValue(result, entry.getValue(), new BaseMocker(field.getGenericType()).mock(mockConfig));
        }
      }
      return result;
    } catch (Exception e) {
      throw new MockException(e);
    }
  }

}
