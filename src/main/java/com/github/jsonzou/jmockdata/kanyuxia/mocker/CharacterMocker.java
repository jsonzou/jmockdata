package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Character对象模拟器
 */
public class CharacterMocker implements Mocker<Character> {

  public static final CharacterMocker INSTANCE = new CharacterMocker();

  @Override
  public Character mockData(final MockConfig mockConfig) throws Exception {
    char[] charSeed = mockConfig.getCharSeed();
    return charSeed[RandomUtils.nextInt(0, charSeed.length)];
  }
}
