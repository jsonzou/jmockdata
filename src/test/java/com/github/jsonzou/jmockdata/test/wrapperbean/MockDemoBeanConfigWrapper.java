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
package com.github.jsonzou.jmockdata.test.wrapperbean;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanSimpleData;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoBeanConfigWrapper extends JmockDataWrapper {
    @JSONField(format = "YYYY-MM-dd HH:mm:ss")
    private Date date;
    private String str;
    private List<String> strs;
    private Boolean bl;
    private Integer integ;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    public Boolean getBl() {
        return bl;
    }

    public void setBl(Boolean bl) {
        this.bl = bl;
    }

    public Integer getInteg() {
        return integ;
    }

    public void setInteg(Integer integ) {
        this.integ = integ;
    }
}
