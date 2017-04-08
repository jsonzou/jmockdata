
package com.github.jsonzou.jmockdata.utils;

import com.github.jsonzou.jmockdata.mockdata.JMockDataManager;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
        if(leftBound >= rightBound){
            return leftBound;
        }
        int _leftBound=Math.abs(leftBound);
        int _rightBound=Math.abs(rightBound);

        if(_leftBound>_rightBound){
            _leftBound=_leftBound^_rightBound;
            _rightBound=_leftBound^_rightBound;
            _leftBound=_leftBound^_rightBound;
        }

        int result=Math.abs(random.nextInt()%(_rightBound-_leftBound+1) + _leftBound);
        if(leftBound>=0 && rightBound>=0){
            return Math.abs(result);
        }else if(leftBound<0 && rightBound<=0 ){
            if( leftBound> result){
                return (leftBound*-1+result);
            }else{
                return  result>0?result*-1:result;
            }

        }else if(leftBound<0 && rightBound>=0 ){
            if(result>=leftBound && result<=rightBound){
                if(random.nextBoolean() && result>0 && result*-1>leftBound){
                    return result * -1;
                }
                return result;
            }else{
                return result*-1;
            }
        }
        return result;
    }
    public static Short randomShort(short leftBound,short rightBound){
         Integer randomInt=randomInteger(leftBound,rightBound);
         return Short.parseShort(randomInt+"");
    }
    public static Long randomLong(long leftBound,long rightBound){
        if(leftBound >= rightBound){
            return leftBound;
        }

        long _leftBound=Math.abs(leftBound);
        long _rightBound=Math.abs(rightBound);

        if(_leftBound>_rightBound){
            _leftBound=_leftBound^_rightBound;
            _rightBound=_leftBound^_rightBound;
            _leftBound=_leftBound^_rightBound;
        }

        long result=Math.abs(random.nextLong()%(_rightBound-_leftBound+1) + _leftBound);
        if(leftBound>=0 && rightBound>=0){
            return Math.abs(result);
        }else if(leftBound<0 && rightBound<=0 ){
            if( leftBound> result){
                return (leftBound*-1+result);
            }else{
                return  result>0?result*-1:result;
            }

        }else if(leftBound<0 && rightBound>=0 ){
             if(result>=leftBound && result<=rightBound){
                 if(random.nextBoolean() && result>0 && result*-1>leftBound){
                     return result * -1;
                 }
                 return result;
             }else{
                 return result*-1;
             }
        }
        return result;

    }
    public static Double randomDouble(double leftBound,double rightBound){
        if(leftBound >= rightBound){
            return leftBound;
        }
        double result=random.nextDouble()*(rightBound-leftBound) + leftBound;
        BigDecimal bigDecimal=new BigDecimal(result);
        result= bigDecimal.setScale(
                JMockDataManager.getInstance().config().getDecimalScale(),
                BigDecimal.ROUND_DOWN
        ).doubleValue();

        if(leftBound>=0 && rightBound>=0){
            return Math.abs(result);
        }else{
            return result;
        }
    }

    public static Float randomFloat(float leftBound,float rightBound){
        if(leftBound >= rightBound){
            return leftBound;
        }
       float result =random.nextFloat()*(rightBound-leftBound) + leftBound;
        BigDecimal bigDecimal=new BigDecimal(result);
        result= bigDecimal.setScale(
                JMockDataManager.getInstance().config().getDecimalScale(),
                BigDecimal.ROUND_DOWN
        ).floatValue();

        if(leftBound>=0 && rightBound>=0){
            return Math.abs(result);
        }else{
            return result;
        }
    }


}
