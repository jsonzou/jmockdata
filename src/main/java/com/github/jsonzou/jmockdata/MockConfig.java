package com.github.jsonzou.jmockdata;


import com.github.jsonzou.jmockdata.annotation.MockIgnore;
import com.github.jsonzou.jmockdata.mocker.*;
import com.github.jsonzou.jmockdata.util.FieldMatchingResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import org.bson.types.Decimal128;

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
  private static final Decimal128Mocker DECIMAL_128_MOCKER = new Decimal128Mocker();
  private static final StringMocker STRING_MOCKER = new StringMocker();
  private static final DateMocker DATE_MOCKER = new DateMocker();
  private static final LocalDateTimeMocker LOCAL_DATE_TIME_MOCKER = new LocalDateTimeMocker();
  private static final LocalDateMocker LOCAL_DATE_MOCKER = new LocalDateMocker();
  private static final LocalTimeMocker LOCAL_TIME_MOCKER = new LocalTimeMocker();
  private static final TimestampMocker TIMESTAMP_MOCKER = new TimestampMocker();
  private boolean enabledCircle = false;
  private boolean enabledStatic = false;
  private boolean enabledPublic = true;
  private boolean enabledProtected = true;
  private boolean enabledPrivate = true;

  /**
   * Bean缓存
   */
  private Map<String, Object> beanCache = new HashMap<>(16);
  /**
   * TypeVariable缓存
   */
  private Map<String, Type> typeVariableCache = new HashMap<>(8);
  /**
   * enum缓存
   */
  private Map<String, Enum[]> enumCache = new HashMap<>(4);
  /**
   * 模拟器配置
   */
  private Map<Class<?>, Mocker> mockerContext = new HashMap<>(32);
  private Map<Class<?>, BeanMockerInterceptor> beanMockerInterceptors = new HashMap<>(4);

  /**
   * 数据模拟范围全局配置
   */
  private DataConfig GLOBAL_DATA_CONFIG=new DataConfig(this);

  /**
   * 数据模拟范围局部特定配置
   * [key] = ClassName[_Field]
   * [value] = DataConfig
   */
  private Map<String,DataConfig> partDataConfig = new HashMap<>(16);

  /**
   * 排除模拟对象
   */
  private Map<Class<?>, List<String>> excludeConfig = new HashMap<>(4);


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
    registerMocker(DECIMAL_128_MOCKER, Decimal128.class);
    registerMocker(STRING_MOCKER, String.class);
    registerMocker(DATE_MOCKER, Date.class);
    registerMocker(LOCAL_DATE_TIME_MOCKER, LocalDateTime.class);
    registerMocker(LOCAL_DATE_MOCKER, LocalDate.class);
    registerMocker(LOCAL_TIME_MOCKER, LocalTime.class);
    registerMocker(TIMESTAMP_MOCKER, Timestamp.class);
  }

  /**
   * 提供实例化工厂
   * @return MockConfig
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
    return this.enabledCircle;
  }

  public MockConfig setEnabledCircle(boolean enabledCircle) {
    this.enabledCircle = enabledCircle;
    return this;
  }
  public MockConfig setEnabledStatic(boolean enabledStatic) {
    this.enabledStatic = enabledStatic;
    return this;
  }
  public boolean isEnabledStatic() {
    return this.enabledStatic;
  }
  public MockConfig setEnabledPublic(boolean enabledPublic) {
    this.enabledPublic = enabledPublic;
    return this;
  }
  public boolean isEnabledPublic() {
    return this.enabledPublic;
  }
  public MockConfig setEnabledProtected(boolean enabledProtected) {
    this.enabledProtected = enabledProtected;
    return this;
  }
  public boolean isEnabledProtected() {
    return this.enabledProtected;
  }
  public MockConfig setEnabledPrivate(boolean enabledPrivate) {
    this.enabledPrivate = enabledPrivate;
    return this;
  }
  public boolean isEnabledPrivate() {
    return this.enabledPrivate;
  }

  public Type getVariableType(String name) {
    return typeVariableCache.get(name);
  }

  /**
   * 注册数据模拟器
   * @param mocker
   * @param clazzs
   * @param <T>
   */
  public <T> void registerMocker(Mocker mocker, Class<T>... clazzs) {
    for (Class<T> clazz : clazzs) {
      mockerContext.put(clazz, mocker);
    }
  }

  /**
   * 注册BeanMocker拦截器，改变模拟行为
   * @param bi
   * @return
   */
  public <T> MockConfig registerBeanMockerInterceptor(Class<T>clazz, BeanMockerInterceptor bi) {
    beanMockerInterceptors.put(clazz, bi);
    return this;
  }

    /**
     * 注册全局BeanMocker拦截器，只能有一个，改变模拟行为
     * @param bi
     * @param <T>
     * @return
     */
  public <T> MockConfig registerBeanMockerInterceptor(BeanMockerInterceptor bi) {
    beanMockerInterceptors.put(MockConfig.class, bi);
    return this;
  }
  public <T> BeanMockerInterceptor getBeanMockerInterceptor(Class<T>clazz) {
      if(this.beanMockerInterceptors.size() == 0){
          return null;
      }
      BeanMockerInterceptor bi = this.beanMockerInterceptors.get(clazz);
      if(bi == null){
          return this.beanMockerInterceptors.get(MockConfig.class);
      }
      return bi;
  }

  public <T> Mocker<T> getMocker(Class<T> clazz) {
    return mockerContext.get(clazz);
  }

  /**
   * 配置转路器 - 切换设置全局配置
   * @return MockConfig
     */
  public MockConfig globalConfig(){
    return this;
  }

  /**
   * 配置转路器 - 切换设置全局字段模拟配置
   * @return DataConfig
   */
  public DataConfig subConfig(String... fieldNames){
    return this.subConfig(DataConfig.class,fieldNames);
  }
  /**
   * 配置转路器 - 切换设置局部Class字段模拟配置
   * @return DataConfig
   */
  public <T> DataConfig subConfig(Class<T> clazz,String... fieldNames){
    /**
     * fieldNames 长度为0 代表是对某各类所有字段的配置
     */
    String clazzName=clazz.getName();
    DataConfig config=partDataConfig.get(clazzName);
    if(fieldNames.length==0){
         if(config==null){
           config=new DataConfig(this);
           partDataConfig.put(clazzName,config);
         }
         return config;
    }
    /**
     * fieldNames 长度不为0 代表是对某各类某几个字段的配置
     */
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
   * @return DataConfig
     */
  public <T> DataConfig getDataConfig(Class<T> clazz,String fieldName){

    Set<String> configKeys=partDataConfig.keySet();
    String clazzName=clazz.getName();
    /**
     * 如果字段为空，则返回类的配置
     */
    if(fieldName==null){
      return  partDataConfig.get(clazzName)==null?GLOBAL_DATA_CONFIG:partDataConfig.get(clazzName);
    }

    /**
     * 优先级1 ： clazz + fieldName
     */
    DataConfig config=partDataConfig.get(clazzName+"#"+fieldName);
    /**
     * 查找不到则模式匹配
     */
    if(config==null){
      for(String fieldPatternKey:configKeys){
        if(fieldPatternKey.startsWith(clazzName+"#")){
          if(FieldMatchingResolver.isMatchPattern(fieldName,fieldPatternKey.split("#")[1])){
            return partDataConfig.get(fieldPatternKey);
          }
        }
      }
    }

    /**
     * 优先级2 ： DataConfig.class + fieldName
     */
    if(config==null){
      clazzName=DataConfig.class.getName();
      config=partDataConfig.get(clazzName+"#"+fieldName);
    }

    /**
     * 优先级3 ： clazz
     */
    if(config==null){
      config=partDataConfig.get(clazzName);
    }


    /**
     * 查找不到则模式匹配
     */
    if(config==null){
      for(String fieldPatternKey:configKeys){
        if(fieldPatternKey.startsWith(clazzName+"#")){
          if(FieldMatchingResolver.isMatchPattern(fieldName,fieldPatternKey.split("#")[1])){
            return partDataConfig.get(fieldPatternKey);
          }
        }
      }
    }

    /**
     * 优先级4 ： GLOBAL CONFIG
     */
    if(config==null){
      config=GLOBAL_DATA_CONFIG;
    }
    return config;
  }
  /**
   * 获取全局配置
   * @return DataConfig
   */
  public DataConfig globalDataConfig(){
    return this.GLOBAL_DATA_CONFIG;
  }
  /**
   * 模拟数据排除某各类的某几个字段
   */
  public <T> MockConfig excludes(Class<T> clazz,String... fieldName){
    excludeConfig.put(clazz, Arrays.asList(fieldName));
    return this;
  }

  /**
   * 模拟数据全局排除某些字段名
   * @param fieldNames
   * @return MockConfig
     */
  public MockConfig excludes(String... fieldNames){
    excludeConfig.put(MockIgnore.class, Arrays.asList(fieldNames));
    return this;
  }
  /**
   * 判断是否排除模拟某个类
   */
  public <T> boolean isConfigExcludeMock(Class<T>clazz){
    return this.excludeConfig.get(clazz)!=null && this.excludeConfig.get(clazz).size()==0;
  }


  /**
   * 判断是否排除模拟某个类的属性
   */
  public <T> boolean isConfigExcludeMock(Class<T>clazz,String fieldName){
    /**
     * 优先配全字段名称
     */
    List<String> fieldsConfig1=this.excludeConfig.get(clazz);
    List<String> fieldsConfig2=this.excludeConfig.get(MockIgnore.class);
    List<String> fieldsConfig = new ArrayList<>();
    if(fieldsConfig1!=null){
      fieldsConfig.addAll(fieldsConfig1);
    }
    if(fieldsConfig2!=null){
      fieldsConfig.addAll(fieldsConfig2);
    }
    if(fieldsConfig.contains(fieldName)){
      return true;
    }else{
      boolean isExclude=false;
      for(String fieldPattern:fieldsConfig){
            isExclude = FieldMatchingResolver.isMatchPattern(fieldName,fieldPattern);
            if(isExclude){
              return isExclude;
            }
      }
      return isExclude;
    }

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
  public MockConfig booleanSeed(boolean... booleanSeed) {
     GLOBAL_DATA_CONFIG.booleanSeed(booleanSeed);
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
  public MockConfig decimalScale(int scale) {
    GLOBAL_DATA_CONFIG.decimalScale(scale);
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
  public MockConfig timeRange(int minHour, int maxHour, int minMinute, int maxMinute, int minSecond, int maxSecond) {
    GLOBAL_DATA_CONFIG.timeRange(minHour, maxHour, minMinute, maxMinute, minSecond, maxSecond);
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
   * 根据正则表达是模拟数字类型，
   * 全局慎用，小数、整数、短整数等都会使用此表达式生成，有可能会超范围，
   * 建议通过转路器指定特定的字段或类型使用此功能
   * @param numberRegex
   * @return MockConfig
     */
  @Deprecated
  public MockConfig numberXeger(String numberRegex) {
    GLOBAL_DATA_CONFIG.numberXeger(numberRegex);
    return this;
  }
  public MockConfig numberRegex(String numberRegex) {
    GLOBAL_DATA_CONFIG.numberRegex(numberRegex);
    return this;
  }

  /**
   * 根据正则表达是模拟字符串类型，
   * @param stringRegex
   * @return MockConfig
     */
  @Deprecated
  public MockConfig stringXeger(String stringRegex) {
    GLOBAL_DATA_CONFIG.stringXeger(stringRegex);
    return this;
  }
  public MockConfig stringRegex(String stringRegex) {
    GLOBAL_DATA_CONFIG.stringRegex(stringRegex);
    return this;
  }
  /**
   * ********************************
   * 获取全局配置
   * ********************************
     */

  public byte[] byteRange() {
    return GLOBAL_DATA_CONFIG.byteRange();
  }
  public boolean[] booleanSeed() {
    return GLOBAL_DATA_CONFIG.booleanSeed();
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
  public int decimalScale() {
    return GLOBAL_DATA_CONFIG.decimalScale();
  }
  public long[] longRange() {
    return GLOBAL_DATA_CONFIG.longRange();
  }

  public String[] dateRange() {
    return  GLOBAL_DATA_CONFIG.dateRange();
  }
  public int[] timeRange() {
    return  GLOBAL_DATA_CONFIG.timeRange();
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

  public String numberRegex() {
    return GLOBAL_DATA_CONFIG.numberRegex() ;
  }
  public String stringRegex() {
    return GLOBAL_DATA_CONFIG.stringRegex() ;
  }

}
