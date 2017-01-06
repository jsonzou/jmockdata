
package com.github.jsonzou.jmockdata.mockdata.mocks;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  mock the Long data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataLongBoxingArray implements MockData<Long[]> {
    public Long[] mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockLongObjectArray (context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
