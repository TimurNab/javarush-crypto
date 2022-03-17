package com.javarush.cryptoanalyser;

public class Crypto {
    private static final char[] ALPHABET = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё','Ж', 'З', 'И', 'Й', 'К', 'Л',
            'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э',
            'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё','ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«',
            '»', '"', '\'', ':', '!', '?', ' '};

    public static String enCode(String str, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char strCharAt = str.charAt(i);
            int value = 0;
            for (int j = 0; j < ALPHABET.length; j++) {
                if (strCharAt == ALPHABET[j]) {
                    value = j + key;
                    if (value > ALPHABET.length) {
                        value = value - ALPHABET.length;
                        //continue;
                    } else if (value < 0) {
                        value = value + ALPHABET.length;
                        //continue;
                    }
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
