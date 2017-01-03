/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.test.wrapperbean;

import org.jsonzou.jmockdata.mockdata.JmockDataWrapper;

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
