package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import java.lang.reflect.Array;
import org.apache.commons.lang3.RandomUtils;

/**
 * 数组模拟器
 */
public class ArrayMocker implements Mocker<Object> {

  private final Class<?> componentClass;

  ArrayMocker(Class<?> clazz) {
    this.componentClass = clazz;
  }
  @Override
  public Object mockData(final MockConfig mockConfig) throws Exception {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
    Object result = Array.newInstance(componentClass, size);
    for (int index = 0; index < size; index++) {
      Object value = JMock.mockData(componentClass);
      Array.set(result, index, value);
    }
    return result;
  }

}
