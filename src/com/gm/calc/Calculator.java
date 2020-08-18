package com.gm.calc;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

    private static int a;
    private static int b;
    private static char operation;
    private static boolean isRomans;

    public static void act(String input) {

        parsing(input);

        int result = compute(a, b, operation);

        if(isRomans) {
            if (result < 0)
                Helper.print("negative romans number");
            else
                Helper.print(Romans.toRoman(result));
        }
        else
            Helper.print(String.valueOf(result));
    }

    private static void parsing(String input) {
        int indexOperation = StringUtils.indexOfAny(input, '*', '/', '+', '-');
        if(indexOperation == -1)
            throw new UnsupportedOperationException();

        String firstNum = input.substring(0, indexOperation).trim();
        String secondNum = input.substring(indexOperation + 1).trim();

        if(firstNum.matches("[0-9][0]?") && secondNum.matches("[0-9][0]?")) {
            a = Integer.parseInt(firstNum);
            b = Integer.parseInt(secondNum);
        } else {
            try {
                a = Romans.toArabic(firstNum);
                b = Romans.toArabic(secondNum);
                isRomans = true;
            } catch (Exception e) {
                throw new UnsupportedOperationException();
            }
        }

        operation = input.toCharArray()[indexOperation];
    }

    private static int compute(int a, int b, char operation) {
        int res;
        switch (operation) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return res;
    }
}
