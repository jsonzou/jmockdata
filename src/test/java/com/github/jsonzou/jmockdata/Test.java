package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.refactor.BaseMocker;
import com.github.jsonzou.jmockdata.refactor.MockData;
import java.util.List;
import java.util.Map;

public class Test {

  @org.junit.Test
  public void test() {
//    Map<List<Integer>, Float>[][] data = MockData.mock(new TypeReference<Map<List<Integer>, Float>[][]>() {
//    });
  }

  @org.junit.Test
  public void test1() {
    Integer[][] data = MockData.mock(new TypeReference<Integer[][]>() {
    });
  }

  @org.junit.Test
  public void test2() {
    Integer[][][] data = (Integer[][][]) new BaseMocker(Integer[][][].class).mock(new MockConfig());
  }

}
