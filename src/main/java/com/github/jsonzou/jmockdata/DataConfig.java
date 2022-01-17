package com.github.jsonzou.jmockdata;

import java.math.BigDecimal;

import com.github.jsonzou.jmockdata.util.StringUtils;

/**
 * @Author: jsonzou
 * @Date: 2018/10/29 13:24
 * @Description:
 */
public class DataConfig {
    private MockConfig config;
    private byte[] byteRange = {0, 127};
    private boolean[] booleanSeed = {true, false};
    private short[] shortRange = {0, 1000};
    private int[] intRange = {0, 10000};
    private float[] floatRange = {0.0f, 10000.00f};
    private double[] doubleRange = {0.0, 10000.00};
    private int decimalScale = 2;
    private long[] longRange = {0L, 10000L};
    private String[] dateRange = {"1970-01-01", "2100-12-31"};
    private int[] timeRange = {0,24,0,60,0,60};
    private int[] sizeRange = {1, 10};

    private char[] charSeed =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
                    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String[] stringSeed =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F",
                    "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private String numberRegex = null;
    private String stringRegex = null;
    
    // 直接设置的值！！！
    private String val;

	public DataConfig setVal(String val) {
		this.val = val;
		return this;
	}

    public String getVal() {
		return val;
	}

    public BigDecimal getValNum() {
		return StringUtils.isEmpty(this.val) ? null : new BigDecimal(this.val);
	}

	public DataConfig(MockConfig config) {
        this.config = config;
    }

    /**
     * 配置转路器 - 设置全局配置
     * @return MockConfig
     */
    public MockConfig globalConfig(){
        return this.config;
    }
    
    public <T> Mocker<T> getMocker(Class<T> clazz) {
        return globalConfig().getMocker(clazz);
      }

    /**
     * 配置转路器 - 切换设置全局字段模拟配置
     * @return DataConfig
     */
    public DataConfig subConfig(String... fieldNames){
        return this.config.subConfig(fieldNames);
    }

    /**
     * 配置转路器 - 设置局部配置
     * @return DataConfig
     */
    public DataConfig subConfig(Class<?> clazz,String... fieldName){
        return this.config.subConfig(clazz,fieldName);
    }

    public DataConfig byteRange(byte min, byte max) {
        if(Math.abs(min)>Byte.MAX_VALUE || Math.abs(max) >Byte.MAX_VALUE  || min> max){
            throw new MockException("Out Of The Range Of Byte Data.");
        }
        this.byteRange[0] = min;
        this.byteRange[1] = max;
        return this;
    }
    public DataConfig booleanSeed(boolean... booleanSeed) {
        this.booleanSeed = booleanSeed;
        return this;
    }

    public DataConfig shortRange(short min, short max) {
        if(Math.abs(min)>Short.MAX_VALUE || Math.abs(max) >Short.MAX_VALUE || min> max){
            throw new MockException("Out Of The Range Of Short Data.");
        }
        this.shortRange[0] = min;
        this.shortRange[1] = max;
        return this;
    }

    public DataConfig intRange(int min, int max) {
        if(Math.abs(min)>Integer.MAX_VALUE || Math.abs(max) >Integer.MAX_VALUE || min> max){
            throw new MockException("Out Of The Range Of Integer Data.");
        }
        this.intRange[0] = min;
        this.intRange[1] = max;
        return this;
    }

    public DataConfig floatRange(float min, float max) {
        if(Math.abs(min)> Float.MAX_VALUE || Math.abs(max)> Float.MAX_VALUE || min> max){
            throw new MockException("Out Of The Range Of Float Data.");
        }
        this.floatRange[0] = min;
        this.floatRange[1] = max;
        return this;
    }

    public DataConfig doubleRange(double min, double max) {
        if(Math.abs(min)> Double.MAX_VALUE || Math.abs(max) >Double.MAX_VALUE || min> max){
            throw new MockException("Out Of The Range Of Double Data.");
        }
        this.doubleRange[0] = min;
        this.doubleRange[1] = max;
        return this;
    }
    public DataConfig decimalScale(int scale) {
        this.decimalScale = scale;
        return this;
    }

    public DataConfig longRange(long min, long max) {
        if(Math.abs(min)> Long.MAX_VALUE || Math.abs(max) >Long.MAX_VALUE || min> max){
            throw new MockException("Out Of The Range Of Long Data.");
        }
        this.longRange[0] = min;
        this.longRange[1] = max;
        return this;
    }

    public DataConfig dateRange(String min, String max) {
        this.dateRange[0] = min;
        this.dateRange[1] = max;
        return this;
    }
    public DataConfig timeRange(int minHour, int maxHour, int minMinute, int maxMinute, int minSecond, int maxSecond) {
        this.timeRange[0] = minHour;
        this.timeRange[1] = maxHour;
        this.timeRange[2] = minMinute;
        this.timeRange[3] = maxMinute;
        this.timeRange[4] = minSecond;
        this.timeRange[5] = maxSecond;
        return this;
    }

    public DataConfig sizeRange(int min, int max) {
        if(Math.abs(min)> Integer.MAX_VALUE || Math.abs(max) >Integer.MAX_VALUE || min> max){
            throw new MockException("The Size Is Out Of The Range Of Integer Data.");
        }
        this.sizeRange[0] = min;
        this.sizeRange[1] = max;
        return this;
    }

    public DataConfig stringSeed(String... stringSeed) {
        this.stringSeed = stringSeed;
        return this;
    }

    public DataConfig charSeed(char... charSeed) {
        this.charSeed = charSeed;
        return this;
    }
    @Deprecated
    public DataConfig numberXeger(String numberRegex) {
       return numberRegex(numberRegex);
    }
    @Deprecated
    public DataConfig stringXeger(String stringRegex) {
        return stringRegex(stringRegex);
    }

    public DataConfig numberRegex(String numberRegex) {
        this.numberRegex = numberRegex;
        return this;
    }
    public DataConfig stringRegex(String stringRegex) {
        this.stringRegex = stringRegex;
        return this;
    }


    public byte[] byteRange() {
        return this.byteRange;
    }
    public boolean[] booleanSeed() {
        return this.booleanSeed;
    }

    public short[] shortRange() {
        return this.shortRange;
    }

    public int[] intRange() {
        return this.intRange;
    }

    public float[] floatRange() {
        return this.floatRange;
    }

    public double[] doubleRange() {
        return this.doubleRange;
    }
    public int decimalScale() {
        return this.decimalScale;
    }
    public long[] longRange() {
        return this.longRange;
    }

    public String[] dateRange() {
        return  this.dateRange;
    }
    public int[] timeRange() {
        return  this.timeRange;
    }

    public int[] sizeRange() {
        return this.sizeRange;
    }

    public String[] stringSeed() {
        return this.stringSeed;
    }

    public char[] charSeed() {
        return this.charSeed;
    }
    public String numberRegex() {
       return this.numberRegex ;
    }
    public String stringRegex() {
       return this.stringRegex ;
    }

}
