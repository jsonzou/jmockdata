package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.JMock;
import com.github.jsonzou.jmockdata.kanyuxia.bean.Teacher;
import org.junit.Test;

public class MockDataTest {

  @Test
  public void test() throws Exception {
    Teacher teacher = JMock.mockData(Teacher.class);
    System.out.println(teacher);
  }

}
