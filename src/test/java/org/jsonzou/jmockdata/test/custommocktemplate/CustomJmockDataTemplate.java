/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package org.jsonzou.jmockdata.test.custommocktemplate;

import org.jsonzou.jmockdata.mockdata.JmockDataContext;
import org.jsonzou.jmockdata.mockdata.JmockDataTemplateDefault;

/**
 * Created by jsonzou on 2016/12/27.
 */
public class CustomJmockDataTemplate extends JmockDataTemplateDefault{
    @Override
    public String mockString(JmockDataContext context) {
        if("stringv".equals(context.getName())){
            return "ABC-{"+super.mockString(context)+"}-XYZ";
        }
        return super.mockString(context);
    }
}
