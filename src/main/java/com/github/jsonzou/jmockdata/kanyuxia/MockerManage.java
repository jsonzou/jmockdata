package com.github.jsonzou.jmockdata.kanyuxia;

import com.github.jsonzou.jmockdata.kanyuxia.mocker.BigDecimalMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.BigIntegerMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.BooleanMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.ByteMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.CharacterMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.DateMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.DoubleMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.FloatMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.IntegerMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.LongMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.ShortMocker;
import com.github.jsonzou.jmockdata.kanyuxia.mocker.StringMocker;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟器管理
 */
public class MockerManage {

  private static Map<Class<?>, Mocker> mockCache = new HashMap<>();

  static {
    registerMocker(ByteMocker.INSTANCE, byte.class, Byte.class);
    registerMocker(BooleanMocker.INSTANCE, boolean.class, Boolean.class);
    registerMocker(CharacterMocker.INSTANCE, char.class, Character.class);
    registerMocker(ShortMocker.INSTANCE, short.class, Short.class);
    registerMocker(IntegerMocker.INSTANCE, Integer.class, int.class);
    registerMocker(FloatMocker.INSTANCE, float.class, Float.class);
    registerMocker(LongMocker.INSTANCE, long.class, Long.class);
    registerMocker(DoubleMocker.INSTANCE, double.class, Double.class);
    registerMocker(BigIntegerMocker.INSTANCE, BigInteger.class);
    registerMocker(BigDecimalMocker.INSTANCE, BigDecimal.class);
    registerMocker(StringMocker.INSTANCE, String.class);
    registerMocker(DateMocker.INSTANCE, Date.class);
  }

  public static void registerMocker(Mocker mockData, Class<?>... classes) {
    for (Class<?> clazz : classes) {
      mockCache.put(clazz, mockData);
    }
  }

  static Mocker getMocker(Class<?> clazz) {
    return mockCache.get(clazz);
  }
}
