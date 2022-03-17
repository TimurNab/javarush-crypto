package com.javarush.cryptoanalyser;

public class Main {
    public static void main(String[] args) {

        System.out.println(Crypto.enCode("Привет, как дела? Пойдем гулять.", 5));
        System.out.println(Crypto.deCode("Фхнжйч:ДпепДийреГДФуоийсДзшр\"ч,'", 5));
    }
}
