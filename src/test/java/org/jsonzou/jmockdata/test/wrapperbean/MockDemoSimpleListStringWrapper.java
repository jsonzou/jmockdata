/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.test.wrapperbean;

import org.jsonzou.jmockdata.mockdata.JmockDataWrapper;

import java.util.List;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoSimpleListStringWrapper extends JmockDataWrapper {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
