package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import com.github.jsonzou.jmockdata.util.StringUtils;

/**
 * 模拟String对象
 */
public class StringMocker implements Mocker<String> {

  @Override
  public String mock(DataConfig mockConfig) {
    /**
     * 若根据正则模拟
     */
    if(StringUtils.isNotEmpty(mockConfig.stringRegex())){
      return RandomUtils.nextStringFromRegex(mockConfig.stringRegex());
    }

    int size = RandomUtils.nextSize(mockConfig.sizeRange()[0], mockConfig.sizeRange()[1]);
    String[] stringSeed = mockConfig.stringSeed();
    StringBuilder sb = new StringBuilder(size);
    for (int i = 0; i < size; i++) {
      sb.append(stringSeed[RandomUtils.nextInt(0, stringSeed.length)]);
    }
    return sb.toString();
  }

}
