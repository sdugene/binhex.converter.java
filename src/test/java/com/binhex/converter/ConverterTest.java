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
        String hexaTest = null;
        try {
            hexaTest = Converter.bin2hex(text);
        } catch (Exception e) {
            assert(false);
        }

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
        try {
            Converter.hex2bin("gt");
        } catch (Exception e) {
            assert(true);
        }

        String stringTest = null;
        try {
            stringTest = Converter.hex2bin(hexa);
        } catch (Exception e) {
            assert(false);
        }

        assertEquals(text, stringTest);
    }
}
