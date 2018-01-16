package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.mocker.BigDecimalMocker;
import com.github.jsonzou.jmockdata.mocker.BigIntegerMocker;
import com.github.jsonzou.jmockdata.mocker.BooleanMocker;
import com.github.jsonzou.jmockdata.mocker.ByteMocker;
import com.github.jsonzou.jmockdata.mocker.CharacterMocker;
import com.github.jsonzou.jmockdata.mocker.DateMocker;
import com.github.jsonzou.jmockdata.mocker.DoubleMocker;
import com.github.jsonzou.jmockdata.mocker.FloatMocker;
import com.github.jsonzou.jmockdata.mocker.IntegerMocker;
import com.github.jsonzou.jmockdata.mocker.LongMocker;
import com.github.jsonzou.jmockdata.mocker.ShortMocker;
import com.github.jsonzou.jmockdata.mocker.StringMocker;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟器管理
 */
public class MockerManager {

  private static final Map<Class<?>, Mocker> MOCKER_MAP = new HashMap<>();

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

  private static void registerMocker(Mocker mocker, Class<?>... clazzs) {
    for (Class<?> clazz : clazzs) {
      MOCKER_MAP.put(clazz, mocker);
    }
  }

  public static Mocker getMocker(Class<?> clazz) {
    return MOCKER_MAP.get(clazz);
  }
}
