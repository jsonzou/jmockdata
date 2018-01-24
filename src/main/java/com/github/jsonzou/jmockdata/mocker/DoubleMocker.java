package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Double对象模拟器
 */
public class DoubleMocker implements Mocker<Double> {

  @Override
  public Double mock(MockConfig mockConfig) {
    return RandomUtils.nextDouble(mockConfig.getDoubleRange()[0], mockConfig.getDoubleRange()[1]);
  }

}
