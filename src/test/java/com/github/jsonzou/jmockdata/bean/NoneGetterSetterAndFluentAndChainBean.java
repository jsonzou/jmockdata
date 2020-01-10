/**
 * *****************************************************
 * Copyright (C) 2020 bytedance.com. All Rights Reserved
 * This file is part of bytedance EA project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.github.jsonzou.jmockdata.bean;

/**
 * @author jsonzou<keko-boy@163.com>
 * @date 01/10/2020 14:18
 */
public class NoneGetterSetterAndFluentAndChainBean {
    private String noneGeterSetter;
    private String haveGetterSetter;
    private String fluent;
    public String fluent(){
        return this.fluent;
    }
    public NoneGetterSetterAndFluentAndChainBean fluent(String fluent){
        this.fluent = fluent;
        return this;
    }
}
