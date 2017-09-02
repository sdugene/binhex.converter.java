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
        try {
            bytes = binString.getBytes("utf-8");
            for (byte c : bytes)
                f.format("%02X",c);

            return (f.toString().toLowerCase());
        } catch(UnsupportedEncodingException e){
            throw(e);
        } finally {
            f.close();
        }
    }

    public static String hex2bin(String hexString) throws NumberFormatException
    {
        try {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < hexString.length(); i+=2) {
                String str = hexString.substring(i, i+2);
                output.append((char)Integer.parseInt(str, 16));
            }
            return output.toString();
        } catch(NumberFormatException e){
            throw(e);
        }
    }
}
