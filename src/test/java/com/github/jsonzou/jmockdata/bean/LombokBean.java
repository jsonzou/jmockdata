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
public class LombokBean {
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    @Accessors(chain = true, fluent = true)
    private Long a;
}
