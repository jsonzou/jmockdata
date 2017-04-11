/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jsonzou.jmockdata.mockdata.mocks;

import java.math.BigInteger;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 * mock the BigInteger data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataBigInteger implements MockData<BigInteger> {
    public BigInteger mock(JmockDataContext context) {
        return JMockDataManager.getInstance().getMockTemplate().mockBigInteger(context);
    }
    public MockType mockType() {
        return MockType.NUMBER;
    }
}
