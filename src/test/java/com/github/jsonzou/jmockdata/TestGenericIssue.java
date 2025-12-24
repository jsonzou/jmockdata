package com.github.jsonzou.jmockdata;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class TestGenericIssue {

    @Test
    public void testGeneric() {
        final GeneralEntity entity = JMockData.mock(GeneralEntity.class);
        assertNotNull(entity);
        assertNotNull(entity.getRows());
        System.out.println("Test passed! Rows: " + entity.getRows());
    }

}

class GeneralEntity{
    private List<GenericEntity<String>> rows;

    public List<GenericEntity<String>> getRows() {
        return rows;
    }

    public void setRows(List<GenericEntity<String>> rows) {
        this.rows = rows;
    }
}

class GenericEntity<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
