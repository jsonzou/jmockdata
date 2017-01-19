
package com.github.jsonzou.jmockdata.mockdata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * <p>默认提供模拟类型数据模板类</p>
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public interface JmockDataTemplate {
    BigDecimal mockBigDecimal(JmockDataContext context);
    BigDecimal[] mockBigDecimalArray(JmockDataContext context);

    BigInteger mockBigInteger(JmockDataContext context);
    BigInteger[] mockBigIntegerArray(JmockDataContext context);

    Boolean mockBoolean(JmockDataContext context);
    boolean[] mockBooleanUnboxingArray(JmockDataContext context);
    Boolean[] mockBooleanBoxingArray(JmockDataContext context);

    Byte mockByte(JmockDataContext context);
    byte[] mockByteUnboxingArray(JmockDataContext context);
    Byte[] mockByteBoxingArray(JmockDataContext context);

    Character mockCharacter(JmockDataContext context);
    char[] mockCharacterUnboxingArray(JmockDataContext context);
    Character[] mockCharacterBoxingArray(JmockDataContext context);

    Date mockDate(JmockDataContext context);
    Date[] mockDateArray(JmockDataContext context);

    Double mockDouble(JmockDataContext context);
    double[] mockDoubleUnboxingArray(JmockDataContext context);
    Double[] mockDoubleBoxingArray(JmockDataContext context);


    Float mockFloat(JmockDataContext context);
    float[] mockFloatUnboxingArray(JmockDataContext context);
    Float[] mockFloatBoxingArray(JmockDataContext context);


    Integer mockInteger(JmockDataContext context);
    int[] mockIntegerUnboxingArray(JmockDataContext context);
    Integer[] mockIntegerBoxingArray(JmockDataContext context);

    Long mockLong(JmockDataContext context);
    long[] mockLongUnboxingArray(JmockDataContext context);
    Long[] mockLongBoxingArray(JmockDataContext context);

    Short mockShort(JmockDataContext context);
    short[] mockShortUnboxingArray(JmockDataContext context);
    Short[] mockShortBoxingArray(JmockDataContext context);

    String mockString(JmockDataContext context);
    String[] mockStringArray(JmockDataContext context);

    JmockdataConfig getConfig();
}
