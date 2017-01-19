
package com.github.jsonzou.jmockdata.utils;

import java.util.Random;

/**
 * Created by jsonzou on 2016/12/16.
 */
public class RandomUtil {
    private static Random  random=new Random();
    public static Integer randomIntegerNotZero(int bound){
        int randomInt=random.nextInt(bound);
        return Math.abs(randomInt==0?1:randomInt);
    }
    public static Integer randomInteger(int bound){
        return random.nextInt(bound);
    }
    public static Integer randomInteger(int leftBound,int rightBound){
        if(leftBound > rightBound){
            return leftBound;
        }
        if(leftBound == rightBound){
            return leftBound;
        }
        return  random.nextInt(rightBound)%(rightBound-leftBound+1) + leftBound;
    }
    public static Short randomShort(short leftBound,short rightBound){
         Integer randomInt=randomInteger(leftBound,rightBound);
         return Short.parseShort(randomInt+"");
    }
    public static Long randomLong(long leftBound,long rightBound){
        if(leftBound > rightBound){
            return leftBound;
        }
        if(leftBound == rightBound){
            return leftBound;
        }
        return random.nextLong()*(rightBound-leftBound) + leftBound;
    }
    public static Double randomDouble(double leftBound,double rightBound){
        if(leftBound > rightBound){
            return leftBound;
        }
        if(leftBound == rightBound){
            return leftBound;
        }
         return random.nextDouble()*(rightBound-leftBound) + leftBound;
    }

    public static Float randomFloat(float leftBound,float rightBound){
        if(leftBound > rightBound){
            return leftBound;
        }
        if(leftBound == rightBound){
            return leftBound;
        }
        return random.nextFloat()*(rightBound-leftBound) + leftBound;
    }


}
