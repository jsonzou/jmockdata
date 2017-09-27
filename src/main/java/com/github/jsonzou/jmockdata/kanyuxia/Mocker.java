package com.github.jsonzou.jmockdata.kanyuxia;

/**
 * 模拟器接口
 */
public interface Mocker<T> {

  T mockData(MockConfig mockConfig) throws Exception;
}
