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
package com.github.jsonzou.jmockdata.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AnyData {

  private Integer integerBoxing;
  private Long longBoxing;
  private Double doubleBoxing;
  private Byte byteBoxing;
  private Character charBoxing;
  private Float floatBoxing;
  private Boolean booleanBoxing;
  private Short shortBoxing;

  private int integerUnboxing;
  private long longUnboxing;
  private double doubleUnboxing;
  private byte byteUnboxing;
  private char charUnboxing;
  private float floatUnboxing;
  private boolean booleanUnboxing;
  private short shortUnboxing;

  private Integer[] integerBoxingArray;
  private Long[] longBoxingArray;
  private Double[] doubleBoxingArray;
  private Byte[] byteBoxingArray;
  private Character[] vCharBoxingArray;
  private Float[] floatBoxingArray;
  private Boolean[] booleanBoxingArray;
  private Short[] shortBoxingArray;

  private int[] integerUnboxingArray;
  private long[] longUnboxingArray;
  private double[] doubleUnboxingArray;
  private byte[] byteUnboxingArray;
  private char[] vCharUnboxingArray;
  private float[] floatUnboxingArray;
  private boolean[] booleanUnboxingArray;
  private short[] shortUnboxingArray;

  private BigDecimal bigDecimal;
  private BigInteger bigInteger;
  private Date date;
  private String string;

  private BigDecimal[] bigDecimalArray;
  private BigInteger[] bigIntegerArray;
  private Date[] dateArray;
  private String[] stringArray;

  private List<String> stringList;
  private Set<Date> dateSet;

  public Integer getIntegerBoxing() {
    return integerBoxing;
  }

  public void setIntegerBoxing(Integer integerBoxing) {
    this.integerBoxing = integerBoxing;
  }

  public Long getLongBoxing() {
    return longBoxing;
  }

  public void setLongBoxing(Long longBoxing) {
    this.longBoxing = longBoxing;
  }

  public Double getDoubleBoxing() {
    return doubleBoxing;
  }

  public void setDoubleBoxing(Double doubleBoxing) {
    this.doubleBoxing = doubleBoxing;
  }

  public Byte getByteBoxing() {
    return byteBoxing;
  }

  public void setByteBoxing(Byte byteBoxing) {
    this.byteBoxing = byteBoxing;
  }

  public Character getCharBoxing() {
    return charBoxing;
  }

  public void setCharBoxing(Character charBoxing) {
    this.charBoxing = charBoxing;
  }

  public Float getFloatBoxing() {
    return floatBoxing;
  }

  public void setFloatBoxing(Float floatBoxing) {
    this.floatBoxing = floatBoxing;
  }

  public Boolean getBooleanBoxing() {
    return booleanBoxing;
  }

  public void setBooleanBoxing(Boolean booleanBoxing) {
    this.booleanBoxing = booleanBoxing;
  }

  public Short getShortBoxing() {
    return shortBoxing;
  }

  public void setShortBoxing(Short shortBoxing) {
    this.shortBoxing = shortBoxing;
  }

  public int getIntegerUnboxing() {
    return integerUnboxing;
  }

  public void setIntegerUnboxing(int integerUnboxing) {
    this.integerUnboxing = integerUnboxing;
  }

  public long getLongUnboxing() {
    return longUnboxing;
  }

  public void setLongUnboxing(long longUnboxing) {
    this.longUnboxing = longUnboxing;
  }

  public double getDoubleUnboxing() {
    return doubleUnboxing;
  }

  public void setDoubleUnboxing(double doubleUnboxing) {
    this.doubleUnboxing = doubleUnboxing;
  }

  public byte getByteUnboxing() {
    return byteUnboxing;
  }

  public void setByteUnboxing(byte byteUnboxing) {
    this.byteUnboxing = byteUnboxing;
  }

  public char getCharUnboxing() {
    return charUnboxing;
  }

  public void setCharUnboxing(char charUnboxing) {
    this.charUnboxing = charUnboxing;
  }

  public float getFloatUnboxing() {
    return floatUnboxing;
  }

  public void setFloatUnboxing(float floatUnboxing) {
    this.floatUnboxing = floatUnboxing;
  }

  public boolean isBooleanUnboxing() {
    return booleanUnboxing;
  }

  public void setBooleanUnboxing(boolean booleanUnboxing) {
    this.booleanUnboxing = booleanUnboxing;
  }

  public short getShortUnboxing() {
    return shortUnboxing;
  }

  public void setShortUnboxing(short shortUnboxing) {
    this.shortUnboxing = shortUnboxing;
  }

  public Integer[] getIntegerBoxingArray() {
    return integerBoxingArray;
  }

  public void setIntegerBoxingArray(Integer[] integerBoxingArray) {
    this.integerBoxingArray = integerBoxingArray;
  }

  public Long[] getLongBoxingArray() {
    return longBoxingArray;
  }

  public void setLongBoxingArray(Long[] longBoxingArray) {
    this.longBoxingArray = longBoxingArray;
  }

  public Double[] getDoubleBoxingArray() {
    return doubleBoxingArray;
  }

  public void setDoubleBoxingArray(Double[] doubleBoxingArray) {
    this.doubleBoxingArray = doubleBoxingArray;
  }

  public Byte[] getByteBoxingArray() {
    return byteBoxingArray;
  }

  public void setByteBoxingArray(Byte[] byteBoxingArray) {
    this.byteBoxingArray = byteBoxingArray;
  }

  public Character[] getvCharBoxingArray() {
    return vCharBoxingArray;
  }

  public void setvCharBoxingArray(Character[] vCharBoxingArray) {
    this.vCharBoxingArray = vCharBoxingArray;
  }

  public Float[] getFloatBoxingArray() {
    return floatBoxingArray;
  }

  public void setFloatBoxingArray(Float[] floatBoxingArray) {
    this.floatBoxingArray = floatBoxingArray;
  }

  public Boolean[] getBooleanBoxingArray() {
    return booleanBoxingArray;
  }

  public void setBooleanBoxingArray(Boolean[] booleanBoxingArray) {
    this.booleanBoxingArray = booleanBoxingArray;
  }

  public Short[] getShortBoxingArray() {
    return shortBoxingArray;
  }

  public void setShortBoxingArray(Short[] shortBoxingArray) {
    this.shortBoxingArray = shortBoxingArray;
  }

  public int[] getIntegerUnboxingArray() {
    return integerUnboxingArray;
  }

  public void setIntegerUnboxingArray(int[] integerUnboxingArray) {
    this.integerUnboxingArray = integerUnboxingArray;
  }

  public long[] getLongUnboxingArray() {
    return longUnboxingArray;
  }

  public void setLongUnboxingArray(long[] longUnboxingArray) {
    this.longUnboxingArray = longUnboxingArray;
  }

  public double[] getDoubleUnboxingArray() {
    return doubleUnboxingArray;
  }

  public void setDoubleUnboxingArray(double[] doubleUnboxingArray) {
    this.doubleUnboxingArray = doubleUnboxingArray;
  }

  public byte[] getByteUnboxingArray() {
    return byteUnboxingArray;
  }

  public void setByteUnboxingArray(byte[] byteUnboxingArray) {
    this.byteUnboxingArray = byteUnboxingArray;
  }

  public char[] getvCharUnboxingArray() {
    return vCharUnboxingArray;
  }

  public void setvCharUnboxingArray(char[] vCharUnboxingArray) {
    this.vCharUnboxingArray = vCharUnboxingArray;
  }

  public float[] getFloatUnboxingArray() {
    return floatUnboxingArray;
  }

  public void setFloatUnboxingArray(float[] floatUnboxingArray) {
    this.floatUnboxingArray = floatUnboxingArray;
  }

  public boolean[] getBooleanUnboxingArray() {
    return booleanUnboxingArray;
  }

  public void setBooleanUnboxingArray(boolean[] booleanUnboxingArray) {
    this.booleanUnboxingArray = booleanUnboxingArray;
  }

  public short[] getShortUnboxingArray() {
    return shortUnboxingArray;
  }

  public void setShortUnboxingArray(short[] shortUnboxingArray) {
    this.shortUnboxingArray = shortUnboxingArray;
  }

  public BigDecimal getBigDecimal() {
    return bigDecimal;
  }

  public void setBigDecimal(BigDecimal bigDecimal) {
    this.bigDecimal = bigDecimal;
  }

  public BigInteger getBigInteger() {
    return bigInteger;
  }

  public void setBigInteger(BigInteger bigInteger) {
    this.bigInteger = bigInteger;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public BigDecimal[] getBigDecimalArray() {
    return bigDecimalArray;
  }

  public void setBigDecimalArray(BigDecimal[] bigDecimalArray) {
    this.bigDecimalArray = bigDecimalArray;
  }

  public BigInteger[] getBigIntegerArray() {
    return bigIntegerArray;
  }

  public void setBigIntegerArray(BigInteger[] bigIntegerArray) {
    this.bigIntegerArray = bigIntegerArray;
  }

  public Date[] getDateArray() {
    return dateArray;
  }

  public void setDateArray(Date[] dateArray) {
    this.dateArray = dateArray;
  }

  public String[] getStringArray() {
    return stringArray;
  }

  public void setStringArray(String[] stringArray) {
    this.stringArray = stringArray;
  }

  public List<String> getStringList() {
    return stringList;
  }

  public void setStringList(List<String> stringList) {
    this.stringList = stringList;
  }

  public Set<Date> getDateSet() {
    return dateSet;
  }

  public void setDateSet(Set<Date> dateSet) {
    this.dateSet = dateSet;
  }

  @Override
  public String toString() {
    return "AnyData{" +
        "integerBoxing=" + integerBoxing +
        ", longBoxing=" + longBoxing +
        ", doubleBoxing=" + doubleBoxing +
        ", byteBoxing=" + byteBoxing +
        ", charBoxing=" + charBoxing +
        ", floatBoxing=" + floatBoxing +
        ", booleanBoxing=" + booleanBoxing +
        ", shortBoxing=" + shortBoxing +
        ", integerUnboxing=" + integerUnboxing +
        ", longUnboxing=" + longUnboxing +
        ", doubleUnboxing=" + doubleUnboxing +
        ", byteUnboxing=" + byteUnboxing +
        ", charUnboxing=" + charUnboxing +
        ", floatUnboxing=" + floatUnboxing +
        ", booleanUnboxing=" + booleanUnboxing +
        ", shortUnboxing=" + shortUnboxing +
        ", integerBoxingArray=" + Arrays.toString(integerBoxingArray) +
        ", longBoxingArray=" + Arrays.toString(longBoxingArray) +
        ", doubleBoxingArray=" + Arrays.toString(doubleBoxingArray) +
        ", byteBoxingArray=" + Arrays.toString(byteBoxingArray) +
        ", vCharBoxingArray=" + Arrays.toString(vCharBoxingArray) +
        ", floatBoxingArray=" + Arrays.toString(floatBoxingArray) +
        ", booleanBoxingArray=" + Arrays.toString(booleanBoxingArray) +
        ", shortBoxingArray=" + Arrays.toString(shortBoxingArray) +
        ", integerUnboxingArray=" + Arrays.toString(integerUnboxingArray) +
        ", longUnboxingArray=" + Arrays.toString(longUnboxingArray) +
        ", doubleUnboxingArray=" + Arrays.toString(doubleUnboxingArray) +
        ", byteUnboxingArray=" + Arrays.toString(byteUnboxingArray) +
        ", vCharUnboxingArray=" + Arrays.toString(vCharUnboxingArray) +
        ", floatUnboxingArray=" + Arrays.toString(floatUnboxingArray) +
        ", booleanUnboxingArray=" + Arrays.toString(booleanUnboxingArray) +
        ", shortUnboxingArray=" + Arrays.toString(shortUnboxingArray) +
        ", bigDecimal=" + bigDecimal +
        ", bigInteger=" + bigInteger +
        ", date=" + date +
        ", string='" + string + '\'' +
        ", bigDecimalArray=" + Arrays.toString(bigDecimalArray) +
        ", bigIntegerArray=" + Arrays.toString(bigIntegerArray) +
        ", dateArray=" + Arrays.toString(dateArray) +
        ", stringArray=" + Arrays.toString(stringArray) +
        ", stringList=" + stringList +
        ", dateSet=" + dateSet +
        '}';
  }
}
