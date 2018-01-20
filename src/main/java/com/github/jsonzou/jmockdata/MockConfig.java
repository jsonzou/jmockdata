package com.github.jsonzou.jmockdata;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据配置类
 */
public class MockConfig {

  /**
   * Bean缓存
   */
  private Map<String, Object> beanCache = new HashMap<>();
  /**
   * TypeVariable缓存
   */
  private Map<String, Type> typeVariableCache = new HashMap<>();
  private byte[] byteRange = {0, 127};
  private short[] shortRange = {0, 1000};
  private int[] intRange = {0, 10000};
  private float[] floatRange = {0.0f, 10000.00f};
  private double[] doubleRange = {0.0, 10000.00};
  private long[] longRange = {0L, 10000L};
  private String[] dateRange = {"1970-01-02", "2100-12-31"};
  private int[] sizeRange = {1, 10};
  private char[] charSeed =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
          'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private String[] stringSeed =
      {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
          "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

  public MockConfig() {
  }

  public void addBeanCache(String name, Object object) {
    beanCache.put(name, object);
  }

  public Object getBeanCacheObject(String name) {
    return beanCache.get(name);
  }

  public MockConfig init(Type type) {
    if (type instanceof ParameterizedType) {
      Class clazz = (Class) ((ParameterizedType) type).getRawType();
      Type[] types = ((ParameterizedType) type).getActualTypeArguments();
      TypeVariable[] typeVariables = clazz.getTypeParameters();
      if (typeVariables != null && typeVariables.length > 0) {
        for (int index = 0; index < typeVariables.length; index++) {
          typeVariableCache.put(typeVariables[index].getName(), types[index]);
        }
      }
    }
    return this;
  }

  public Type getVariableType(String name) {
    return typeVariableCache.get(name);
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

  public MockConfig stringSeed(String... stringSeed) {
    this.stringSeed = stringSeed;
    return this;
  }

  public MockConfig charSeed(char... charSeed) {
    this.charSeed = charSeed;
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

  public char[] getCharSeed() {
    return charSeed;
  }

  public String[] getStringSeed() {
    return stringSeed;
  }

}
