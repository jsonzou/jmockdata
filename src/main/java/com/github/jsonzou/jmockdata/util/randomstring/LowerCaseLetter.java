package com.github.jsonzou.jmockdata.util.randomstring;

enum LowerCaseLetter implements Letter {
  A("a"), B("b"), C("c"), D("d"), E("e"), F("f"), G("g"), H("h"),
  I("i"), J("j"), K("k"), L("l"), M("m"), N("n"), O("o"), P("p"),
  Q("q"), R("r"), S("s"), T("t"), U("u"), V("v"), W("w"), X("x"),
  Y("y"), Z("z");

  private final String letter;

  private LowerCaseLetter(String letter) {
    this.letter = letter;
  }

  @Override
  public String getLetter() {
    return letter;
  }
}
