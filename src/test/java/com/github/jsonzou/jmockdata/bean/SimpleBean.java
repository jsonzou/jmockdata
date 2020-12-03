package com.github.jsonzou.jmockdata.bean;

import lombok.Setter;

/**
 * @author jsonzou
 * @date 12/02/2020 18:33
 */
public class SimpleBean {
    private byte byteNum;
    private boolean booleanNum;
    private char charNum;
    private short shortNum;
    private int integerNum;
    private long longNum;
    private float floatNum;
    private double doubleNum;
    @Setter
    private String stringValue;
}
