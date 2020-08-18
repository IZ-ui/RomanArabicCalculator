package com.gm.calc;


public class Main {

    public static void main(String[] args) {

        // подключить через maven библиотеку org.apache.commons:commons-lang3:3.0

        String input = Helper.readString();
        Calculator.act(input);
    }
}