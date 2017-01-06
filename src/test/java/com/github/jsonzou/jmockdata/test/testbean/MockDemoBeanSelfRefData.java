
package com.github.jsonzou.jmockdata.test.testbean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jsonzou on 2016/12/31.
 */
public class MockDemoBeanSelfRefData {
    private String id;
    private String aString;
    private Integer aInteger;
    private Date aDate;
    private MockDemoBeanSelfRefData parent;
    private Map<MockDemoBeanSelfRefData,MockDemoBeanSelfRefData> parentMap;
    private MockDemoBeanSelfRefData[] parentArray;
    private List<MockDemoBeanSelfRefData> list;
    private List<MockDemoBeanSelfRefData[]> listArray;
    private List<List<MockDemoBeanSelfRefData[]>> listListArray;
    private List<MockDemoBeanSelfRefData>[] arrayList;
    private Map<MockDemoBeanSelfRefData,MockDemoBeanSelfRefData[]> mapArray;
    private Map<MockDemoBeanSelfRefData,List<MockDemoBeanSelfRefData>> mapList;
    private Map<MockDemoBeanSelfRefData,List<MockDemoBeanSelfRefData[]>> mapListArray;

    public Map<MockDemoBeanSelfRefData, MockDemoBeanSelfRefData[]> getMapArray() {
        return mapArray;
    }

    public void setMapArray(Map<MockDemoBeanSelfRefData, MockDemoBeanSelfRefData[]> mapArray) {
        this.mapArray = mapArray;
    }

    public Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData>> getMapList() {
        return mapList;
    }

    public void setMapList(Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData>> mapList) {
        this.mapList = mapList;
    }

    public Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData[]>> getMapListArray() {
        return mapListArray;
    }

    public void setMapListArray(Map<MockDemoBeanSelfRefData, List<MockDemoBeanSelfRefData[]>> mapListArray) {
        this.mapListArray = mapListArray;
    }

    public List<MockDemoBeanSelfRefData>[] getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<MockDemoBeanSelfRefData>[] arrayList) {
        this.arrayList = arrayList;
    }

    public List<List<MockDemoBeanSelfRefData[]>> getListListArray() {
        return listListArray;
    }

    public void setListListArray(List<List<MockDemoBeanSelfRefData[]>> listListArray) {
        this.listListArray = listListArray;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public Integer getaInteger() {
        return aInteger;
    }

    public void setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public List<MockDemoBeanSelfRefData[]> getListArray() {
        return listArray;
    }

    public void setListArray(List<MockDemoBeanSelfRefData[]> listArray) {
        this.listArray = listArray;
    }
}
