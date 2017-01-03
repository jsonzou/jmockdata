/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.mockdata.mocks;

import org.jsonzou.jmockdata.mockdata.JMockDataManager;
import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.JmockDataInterceptor;
import org.jsonzou.jmockdata.mockdata.MockData;
import org.jsonzou.jmockdata.mockdata.constants.MockType;

/**
 *  the mock proxy of intercept
 * Created by jsonzou on 2016/12/16.
 */
public class MockDataProxy<E> implements MockData<E> ,JmockDataInterceptor{
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
