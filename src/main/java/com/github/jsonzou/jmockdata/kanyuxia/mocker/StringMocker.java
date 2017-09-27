package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟String对象
 */
public class StringMocker implements Mocker<String> {

  public static final StringMocker INSTANCE = new StringMocker();

  public String mockData(final MockConfig mockConfig) throws Exception {
    String[] stringSeed = mockConfig.getStringSeed();
    return stringSeed[RandomUtils.nextInt(0, stringSeed.length - 1)];
  }
}
