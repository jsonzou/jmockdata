package com.github.jsonzou.jmockdata.bean;

import java.util.List;

/**
 * Bean containing a list of generic entities
 * Used to test the fix for issue: 普通对象包含含有泛型字段的集合时mock失败
 */
public class GeneralBean {
    private List<GenericFieldEntity<String>> rows;

    public List<GenericFieldEntity<String>> getRows() {
        return rows;
    }

    public void setRows(List<GenericFieldEntity<String>> rows) {
        this.rows = rows;
    }
}
