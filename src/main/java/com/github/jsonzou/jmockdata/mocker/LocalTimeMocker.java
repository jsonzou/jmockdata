package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.github.jsonzou.jmockdata.util.RandomUtils;

import java.time.LocalTime;

/**
 * LocalTime对象模拟器
 */
public class LocalTimeMocker implements Mocker<LocalTime> {
  @Override
  public LocalTime mock(DataConfig mockConfig) {
      int[] timeRange = mockConfig.timeRange();
      int randomHour = RandomUtils.nextInt(timeRange[0],timeRange[1]);
      int randomMinute = RandomUtils.nextInt(timeRange[2],timeRange[3]);
      int randomSecond = RandomUtils.nextInt(timeRange[4],timeRange[5]);
     return  LocalTime.of(randomHour,randomMinute,randomSecond);
  }
}
