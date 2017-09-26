package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import java.math.BigInteger;
import org.apache.commons.lang3.RandomUtils;

/**
 * BigInteger对象模拟器
 */
public class BigIntegerMocker extends BaseMocker<BigInteger> {

  public static final BigIntegerMocker INSTANCE = new BigIntegerMocker();

  public BigInteger mockData() throws Exception {
    return BigInteger.valueOf(RandomUtils.nextLong(config.getLongRange()[0], config.getLongRange()[1]));
  }
}
