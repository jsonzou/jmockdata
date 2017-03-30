
package com.github.jsonzou.jmockdata.mockdata;

import com.github.jsonzou.jmockdata.JMockData;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 模拟单个元数据，只有在调用具体数据时实时模拟此改数据类型的数据
 * Created by v_zoupengfei on 2017/3/27.
 */
public class JmockdataWrapperMetaDataSingle {
    public BigDecimal getBigDecimalData() {
        return JMockData.mockSimpleBean(BigDecimal.class);
    }


    public BigDecimal[] getBigDecimalArrayData() {
        return JMockData.mockSimpleBean(BigDecimal[].class);
    }


    public BigInteger getBigIntegerData() {
        return JMockData.mockSimpleBean(BigInteger.class);
    }

    public BigInteger[] getBigIntegerArrayData() {
        return JMockData.mockSimpleBean(BigInteger[].class);
    }

    public Boolean getBooleanData() {
        return JMockData.mockSimpleBean(Boolean.class);
    }

    public boolean[] getBooleanUnboxingArrayData() {
        return JMockData.mockSimpleBean(boolean[].class);
    }


    public Boolean[] getBooleanBoxingArrayData() {
        return JMockData.mockSimpleBean(Boolean[].class);
    }


    public Byte getByteData() {
        return JMockData.mockSimpleBean(Byte.class);
    }


    public byte[] getByteUnboxingArrayData() {
        return JMockData.mockSimpleBean(byte[].class);
    }


    public Byte[] getByteBoxingArrayData() {
        return JMockData.mockSimpleBean(Byte[].class);
    }


    public Character getCharacterData() {
        return JMockData.mockSimpleBean(Character.class);
    }


    public char[] getCharacterUnboxingArrayData() {
        return JMockData.mockSimpleBean(char[].class);
    }


    public Character[] getCharacterBoxingArrayData() {
        return JMockData.mockSimpleBean(Character[].class);
    }


    public Date getDateData() {
        return JMockData.mockSimpleBean(Date.class);
    }


    public Date[] getDateArrayData() {
        return JMockData.mockSimpleBean(Date[].class);
    }


    public Double getDoubleData() {
        return JMockData.mockSimpleBean(Double.class);
    }


    public double[] getDoubleUnboxingArrayData() {
        return JMockData.mockSimpleBean(double[].class);
    }


    public Double[] getDoubleBoxingArrayData() {
        return JMockData.mockSimpleBean(Double[].class);
    }


    public Float getFloatData() {
        return JMockData.mockSimpleBean(Float.class);
    }

    public float[] getFloatUnboxingArrayData() {
        return JMockData.mockSimpleBean(float[].class);
    }


    public Float[] getFloatBoxingArrayData() {
        return JMockData.mockSimpleBean(Float[].class);
    }


    public Integer getIntegerData() {
        return JMockData.mockSimpleBean(Integer.class);
    }


    public int[] getIntegerUnboxingArrayData() {
        return JMockData.mockSimpleBean(int[].class);
    }


    public Integer[] getIntegerBoxingArrayData() {
        return JMockData.mockSimpleBean(Integer[].class);
    }


    public Long getLongData() {
        return JMockData.mockSimpleBean(Long.class);
    }


    public long[] getLongUnboxingArrayData() {
        return JMockData.mockSimpleBean(long[].class);
    }


    public Long[] getLongBoxingArrayData() {
        return JMockData.mockSimpleBean(Long[].class);
    }


    public Short getShortData() {
        return JMockData.mockSimpleBean(Short.class);
    }


    public short[] getShortUnboxingArrayData() {
        return JMockData.mockSimpleBean(short[].class);
    }


    public Short[] getShortBoxingArrayData() {
        return JMockData.mockSimpleBean(Short[].class);
    }


    public String getStringData() {
        return JMockData.mockSimpleBean(String.class);
    }


    public String[] getStringArrayData() {
        return JMockData.mockSimpleBean(String[].class);
    }


}
