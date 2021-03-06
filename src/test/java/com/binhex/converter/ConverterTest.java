package com.binhex.converter;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class ConverterTest
{
    String text = "ceci est un test";
    String hexa = "636563692065737420756e2074657374";

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

    @Test
    public void bin2hexTest()
    {
        String hexaTest = Converter.bin2hex(text);
        assertEquals(hexa, hexaTest);

        try {
            Converter.bin2hex(null);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    public void hex2binTest()
    {
        String Error = Converter.hex2bin("gt");
        assertEquals(null, Error);

        String stringTest = Converter.hex2bin(hexa);
        assertEquals(text, stringTest);
    }
}
