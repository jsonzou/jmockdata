package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import com.github.jsonzou.jmockdata.util.StringUtils;

/**
 * Boolean对象模拟器
 */
public class BooleanMocker implements Mocker<Boolean> {

  @Override
  public Boolean mock(DataConfig mockConfig) {
	if(StringUtils.isNotEmpty(mockConfig.getVal())) {
		return "true".equals(mockConfig.getVal().toLowerCase());
	}
    boolean[] booleanSeed = mockConfig.booleanSeed();
    return booleanSeed[RandomUtils.nextInt(0, booleanSeed.length)];
  }

}
