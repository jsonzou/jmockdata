package com.github.jsonzou.jmockdata.util.randomstring;

enum SymbolLetter implements Letter {
  TILDE("~"), BACKTICK("`"), EXCLAMATION("!"), AT("@"), DOLLER("$"), PERCENT("%"), CAP("^"),
  AND("&"), ASTERISK("*"), LPAREN("("), RPAREN(")"), MINUS("-"), UNDERBAR("_"), PLUS("+"),
  EQUAL("="), LBRACE("{"), RBRACE("}"), LBRACKET("["), RBRACKET("]"), PIPE("|"), COLON(":"),
  SEMICOLON(";"), SINGLEQUOTE("'"), DOT("."), LANGLE("<"), RANGLE(">"), QUESTION("?"),
  SLASH("/"), SHARP("#"), COMMA(","), BACKSLASH("\\"), DOUBLEQUOTE("\"");

  private final String letter;

  private SymbolLetter(String letter) {
    this.letter = letter;
  }

  @Override
  public String getLetter() {
    return letter;
  }
}
