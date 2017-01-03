/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata;

import org.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 * <p>模拟数据类型bean接口</p>
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/16.
 */
public interface MockData<T> {
    T mock(JmockDataContext context);
    MockType mockType();
}
