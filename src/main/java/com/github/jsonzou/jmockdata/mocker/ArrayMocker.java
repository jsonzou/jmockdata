package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Array;

/**
 * 数组模拟器
 */
public class ArrayMocker implements Mocker<Object> {

  private Class<?> componentClass;

  ArrayMocker(Class<?> clazz) {
    this.componentClass = clazz;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    Object result = Array.newInstance(componentClass, size);
    for (int index = 0; index < size; index++) {
      Object value = JMockData.mock(componentClass, mockConfig);
      Array.set(result, index, value);
    }
    return result;
  }

}
