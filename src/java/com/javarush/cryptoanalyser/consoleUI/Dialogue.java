package com.javarush.cryptoanalyser.consoleUI;

import com.javarush.cryptoanalyser.bruteforce.BruteForce;
import com.javarush.cryptoanalyser.crypt.Crypto;

import java.util.Scanner;

public class Dialogue {

    private static final String HELLO_LINE = """
            Выберите один из вариантов:
            Для шифрования наберите -------------------- [1]:
            Для дешифрования наберите ------------------ [2]:
            Для дешифрования методом перебора наберите - [3]:
            """;
    private static final String SRC_LINE = "Введите путь к файлу";
    private static final String DEST_LINE = "Введите путь для сохранения результата";
    private static final String KEY = "Введите цифру ключа от \"0 до 77\"";
    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(HELLO_LINE);

        String exit = "exit";
        while (exit.equals("exit")) {
            exit = scanner.nextLine();
            if (1 == Integer.parseInt(exit)) {
                first();
            }
            if (2 == Integer.parseInt(exit)) {
                second();
            }
            if (3 == Integer.parseInt(exit)) {
                third();
            }

        }
    }

    public void first() {
        System.out.println(SRC_LINE);
        String src = scanner.nextLine();

        System.out.println(DEST_LINE);
        String dest = scanner.nextLine();

        System.out.println(KEY);
        int key = Integer.parseInt(scanner.nextLine());

        Crypto crypto = new Crypto();
        crypto.enCode(src, dest, key);
    }

    public void second() {
        System.out.println(SRC_LINE);
        String src = scanner.nextLine();

        System.out.println(DEST_LINE);
        String dest = scanner.nextLine();

        System.out.println(KEY);
        int key = Integer.parseInt(scanner.nextLine());

        Crypto crypto = new Crypto();
        crypto.deCode(src, dest, key);

    }

    public void third() {
        System.out.println(SRC_LINE);
        String src = scanner.nextLine();

        System.out.println(DEST_LINE);
        String dest = scanner.nextLine();

        new BruteForce(src, dest);
    }
}
