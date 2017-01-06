
package com.github.jsonzou.jmockdata.test.wrapperbean;

import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanSelfRefData;

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
