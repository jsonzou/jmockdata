package com.github.jsonzou.jmockdata.mocker;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;
import java.math.BigDecimal;
import org.bson.types.Decimal128;

/**
 * Decimal128对象模拟器
 */
public class Decimal128Mocker implements Mocker<Decimal128> {

  @Override
  public Decimal128 mock(DataConfig mockConfig) {
    return new Decimal128(
        BigDecimal.valueOf(
            mockConfig.globalConfig().getMocker(Double.class).mock(mockConfig)
        )
    );
  }

}
