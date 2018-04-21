package com.github.jsonzou.jmockdata;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T> {

  private final Type type;

  public TypeReference() {
    Type superClass = getClass().getGenericSuperclass();
    if (superClass instanceof Class) {
      throw new MockException("不支持的类型或者检查参数是否已经添加{},eg: JMockData.mock(new TypeReference<Integer>(){})");
    }
    type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
  }

  public Type getType() {
    return type;
  }

}
