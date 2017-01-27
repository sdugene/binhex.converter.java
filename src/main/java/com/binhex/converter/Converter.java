package com.binhex.converter;

import java.math.BigInteger;

/**
 * Created by Sébastien Dugène on 27/01/2017.
 */
public class Converter {

    public static String bin2hex(String binString)
    {
        return binString;
    }

    public static String hex2bin(String hexString)
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexString.length(); i+=2) {
            String str = hexString.substring(i, i+2);
            output.append((char)Integer.parseInt(str, 16));
        }
        return output.toString();
    }
}
