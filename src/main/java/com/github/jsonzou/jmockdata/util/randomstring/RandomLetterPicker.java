package com.github.jsonzou.jmockdata.util.randomstring;

import lombok.Getter;

import java.util.*;

class RandomLetterPicker {
  private final List<String> letters;
  private final int size;
  private final Random random;

  @Getter
  public static class Builder {
    private List<String> letters;
    private Random random;

    public Builder() {
      letters = new ArrayList<>();
      random = null;
    }

    public <E extends Enum<E> & Letter> Builder addAllByEnum(Class<E> enumClass) {
      E[] enumConstants = enumClass.getEnumConstants();
      for(E e:enumConstants){
        letters.add(e.getLetter());
      }
      return this;
    }

    public Builder addAll(List<String> list) {
      letters.addAll(list);
      return this;
    }

    public Builder add(String letter) {
      letters.add(letter);
      return this;
    }

    public Builder remove(String remove) {
      Iterator<String> iterator = letters.iterator();
      List<String> tempLetters = new ArrayList<>(letters.size());
      while (iterator.hasNext()){
        tempLetters.add(iterator.next());
      }
      letters = tempLetters;
      return this;
    }

    public Builder setRandom(Random random) {
      this.random = random;
      return this;
    }

    public RandomLetterPicker build() {
      return new RandomLetterPicker(this);
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  private RandomLetterPicker(Builder b) {
    letters = Collections.unmodifiableList(b.getLetters());
    if (b.getRandom() == null) {
      random = new Random();
    } else {
      random = b.getRandom();
    }

    size = letters.size();
  }

  public String pickRandomLetter() {
    return letters.get(random.nextInt(size));
  }

  public static RandomLetterPicker constructByCharacterRange(final List<String> bounds) {
    Builder definedPickerBuilder = builder();
    int bufferSize = bounds.size();

    for (int i = 0; i < bufferSize; ) {
      /**
       * 处理[a-z][A-Z][0-9]这种匹配规则
       */
      if(i+2 <= bufferSize && bounds.get(i+1).length() == 2 && bounds.get(i+1).charAt(1) == '-'){
        int beginCode = (int) bounds.get(i).charAt(0);
        int endCode = (int) bounds.get(i + 1).charAt(0);
        i = i+2;
        if (beginCode > endCode) {
          throw new RuntimeException("Detected invalid character range: ["
                  + (char) beginCode + "-" + (char) endCode + "]");
        }

        for (int code = beginCode; code <= endCode; code++) {
          definedPickerBuilder.add(String.valueOf((char) code));
        }

      }else{
        definedPickerBuilder.add(bounds.get(i++));
      }

    }

    return definedPickerBuilder.build();
  }
}
