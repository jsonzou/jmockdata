package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Double对象模拟器
 */
public class DoubleMocker implements Mocker<Double> {

  public static final DoubleMocker INSTANCE = new DoubleMocker();

  @Override
  public Double mockData(final MockConfig mockConfig) throws Exception {
    return RandomUtils.nextDouble(mockConfig.getDoubleRange()[0], mockConfig.getDoubleRange()[1] + 1);
  }
}
