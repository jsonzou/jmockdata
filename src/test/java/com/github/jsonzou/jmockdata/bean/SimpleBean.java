/**
 * *****************************************************
 * Copyright (C) 2020 pds-inc.com.cn. All Rights Reserved
 * This file is part of pds project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.github.jsonzou.jmockdata.bean;

import lombok.Setter;

/**
 * @author jsonzou<pengfei.zou @ pds-inc.com.cn>
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
