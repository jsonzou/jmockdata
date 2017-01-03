/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

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
