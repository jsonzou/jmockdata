package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Boolean对象模拟器
 */
public class BooleanMocker implements Mocker<Boolean> {

  @Override
  public Boolean mock(DataConfig mockConfig) {
    return RandomUtils.nextBoolean();
  }

}
