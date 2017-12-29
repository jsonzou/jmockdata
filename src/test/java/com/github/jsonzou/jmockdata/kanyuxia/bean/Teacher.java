package com.github.jsonzou.jmockdata.kanyuxia.bean;

import java.util.List;
import lombok.Data;

@Data
public class Teacher extends People {

  private List<People> list;

}
