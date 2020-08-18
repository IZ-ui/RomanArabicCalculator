package com.gm.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Romans {

    private final static Map<String, Integer> romans = new HashMap<>();
    private final static TreeMap<Integer, String> arabicToRoman = new TreeMap<>();

    static {
        romans.put("I",1);
        romans.put("II",2);
        romans.put("III",3);
        romans.put("IV",4);
        romans.put("V",5);
        romans.put("VI",6);
        romans.put("VII",7);
        romans.put("VIII",8);
        romans.put("IX",9);
        romans.put("X",10);

        arabicToRoman.put(100, "C");
        arabicToRoman.put(90, "XC");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(40, "XL");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(1, "I");
    }

    public static int toArabic(String romanString) {
        return romans.get(romanString);
    }

    public static String toRoman(int number) {
        if ( number == 0)
            return "roman zero";
        int l =  arabicToRoman.floorKey(number);
        if ( number == l ) {
            return arabicToRoman.get(number);
        }
        return arabicToRoman.get(l) + toRoman(number-l);
    }

}
