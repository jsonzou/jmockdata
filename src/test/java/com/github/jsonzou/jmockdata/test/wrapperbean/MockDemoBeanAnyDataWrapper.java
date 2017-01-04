/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.github.jsonzou.jmockdata.test.wrapperbean;

import com.github.jsonzou.jmockdata.mockdata.JmockDataWrapper;
import com.github.jsonzou.jmockdata.test.testbean.MockDemoBeanAnyData;

import java.util.List;
import java.util.Map;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class MockDemoBeanAnyDataWrapper extends JmockDataWrapper {
    private MockDemoBeanAnyData bean;
    private List<MockDemoBeanAnyData> beans;
    private Map<String,Integer> map;
    private Map<String,MockDemoBeanAnyData> mapBean;
    private List<Map<String,Integer>> listMap;
    private Map<String,List<String>> mapList;
    private Map<String,List<String>>[] mapListArray;
    private Map<String,Integer>[] mapArray;
    private Map<String,MockDemoBeanAnyData>[] mapBeanArray;
    private Map<String,Map<String,List<String>>[]>[] mapArray2;
    private List<Map<String,Integer>>[] listArray;
    private List<Map<String,Map<String,List<String>>[]>>[] listArray2;

    public List<Map<String, Integer>>[] getListArray() {
        return listArray;
    }

    public void setListArray(List<Map<String, Integer>>[] listArray) {
        this.listArray = listArray;
    }

    public List<Map<String, Map<String, List<String>>[]>>[] getListArray2() {
        return listArray2;
    }

    public void setListArray2(List<Map<String, Map<String, List<String>>[]>>[] listArray2) {
        this.listArray2 = listArray2;
    }

    public Map<String, MockDemoBeanAnyData>[] getMapBeanArray() {
        return mapBeanArray;
    }

    public void setMapBeanArray(Map<String, MockDemoBeanAnyData>[] mapBeanArray) {
        this.mapBeanArray = mapBeanArray;
    }

    public Map<String, Map<String, List<String>>[]>[] getMapArray2() {
        return mapArray2;
    }

    public void setMapArray2(Map<String, Map<String, List<String>>[]>[] mapArray2) {
        this.mapArray2 = mapArray2;
    }

    public Map<String, MockDemoBeanAnyData> getMapBean() {
        return mapBean;
    }

    public void setMapBean(Map<String, MockDemoBeanAnyData> mapBean) {
        this.mapBean = mapBean;
    }

    public Map<String, List<String>>[] getMapListArray() {
        return mapListArray;
    }

    public void setMapListArray(Map<String, List<String>>[] mapListArray) {
        this.mapListArray = mapListArray;
    }

    public Map<String, Integer>[] getMapArray() {
        return mapArray;
    }

    public void setMapArray(Map<String, Integer>[] mapArray) {
        this.mapArray = mapArray;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public List<Map<String, Integer>> getListMap() {
        return listMap;
    }

    public void setListMap(List<Map<String, Integer>> listMap) {
        this.listMap = listMap;
    }

    public Map<String, List<String>> getMapList() {
        return mapList;
    }

    public void setMapList(Map<String, List<String>> mapList) {
        this.mapList = mapList;
    }

    public MockDemoBeanAnyData getBean() {
        return bean;
    }

    public void setBean(MockDemoBeanAnyData bean) {
        this.bean = bean;
    }

    public List<MockDemoBeanAnyData> getBeans() {
        return beans;
    }

    public void setBeans(List<MockDemoBeanAnyData> beans) {
        this.beans = beans;
    }
}
