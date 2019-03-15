package com.github.jsonzou.jmockdata.util.randomstring;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexNormalizer {
  // for repetition quantifier, e.g. {1,4}
  private static final Pattern REPETITION_QUANTIFIER_RE = Pattern
      .compile("([^\\\\])\\{([0-9]+),([0-9]+)?\\}");
  private static final Pattern ASTERISK_QUANTIFIER_RE = Pattern.compile("([^\\\\])\\*");
  private static final Pattern PLUS_QUANTIFIER_RE = Pattern.compile("([^\\\\])\\+");
  private static final Pattern QUESTION_QUANTIFIER_RE = Pattern.compile("([^\\\\])\\?");

  private final int numOfUpperLimit;
  private final Random random;

  public RegexNormalizer(int numOfUpperLimit, Random random) {
    this.numOfUpperLimit = numOfUpperLimit;
    this.random = random;
  }

  public String normalizeQuantifiers(final String regex) {
    String expanded = regex;

    Matcher repetitionMatcher = REPETITION_QUANTIFIER_RE.matcher(expanded);
    while (repetitionMatcher.find()) {
      int start = Integer.parseInt(repetitionMatcher.group(2), 10);
      int end;
      if (repetitionMatcher.group(3) == null) {
        end = numOfUpperLimit;
      } else {
        end = Integer.parseInt(repetitionMatcher.group(3), 10);
      }
      expanded =
          repetitionMatcher.replaceFirst(repetitionMatcher.group(1) + "{"
              + getRandomNumAsString(start, end) + "}");
      repetitionMatcher = REPETITION_QUANTIFIER_RE.matcher(expanded);
    }

    Matcher asteriskMatcher = ASTERISK_QUANTIFIER_RE.matcher(expanded);
    while (asteriskMatcher.find()) {
      expanded =
          asteriskMatcher.replaceFirst(asteriskMatcher.group(1) + "{"
              + getRandomNumAsString(0, numOfUpperLimit) + "}");
      asteriskMatcher = ASTERISK_QUANTIFIER_RE.matcher(expanded);
    }

    Matcher plusMatcher = PLUS_QUANTIFIER_RE.matcher(expanded);
    while (plusMatcher.find()) {
      expanded =
          plusMatcher.replaceFirst(plusMatcher.group(1) + "{"
              + getRandomNumAsString(1, numOfUpperLimit) + "}");
      plusMatcher = PLUS_QUANTIFIER_RE.matcher(expanded);
    }

    Matcher questionMatcher = QUESTION_QUANTIFIER_RE.matcher(expanded);
    while (questionMatcher.find()) {
      expanded =
          questionMatcher.replaceFirst(questionMatcher.group(1) + "{"
              + getRandomNumAsString(0, 1) + "}");
      questionMatcher = QUESTION_QUANTIFIER_RE.matcher(expanded);
    }

    return expanded;
  }

  private String getRandomNumAsString(final int start, final int end) {
    int bound = end - start;
    if (bound < 0) {
      throw new RuntimeException("Detected invalid quantifier: " + "{" + start + "," + end + "}");
    }
    return Integer.toString(random.nextInt(bound + 1) + start, 10);
  }
}
