package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import java.math.BigDecimal;
import org.apache.commons.lang3.RandomUtils;

/**
 * BigDecimal对象模拟器
 */
public class BigDecimalMocker extends BaseMocker<BigDecimal> {

  public static final BigDecimalMocker INSTANCE = new BigDecimalMocker();

  public BigDecimal mockData() throws Exception {
    return BigDecimal.valueOf(RandomUtils.nextDouble(config.getDoubleRange()[0], config.getDoubleRange()[1]));
  }
}
