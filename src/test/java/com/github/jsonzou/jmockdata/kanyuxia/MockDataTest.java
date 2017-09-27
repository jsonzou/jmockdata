package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.kanyuxia.bean.People;
import org.junit.Test;

public class MockDataTest {

  @Test
  @SuppressWarnings("unchecked")
  public void test() throws Exception {
    People people1 = JMock.mockData(People.class);
    System.out.println(people1);

    MockConfig mockConfig = new MockConfig();
    mockConfig.setStringSeed("hello", "world");
    People people2 = JMock.mockData(People.class, mockConfig);
    System.out.println(people2);
  }

}
