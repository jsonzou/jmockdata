package com.github.jsonzou.jmockdata.kanyuxia;

import lombok.Data;

/**
 * 模拟数据配置类
 */
@Data
public class MockConfig {

  public static final MockConfig INSTANCE = new MockConfig();

  // valueRange[min,max] / [fixed value]
  private final byte[] byteRange = {0, 100};
  private final short[] shortRange = {0, 100};
  private final int[] intRange = {0, 100};
  private final float[] floatRange = {0.0f, 100.00f};
  private final double[] doubleRange = {0.0, 100.00};// Double & BigDecimal
  private final long[] longRange = {0L, 100L};// Double & BigInteger
  private final boolean[] booleanRange = {true, false};

  // value[seed,seed,seed]
  private final char[] charSeed =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
          'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private final String[] stringSeed =
      {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
          "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

  // dateRange[min, max]
  private final String[] dateRange = {"2000-01-01", "2017-9-26"};

  // list、set、map sizeRange[min,max] / [fixed value]
  private final int[] sizeRange = {0, 5};


}
