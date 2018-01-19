package com.github.jsonzou.jmockdata.bean;

import lombok.Data;

/**
 * Created by jsonzou on 2018/1/17.
 */
@Data
public class GenericData<A, B, C> {

  private A a;
  private B b;
  private C c;

}
