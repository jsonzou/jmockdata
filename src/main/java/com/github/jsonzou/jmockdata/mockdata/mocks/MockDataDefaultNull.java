/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.mockdata.mocks;

import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  mock the NULL
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataDefaultNull<E> implements MockData<E> {
    public E mock(JmockDataContext context) {
        return null;
    }
    public MockType mockType() {
        return MockType.NULL;
    }
}
