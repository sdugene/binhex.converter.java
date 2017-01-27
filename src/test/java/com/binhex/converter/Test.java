package com.binhex.converter;

/**
 * Created by Sébastien Dugène on 27/01/2017.
 */
public class Test {
    public static void main(String[] args) {
        String binString = "toto";
        String convertedBinString = Converter.bin2hex(binString);
        String hexString = "746f746f";
        String convertedHexString = Converter.hex2bin(hexString);


        System.out.println("bin2hex:");
        System.out.println("string: " + binString);
        System.out.println("result: " + convertedBinString);

        System.out.println("");

        System.out.println("hex2bin:");
        System.out.println("string: " + hexString);
        System.out.println("result: " + convertedHexString);

        int errors = 0;
        System.out.println("");

        if (!hexString.equals(convertedBinString)) {
            System.out.println("bin2hex function error");
            errors++;
        }

        if (!binString.equals(convertedHexString)) {
            System.out.println("hex2bin function error");
            errors++;
        }

        if (errors == 0) {
            System.out.println("conversion success");
        }
    }
}
