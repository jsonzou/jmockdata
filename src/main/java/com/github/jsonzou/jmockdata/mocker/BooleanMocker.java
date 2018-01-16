package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Boolean对象模拟器
 */
public class BooleanMocker implements Mocker<Boolean> {

  public static final BooleanMocker INSTANCE = new BooleanMocker();

  @Override
  public Boolean mock(MockConfig mockConfig) {
    return RandomUtils.nextBoolean();
  }
}
