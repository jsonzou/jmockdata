package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

import java.math.BigDecimal;

/**
 * Float对象模拟器
 */
public class FloatMocker implements Mocker<Float> {

  @Override
  public Float mock(DataConfig mockConfig) {
    /**
     * 若根据正则模拟
     */
    if(mockConfig.numberXeger()!=null){
      return RandomUtils.nextNumberFromXeger(mockConfig.numberXeger()).setScale(mockConfig.decimalScale(), BigDecimal.ROUND_FLOOR).floatValue();
    }
    return new BigDecimal(RandomUtils.nextFloat(mockConfig.floatRange()[0], mockConfig.floatRange()[1])).setScale(mockConfig.decimalScale(),BigDecimal.ROUND_FLOOR).floatValue();
  }
}
