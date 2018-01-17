package com.github.jsonzou.jmockdata.bean;

import lombok.Data;

/**
 * Created by jsonzou on 2018/1/17.
 */
@Data
public class GenericData<A,B> {
  private Integer id;
   private A message;
   private B data;
}
