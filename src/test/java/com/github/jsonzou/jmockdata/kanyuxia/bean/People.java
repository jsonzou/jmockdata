package com.github.jsonzou.jmockdata.kanyuxia.bean;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class People {

  private String name;

  private int age;

  private String sex;

  private boolean married;

  private List<List<User>> users;

  private Map<String, User> map;
}
