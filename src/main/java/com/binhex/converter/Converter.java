package com.binhex.converter;

import java.io.UnsupportedEncodingException;
import java.util.Formatter;

public class Converter
{
    private Converter() {
        throw new IllegalStateException("Utility class");
    }

    public static String bin2hex(String binString) throws UnsupportedEncodingException
    {
        byte[] bytes;
        Formatter f = new Formatter();
        bytes = binString.getBytes("utf-8");
        for (byte c : bytes)
            f.format("%02X",c);

        String string = f.toString().toLowerCase();
        f.close();
        return string;
    }

    public static String hex2bin(String hexString) throws NumberFormatException
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexString.length(); i+=2) {
            String str = hexString.substring(i, i+2);
            output.append((char)Integer.parseInt(str, 16));
        }
        return output.toString();
    }
}
