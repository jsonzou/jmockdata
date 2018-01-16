package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 数组模拟器
 */
@SuppressWarnings("unchecked")
public class ArrayMocker implements Mocker<Object> {

  private Class<?> clazz;

  private Type componentType;

  ArrayMocker(Class<?> clazz, Type componentType) {
    this.clazz = clazz;
    this.componentType = componentType;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Object result = Array.newInstance(clazz.getComponentType(), size);
    for (int index = 0; index < size; index++) {
      Object value;
      // 数组元素是参数化类型，如Collection<E>
      if (componentType instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType) this.componentType;
        value = new BeanMocker((Class<?>) parameterizedType.getRawType(),
            parameterizedType.getActualTypeArguments()[0]).mock(mockConfig);
      } else {
        value = JMockData.mock((Class<?>) componentType);
      }
      Array.set(result, index, value);
    }
    return result;
  }

}
