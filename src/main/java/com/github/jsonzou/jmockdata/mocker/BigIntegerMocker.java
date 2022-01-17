package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import com.github.jsonzou.jmockdata.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger对象模拟器
 */
public class BigIntegerMocker implements Mocker<BigInteger> {
  @Override
  public BigInteger mock(DataConfig mockConfig) {
	if(StringUtils.isNotEmpty(mockConfig.getVal())) {
		return mockConfig.getValNum().toBigInteger();
	}
   return BigInteger.valueOf(mockConfig.globalConfig().getMocker(Long.class).mock(mockConfig));
  }

}
