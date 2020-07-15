package com.chinaedu.springcloud;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

    }

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); //获得默认时区时间
        System.out.println(zonedDateTime);
    }
}
