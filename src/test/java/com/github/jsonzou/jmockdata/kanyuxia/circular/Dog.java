package com.github.jsonzou.jmockdata.kanyuxia.circular;

public class Dog {

  private Pig pig;

  private String name;

  @Override
  public String toString() {
    return "Dog name: " + name + "\nPig name: " +  pig;
  }

  public Pig getPig() {
    return pig;
  }

  public void setPig(Pig pig) {
    this.pig = pig;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
