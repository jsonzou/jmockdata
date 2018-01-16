package com.github.jsonzou.jmockdata;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟数据配置类
 */
public class MockConfig {

  /**
   * Bean缓存
   */
  private Map<String, Object> beanCache = new ConcurrentHashMap<>(16);

  private byte[] byteRange = {0, 100};
  private short[] shortRange = {0, 100};
  private int[] intRange = {0, 100};
  private float[] floatRange = {0.0f, 100.00f};
  private double[] doubleRange = {0.0, 100.00};
  private long[] longRange = {0L, 100L};
  private String[] dateRange = {"1970-01-02", "2100-12-31"};
  private int[] sizeRange = {1, 5};
  private int selfLevel = 3;
  private char[] charSeed =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
          'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private String[] stringSeed =
      {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
          "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

  public Map<String, Object> getBeanCache() {
    return beanCache;
  }

  public MockConfig byteRange(byte min, byte max) {
    this.byteRange[0] = min;
    this.byteRange[1] = max;
    return this;
  }

  public MockConfig shortRange(short min, short max) {
    this.shortRange[0] = min;
    this.shortRange[1] = max;
    return this;
  }

  public MockConfig intRange(int min, int max) {
    this.intRange[0] = min;
    this.intRange[1] = max;
    return this;
  }

  public MockConfig floatRange(float min, float max) {
    this.floatRange[0] = min;
    this.floatRange[1] = max;
    return this;
  }

  public MockConfig doubleRange(double min, double max) {
    this.doubleRange[0] = min;
    this.doubleRange[1] = max;
    return this;
  }

  public MockConfig longRange(long min, long max) {
    this.longRange[0] = min;
    this.longRange[1] = max;
    return this;
  }

  public MockConfig dateRange(String min, String max) {
    this.dateRange[0] = min;
    this.dateRange[1] = max;
    return this;
  }

  public MockConfig sizeRange(int min, int max) {
    this.sizeRange[0] = min;
    this.sizeRange[1] = max;
    return this;
  }

  public MockConfig selfLevel(int selfLevel) {
    this.selfLevel = selfLevel;
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

  public String[] getDateRange() {
    return dateRange;
  }

  public int[] getSizeRange() {
    return sizeRange;
  }

  public int getSelfLevel() {
    return selfLevel;
  }

  public char[] getCharSeed() {
    return charSeed;
  }

  public String[] getStringSeed() {
    return stringSeed;
  }
}
