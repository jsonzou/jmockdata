/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

import java.math.BigDecimal;

/**
 *  mock the BigDecimal data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataBigDecimal implements MockData<BigDecimal> {
    public BigDecimal mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockBigDecimal(context);
    }

    public MockType mockType() {
        return MockType.NUMBER;
    }
}
