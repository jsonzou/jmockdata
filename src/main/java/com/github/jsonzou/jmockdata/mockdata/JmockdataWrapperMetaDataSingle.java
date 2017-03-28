
/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.mockdata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by v_zoupengfei on 2017/3/27.
 */
public class JmockdataWrapperMetaDataSingle {
    private final BigDecimal bigDecimalData=BigDecimal.ZERO;
    private final BigDecimal[] bigDecimalArrayData=new BigDecimal[]{};

    private final BigInteger bigIntegerData=BigInteger.ZERO;
    private final BigInteger[] bigIntegerArrayData=new BigInteger[]{};

    private final Boolean booleanDataData=Boolean.FALSE;
    private final boolean[] booleanUnboxingArrayData=new boolean[]{};
    private final Boolean[] booleanBoxingArrayData=new Boolean[]{};

    private final Byte byteData=0;
    private final byte[] byteUnboxingArrayData=new byte[]{};
    private final Byte[] byteBoxingArrayData=new Byte[]{};

    private final Character characterData='0';
    private final char[] characterUnboxingArrayData=new char[]{};
    private final Character[] characterBoxingArrayData=new Character[]{};

    private final Date dateData=new Date();
    private final Date[] dateArrayData=new Date[]{};

    private final Double doubleData=0.0d;
    private final double[] doubleUnboxingArrayData=new double[] {};
    private final Double[] doubleBoxingArrayData=new Double[]{};


    private final Float floatData=0.0f;
    private final float[] floatUnboxingArrayData=new float[]{};
    private final Float[] floatBoxingArrayData=new Float[] {};


    private final Integer integerData=0;
    private final int[] integerUnboxingArrayData=new int[]{};
    private final Integer[] integerBoxingArrayData=new Integer[]{};

    private final Long longData=0l;
    private final long[] longUnboxingArrayData=new long[] {};
    private final Long[] longBoxingArrayData=new Long[] {};

    private final Short shortData=0;
    private final short[] shortUnboxingArrayData=new short[]{};
    private final Short[] shortBoxingArrayData=new Short[]{};

    private final String stringData="";
    private final String[] stringArrayData=new String[]{};

    public BigDecimal getBigDecimalData() {
        JmockDataContext context=JmockDataContext.newRootInstance(bigDecimalData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(bigDecimalData.getClass()).mock(context);
    }


    public BigDecimal[] getBigDecimalArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(bigDecimalArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(bigDecimalArrayData.getClass()).mock(context);
    }


    public BigInteger getBigIntegerData() {
        JmockDataContext context=JmockDataContext.newRootInstance(bigIntegerData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(bigIntegerData.getClass()).mock(context);
    }

    public BigInteger[] getBigIntegerArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(bigIntegerArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(bigIntegerArrayData.getClass()).mock(context);
    }

    public Boolean getBooleanDataData() {
        JmockDataContext context=JmockDataContext.newRootInstance(booleanDataData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(booleanDataData.getClass()).mock(context);
    }

    public boolean[] getBooleanUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(booleanUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(booleanUnboxingArrayData.getClass()).mock(context);
    }



    public Boolean[] getBooleanBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(booleanBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(booleanBoxingArrayData.getClass()).mock(context);
    }


    public Byte getByteData() {
        JmockDataContext context=JmockDataContext.newRootInstance(byteData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(byteData.getClass()).mock(context);
    }


    public byte[] getByteUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(byteUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(byteUnboxingArrayData.getClass()).mock(context);
    }



    public Byte[] getByteBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(byteBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(byteBoxingArrayData.getClass()).mock(context);
    }


    public Character getCharacterData() {
        JmockDataContext context=JmockDataContext.newRootInstance(characterData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(characterData.getClass()).mock(context);
    }


    public char[] getCharacterUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(characterUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(characterUnboxingArrayData.getClass()).mock(context);
    }



    public Character[] getCharacterBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(characterBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(characterBoxingArrayData.getClass()).mock(context);
    }



    public Date getDateData() {
        JmockDataContext context=JmockDataContext.newRootInstance(dateData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(dateData.getClass()).mock(context);
    }


    public Date[] getDateArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(dateArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(dateArrayData.getClass()).mock(context);
    }


    public Double getDoubleData() {
        JmockDataContext context=JmockDataContext.newRootInstance(doubleData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(doubleData.getClass()).mock(context);
    }


    public double[] getDoubleUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(doubleUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(doubleUnboxingArrayData.getClass()).mock(context);
    }


    public Double[] getDoubleBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(doubleBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(doubleBoxingArrayData.getClass()).mock(context);
    }



    public Float getFloatData() {
        JmockDataContext context=JmockDataContext.newRootInstance(floatData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(floatData.getClass()).mock(context);
    }

    public float[] getFloatUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(floatUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(floatUnboxingArrayData.getClass()).mock(context);
    }


    public Float[] getFloatBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(floatBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(floatBoxingArrayData.getClass()).mock(context);
    }


    public Integer getIntegerData() {
        JmockDataContext context=JmockDataContext.newRootInstance(integerData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(integerData.getClass()).mock(context);
    }


    public int[] getIntegerUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(integerUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(integerUnboxingArrayData.getClass()).mock(context);
    }



    public Integer[] getIntegerBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(integerBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(integerBoxingArrayData.getClass()).mock(context);
    }


    public Long getLongData() {
        JmockDataContext context=JmockDataContext.newRootInstance(longData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(longData.getClass()).mock(context);
    }


    public long[] getLongUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(longUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(longUnboxingArrayData.getClass()).mock(context);
    }


    public Long[] getLongBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(longBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(longBoxingArrayData.getClass()).mock(context);
    }


    public Short getShortData() {
        JmockDataContext context=JmockDataContext.newRootInstance(shortData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(shortData.getClass()).mock(context);
    }


    public short[] getShortUnboxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(shortUnboxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(shortUnboxingArrayData.getClass()).mock(context);
    }



    public Short[] getShortBoxingArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(shortBoxingArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(shortBoxingArrayData.getClass()).mock(context);
    }



    public String getStringData() {
        JmockDataContext context=JmockDataContext.newRootInstance(stringData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(stringData.getClass()).mock(context);
    }


    public String[] getStringArrayData() {
        JmockDataContext context=JmockDataContext.newRootInstance(stringArrayData.getClass());
        return  JMockDataManager.getInstance().getMockDataBean(stringArrayData.getClass()).mock(context);
    }


}
