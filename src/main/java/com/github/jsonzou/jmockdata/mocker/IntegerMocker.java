package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker implements Mocker<Integer> {

  public static final IntegerMocker INSTANCE = new IntegerMocker();

  @Override
  public Integer mock(MockConfig mockConfig) {
    return RandomUtils.nextInt(mockConfig.getIntRange()[0], mockConfig.getIntRange()[1] + 1);
  }
}
