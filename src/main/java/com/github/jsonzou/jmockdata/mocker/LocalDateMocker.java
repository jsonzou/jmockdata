package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * LocalDate对象模拟器
 */
public class LocalDateMocker implements Mocker<LocalDate> {
  private LocalDateTimeMocker localDateTimeMocker = new LocalDateTimeMocker();
  @Override
  public LocalDate mock(DataConfig mockConfig) {
      LocalDateTime dateTime = localDateTimeMocker.mock(mockConfig);
     return LocalDate.of(dateTime.getYear(),dateTime.getMonth(),dateTime.getDayOfMonth());
  }
}
