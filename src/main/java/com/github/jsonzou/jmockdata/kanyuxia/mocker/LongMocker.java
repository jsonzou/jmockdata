package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟Long对象
 */
public class LongMocker implements Mocker<Long> {

  public static final LongMocker INSTANCE = new LongMocker();

  public Long mockData(final MockConfig mockConfig) throws Exception {
    return RandomUtils.nextLong(mockConfig.getLongRange()[0], mockConfig.getLongRange()[1]);
  }
}
