/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.extends_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.jsonzou.jmockdata.JMockData;

import java.lang.reflect.Field;

public class ExtendTest {

    public static void main(String[] args) {
        B b = JMockData.mockSimpleType(B.class);
        System.out.println(JSON.toJSONStringWithDateFormat(b, "YYYY-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat));

    }
}