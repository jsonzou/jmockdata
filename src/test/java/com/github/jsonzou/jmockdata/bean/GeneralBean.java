package com.github.jsonzou.jmockdata.bean;

import java.util.List;

/**
 * Bean containing a list of generic entities
 * Used to test the fix for issue: Mocking fails when regular objects contain collections with generic fields
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
