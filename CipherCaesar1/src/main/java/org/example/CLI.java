package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public void startCli() throws IOException{
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();
        CaesarCipher caesarCipher = new CaesarCipher();
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Введіть команду (ENCRYPT, DECRYPT, BRUTEFORCE або EXIT): ");
            Runner.command = scanner.nextLine();
            switch (Runner.command) {
                case "ENCRYPT" -> {
                    System.out.print("Введіть шлях: ");
                    Runner.readPath = scanner.nextLine();
                    File file = new File(Runner.readPath);
                    if (file.exists() && file.isFile()) {
                        System.out.print("Введіть ключ зсуву символів: ");
                        Runner.key = scanner.nextInt();
                        scanner.nextLine();
                        fileService.myFileWriter(caesarCipher.encrypt(Runner.readPath,Runner.key), "C:\\Users\\user\\IdeaProjects\\CipherCaesar1\\src\\main\\resources\\textFile1[ENCRYPTED].txt");
                    } else {
                        System.out.println("Шлях не вказує на існуючий файл.");
                    }
                }
                case "DECRYPT" -> {
                    System.out.print("Введіть шлях: ");
                    Runner.readPath = scanner.nextLine();
                    File file = new File(Runner.readPath);
                    if (file.exists() && file.isFile()) {
                        System.out.print("Введіть ключ зсуву символів: ");
                        Runner.key = scanner.nextInt();
                        scanner.nextLine();
                        fileService.myFileWriter(caesarCipher.decrypt(Runner.readPath,Runner.key), "C:\\Users\\user\\IdeaProjects\\CipherCaesar1\\src\\main\\resources\\textFile1[DECRYPTED].txt");
                    } else {
                        System.out.println("Шлях не вказує на існуючий файл.");
                    }
                }
                case "BRUTEFORCE" -> {
                    System.out.print("Введіть шлях: ");
                    Runner.readPath = scanner.nextLine();
                    File file = new File(Runner.readPath);
                    if (file.exists() && file.isFile()) {
                        fileService.myFileWriter(caesarCipher.bruteForce(Runner.readPath), "C:\\Users\\user\\IdeaProjects\\CipherCaesar1\\src\\main\\resources\\textFile1[BRUTEFORCE].txt");
                    } else {
                        System.out.println("Шлях не вказує на існуючий файл.");
                    }
                }
                case "EXIT" -> {
                    isRunning = false;
                    System.out.println("Програма завершена.");
                }
                default -> System.out.println("Ви ввели неправильну команду");
            }
        }
    }
}