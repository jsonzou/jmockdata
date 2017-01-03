/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata;

/**
 * <p>模拟数据结果包装类</p>
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public abstract class JmockDataWrapper {
    private JmockDataContext jmockDataContext;

    public JmockDataContext getJmockDataContext() {
        return jmockDataContext;
    }

    public void setJmockDataContext(JmockDataContext jmockDataContext) {
        this.jmockDataContext = jmockDataContext;
    }
}
