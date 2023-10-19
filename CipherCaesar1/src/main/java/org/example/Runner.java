package org.example;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Runner {
    public static int  key;
    public static String readPath;
    public static String command;
    public static void main(String[] args) throws IOException {
        CLI cli = new CLI();
        cli.startCli();
    }
}