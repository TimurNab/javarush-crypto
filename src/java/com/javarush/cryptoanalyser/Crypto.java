package com.javarush.cryptoanalyser;

public class Crypto {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private static final int[] ALPHABETIK = {1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080,
            1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094,
            1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 46, 44, 171, 187, 34, 39, 58, 33, 63, 32};

    public static char[] chars = ALPHABET;
    public static int[] ints = ALPHABETIK;

    public String crypt (String str, int key) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char strCharAt = str.charAt(i);
            int value = 0;
            for (int j = i; j < ALPHABET.length; j++) {
                if (strCharAt == ALPHABET[j]) {
                    if (str.length() + key > ALPHABET.length) {
                        value = (key - (ALPHABET.length - j));
                        continue;
                    }
                    value = j + key;
                }
            }
            sb.append(ALPHABET[value]);
        }
        return sb.toString();
    }
}
