package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;

/**
 * java.sql.Date对象模拟器
 */
public class SqlDateMocker implements Mocker<java.sql.Date> {
  private DateMocker dateMocker = new DateMocker();
  @Override
  public java.sql.Date mock(DataConfig mockConfig) {
     java.util.Date date = dateMocker.mock(mockConfig);
     return new java.sql.Date(date.getTime());
  }
}
