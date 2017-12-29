package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Float对象模拟器
 */
public class FloatMocker implements Mocker<Float> {

  public static final FloatMocker INSTANCE = new FloatMocker();
  @Override
  public Float mockData(final MockConfig mockConfig) throws Exception {
    return RandomUtils.nextFloat(mockConfig.getFloatRange()[0], mockConfig.getFloatRange()[1]);
  }
}
