package com.github.jsonzou.jmockdata.util;

import java.util.Random;

public final class RandomUtils {

  private final static Random RANDOM = new Random();

  private RandomUtils() {
  }

  public static boolean nextBoolean() {
    return RANDOM.nextBoolean();
  }

  public static int nextInt(int startInclusive, int endExclusive) {
    return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
  }

  public static long nextLong(long startInclusive, long endExclusive) {
    return (long) nextDouble(startInclusive, endExclusive);
  }

  public static float nextFloat(float startInclusive, float endInclusive) {
    return startInclusive + ((endInclusive - startInclusive) * RANDOM.nextFloat());
  }

  public static double nextDouble(double startInclusive, double endInclusive) {
    return startInclusive + ((endInclusive - startInclusive) * RANDOM.nextDouble());
  }

  public static int nextSize(int startInclusive, int endInclusive) {
    return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
  }

}