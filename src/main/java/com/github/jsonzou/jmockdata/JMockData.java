package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mocker.BeanMocker;
import com.github.jsonzou.jmockdata.mocker.CollectionMocker;
import com.github.jsonzou.jmockdata.mocker.MapMocker;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

/**
 * 模拟对象门面类
 *
 * @author jsonzou, kanyuxia, TaoYu
 */
@SuppressWarnings("unchecked")
public class JMockData {


  /**
   * 模拟数据接口
   *
   * @return 模拟数据对象
   */
  public static <T> T mock(Class<T> clazz) {
 return mock(clazz,new MockConfig());
  }

  public static <T> T mock(Class<T> clazz,MockConfig mockConfig) {
    Mocker mocker = MockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mock(mockConfig);
  }

  public static <T> T mock(TypeReference<T> typeReference) {
    ParameterizedTypeImpl type = (ParameterizedTypeImpl) typeReference.getType();
    return null;
  }


}
