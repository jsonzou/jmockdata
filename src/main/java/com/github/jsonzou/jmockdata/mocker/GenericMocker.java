package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 模拟泛型
 */
public class GenericMocker implements Mocker<Object> {

  private ParameterizedType type;

  GenericMocker(ParameterizedType type) {
    this.type = type;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    Type rawType = type.getRawType();
    Type[] argumentTypes = type.getActualTypeArguments();
    return new BaseMocker(rawType, argumentTypes).mock(mockConfig);
  }
}
