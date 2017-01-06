
package com.github.jsonzou.jmockdata.test.custommocktemplate;

import com.github.jsonzou.jmockdata.mockdata.JmockDataContext;
import com.github.jsonzou.jmockdata.mockdata.JmockDataTemplateDefault;

/**
 * Created by jsonzou on 2016/12/27.
 */
public class CustomJmockDataTemplate extends JmockDataTemplateDefault {
    @Override
    public String mockString(JmockDataContext context) {
        if("stringv".equals(context.getName())){
            return "ABC-{"+super.mockString(context)+"}-XYZ";
        }
        return super.mockString(context);
    }
}
