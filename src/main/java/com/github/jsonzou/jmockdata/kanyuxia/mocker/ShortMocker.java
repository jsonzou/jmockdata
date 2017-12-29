package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟Short对象
 */
public class ShortMocker implements Mocker<Short> {

  public static final ShortMocker INSTANCE = new ShortMocker();
  @Override
  public Short mockData(final MockConfig mockConfig) throws Exception {
    return (short) RandomUtils.nextInt(mockConfig.getShortRange()[0], mockConfig.getShortRange()[1]);
  }
}
