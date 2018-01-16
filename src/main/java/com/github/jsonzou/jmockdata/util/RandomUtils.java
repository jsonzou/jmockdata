package com.github.jsonzou.jmockdata.util;

import java.util.Random;

public final class RandomUtils {

  private static final Random RANDOM = new Random();

  private RandomUtils() {
  }

  public static boolean nextBoolean() {
    return RANDOM.nextBoolean();
  }

  public static int nextInt(final int startInclusive, final int endExclusive) {
    if (startInclusive == endExclusive) {
      return startInclusive;
    }
    return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
  }

  public static long nextLong(final long startInclusive, final long endExclusive) {
    if (startInclusive == endExclusive) {
      return startInclusive;
    }
    return (long) nextDouble(startInclusive, endExclusive);
  }

  public static float nextFloat(final float startInclusive, final float endInclusive) {
    if (startInclusive == endInclusive) {
      return startInclusive;
    }
    return startInclusive + ((endInclusive - startInclusive) * RANDOM.nextFloat());
  }

  public static double nextDouble(final double startInclusive, final double endInclusive) {
    if (startInclusive == endInclusive) {
      return startInclusive;
    }
    return startInclusive + ((endInclusive - startInclusive) * RANDOM.nextDouble());
  }


}