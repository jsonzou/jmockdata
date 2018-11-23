package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

/**
 * Character对象模拟器
 */
public class CharacterMocker implements Mocker<Character> {

  @Override
  public Character mock(DataConfig mockConfig) {
    char[] charSeed = mockConfig.charSeed();
    return charSeed[RandomUtils.nextInt(0, charSeed.length)];
  }

}
