/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.wrapperbean;

import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;

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
