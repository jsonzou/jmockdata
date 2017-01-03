/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata;

import org.jsonzou.jmockdata.utils.MockUtil;
import org.jsonzou.jmockdata.utils.RandomUtil;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * <p>默认提供模拟类型数据模板类默认实现</p>
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public class JmockDataTemplateDefault implements JmockDataTemplate {
    private final String ALL_SIMPLE_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final Random random = new Random();

    public BigDecimal mockBigDecimal(JmockDataContext context) {
        return new BigDecimal(mockDouble(context));
    }

    public BigDecimal[] mockBigDecimalObjectArray(JmockDataContext context) {
        BigDecimal[] mockDataArr = MockUtil.mockArray(BigDecimal.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockBigDecimal(context));
        }
        return mockDataArr;
    }

    public BigInteger mockBigInteger(JmockDataContext context) {

        return BigInteger.valueOf(random.nextLong());
    }

    public BigInteger[] mockBigIntegerObjectArray(JmockDataContext context) {
        BigInteger[] mockDataArr = MockUtil.mockArray(BigInteger.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockBigInteger(context));
        }
        return mockDataArr;
    }

    public Boolean mockBoolean(JmockDataContext context) {
        return random.nextBoolean();
    }

    public boolean[] mockBooleanBaseArray(JmockDataContext context) {
        Boolean[] arrayData = mockBooleanObjectArray(context);
        int len = arrayData.length;
        boolean[] mockData = new boolean[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Boolean[] mockBooleanObjectArray(JmockDataContext context) {
        Boolean[] mockDataArr = MockUtil.mockArray(Boolean.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockBoolean(context));
        }
        return mockDataArr;
    }

    public Byte mockByte(JmockDataContext context) {
        byte[] nbyte = new byte[1];
        random.nextBytes(nbyte);
        return nbyte[0];
    }

    public byte[] mockByteBaseArray(JmockDataContext context) {
        Byte[] arrayData = mockByteObjectArray(context);
        int len = arrayData.length;
        byte[] mockData = new byte[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Byte[] mockByteObjectArray(JmockDataContext context) {
        Byte[] mockDataArr = MockUtil.mockArray(Byte.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockByte(context));
        }
        return mockDataArr;
    }

    public Character mockCharacter(JmockDataContext context) {
        return ALL_SIMPLE_CHAR.charAt(RandomUtil.randomIntNotZero(ALL_SIMPLE_CHAR.length()));
    }

    public char[] mockCharacterBaseArray(JmockDataContext context) {
        Character[] arrayData = mockCharacterObjectArray(context);
        int len = arrayData.length;
        char[] mockData = new char[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Character[] mockCharacterObjectArray(JmockDataContext context) {
        Character[] mockDataArr = MockUtil.mockArray(Character.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockCharacter(context));
        }
        return mockDataArr;
    }

    public Date mockDate(JmockDataContext context) {
        Date mockData = new Date();
        mockData.setMonth(random.nextInt(12));
        mockData.setDate(random.nextInt(30));
        mockData.setHours(random.nextInt(60));
        mockData.setMinutes(random.nextInt(60));
        mockData.setSeconds(random.nextInt(60));
        return mockData;
    }

    public Date[] mockDateObjectArray(JmockDataContext context) {
        Date[] mockDataArr = MockUtil.mockArray(Date.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockDate(context));
        }
        return mockDataArr;
    }

    public Double mockDouble(JmockDataContext context) {
        return Math.abs(random.nextDouble()) * 100;
    }

    public double[] mockDoubleBaseArray(JmockDataContext context) {
        Double[] arrayData = mockDoubleObjectArray(context);
        int len = arrayData.length;
        double[] mockData = new double[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Double[] mockDoubleObjectArray(JmockDataContext context) {
        Double[] mockDataArr = MockUtil.mockArray(Double.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockDouble(context));
        }
        return mockDataArr;
    }

    public Float mockFloat(JmockDataContext context) {
        return Math.abs(random.nextFloat()) * 100;
    }

    public float[] mockFloatBaseArray(JmockDataContext context) {
        Float[] arrayData = mockFloatObjectArray(context);
        int len = arrayData.length;
        float[] mockData = new float[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Float[] mockFloatObjectArray(JmockDataContext context) {
        Float[] mockDataArr = MockUtil.mockArray(Float.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockFloat(context));
        }
        return mockDataArr;
    }

    public Integer mockInteger(JmockDataContext context) {
        return Math.abs(random.nextInt(Integer.MAX_VALUE));
    }

    public int[] mockIntegerBaseArray(JmockDataContext context) {
        Integer[] arrayData = mockIntegerObjectArray(context);
        int len = arrayData.length;
        int[] mockData = new int[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Integer[] mockIntegerObjectArray(JmockDataContext context) {
        Integer[] mockDataArr = MockUtil.mockArray(Integer.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockInteger(context));
        }
        return mockDataArr;
    }

    public Long mockLong(JmockDataContext context) {
        return Math.abs(random.nextLong());
    }

    public long[] mockLongBaseArray(JmockDataContext context) {
        Long[] arrayData = mockLongObjectArray(context);
        int len = arrayData.length;
        long[] mockData = new long[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Long[] mockLongObjectArray(JmockDataContext context) {
        Long[] mockDataArr = MockUtil.mockArray(Long.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockLong(context));
        }
        return mockDataArr;
    }

    public Short mockShort(JmockDataContext context) {
        return Short.parseShort(Math.abs(random.nextInt(Short.MAX_VALUE)) + "");
    }

    public short[] mockShortBaseArray(JmockDataContext context) {
        Short[] arrayData = mockShortObjectArray(context);
        int len = arrayData.length;
        short[] mockData = new short[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Short[] mockShortObjectArray(JmockDataContext context) {
        Short[] mockDataArr = MockUtil.mockArray(Short.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockShort(context));
        }
        return mockDataArr;
    }

    public String mockString(JmockDataContext context) {
        StringBuffer sb = new StringBuffer();
        int len = RandomUtil.randomIntNotZero(50);
        for (int i = 0; i < len; i++) {
            sb.append(mockCharacter(context));
        }
        return sb.toString();
    }

    public String[] mockStringObjectArray(JmockDataContext context) {
        String[] mockDataArr = MockUtil.mockArray(String.class);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockString(context));
        }
        return mockDataArr;
    }

}
