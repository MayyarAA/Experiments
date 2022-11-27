package com.mayyar.mayyarEffectiveJava;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        DBConnectionSingleton dBConnectionSingleton = DBConnectionSingleton.INSTANCE;
        dBConnectionSingleton.connectToDB();

    }
}
