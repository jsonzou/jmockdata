
package com.github.jsonzou.jmockdata.mockdata.mocks;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

import java.math.BigInteger;

/**
 * mock the BigInteger data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataBigIntegerArray implements MockData<BigInteger[]> {
    public BigInteger[] mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockBigIntegerObjectArray(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
