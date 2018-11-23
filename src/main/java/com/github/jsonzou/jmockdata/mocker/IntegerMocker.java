package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker implements Mocker<Integer> {

  @Override
  public Integer mock(DataConfig mockConfig) {
    return RandomUtils.nextInt(mockConfig.intRange()[0], mockConfig.intRange()[1]);
  }

}
