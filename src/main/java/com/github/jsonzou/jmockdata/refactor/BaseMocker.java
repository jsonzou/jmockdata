package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

@SuppressWarnings("unchecked")
public class BaseMocker<T> implements Mocker<T> {

  private final Type type;

  private Type[] genericTypes;

  private Map<String, Type> typeVariableMap;

  public BaseMocker(Type type, Type... genericTypes) {
    this.type = type;
    this.genericTypes = genericTypes;
  }

  @Override
  public T mock(MockConfig mockConfig) {
    if (type instanceof ParameterizedType) {
      return (T) new GenericMocker((ParameterizedType) type).mock(mockConfig);
    }
    if (type instanceof GenericArrayType) {
      return (T) new ArrayMocker(type).mock(mockConfig);
    }
    if (type instanceof TypeVariable) {
      Type actualType = typeVariableMap.get(((TypeVariable) this.type).getName());
      return (T) new BaseMocker(actualType).mock(mockConfig);
    }
    return (T) new ClassMocker((Class) type, genericTypes).mock(mockConfig);
  }

}
