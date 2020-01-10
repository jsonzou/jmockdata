package com.github.jsonzou.jmockdata.util.randomstring;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

class UserDefinedLetterPickerScanner {
  @Getter
  public static class ScannedUserDefinedPicker {
    private final int cursor;
    private final String key;
    private final List<String> bounds;

    public ScannedUserDefinedPicker(
            final int cursorForScanning, final String key, final List<String> bounds) {
      this.cursor = cursorForScanning;
      this.key = key;
      this.bounds = bounds;
    }
  }

  public static ScannedUserDefinedPicker scan(final String[] regexCharacters, final int index) {
    String key = "";
    String character;
    List<String> bounds = new ArrayList<>();

    int i = index;
    while (!(character = regexCharacters[++i]).equals("]")) {
      if (character.equals("-") && !bounds.isEmpty()) {
        String beginCharacter = bounds.get(bounds.size() - 1); // take from tail
        String endCharacter = regexCharacters[++i]; // take from after "-"

        key += beginCharacter + "-" + endCharacter;

        bounds.add(endCharacter + "-");
      } else {
        if (String.valueOf(character).matches("\\W")) {
          throw new RuntimeException("'" + character + "'" + "will be treated literally inside []");
        }
        bounds.add(character);
      }
    }

    return new ScannedUserDefinedPicker(i, key, bounds);
  }
}
