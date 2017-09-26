package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker extends BaseMocker<Integer> {

  public static final IntegerMocker INSTANCE = new IntegerMocker();

  public Integer mockData() {
    return RandomUtils.nextInt(config.getIntRange()[0], config.getIntRange()[1]);
  }
}
