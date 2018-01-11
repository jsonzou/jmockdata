package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * 模拟String对象
 */
public class StringMocker implements Mocker<String> {

  public static final StringMocker INSTANCE = new StringMocker();
  @Override
  public String mockData(final MockConfig mockConfig) throws Exception {
    int size = RandomUtils.nextInt(mockConfig.getSizeRange()[0], mockConfig.getSizeRange()[1] + 1);
    String[] stringSeed = mockConfig.getStringSeed();
    StringBuilder sb = new StringBuilder(size);
    for (int i = 0; i < size; i++) {
      sb.append(stringSeed[RandomUtils.nextInt(0, stringSeed.length)]);
    }
    return sb.toString();
  }
}
