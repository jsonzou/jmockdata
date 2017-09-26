package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Boolean对象模拟器
 */
public class BooleanMocker extends BaseMocker<Boolean> {

  public static final BooleanMocker INSTANCE = new BooleanMocker();

  public Boolean mockData() throws Exception {
    boolean[] booleanRange = config.getBooleanRange();
    return booleanRange[RandomUtils.nextInt(0, booleanRange.length - 1)];
  }
}
