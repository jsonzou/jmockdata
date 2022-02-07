package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;

import java.time.Instant;
import java.util.Date;

/**
 * Instant对象模拟器
 */
public class InstantMocker implements Mocker<Instant> {
  private DateMocker dateMocker = new DateMocker();
  @Override
  public Instant mock(DataConfig mockConfig) {
     Date date = dateMocker.mock(mockConfig);
     return date.toInstant();
  }
}
