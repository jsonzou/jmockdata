package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Byte对象模拟器
 */
public class ByteMocker implements Mocker<Byte> {

  @Override
  public Byte mock(MockConfig mockConfig) {
    return (byte) RandomUtils.nextInt(mockConfig.getByteRange()[0], mockConfig.getByteRange()[1]);
  }

}
