package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import java.math.BigDecimal;
import org.apache.commons.lang3.RandomUtils;

/**
 * BigDecimal对象模拟器
 */
public class BigDecimalMocker implements Mocker<BigDecimal> {

  public static final BigDecimalMocker INSTANCE = new BigDecimalMocker();
  @Override
  public BigDecimal mockData(final MockConfig mockConfig) throws Exception {
    return BigDecimal.valueOf(RandomUtils.nextDouble(mockConfig.getDoubleRange()[0], mockConfig.getDoubleRange()[1]));
  }
}
