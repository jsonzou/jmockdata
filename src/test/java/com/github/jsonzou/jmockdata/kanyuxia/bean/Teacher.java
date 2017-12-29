package com.github.jsonzou.jmockdata.kanyuxia.bean;

import java.util.List;
import lombok.Data;


public class Teacher extends People {

  private List<People> list;

  public List<People> getList() {
    return list;
  }

  public void setList(List<People> list) {
    this.list = list;
  }
}
