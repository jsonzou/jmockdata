package com.github.jsonzou.jmockdata.kanyuxia.circular;

public class Pig {

  private Dog dog;

  private String str;

  @Override
  public String toString() {
    return str;
  }

  public Dog getDog() {
    return dog;
  }

  public void setDog(Dog dog) {
    this.dog = dog;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }
}
