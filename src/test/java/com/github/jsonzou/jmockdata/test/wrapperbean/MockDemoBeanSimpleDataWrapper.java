/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.wrapperbean;

import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanSimpleData;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoBeanSimpleDataWrapper extends JmockDataWrapper {
    private MockDemoBeanSimpleData simpleData;

    public MockDemoBeanSimpleData getSimpleData() {
        return simpleData;
    }

    public void setSimpleData(MockDemoBeanSimpleData simpleData) {
        this.simpleData = simpleData;
    }
}
