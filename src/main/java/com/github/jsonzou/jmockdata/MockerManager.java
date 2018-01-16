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

  public static final ThreadLocal<MockerManager> MOCKER_MANAGER = new ThreadLocal<MockerManager>() {
    @Override
    protected MockerManager initialValue() {
      return new MockerManager();
    }
  };

   public static MockerManager local(){
    return MOCKER_MANAGER.get();
  }

  private final Map<Class<?>, Mocker> map = new HashMap<>();

  private MockConfig mockConfig = new MockConfig();

  private MockerManager() {
    init();
  }

  private void init() {
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

  private void registerMocker(Mocker mocker, Class<?>... clazzs) {
    for (Class<?> clazz : clazzs) {
      map.put(clazz, mocker);
    }
  }

  public Mocker getMocker(Class<?> clazz) {
    return map.get(clazz);
  }

  public MockConfig config() {
    return mockConfig;
  }
}
