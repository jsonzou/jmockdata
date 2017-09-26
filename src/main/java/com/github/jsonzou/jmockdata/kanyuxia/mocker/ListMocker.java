package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.BaseMocker;
import com.github.jsonzou.jmockdata.kanyuxia.HandleMock;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;

/**
 * List对象模拟器
 */
@SuppressWarnings("unchecked")
public class ListMocker extends BaseMocker<List> {

  private final Type genericType;

  public ListMocker(Type genericType) {
    this.genericType = genericType;
  }

  public List mockData() throws Exception {
    int size = RandomUtils.nextInt(config.getSizeRange()[0], config.getSizeRange()[1]);
    List result = new ArrayList(size);
    while (size-- > 0) {
      // 判断是否还有泛型
      if (genericType instanceof ParameterizedType) {
        ParameterizedType type = (ParameterizedType) genericType;
        result.add(HandleMock.mockData((Class<?>) type.getRawType(), type.getActualTypeArguments()[0]));
        continue;
      }
      result.add(HandleMock.mockData((Class<?>) genericType));
    }
    return result;
  }
}
