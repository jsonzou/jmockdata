package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import java.math.BigInteger;
import org.apache.commons.lang3.RandomUtils;

/**
 * BigInteger对象模拟器
 */
public class BigIntegerMocker implements Mocker<BigInteger> {

  public static final BigIntegerMocker INSTANCE = new BigIntegerMocker();
  @Override
  public BigInteger mockData(final MockConfig mockConfig) throws Exception {
    return BigInteger.valueOf(RandomUtils.nextLong(mockConfig.getLongRange()[0], mockConfig.getLongRange()[1] + 1));
  }
}
