package com.github.jsonzou.jmockdata.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author: jsonzou
 * @date: 2019/4/28 10:22
 * @version:V1.0
 * @description:
 */
@Accessors
public class LombokBean {
    @Setter
    @Getter
  //  @Accessors(prefix = "i")
    private Long id;
}
