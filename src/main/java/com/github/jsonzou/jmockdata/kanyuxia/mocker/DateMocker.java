package com.github.jsonzou.jmockdata.kanyuxia.mocker;

import com.github.jsonzou.jmockdata.kanyuxia.MockConfig;
import com.github.jsonzou.jmockdata.kanyuxia.Mocker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.RandomUtils;

/**
 * Date对象模拟器
 */
// TODO: 2017/9/26 模拟Date数据方式有待商榷
public class DateMocker implements Mocker<Date> {

  public static final DateMocker INSTANCE = new DateMocker();
  @Override
  public Date mockData(final MockConfig mockConfig) throws Exception {
    return random(mockConfig.getDateRange()[0], mockConfig.getDateRange()[1]);
  }

  private Date random(String start, String end) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = dateFormat.parse(start);
    Date endDate = dateFormat.parse(end);
    long randomTime = RandomUtils.nextLong(startDate.getTime(), endDate.getTime());
    return new Date(randomTime);
  }

}
