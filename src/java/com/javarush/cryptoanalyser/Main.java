package com.javarush.cryptoanalyser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Crypto crypto = new Crypto();

        for (int i = 0; i < Crypto.ints.length; i++) {

            System.out.println((char) Crypto.ints[i]);
        }
    }
}
