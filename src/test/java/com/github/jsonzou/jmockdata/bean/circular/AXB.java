package com.github.jsonzou.jmockdata.bean.circular;

public class AXB {

  private BXA BXA;

  private String name;

  @Override
  public String toString() {
    return "AXB name: " + name + "\nBXA name: " + BXA;
  }

  public BXA getBXA() {
    return BXA;
  }

  public void setBXA(BXA BXA) {
    this.BXA = BXA;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
