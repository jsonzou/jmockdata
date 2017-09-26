package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟Short对象
 */
public class ShortMocker extends BaseMocker<Short> {

  public static final ShortMocker INSTANCE = new ShortMocker();

  public Short mockData() throws Exception {
    return (short) RandomUtils.nextInt(config.getShortRange()[0], config.getShortRange()[1]);
  }
}
