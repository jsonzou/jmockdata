package com.github.jsonzou.jmockdata;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeReference<T> {

  private final Type type;

  public TypeReference() {
    Type superClass = getClass().getGenericSuperclass();
    type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
  }

  public Type getType() {
    return type;
  }

}