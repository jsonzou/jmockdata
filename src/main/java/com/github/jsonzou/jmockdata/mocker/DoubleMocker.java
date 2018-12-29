package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

import java.math.BigDecimal;

/**
 * Double对象模拟器
 */
public class DoubleMocker implements Mocker<Double> {

  @Override
  public Double mock(DataConfig mockConfig) {
    if(mockConfig.numberXeger()!=null){
      return Double.valueOf(mockConfig.numberXeger().generate());
    }
    return RandomUtils.nextDouble(mockConfig.doubleRange()[0], mockConfig.doubleRange()[1]);
  }

}
