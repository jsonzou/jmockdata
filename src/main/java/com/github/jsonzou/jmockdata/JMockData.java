package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mocker.BeanMocker;
import com.github.jsonzou.jmockdata.mocker.CollectionMocker;
import com.github.jsonzou.jmockdata.mocker.MapMocker;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    MockerManager mockerManager = MockerManager.local();
    Mocker mocker = mockerManager.getMocker(clazz);
    if (mocker == null) {
      mocker = new BeanMocker(clazz);
    }
    return (T) mocker.mock(mockerManager.config());
  }

  public static <T> Set<T> mockSet(Class<T> genericClass) {
    CollectionMocker mocker = new CollectionMocker(Set.class, genericClass);
    return (Set<T>) mocker.mock(MockerManager.local().config());
  }

  public static <T> List<T> mockList(Class<T> genericClass) {
    CollectionMocker mocker = new CollectionMocker(List.class, genericClass);
    return (List<T>) mocker.mock(MockerManager.local().config());
  }

  public static <K, V> Map<K, V> mockMap(Class<K> keyClass, Class<V> valueClass) {
    MapMocker mocker = new MapMocker(new Type[]{keyClass, valueClass});
    return mocker.mock(MockerManager.local().config());
  }


}
