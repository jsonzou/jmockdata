/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        return JMockData.mockSimpleType(BigDecimal.class);
    }

    public BigDecimal[] getBigDecimalArrayData() {
        return JMockData.mockSimpleType(BigDecimal[].class);
    }

    public BigInteger getBigIntegerData() {
        return JMockData.mockSimpleType(BigInteger.class);
    }

    public BigInteger[] getBigIntegerArrayData() {
        return JMockData.mockSimpleType(BigInteger[].class);
    }

    public Boolean getBooleanData() {
        return JMockData.mockSimpleType(Boolean.class);
    }

    public boolean[] getBooleanUnboxingArrayData() {
        return JMockData.mockSimpleType(boolean[].class);
    }

    public Boolean[] getBooleanBoxingArrayData() {
        return JMockData.mockSimpleType(Boolean[].class);
    }

    public Byte getByteData() {
        return JMockData.mockSimpleType(Byte.class);
    }

    public byte[] getByteUnboxingArrayData() {
        return JMockData.mockSimpleType(byte[].class);
    }

    public Byte[] getByteBoxingArrayData() {
        return JMockData.mockSimpleType(Byte[].class);
    }

    public Character getCharacterData() {
        return JMockData.mockSimpleType(Character.class);
    }

    public char[] getCharacterUnboxingArrayData() {
        return JMockData.mockSimpleType(char[].class);
    }

    public Character[] getCharacterBoxingArrayData() {
        return JMockData.mockSimpleType(Character[].class);
    }

    public Date getDateData() {
        return JMockData.mockSimpleType(Date.class);
    }

    public Date[] getDateArrayData() {
        return JMockData.mockSimpleType(Date[].class);
    }

    public Double getDoubleData() {
        return JMockData.mockSimpleType(Double.class);
    }

    public double[] getDoubleUnboxingArrayData() {
        return JMockData.mockSimpleType(double[].class);
    }

    public Double[] getDoubleBoxingArrayData() {
        return JMockData.mockSimpleType(Double[].class);
    }

    public Float getFloatData() {
        return JMockData.mockSimpleType(Float.class);
    }

    public float[] getFloatUnboxingArrayData() {
        return JMockData.mockSimpleType(float[].class);
    }

    public Float[] getFloatBoxingArrayData() {
        return JMockData.mockSimpleType(Float[].class);
    }

    public Integer getIntegerData() {
        return JMockData.mockSimpleType(Integer.class);
    }

    public int[] getIntegerUnboxingArrayData() {
        return JMockData.mockSimpleType(int[].class);
    }

    public Integer[] getIntegerBoxingArrayData() {
        return JMockData.mockSimpleType(Integer[].class);
    }

    public Long getLongData() {
        return JMockData.mockSimpleType(Long.class);
    }

    public long[] getLongUnboxingArrayData() {
        return JMockData.mockSimpleType(long[].class);
    }

    public Long[] getLongBoxingArrayData() {
        return JMockData.mockSimpleType(Long[].class);
    }

    public Short getShortData() {
        return JMockData.mockSimpleType(Short.class);
    }

    public short[] getShortUnboxingArrayData() {
        return JMockData.mockSimpleType(short[].class);
    }

    public Short[] getShortBoxingArrayData() {
        return JMockData.mockSimpleType(Short[].class);
    }

    public String getStringData() {
        return JMockData.mockSimpleType(String.class);
    }

    public String[] getStringArrayData() {
        return JMockData.mockSimpleType(String[].class);
    }
}
