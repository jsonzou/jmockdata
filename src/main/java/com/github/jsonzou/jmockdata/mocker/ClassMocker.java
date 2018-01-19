package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.MockerManager;

public class ClassMocker<T> implements Mocker<Object> {

  private Class<T> clazz;

  public ClassMocker(Class<T> clazz) {
    this.clazz = clazz;
  }

  @Override
  public T mock(MockConfig mockConfig) {
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mock(mockConfig);
  }
}
