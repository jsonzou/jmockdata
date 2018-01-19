package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

@SuppressWarnings("unchecked")
public class GenericMocker implements Mocker<Object> {

  private Type type;

  public GenericMocker(Type type) {
    this.type = type;
  }


  @Override
  public Object mock(MockConfig mockConfig) {
    Mocker<?> mocker;
    if (type instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType) type;
      mocker = new BeanMocker((Class<?>) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
    } else if (type instanceof GenericArrayType) {
      ParameterizedType parameterizedType = (ParameterizedType) ((GenericArrayType) type).getGenericComponentType();
      mocker = new ArrayMocker((Class<?>) parameterizedType.getRawType(), parameterizedType);
    } else {
      mocker = new ClassMocker((Class<?>) type);
    }
    return mocker.mock(mockConfig);
  }

}
