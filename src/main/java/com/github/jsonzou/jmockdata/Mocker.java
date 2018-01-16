package com.github.jsonzou.jmockdata;

/**
 * 模拟器接口
 */
public interface Mocker<T> {

  T mock(MockConfig mockConfig);

}
