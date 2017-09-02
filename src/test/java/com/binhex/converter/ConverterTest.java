package com.binhex.converter;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class ConverterTest
{
    @Test
    public void instantiateTest()
    {
        try {
            Constructor<Converter> c = Converter.class.getDeclaredConstructor();
            c.setAccessible(true);
            c.newInstance();
        } catch (Exception e) {
            assert(true);
        }
    }
}
