package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Character对象模拟器
 */
public class CharacterMocker implements Mocker<Character> {

  @Override
  public Character mock(MockConfig mockConfig) {
    char[] charSeed = mockConfig.getCharSeed();
    return charSeed[RandomUtils.nextInt(0, charSeed.length)];
  }

}
