package com.github.jsonzou.jmockdata.kanyuxia.bean;

import java.util.List;
import java.util.Map;

import com.github.jsonzou.jmockdata.test.SuperToString;
import lombok.Data;

@Data
public class People extends SuperToString{

  private String name;

  private int age;

  private String sex;

  private boolean married;

  private List<List<User>> users;

  private Map<String, User> map;

}
