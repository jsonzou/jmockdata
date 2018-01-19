package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

/**
 * 数组模拟器
 */
@SuppressWarnings("unchecked")
public class ArrayMocker implements Mocker<Object> {

  private Class<?> clazz;

  private Type componentType;

  public ArrayMocker(Class<?> clazz, Type componentType) {
    this.clazz = clazz;
    this.componentType = componentType;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    int size = RandomUtils.nextSize(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1]);
    Object result = Array.newInstance(clazz, size);
    for (int index = 0; index < size; index++) {
      Array.set(result, index, new GenericMocker(componentType).mock(mockConfig));
    }
    return result;
  }

}
