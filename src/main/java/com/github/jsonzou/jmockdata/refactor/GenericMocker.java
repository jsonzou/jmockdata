package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericMocker implements Mocker<Object> {

  private final ParameterizedType type;

  public GenericMocker(ParameterizedType type) {
    this.type = type;
  }

  @Override
  public Object mock(MockConfig mockConfig) {
    Type rawType = type.getRawType();
    Type[] argumentTypes = type.getActualTypeArguments();
    return new BaseMocker(rawType, argumentTypes).mock(mockConfig);
  }
}
