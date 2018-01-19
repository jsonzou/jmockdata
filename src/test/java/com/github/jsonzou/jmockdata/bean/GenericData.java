package com.github.jsonzou.jmockdata.bean;

import java.util.List;
import lombok.Data;

/**
 * Created by jsonzou on 2018/1/17.
 */
@Data
public class GenericData<A, B> {

//  private Integer id;
  private List<A[]> message;
  private B data;

}
