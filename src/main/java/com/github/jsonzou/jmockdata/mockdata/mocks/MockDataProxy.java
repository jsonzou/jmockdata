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

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;
import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.JmockDataInterceptor;
import com.github.jsonzou.jmockdata.mockdata.MockData;
import com.github.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  the mock proxy of intercept
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataProxy<E> implements MockData<E>,JmockDataInterceptor{
    private MockData<E> mockData;
    public MockDataProxy(){

    }
    public MockDataProxy(MockData<E> mockData){
          this.mockData=mockData;
    }
    public E mock(JmockDataContext context) {
        Boolean isContinue=before(this.mockData,context);
        if(!isContinue){
            return null;
        }
      try {
            E result = mockData.mock(context);
            after(this.mockData,context);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            error(this.mockData,context,e);
            return null;
        } finally {
          finallyDo(this.mockData,context);
        }

    }
    public MockType mockType() {
        return mockData.mockType();
    }


    public Boolean before(MockData mockData, JmockDataContext context) {
        Boolean isContinue=true;
        if(JMockDataManager.getInstance().interceptors().size()>0){
            for (JmockDataInterceptor inter:JMockDataManager.getInstance().interceptors()){
                if(inter.interceptRule(mockData,context)){
                    isContinue= inter.before(mockData,context);
                    if(!isContinue){
                        break;
                    }
                }

            }
        }
        return isContinue;
    }

    public void after(MockData mockData, JmockDataContext context) {
        if(JMockDataManager.getInstance().interceptors().size()>0){
            for (JmockDataInterceptor inter:JMockDataManager.getInstance().interceptors()){
                if(inter.interceptRule(mockData,context)) {
                    inter.after(mockData, context);
                }
            }
        }
    }

    public void error(MockData mockData, JmockDataContext context, Throwable e) {
        if(JMockDataManager.getInstance().interceptors().size()>0){
            for (JmockDataInterceptor inter:JMockDataManager.getInstance().interceptors()){
                if(inter.interceptRule(mockData,context)) {
                    inter.error(mockData, context, e);
                }
            }
        }
    }

    public void finallyDo(MockData mockData, JmockDataContext context) {
        if(JMockDataManager.getInstance().interceptors().size()>0){
            for (JmockDataInterceptor inter:JMockDataManager.getInstance().interceptors()){
                if(inter.interceptRule(mockData,context)) {
                    inter.finallyDo(mockData, context);
                }
            }
        }
    }

    public Boolean interceptRule(MockData mockData, JmockDataContext context) {
        return true;
    }

}
