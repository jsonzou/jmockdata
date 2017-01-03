/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

import java.util.Date;

/**
 *  mock the Date data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataDateArray implements MockData<Date[]> {
    public Date[] mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockDateObjectArray(context);
    }
    public MockType mockType() {
        return MockType.DATE;
    }
}
