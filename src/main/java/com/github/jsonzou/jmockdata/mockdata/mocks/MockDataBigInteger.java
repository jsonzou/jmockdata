/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.mockdata.mocks;

import java.math.BigInteger;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 * mock the BigInteger data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataBigInteger implements MockData<BigInteger> {
    public BigInteger mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockBigInteger(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
