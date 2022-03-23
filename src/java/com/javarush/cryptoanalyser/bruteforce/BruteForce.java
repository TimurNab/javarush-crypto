package com.javarush.cryptoanalyser.bruteforce;

import com.javarush.cryptoanalyser.exeption.AppException;
import com.javarush.cryptoanalyser.crypt.Crypto;

import java.io.*;

public class BruteForce {
    private static final String alphabet = " !\"',.:;?«»ЁАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюяё";

    public BruteForce(String src, String dest) {
        try (BufferedReader reader = new BufferedReader(new FileReader(src))) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                line.append(reader.readLine());
            }
            String readLine = line.toString();
            StringBuilder lineForCheck = new StringBuilder();


                for (int key = 0; key < alphabet.length(); key++) {
                    for (int i = 0; i < readLine.length(); i++) {
                        lineForCheck.append(symbol_right_shift(readLine.charAt(i), key));
                    }

                    if (lineForCheck.toString().contains(", ") || lineForCheck.toString().contains(". ") && lineForCheck.toString().contains("! ") && lineForCheck.toString().contains("? ")) {
                        new Crypto().deCode(src, dest, key);
                        System.out.println(key);
                        break;
                    }
                    lineForCheck.delete(0, lineForCheck.length());
                }

        } catch (IOException e) {
            throw new AppException(e);
        }
    }
    private static char symbol_right_shift(char symbol, int shift) {
        if (alphabet.indexOf(symbol) != -1) {
            return alphabet.charAt((alphabet.indexOf(symbol) + shift) % alphabet.length());
        }
        return symbol;
    }
}
