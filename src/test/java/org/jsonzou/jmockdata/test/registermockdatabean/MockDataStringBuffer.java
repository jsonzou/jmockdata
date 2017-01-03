/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.test.registermockdatabean;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;
import org.jsonzou.jmockdata.utils.RandomUtil;

/**
 *  mock the StringBuffer data
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataStringBuffer implements MockData<StringBuffer> {
    public StringBuffer mock(JmockDataContext context) {
        StringBuffer sb = new StringBuffer();
        int len= RandomUtil.randomIntNotZero(50);
        for (int i=0;i<len;i++){
            sb.append(JMockDataManager.getInstance().getMockDataBean(Character.class).mock(context));
        }
        return sb;
    }
    public MockType mockType() {
        return MockType.STRING;
    }
}
