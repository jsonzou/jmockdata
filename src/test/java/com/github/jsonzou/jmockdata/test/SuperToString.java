package com.github.jsonzou.jmockdata.test;

import com.alibaba.fastjson.JSON;

/**
 * Created by jsonzou on 2017/12/29.
 */
public class SuperToString {
    @Override
    public String toString() {

        return JSON.toJSONString(this,true);
    }
}
