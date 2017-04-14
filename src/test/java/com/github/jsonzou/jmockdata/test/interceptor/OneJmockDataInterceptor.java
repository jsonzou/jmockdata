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
package com.github.jsonzou.jmockdata.test.interceptor;

import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.JmockDataInterceptor;
import com.github.jsonzou.jmockdata.mockdata.MockData;

import java.util.Arrays;

/**
 * Created by jsonzou on 2016/12/27.
 */
public class OneJmockDataInterceptor implements JmockDataInterceptor{
    public Boolean before(MockData mockData, JmockDataContext context) {
        System.out.println("before..."+context.getName());
        return true;
    }

    public void after(MockData mockData, JmockDataContext context) {
        System.out.println("after..."+context.getName());
    }

    public void error(MockData mockData, JmockDataContext context, Throwable e) {
        System.out.println("error..."+context.getName());
    }

    public void finallyDo(MockData mockData, JmockDataContext context) {
        System.out.println("finally..."+context.getName());
    }

    public Boolean interceptRule(MockData mockData, JmockDataContext context) {
         Class[] interceptClass=new Class[]{
                 String.class
         };
        return Arrays.asList(interceptClass).contains(context.getMockType());
    }

}
