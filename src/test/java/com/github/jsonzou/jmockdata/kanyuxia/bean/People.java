package com.github.jsonzou.jmockdata.kanyuxia.bean;

import java.util.List;
import java.util.Map;

import com.github.jsonzou.jmockdata.test.SuperToString;
import lombok.Data;


public class People {

  private String name;

  private int age;

  private String sex;

  private boolean married;

  private List<List<User>> users;

  private Map<String, User> map;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public boolean isMarried() {
    return married;
  }

  public void setMarried(boolean married) {
    this.married = married;
  }

  public List<List<User>> getUsers() {
    return users;
  }

  public void setUsers(List<List<User>> users) {
    this.users = users;
  }

  public Map<String, User> getMap() {
    return map;
  }

  public void setMap(Map<String, User> map) {
    this.map = map;
  }
}
