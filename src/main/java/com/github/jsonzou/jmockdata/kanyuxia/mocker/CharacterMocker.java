package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import org.apache.commons.lang3.RandomUtils;

/**
 * Character对象模拟器
 */
public class CharacterMocker extends BaseMocker<Character> {

  public static final CharacterMocker INSTANCE = new CharacterMocker();

  public Character mockData() throws Exception {
    char[] charSeed = config.getCharSeed();
    return charSeed[RandomUtils.nextInt(0, charSeed.length - 1)];
  }
}
