package com.github.jsonzou.jmockdata;


import com.github.jsonzou.jmockdata.mocker.*;

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
  private static final DateMocker DATE_MOCKER = new DateMocker();
  private boolean enabledCircle=false;

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

  /**
   * 数据模拟范围全局配置
   */
  private DataConfig GLOBAL_DATA_CONFIG=new DataConfig(this);
  /**
   * 数据模拟范围局部特定配置
   * [key] = ClassName[_Field]
   * [value] = DataConfig
   */
  private Map<String,DataConfig> partDataConfig = new HashMap<>();


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

  /**
   * 提供实例化工厂
   * @return
     */
  public static MockConfig newInstance(){
    return new MockConfig();
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


  public void registerMocker(Mocker mocker, Class<?>... clazzs) {
    for (Class<?> clazz : clazzs) {
      mockerContext.put(clazz, mocker);
    }
  }

  public Mocker getMocker(Class<?> clazz) {
    return mockerContext.get(clazz);
  }

  /**
   * 配置转路器 - 切换设置全局配置
   * @return
     */
  public MockConfig switchGlobalConfig(){
    return this;
  }
  /**
   * 配置转路器 - 切换设置局部配置
   * @return
   */
  public DataConfig switchPartConfig(Class<?> clazz,String... fieldNames){
    String clazzName=clazz.getName();
    DataConfig config=partDataConfig.get(clazzName);
    if(fieldNames==null || fieldNames.length==0){
         if(config==null){
           config=new DataConfig(this);
           partDataConfig.put(clazzName,config);
         }
         return config;
    }
    config=null;
    for (String fieldName : fieldNames) {
      config=partDataConfig.get(clazzName+"#"+fieldName);
      if(config!=null){
        break;
      }
    }
    if(config == null){
       config = new DataConfig(this);
    }
    for (String fieldName : fieldNames) {
      partDataConfig.put(clazzName+"#"+fieldName,config);
    }
    return config;
  }

  /**
   * 获取指定配置，如果没有则返回全局配置
   * @param clazz
   * @return
     */
  public DataConfig getDataConfig(Class<?> clazz,String fieldName){
    String clazzName=clazz.getName();
    DataConfig config=partDataConfig.get(clazzName+"#"+fieldName);
    if(config==null){
      config=partDataConfig.get(clazzName);
    }
    if(config==null){
      config=GLOBAL_DATA_CONFIG;
    }
    return config;
  }
  /**
   * 获取全局配置
   *
   */
  public DataConfig globalConfig(){
    return GLOBAL_DATA_CONFIG;
  }


  /**
   * ********************************
   * 设置全局配置
   * ********************************
   */

  public MockConfig byteRange(byte min, byte max) {
     GLOBAL_DATA_CONFIG.byteRange(min,max);
     return this;
  }

  public MockConfig shortRange(short min, short max) {
    GLOBAL_DATA_CONFIG.shortRange(min,max);
    return this;
  }

  public MockConfig intRange(int min, int max) {
    GLOBAL_DATA_CONFIG.intRange(min,max);
    return this;
  }

  public MockConfig floatRange(float min, float max) {
    GLOBAL_DATA_CONFIG.floatRange(min,max);
    return this;
  }

  public MockConfig doubleRange(double min, double max) {
     GLOBAL_DATA_CONFIG.doubleRange(min,max);
     return this;
  }

  public MockConfig longRange(long min, long max) {
    GLOBAL_DATA_CONFIG.longRange(min,max);
    return this;
  }

  public MockConfig dateRange(String min, String max) {
    GLOBAL_DATA_CONFIG.dateRange(min,max);
    return this;
  }

  public MockConfig sizeRange(int min, int max) {
    GLOBAL_DATA_CONFIG.sizeRange(min,max);
    return this;
  }

  public MockConfig stringSeed(String... stringSeed) {
    GLOBAL_DATA_CONFIG.stringSeed(stringSeed);
    return this;
  }

  public MockConfig charSeed(char... charSeed) {
    GLOBAL_DATA_CONFIG.charSeed(charSeed);
    return this;
  }

  /**
   * ********************************
   * 获取全局配置
   * ********************************
     */

  public byte[] byteRange() {
    return this.byteRange();
  }

  public short[] shortRange() {
    return GLOBAL_DATA_CONFIG.shortRange();
  }

  public int[] intRange() {
    return GLOBAL_DATA_CONFIG.intRange();
  }

  public float[] floatRange() {
    return GLOBAL_DATA_CONFIG.floatRange();
  }

  public double[] doubleRange() {
    return GLOBAL_DATA_CONFIG.doubleRange();
  }

  public long[] longRange() {
    return GLOBAL_DATA_CONFIG.longRange();
  }

  public String[] dateRange() {
    return  GLOBAL_DATA_CONFIG.dateRange();
  }

  public int[] sizeRange() {
    return GLOBAL_DATA_CONFIG.sizeRange();
  }

  public String[] stringSeed() {
    return GLOBAL_DATA_CONFIG.stringSeed();
  }

  public char[] charSeed() {
    return GLOBAL_DATA_CONFIG.charSeed();
  }


}
