package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟String对象
 */
public class StringMocker extends BaseMocker<String> {

  public static final StringMocker INSTANCE = new StringMocker();

  public String mockData() throws Exception {
    String[] stringSeed = config.getStringSeed();
    return stringSeed[RandomUtils.nextInt(0, stringSeed.length - 1)];
  }
}
