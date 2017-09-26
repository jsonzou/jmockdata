package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Float对象模拟器
 */
public class FloatMocker extends BaseMocker<Float> {

  public static final FloatMocker INSTANCE = new FloatMocker();

  public Float mockData() throws Exception {
    return RandomUtils.nextFloat(config.getFloatRange()[0], config.getFloatRange()[1]);
  }
}
