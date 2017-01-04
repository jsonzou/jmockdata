/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.mockdata.mocks;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

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
