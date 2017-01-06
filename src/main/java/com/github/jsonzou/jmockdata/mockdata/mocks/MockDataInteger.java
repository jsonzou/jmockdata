
package com.github.jsonzou.jmockdata.mockdata.mocks;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  mock the Integer data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataInteger implements MockData<Integer> {
    public Integer mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockInteger(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
