package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import java.lang.reflect.Array;
import org.apache.commons.lang3.RandomUtils;

/**
 * 数组模拟器
 */
public class ArrayMocker extends BaseMocker<Object> {

  private final Class<?> componentClass;

  ArrayMocker(Class<?> clazz) {
    this.componentClass = clazz;
  }

  public Object mockData() throws Exception {
    int size = RandomUtils.nextInt(config.getSizeRange()[0], config.getSizeRange()[1]);
    Object result = Array.newInstance(componentClass, size);
    for (int index = 0; index < size; index++) {
      Object value = JMock.mockData(componentClass);
      Array.set(result, index, value);
    }
    return result;
  }

}
