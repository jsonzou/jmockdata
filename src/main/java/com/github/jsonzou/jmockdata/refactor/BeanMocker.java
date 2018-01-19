package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;

public class BeanMocker<T> implements Mocker<T> {

  private final Class clazz;

  public BeanMocker(Class clazz) {
    this.clazz = clazz;
  }

  @Override
  public T mock(MockConfig mockConfig) {
    // TODO 2018/1/19 未实现
    return null;
  }
}
