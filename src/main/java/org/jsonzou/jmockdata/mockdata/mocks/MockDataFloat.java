/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  mock the Float data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataFloat implements MockData<Float> {
    public Float mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockFloat(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
