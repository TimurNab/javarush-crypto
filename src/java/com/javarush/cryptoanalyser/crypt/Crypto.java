package com.javarush.cryptoanalyser.crypt;

import com.javarush.cryptoanalyser.exeption.AppException;

import java.io.*;

public class Crypto {
    private static final char[] ALPHABET = {' ', '!', '\"', '\'', ',', '.', ':', ';', '?', '«', '»', 'Ё', 'А', 'Б', 'В',
            'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш',
            'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'ё'};

    public static char[] alphabet = ALPHABET;

    public void enCode(String src, String dest, int key) {

        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dest))) {

            while (reader.ready()) {
                String readLine = reader.readLine();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < readLine.length(); i++) {
                    char strCharAt = readLine.charAt(i);
                    int value = Integer.MIN_VALUE;
                    for (int j = 0; j < ALPHABET.length; j++) {
                        if (strCharAt == ALPHABET[j]) {
                            value = j + key;
                            if (value > ALPHABET.length - 1) {
                                value = value - ALPHABET.length;
                            } else if (value != Integer.MIN_VALUE && value < 0) {
                                value = value + ALPHABET.length - 1;
                            }
                            break;
                        }
                    }
                    sb.append(value == Integer.MIN_VALUE ? strCharAt : ALPHABET[value]);
                }
                writer.append(sb);
                sb.delete(0, sb.length());
                writer.newLine();
            }

        } catch (IOException e) {
            throw new AppException(e);
        }
    }

    public void deCode(String src, String dest, int key) {
        enCode(src, dest, -key);
    }
}
