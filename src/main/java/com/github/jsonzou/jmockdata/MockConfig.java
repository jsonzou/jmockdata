package com.github.jsonzou.jmockdata;


import com.github.jsonzou.jmockdata.mocker.BigDecimalMocker;
import com.github.jsonzou.jmockdata.mocker.BigIntegerMocker;
import com.github.jsonzou.jmockdata.mocker.BooleanMocker;
import com.github.jsonzou.jmockdata.mocker.ByteMocker;
import com.github.jsonzou.jmockdata.mocker.CharacterMocker;
import com.github.jsonzou.jmockdata.mocker.DateMocker;
import com.github.jsonzou.jmockdata.mocker.DoubleMocker;
import com.github.jsonzou.jmockdata.mocker.FloatMocker;
import com.github.jsonzou.jmockdata.mocker.IntegerMocker;
import com.github.jsonzou.jmockdata.mocker.LongMocker;
import com.github.jsonzou.jmockdata.mocker.ShortMocker;
import com.github.jsonzou.jmockdata.mocker.StringMocker;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据配置类
 */
public class MockConfig {

  private static final ByteMocker BYTE_MOCKER = new ByteMocker();
  private static final BooleanMocker BOOLEAN_MOCKER = new BooleanMocker();
  private static final CharacterMocker CHARACTER_MOCKER = new CharacterMocker();
  private static final ShortMocker SHORT_MOCKER = new ShortMocker();
  private static final IntegerMocker INTEGER_MOCKER = new IntegerMocker();
  private static final LongMocker LONG_MOCKER = new LongMocker();
  private static final FloatMocker FLOAT_MOCKER = new FloatMocker();
  private static final DoubleMocker DOUBLE_MOCKER = new DoubleMocker();
  private static final BigIntegerMocker BIG_INTEGER_MOCKER = new BigIntegerMocker();
  private static final BigDecimalMocker BIG_DECIMAL_MOCKER = new BigDecimalMocker();
  private static final StringMocker STRING_MOCKER = new StringMocker();
  private static final DateMocker DATE_MOCKER = new DateMocker("1970-01-01", "2100-12-31");

  /**
   * Bean缓存
   */
  private Map<String, Object> beanCache = new HashMap<>();
  /**
   * TypeVariable缓存
   */
  private Map<String, Type> typeVariableCache = new HashMap<>();
  /**
   * enum缓存
   */
  private Map<String, Enum[]> enumCache = new HashMap<>();
  private Map<Class<?>, Mocker> mockerContext = new HashMap<>();
  private byte[] byteRange = {0, 127};
  private short[] shortRange = {0, 1000};
  private int[] intRange = {0, 10000};
  private float[] floatRange = {0.0f, 10000.00f};
  private double[] doubleRange = {0.0, 10000.00};
  private long[] longRange = {0L, 10000L};
  private String[] dateRange = {"1970-01-01", "2100-12-31"};
  private int[] sizeRange = {1, 10};
  private boolean enabledCircle=false;

  private char[] charSeed =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
          'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private String[] stringSeed =
      {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
          "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

  public MockConfig() {
    registerMocker(BYTE_MOCKER, byte.class, Byte.class);
    registerMocker(BOOLEAN_MOCKER, boolean.class, Boolean.class);
    registerMocker(CHARACTER_MOCKER, char.class, Character.class);
    registerMocker(SHORT_MOCKER, short.class, Short.class);
    registerMocker(INTEGER_MOCKER, Integer.class, int.class);
    registerMocker(LONG_MOCKER, long.class, Long.class);
    registerMocker(FLOAT_MOCKER, float.class, Float.class);
    registerMocker(DOUBLE_MOCKER, double.class, Double.class);
    registerMocker(BIG_INTEGER_MOCKER, BigInteger.class);
    registerMocker(BIG_DECIMAL_MOCKER, BigDecimal.class);
    registerMocker(STRING_MOCKER, String.class);
    registerMocker(DATE_MOCKER, Date.class);
  }

  public void cacheBean(String name, Object bean) {
    beanCache.put(name, bean);
  }

  public Object getcacheBean(String beanClassName) {
    return beanCache.get(beanClassName);
  }

  public void cacheEnum(String name, Enum[] enums) {
    enumCache.put(name, enums);
  }

  public Enum[] getcacheEnum(String enumClassName) {
    return enumCache.get(enumClassName);
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

  public boolean isEnabledCircle() {
    return enabledCircle;
  }

  public MockConfig setEnabledCircle(boolean enabledCircle) {
    this.enabledCircle = enabledCircle;
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
    registerMocker(new DateMocker(min, max), Date.class);
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

  public int[] getSizeRange() {
    return sizeRange;
  }

  public char[] getCharSeed() {
    return charSeed;
  }

  public String[] getStringSeed() {
    return stringSeed;
  }

  public void registerMocker(Mocker mocker, Class<?>... clazzs) {
    for (Class<?> clazz : clazzs) {
      mockerContext.put(clazz, mocker);
    }
  }

  public Mocker getMocker(Class<?> clazz) {
    return mockerContext.get(clazz);
  }

}
