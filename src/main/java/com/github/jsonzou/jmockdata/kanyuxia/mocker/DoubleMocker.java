package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Double对象模拟器
 */
public class DoubleMocker extends BaseMocker<Double> {

  public static final DoubleMocker INSTANCE = new DoubleMocker();

  public Double mockData() throws Exception {
    return RandomUtils.nextDouble(config.getDoubleRange()[0], config.getDoubleRange()[1]);
  }
}
