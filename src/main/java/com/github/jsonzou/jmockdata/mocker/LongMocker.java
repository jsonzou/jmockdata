package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * 模拟Long对象
 */
public class LongMocker implements Mocker<Long> {

  @Override
  public Long mock(DataConfig mockConfig) {
    return RandomUtils.nextLong(mockConfig.longRange()[0], mockConfig.longRange()[1]);
  }

}
