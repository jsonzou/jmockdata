package com.github.jsonzou.jmockdata.bean.circular;

public class BXA {

  private AXB AXB;

  private String name;

  @Override
  public String toString() {
    return name;
  }

  public AXB getAXB() {
    return AXB;
  }

  public void setAXB(AXB AXB) {
    this.AXB = AXB;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
