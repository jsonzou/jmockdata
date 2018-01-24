package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.math.BigDecimal;

/**
 * BigDecimal对象模拟器
 */
public class BigDecimalMocker implements Mocker<BigDecimal> {

  @Override
  public BigDecimal mock(MockConfig mockConfig) {
    return BigDecimal.valueOf(RandomUtils.nextDouble(mockConfig.getDoubleRange()[0], mockConfig.getDoubleRange()[1]));
  }

}
