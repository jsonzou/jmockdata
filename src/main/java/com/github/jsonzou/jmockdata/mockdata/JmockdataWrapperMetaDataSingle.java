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
        return JMockData.mock(BigDecimal.class);
    }

    public BigDecimal[] getBigDecimalArrayData() {
        return JMockData.mock(BigDecimal[].class);
    }

    public BigInteger getBigIntegerData() {
        return JMockData.mock(BigInteger.class);
    }

    public BigInteger[] getBigIntegerArrayData() {
        return JMockData.mock(BigInteger[].class);
    }

    public Boolean getBooleanData() {
        return JMockData.mock(Boolean.class);
    }

    public boolean[] getBooleanUnboxingArrayData() {
        return JMockData.mock(boolean[].class);
    }

    public Boolean[] getBooleanBoxingArrayData() {
        return JMockData.mock(Boolean[].class);
    }

    public Byte getByteData() {
        return JMockData.mock(Byte.class);
    }

    public byte[] getByteUnboxingArrayData() {
        return JMockData.mock(byte[].class);
    }

    public Byte[] getByteBoxingArrayData() {
        return JMockData.mock(Byte[].class);
    }

    public Character getCharacterData() {
        return JMockData.mock(Character.class);
    }

    public char[] getCharacterUnboxingArrayData() {
        return JMockData.mock(char[].class);
    }

    public Character[] getCharacterBoxingArrayData() {
        return JMockData.mock(Character[].class);
    }

    public Date getDateData() {
        return JMockData.mock(Date.class);
    }

    public Date[] getDateArrayData() {
        return JMockData.mock(Date[].class);
    }

    public Double getDoubleData() {
        return JMockData.mock(Double.class);
    }

    public double[] getDoubleUnboxingArrayData() {
        return JMockData.mock(double[].class);
    }

    public Double[] getDoubleBoxingArrayData() {
        return JMockData.mock(Double[].class);
    }

    public Float getFloatData() {
        return JMockData.mock(Float.class);
    }

    public float[] getFloatUnboxingArrayData() {
        return JMockData.mock(float[].class);
    }

    public Float[] getFloatBoxingArrayData() {
        return JMockData.mock(Float[].class);
    }

    public Integer getIntegerData() {
        return JMockData.mock(Integer.class);
    }

    public int[] getIntegerUnboxingArrayData() {
        return JMockData.mock(int[].class);
    }

    public Integer[] getIntegerBoxingArrayData() {
        return JMockData.mock(Integer[].class);
    }

    public Long getLongData() {
        return JMockData.mock(Long.class);
    }

    public long[] getLongUnboxingArrayData() {
        return JMockData.mock(long[].class);
    }

    public Long[] getLongBoxingArrayData() {
        return JMockData.mock(Long[].class);
    }

    public Short getShortData() {
        return JMockData.mock(Short.class);
    }

    public short[] getShortUnboxingArrayData() {
        return JMockData.mock(short[].class);
    }

    public Short[] getShortBoxingArrayData() {
        return JMockData.mock(Short[].class);
    }

    public String getStringData() {
        return JMockData.mock(String.class);
    }

    public String[] getStringArrayData() {
        return JMockData.mock(String[].class);
    }
}
