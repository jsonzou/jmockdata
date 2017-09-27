package com.github.jsonzou.jmockdata.kanyuxia;

import lombok.Getter;

/**
 * 模拟数据配置类
 */
@Getter
public class MockConfig {

  // valueRange[min,max] / [fixed value]
  private final byte[] byteRange = {0, 100};
  private final short[] shortRange = {0, 100};
  private final int[] intRange = {0, 100};
  private final float[] floatRange = {0.0f, 100.00f};
  private final double[] doubleRange = {0.0, 100.00};// Double & BigDecimal
  private final long[] longRange = {0L, 100L};// Double & BigInteger
  private boolean[] booleanRange = {true, false};

  // value[seed,seed,seed]
  private char[] charSeed =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
          'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private String[] stringSeed =
      {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
          "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

  // dateRange[min, max]
  private final String[] dateRange = {"2000-01-01", "2017-9-26"};

  // list、set、map sizeRange[min,max] / [fixed value]
  private final int[] sizeRange = {0, 5};


  // -------------------------------- 设置模拟数据配置的值 ------------------------------------ //
  public void setByteRange(byte min, byte max) {
    byteRange[0] = min;
    byteRange[1] = max;
  }

  public void setShortRange(short min, short max) {
    shortRange[0] = min;
    shortRange[1] = max;
  }

  public void setIntRange(int min, int max) {
    intRange[0] = min;
    intRange[1] = max;
  }

  public void setFloatRange(float min, float max) {
    floatRange[0] = min;
    floatRange[1] = max;
  }

  public void setDoubleRange(double min, double max) {
    doubleRange[0] = min;
    doubleRange[1] = max;
  }

  public void setLongRange(long min, long max) {
    longRange[0] = min;
    longRange[1] = max;
  }

  public void setBooleanRange(boolean... booleanRange) {
    this.booleanRange = booleanRange;
  }

  public void setCharSeed(char... charSeed) {
    this.charSeed = charSeed;
  }

  public void setStringSeed(String... stringSeed) {
    this.stringSeed = stringSeed;
  }

  public void setDateRange(String min, String max) {
    dateRange[0] = min;
    dateRange[1] = max;
  }

  public void setSizeRange(int min, int max) {
    sizeRange[0] = min;
    sizeRange[1] = max;
  }
}
