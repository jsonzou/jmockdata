package com.github.jsonzou.jmockdata.refactor;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.TypeReference;

public class MockData {

  public static <T> T mock(TypeReference<T> typeReference) {
    return new BaseMocker<T>(typeReference.getType()).mock(new MockConfig());
  }

}
