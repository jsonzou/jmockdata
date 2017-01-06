
package com.github.jsonzou.jmockdata.utils;

import java.util.Random;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class RandomUtil {
    private static Random  random=new Random();
    public static int randomIntNotZero(int bound){
        int randomInt=random.nextInt(bound);
        return Math.abs(randomInt==0?1:randomInt);
    }
}
