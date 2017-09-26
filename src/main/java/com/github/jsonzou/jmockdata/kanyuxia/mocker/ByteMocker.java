package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Byte对象模拟器
 */
public class ByteMocker extends BaseMocker<Byte> {

  public static final ByteMocker INSTANCE = new ByteMocker();

  public Byte mockData() throws Exception {
    return (byte) RandomUtils.nextInt(config.getByteRange()[0], config.getByteRange()[1]);
  }
}
