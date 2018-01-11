package com.github.jsonzou.jmockdata.kanyuxia;


/**
 * 模拟数据配置类
 */
public class MockConfig {

  public static final MockConfig DEFAULT_MOCK_CONFIG =new MockConfig();

  // valueRange[min,max] / [fixed value]
  private final byte[] byteRange = {0, 100};
  private final short[] shortRange = {0, 100};
  private final int[] intRange = {0, 100};
  private final float[] floatRange = {0.0f, 100.00f};
  private final double[] doubleRange = {0.0, 100.00};// Double & BigDecimal
  private final long[] longRange = {0L, 100L};// Double & BigInteger
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
  private final String[] dateRange = {"1970-01-02", "2100-12-31"};

  // list、set、map sizeRange[min,max]
  private final int[] sizeRange = {1, 5};

  // -------------------------------- 设置模拟数据配置的值 ------------------------------------ //
  public MockConfig setByteRange(byte min, byte max) {
    byteRange[0] = min;
    byteRange[1] = max;
    return this;
  }

  public MockConfig setShortRange(short min, short max) {
    shortRange[0] = min;
    shortRange[1] = max;
    return this;
  }

  public MockConfig setIntRange(int min, int max) {
    intRange[0] = min;
    intRange[1] = max;
    return this;
  }

  public MockConfig setFloatRange(float min, float max) {
    floatRange[0] = min;
    floatRange[1] = max;
    return this;
  }

  public MockConfig setDoubleRange(double min, double max) {
    doubleRange[0] = min;
    doubleRange[1] = max;
    return this;
  }

  public MockConfig setLongRange(long min, long max) {
    longRange[0] = min;
    longRange[1] = max;
    return this;
  }

  public MockConfig setCharSeed(char... charSeed) {
    this.charSeed = charSeed;
    return this;
  }

  public MockConfig setStringSeed(String... stringSeed) {
    this.stringSeed = stringSeed;
    return this;
  }

  public MockConfig setDateRange(String min, String max) {
    dateRange[0] = min;
    dateRange[1] = max;
    return this;
  }

  public MockConfig setSizeRange(int min, int max) {
    sizeRange[0] = min;
    sizeRange[1] = max;
    return this;
  }

  public byte[] getByteRange() {
    return byteRange;
  }

  public short[] getShortRange() {
    return shortRange;
  }

  public int[] getIntRange() {
    return intRange;
  }

  public float[] getFloatRange() {
    return floatRange;
  }

  public double[] getDoubleRange() {
    return doubleRange;
  }

  public long[] getLongRange() {
    return longRange;
  }

  public char[] getCharSeed() {
    return charSeed;
  }

  public String[] getStringSeed() {
    return stringSeed;
  }

  public String[] getDateRange() {
    return dateRange;
  }

  public int[] getSizeRange() {
    return sizeRange;
  }
}
