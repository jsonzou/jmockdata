package com.github.jsonzou.jmockdata;

import com.github.jsonzou.jmockdata.util.Xeger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @Author: jsonzou
 * @Date: 2018/12/29 13:05
 * @Description:
 */
public class XegerTest {
    @Test
    public void should1Email() {
        String regex = "[a-z0-9]{5,15}\\@(qq|163|sina)\\.(com|cn|com\\.cn)";
        Xeger generator = new Xeger(regex);
        for (int i = 0; i < 100; i++) {
            String text = generator.generate();
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }
    @Test
    public void shouldNumber() {
        String regex = "[0-9]{3,5}\\.[0-9]{2}";
        Xeger generator = new Xeger(regex);
        for (int i = 0; i < 100; i++) {
            String text = generator.generate();
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }

    @Test
    public void shouldGBS() {
        String regex = "\\([0-9]{3}\\.[0-9]{3}\\,[0-9]{3}\\.[0-9]{3}\\)";
        Xeger generator = new Xeger(regex);
        for (int i = 0; i < 100; i++) {
            String text = generator.generate();
            System.out.println(text);
            assertTrue(text.matches(regex));
        }
    }

}
