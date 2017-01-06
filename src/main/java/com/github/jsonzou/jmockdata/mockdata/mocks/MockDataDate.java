
package com.github.jsonzou.jmockdata.mockdata.mocks;

import java.util.Date;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  mock the Date data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataDate implements MockData<Date> {
    public Date mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockDate(context);
    }

    public MockType mockType() {
        return MockType.DATE;
    }
}
