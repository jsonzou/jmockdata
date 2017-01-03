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
 * Created by v_zoupengfei on 2016/12/16.
 */
public class MockDataShortUnboxingArray implements MockData<short[]> {
    public short[] mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockShortBaseArray (context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
