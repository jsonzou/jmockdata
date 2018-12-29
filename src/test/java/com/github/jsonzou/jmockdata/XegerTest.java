package com.github.jsonzou.jmockdata;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.github.jsonzou.jmockdata.util.Xeger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: jsonzou
 * @Date: 2018/12/29 13:05
 * @Description:
 */
public class XegerTest {
    @Test
    public void should163Email() {
        String regex = "[a-z]{5,15}\\@163\\.com";
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
