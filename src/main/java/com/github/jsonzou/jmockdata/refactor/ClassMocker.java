package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.MockerManager;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ClassMocker<T> implements Mocker<T> {

  private final Class clazz;

  private Type[] genericTypes;

  ClassMocker(Class clazz, Type[] genericTypes) {
    this.clazz = clazz;
    this.genericTypes = genericTypes;
  }

  @Override
  public T mock(MockConfig mockConfig) {
    if (clazz.isArray()) {
      return (T) new ArrayMocker(clazz).mock(mockConfig);
    }
    if (Map.class.isAssignableFrom(clazz)) {
      return (T) new MapMocker(genericTypes).mock(mockConfig);
    }
    if (Collection.class.isAssignableFrom(clazz)) {
      return (T) new CollectionMocker(clazz, genericTypes[0]).mock(mockConfig);
    }
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mock(mockConfig);
  }
}
