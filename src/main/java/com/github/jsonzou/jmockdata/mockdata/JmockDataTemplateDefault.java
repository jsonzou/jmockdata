
package com.github.jsonzou.jmockdata.mockdata;

import com.github.jsonzou.jmockdata.utils.MockUtil;
import com.github.jsonzou.jmockdata.utils.RandomUtil;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
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
    private final Random random = new Random();

    public JmockdataConfig getConfig() {
        return JMockDataManager.getInstance().getConfig();
    }

    public BigDecimal mockBigDecimal(JmockDataContext context) {
        return new BigDecimal(mockDouble(context)).setScale(
                JMockDataManager.getInstance().config().getDecimalScale(),
                BigDecimal.ROUND_DOWN
        );
    }

    public BigDecimal[] mockBigDecimalArray(JmockDataContext context) {
        BigDecimal[] mockDataArr = MockUtil.mockArray(BigDecimal.class,
                getConfig().getArrsizeBigdecimal()[0], getConfig().getArrsizeBigdecimal()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockBigDecimal(context));
        }
        return mockDataArr;
    }

    public BigInteger mockBigInteger(JmockDataContext context) {
        return BigInteger.valueOf(mockLong(context));
    }

    public BigInteger[] mockBigIntegerArray(JmockDataContext context) {
        BigInteger[] mockDataArr = MockUtil.mockArray(BigInteger.class, getConfig().getArrsizeBiginteger()[0],
                getConfig().getArrsizeBiginteger()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockBigInteger(context));
        }
        return mockDataArr;
    }

    public Boolean mockBoolean(JmockDataContext context) {
        if (getConfig().getRangeBoolean()[0].equals(getConfig().getRangeBoolean()[1])) {
            return getConfig().getRangeBoolean()[0];
        }
        return random.nextBoolean();
    }

    public boolean[] mockBooleanUnboxingArray(JmockDataContext context) {
        Boolean[] arrayData = mockBooleanBoxingArray(context);
        int len = arrayData.length;
        boolean[] mockData = new boolean[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Boolean[] mockBooleanBoxingArray(JmockDataContext context) {
        Boolean[] mockDataArr = MockUtil.mockArray(Boolean.class, getConfig().getArrsizeBoolean()[0], getConfig()
                .getArrsizeBoolean()[1]);
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

    public byte[] mockByteUnboxingArray(JmockDataContext context) {
        Byte[] arrayData = mockByteBoxingArray(context);
        int len = arrayData.length;
        byte[] mockData = new byte[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Byte[] mockByteBoxingArray(JmockDataContext context) {
        Byte[] mockDataArr = MockUtil.mockArray(Byte.class, getConfig().getArrsizeByte()[0], getConfig().getArrsizeByte
                ()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockByte(context));
        }
        return mockDataArr;
    }

    public Character mockCharacter(JmockDataContext context) {
        return JMockDataManager.getInstance().getConfig().getSeedCharacter()[RandomUtil
                .randomInteger(JMockDataManager.getInstance().getConfig().getSeedCharacter().length)];
    }

    public char[] mockCharacterUnboxingArray(JmockDataContext context) {
        Character[] arrayData = mockCharacterBoxingArray(context);
        int len = arrayData.length;
        char[] mockData = new char[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Character[] mockCharacterBoxingArray(JmockDataContext context) {
        Character[] mockDataArr = MockUtil.mockArray(Character.class, getConfig().getArrsizeCharacter()[0], getConfig()
                .getArrsizeCharacter()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockCharacter(context));
        }
        return mockDataArr;
    }

    public Date mockDate(JmockDataContext context) {
        Calendar cld = Calendar.getInstance();
        cld.set(RandomUtil.randomInteger(getConfig().getRangeDateY()[0], getConfig().getRangeDateY()[1]),
                RandomUtil.randomInteger(getConfig().getRangeDateM()[0], getConfig().getRangeDateM()[1]),
                RandomUtil.randomInteger(getConfig().getRangeDateD()[0], getConfig().getRangeDateD()[1]),
                RandomUtil.randomInteger(getConfig().getRangeDateH()[0], getConfig().getRangeDateH()[1]),
                RandomUtil.randomInteger(getConfig().getRangeDateMi()[0], getConfig().getRangeDateMi()[1]),
                RandomUtil.randomInteger(getConfig().getRangeDateS()[0], getConfig().getRangeDateS()[1])
        );
        return cld.getTime();
    }

    public Date[] mockDateArray(JmockDataContext context) {
        Date[] mockDataArr = MockUtil.mockArray(Date.class, getConfig().getArrsizeDate()[0], getConfig().getArrsizeDate
                ()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockDate(context));
        }
        return mockDataArr;
    }

    public Double mockDouble(JmockDataContext context) {
        return RandomUtil.randomDouble(JMockDataManager.getInstance().getConfig()
                .getRangeDouble()[0], JMockDataManager.getInstance().getConfig().getRangeDouble()[1]);
    }

    public double[] mockDoubleUnboxingArray(JmockDataContext context) {
        Double[] arrayData = mockDoubleBoxingArray(context);
        int len = arrayData.length;
        double[] mockData = new double[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Double[] mockDoubleBoxingArray(JmockDataContext context) {
        Double[] mockDataArr = MockUtil.mockArray(Double.class, getConfig().getArrsizeDouble()[0], getConfig()
                .getArrsizeDouble()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockDouble(context));
        }
        return mockDataArr;
    }

    public Float mockFloat(JmockDataContext context) {
        return RandomUtil.randomFloat(JMockDataManager.getInstance().getConfig()
                .getRangeFloat()[0], JMockDataManager.getInstance().getConfig().getRangeFloat()[1]);
    }

    public float[] mockFloatUnboxingArray(JmockDataContext context) {
        Float[] arrayData = mockFloatBoxingArray(context);
        int len = arrayData.length;
        float[] mockData = new float[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Float[] mockFloatBoxingArray(JmockDataContext context) {
        Float[] mockDataArr = MockUtil.mockArray(Float.class, getConfig().getArrsizeFloat()[0], getConfig()
                .getArrsizeFloat()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockFloat(context));
        }
        return mockDataArr;
    }

    public Integer mockInteger(JmockDataContext context) {
        return RandomUtil.randomInteger(JMockDataManager.getInstance().getConfig()
                .getRangeInteger()[0], JMockDataManager.getInstance().getConfig().getRangeInteger()[1]);
    }

    public int[] mockIntegerUnboxingArray(JmockDataContext context) {
        Integer[] arrayData = mockIntegerBoxingArray(context);
        int len = arrayData.length;
        int[] mockData = new int[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Integer[] mockIntegerBoxingArray(JmockDataContext context) {
        Integer[] mockDataArr = MockUtil.mockArray(Integer.class, getConfig().getArrsizeInteger()[0], getConfig()
                .getArrsizeInteger()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockInteger(context));
        }
        return mockDataArr;
    }

    public Long mockLong(JmockDataContext context) {
        return RandomUtil.randomLong(JMockDataManager.getInstance().getConfig()
                .getRangeLong()[0], JMockDataManager.getInstance().getConfig().getRangeLong()[1]);
    }

    public long[] mockLongUnboxingArray(JmockDataContext context) {
        Long[] arrayData = mockLongBoxingArray(context);
        int len = arrayData.length;
        long[] mockData = new long[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Long[] mockLongBoxingArray(JmockDataContext context) {
        Long[] mockDataArr = MockUtil.mockArray(Long.class, getConfig().getArrsizeLong()[0], getConfig().getArrsizeLong
                ()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockLong(context));
        }
        return mockDataArr;
    }

    public Short mockShort(JmockDataContext context) {
        return RandomUtil.randomShort(JMockDataManager.getInstance().getConfig()
                .getRangeShort()[0], JMockDataManager.getInstance().getConfig().getRangeShort()[1]);
    }

    public short[] mockShortUnboxingArray(JmockDataContext context) {
        Short[] arrayData = mockShortBoxingArray(context);
        int len = arrayData.length;
        short[] mockData = new short[len];
        while (--len >= 0) {
            mockData[len] = arrayData[len];
        }
        return mockData;
    }

    public Short[] mockShortBoxingArray(JmockDataContext context) {
        Short[] mockDataArr = MockUtil.mockArray(Short.class, getConfig().getArrsizeShort()[0], getConfig()
                .getArrsizeShort()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockShort(context));
        }
        return mockDataArr;
    }

    public String mockString(JmockDataContext context) {
        StringBuffer sb = new StringBuffer();
        int len = RandomUtil.randomInteger(10);
        for (int i = 0; i < len; i++) {
            sb.append(JMockDataManager.getInstance().getConfig().getSeedString()[RandomUtil
                    .randomInteger(JMockDataManager.getInstance().getConfig().getSeedString().length)]).append(" ");
        }
        return sb.toString();
    }

    public String[] mockStringArray(JmockDataContext context) {
        String[] mockDataArr = MockUtil.mockArray(String.class, getConfig().getArrsizeString()[0], getConfig()
                .getArrsizeString()[1]);
        int len = mockDataArr.length;
        while (--len >= 0) {
            Array.set(mockDataArr, len, mockString(context));
        }
        return mockDataArr;
    }

}
