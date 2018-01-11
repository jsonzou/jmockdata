package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker implements Mocker<Integer> {

  public static final IntegerMocker INSTANCE = new IntegerMocker();

  @Override
  public Integer mockData(final MockConfig mockConfig) {
    return RandomUtils.nextInt(mockConfig.getIntRange()[0], mockConfig.getIntRange()[1] + 1);
  }
}
