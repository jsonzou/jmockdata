package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.kanyuxia.circular.Dog;
import org.junit.Test;

/**
 * 循环依赖测试
 * @author KanYuXia
 * @date 2018/1/12
 */
public class CircularDependencyTest {

  @Test
  public void Test() throws Exception {
    Dog dog = JMock.mockData(Dog.class);
    System.out.println(dog);
  }
}
