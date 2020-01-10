package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.MockException;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.DateTool;
import com.github.jsonzou.jmockdata.util.RandomUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Date对象模拟器
 */
public class DateMocker implements Mocker<Date> {
  @Override
  public Date mock(DataConfig mockConfig) {
    try {
      long startTime = DateTool.getString2DateAuto(mockConfig.dateRange()[0]).getTime();
      long endTime = DateTool.getString2DateAuto(mockConfig.dateRange()[1]).getTime();
      return new Date(RandomUtils.nextLong(startTime,endTime));
    } catch (ParseException e) {
      throw new MockException("不支持的日期格式，或者使用了错误的日期", e);
    }
  }

}
