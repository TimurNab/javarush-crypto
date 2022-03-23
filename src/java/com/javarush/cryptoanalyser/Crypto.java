package com.javarush.cryptoanalyser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crypto {
    private static final char[] ALPHABET = {' ', '!', '\"', '\'', ',', '.', ':', ';', '?', '«', '»', 'Ё', 'А', 'Б', 'В',
            'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш',
            'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'ё'};
    public static int arrayLength = ALPHABET.length;


    public static String enCode(String str, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char strCharAt = str.charAt(i);
            int value = 0;
            for (int j = 0; j < ALPHABET.length; j++) {
                if (strCharAt == ALPHABET[j]) {
                    value = j + key;
                    if (value > ALPHABET.length - 1) {
                        value = value - ALPHABET.length;
                    } else if (value < 0) {
                        value = value + ALPHABET.length;
                    }
                    break;
                }
            }
            sb.append(ALPHABET[value]);
        }
        return sb.toString();
    }

    public static String deCode(String str, int key) {
        return enCode(str, -key);
    }
}
