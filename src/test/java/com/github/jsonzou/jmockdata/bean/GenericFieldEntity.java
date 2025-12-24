package com.github.jsonzou.jmockdata.bean;

/**
 * Generic entity with a parameterized type field
 */
public class GenericFieldEntity<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
