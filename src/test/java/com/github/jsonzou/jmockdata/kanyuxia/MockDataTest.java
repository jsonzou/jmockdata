package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.bean.People;
import org.junit.Test;

public class MockDataTest {

  @Test
  public void test() throws Exception {
    People teacher = JMock.mockData(People.class);
    System.out.println(teacher);
  }

}
