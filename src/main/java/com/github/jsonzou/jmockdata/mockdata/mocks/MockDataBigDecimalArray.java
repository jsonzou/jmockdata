
package com.github.jsonzou.jmockdata.mockdata.mocks;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

import java.math.BigDecimal;

/**
 *  mock the BigDecimal data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataBigDecimalArray implements MockData<BigDecimal[]> {
    public BigDecimal[] mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockBigDecimalArray(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
