/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.test.wrapperbean;

import org.jsonzou.jmockdata.mockdata.JmockDataWrapper;
import org.jsonzou.jmockdata.test.testbean.MockDemoBeanSelfRefData;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoBeanSelfRefDataWrapper extends JmockDataWrapper {
    private MockDemoBeanSelfRefData selfRefData;

    public MockDemoBeanSelfRefData getSelfRefData() {
        return selfRefData;
    }

    public void setSelfRefData(MockDemoBeanSelfRefData selfRefData) {
        this.selfRefData = selfRefData;
    }
}
