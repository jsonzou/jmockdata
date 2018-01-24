package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * 模拟Short对象
 */
public class ShortMocker implements Mocker<Short> {

  @Override
  public Short mock(MockConfig mockConfig) {
    return (short) RandomUtils.nextInt(mockConfig.getShortRange()[0], mockConfig.getShortRange()[1]);
  }

}
