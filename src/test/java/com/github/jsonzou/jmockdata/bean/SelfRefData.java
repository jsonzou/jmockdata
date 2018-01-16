/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.github.jsonzou.jmockdata.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SelfRefData {

  private String id;
  private String string;
  private Integer Integer;
  private Date date;
  private SelfRefData parent;
  private Map<SelfRefData, SelfRefData> parentMap;
  private SelfRefData[] parentArray;
  private List<SelfRefData> list;
  private List<SelfRefData[]> listArray;
  private List<List<SelfRefData[]>> listListArray;
  private List<SelfRefData>[] arrayList;
  private Map<SelfRefData, SelfRefData[]> mapArray;
  private Map<SelfRefData, List<SelfRefData>> mapList;
  private Map<SelfRefData, List<SelfRefData[]>> mapListArray;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public Integer getInteger() {
    return Integer;
  }

  public void setInteger(Integer integer) {
    this.Integer = integer;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public SelfRefData getParent() {
    return parent;
  }

  public void setParent(SelfRefData parent) {
    this.parent = parent;
  }

  public Map<SelfRefData, SelfRefData> getParentMap() {
    return parentMap;
  }

  public void setParentMap(
      Map<SelfRefData, SelfRefData> parentMap) {
    this.parentMap = parentMap;
  }

  public SelfRefData[] getParentArray() {
    return parentArray;
  }

  public void setParentArray(SelfRefData[] parentArray) {
    this.parentArray = parentArray;
  }

  public List<SelfRefData> getList() {
    return list;
  }

  public void setList(List<SelfRefData> list) {
    this.list = list;
  }

  public List<SelfRefData[]> getListArray() {
    return listArray;
  }

  public void setListArray(List<SelfRefData[]> listArray) {
    this.listArray = listArray;
  }

  public List<List<SelfRefData[]>> getListListArray() {
    return listListArray;
  }

  public void setListListArray(List<List<SelfRefData[]>> listListArray) {
    this.listListArray = listListArray;
  }

  public List<SelfRefData>[] getArrayList() {
    return arrayList;
  }

  public void setArrayList(List<SelfRefData>[] arrayList) {
    this.arrayList = arrayList;
  }

  public Map<SelfRefData, SelfRefData[]> getMapArray() {
    return mapArray;
  }

  public void setMapArray(
      Map<SelfRefData, SelfRefData[]> mapArray) {
    this.mapArray = mapArray;
  }

  public Map<SelfRefData, List<SelfRefData>> getMapList() {
    return mapList;
  }

  public void setMapList(
      Map<SelfRefData, List<SelfRefData>> mapList) {
    this.mapList = mapList;
  }

  public Map<SelfRefData, List<SelfRefData[]>> getMapListArray() {
    return mapListArray;
  }

  public void setMapListArray(
      Map<SelfRefData, List<SelfRefData[]>> mapListArray) {
    this.mapListArray = mapListArray;
  }
}
