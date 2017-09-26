package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟Long对象
 */
public class LongMocker extends BaseMocker<Long> {

  public static final LongMocker INSTANCE = new LongMocker();

  public Long mockData() throws Exception {
    return RandomUtils.nextLong(config.getLongRange()[0], config.getLongRange()[1]);
  }
}
