package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.util.RandomUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @Author: jsonzou
 * @Date: 2018/12/29 13:05
 * @Description:
 */
public class RegexGeneratorTest {
    @Test
    public void should1Email() {
        String regex = "[a-z0-9]{5,15}\\@\\w{3,5}\\.[a-z]{2,3}";
        for (int i = 0; i < 100; i++) {
            String text = RandomUtils.nextStringFromRegex(regex);
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }
    @Test
    public void shouldNumber() {
        String regex = "[0-9]{3,5}\\.[0-9]{2}";
        for (int i = 0; i < 100; i++) {
            String text = RandomUtils.nextStringFromRegex(regex);
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }

    @Test
    public void shouldNumber2() {
        String regex = "\\d+\\.\\d+";
        for (int i = 0; i < 100; i++) {
            String text =  RandomUtils.nextStringFromRegex(regex);
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }

    @Test
    public void shouldGPS() {
        String regex = "\\([0-9]{3}\\.[0-9]{3}\\,[0-9]{3}\\.[0-9]{3}\\)";
        for (int i = 0; i < 100; i++) {
            String text =  RandomUtils.nextStringFromRegex(regex);
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }

    @Test
    public void shouldAllPattern() {
        String regex = "[a-z]{2}-[0-9]{2}-[abc123]{2}-\\w{2}-\\d{2}@\\s{1}-\\S{1}\\.?-.";
        for (int i = 0; i < 100; i++) {
            String text = RandomUtils.nextStringFromRegex(regex);
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }
    @Test
    public void shouldAllPattern2() {
        String regex = "[a-z]{2}\\.[0-9]{2}\\.[A-Z]{2}";
        for (int i = 0; i < 100; i++) {
            String text = RandomUtils.nextStringFromRegex(regex);
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }

}
