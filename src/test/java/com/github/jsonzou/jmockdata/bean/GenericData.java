package com.github.jsonzou.jmockdata.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by jsonzou on 2018/1/17.
 */
public class GenericData<A, B, C> {


  private A a;
  private B b;
  private C c;
  private A[] aArray;
  private List<B> bList;
  private Map<A, B> map;
  private List<C>[] cArray;
  private Map<Map<A, B>, List<C>>[] d;


  public A getA() {
    return a;
  }

  public void setA(A a) {
    this.a = a;
  }

  public B getB() {
    return b;
  }

  public void setB(B b) {
    this.b = b;
  }

  public C getC() {
    return c;
  }

  public void setC(C c) {
    this.c = c;
  }

  public A[] getaArray() {
    return aArray;
  }

  public void setaArray(A[] aArray) {
    this.aArray = aArray;
  }

  public List<B> getbList() {
    return bList;
  }

  public void setbList(List<B> bList) {
    this.bList = bList;
  }

  public Map<A, B> getMap() {
    return map;
  }

  public void setMap(Map<A, B> map) {
    this.map = map;
  }

  public List<C>[] getcArray() {
    return cArray;
  }

  public void setcArray(List<C>[] cArray) {
    this.cArray = cArray;
  }

  public Map<Map<A, B>, List<C>>[] getD() {
    return d;
  }

  public void setD(Map<Map<A, B>, List<C>>[] d) {
    this.d = d;
  }
}
