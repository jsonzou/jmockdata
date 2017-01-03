/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  mock the Short data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataShort implements MockData<Short> {
    public Short mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockShort(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
