package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date对象模拟器
 */
public class DateMocker implements Mocker<Date> {

  public static final DateMocker INSTANCE = new DateMocker();

  @Override
  public Date mock(MockConfig mockConfig) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date startDate = dateFormat.parse(mockConfig.getDateRange()[0]);
      Date endDate = dateFormat.parse(mockConfig.getDateRange()[1]);
      long randomTime = RandomUtils.nextLong(startDate.getTime(), endDate.getTime());
      return new Date(randomTime);
    } catch (ParseException e) {
      throw new MockException(e);
    }
  }

}
