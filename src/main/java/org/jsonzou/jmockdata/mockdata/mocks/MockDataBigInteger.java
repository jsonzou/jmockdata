/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import java.math.BigInteger;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

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
