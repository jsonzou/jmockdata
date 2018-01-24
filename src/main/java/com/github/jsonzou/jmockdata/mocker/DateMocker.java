package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;
import java.util.Date;

/**
 * Date对象模拟器
 */
public class DateMocker extends AbstractDateMock implements Mocker<Date> {

  public DateMocker(String startTimePattern, String endTime) {
    super(startTimePattern, endTime);
  }

  @Override
  public Date mock(MockConfig mockConfig) {
    return new Date(RandomUtils.nextLong(startTime, endTime));
  }

}
