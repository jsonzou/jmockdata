package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * 模拟Short对象
 */
public class ShortMocker implements Mocker<Short> {

  @Override
  public Short mock(DataConfig mockConfig) {
    return (short) RandomUtils.nextInt(mockConfig.shortRange()[0], mockConfig.shortRange()[1]);
  }

}
