package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Byte对象模拟器
 */
public class ByteMocker implements Mocker<Byte> {

  @Override
  public Byte mock(DataConfig mockConfig) {
    /**
     * 若根据正则模拟
     */
    if(mockConfig.numberXeger()!=null){
      return RandomUtils.nextNumberFromXeger(mockConfig.numberXeger()).byteValue();
    }
    return (byte) RandomUtils.nextInt(mockConfig.byteRange()[0], mockConfig.byteRange()[1]);
  }

}
