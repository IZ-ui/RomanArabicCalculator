package com.gm.calc;

import java.util.Scanner;

public class Helper {

    public static void print(String output) {
        System.out.println(output);
    }

    public static String readString() {
        try(Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

}
