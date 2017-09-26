/**
 * Copyright © 2017 jsonzou (keko-boy@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.github.jsonzou.jmockdata.mockdata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * <p>默认提供模拟类型数据模板类</p>
 *
 * @author jsonzou(keko-boy@163.com)
 * @version 1.0
 * @since 2016/12/26
 */
public interface JmockDataTemplate {

  BigDecimal mockBigDecimal(JmockDataContext context);

  BigDecimal[] mockBigDecimalArray(JmockDataContext context);

  BigInteger mockBigInteger(JmockDataContext context);

  BigInteger[] mockBigIntegerArray(JmockDataContext context);

  Boolean mockBoolean(JmockDataContext context);

  boolean[] mockBooleanUnboxingArray(JmockDataContext context);

  Boolean[] mockBooleanBoxingArray(JmockDataContext context);

  Byte mockByte(JmockDataContext context);

  byte[] mockByteUnboxingArray(JmockDataContext context);

  Byte[] mockByteBoxingArray(JmockDataContext context);

  Character mockCharacter(JmockDataContext context);

  char[] mockCharacterUnboxingArray(JmockDataContext context);

  Character[] mockCharacterBoxingArray(JmockDataContext context);

  Date mockDate(JmockDataContext context);

  Date[] mockDateArray(JmockDataContext context);

  Double mockDouble(JmockDataContext context);

  double[] mockDoubleUnboxingArray(JmockDataContext context);

  Double[] mockDoubleBoxingArray(JmockDataContext context);

  Float mockFloat(JmockDataContext context);

  float[] mockFloatUnboxingArray(JmockDataContext context);

  Float[] mockFloatBoxingArray(JmockDataContext context);

  Integer mockInteger(JmockDataContext context);

  int[] mockIntegerUnboxingArray(JmockDataContext context);

  Integer[] mockIntegerBoxingArray(JmockDataContext context);

  Long mockLong(JmockDataContext context);

  long[] mockLongUnboxingArray(JmockDataContext context);

  Long[] mockLongBoxingArray(JmockDataContext context);

  Short mockShort(JmockDataContext context);

  short[] mockShortUnboxingArray(JmockDataContext context);

  Short[] mockShortBoxingArray(JmockDataContext context);

  String mockString(JmockDataContext context);

  String[] mockStringArray(JmockDataContext context);

  JmockdataConfig getConfig();
}
