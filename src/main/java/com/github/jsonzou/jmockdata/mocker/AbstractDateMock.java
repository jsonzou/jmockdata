package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.MockException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AbstractDateMock {

  private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
  protected Long startTime;
  protected Long endTime;

  public AbstractDateMock(String startTimePattern, String endTimePattern) {
    try {
      this.startTime = FORMAT.parse(startTimePattern).getTime();
      this.endTime = FORMAT.parse(endTimePattern).getTime();
    } catch (ParseException e) {
      throw new MockException("时间格式设置错误，设置如下格式yyyy-MM-dd ", e);
    }
  }
}
