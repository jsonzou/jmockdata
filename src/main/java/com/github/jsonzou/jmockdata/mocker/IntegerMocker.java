package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import com.github.jsonzou.jmockdata.util.StringUtils;

/**
 * Integer对象模拟器
 */
public class IntegerMocker implements Mocker<Integer> {

  @Override
  public Integer mock(DataConfig mockConfig) {
    /**
     * 若根据正则模拟
     */
    if(StringUtils.isNotEmpty(mockConfig.numberRegex())){
      return RandomUtils.nextNumberFromRegex(mockConfig.numberRegex()).intValue();
    }
    return RandomUtils.nextInt(mockConfig.intRange()[0], mockConfig.intRange()[1]);
  }

}
