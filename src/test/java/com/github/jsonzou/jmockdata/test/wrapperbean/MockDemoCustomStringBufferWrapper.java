/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.wrapperbean;

import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoCustomStringBufferWrapper extends JmockDataWrapper {
    private StringBuffer stringBuffer;

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public void setStringBuffer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }
}
