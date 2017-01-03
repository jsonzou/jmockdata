/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata;

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
    BigDecimal[] mockBigDecimalObjectArray(JmockDataContext context);

    BigInteger mockBigInteger(JmockDataContext context);
    BigInteger[] mockBigIntegerObjectArray(JmockDataContext context);

    Boolean mockBoolean(JmockDataContext context);
    boolean[] mockBooleanBaseArray(JmockDataContext context);
    Boolean[] mockBooleanObjectArray(JmockDataContext context);

    Byte mockByte(JmockDataContext context);
    byte[] mockByteBaseArray(JmockDataContext context);
    Byte[] mockByteObjectArray(JmockDataContext context);

    Character mockCharacter(JmockDataContext context);
    char[] mockCharacterBaseArray(JmockDataContext context);
    Character[] mockCharacterObjectArray(JmockDataContext context);

    Date mockDate(JmockDataContext context);
    Date[] mockDateObjectArray(JmockDataContext context);

    Double mockDouble(JmockDataContext context);
    double[] mockDoubleBaseArray(JmockDataContext context);
    Double[] mockDoubleObjectArray(JmockDataContext context);


    Float mockFloat(JmockDataContext context);
    float[] mockFloatBaseArray(JmockDataContext context);
    Float[] mockFloatObjectArray(JmockDataContext context);


    Integer mockInteger(JmockDataContext context);
    int[] mockIntegerBaseArray(JmockDataContext context);
    Integer[] mockIntegerObjectArray(JmockDataContext context);

    Long mockLong(JmockDataContext context);
    long[] mockLongBaseArray(JmockDataContext context);
    Long[] mockLongObjectArray(JmockDataContext context);

    Short mockShort(JmockDataContext context);
    short[] mockShortBaseArray(JmockDataContext context);
    Short[] mockShortObjectArray(JmockDataContext context);

    String mockString(JmockDataContext context);
    String[] mockStringObjectArray(JmockDataContext context);

}
