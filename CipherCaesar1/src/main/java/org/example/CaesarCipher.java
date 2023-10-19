package org.example;

import java.io.IOException;

public class CaesarCipher {
    public String encrypt(String path,int shift) throws IOException {
        FileService fileService = new FileService();
        StringBuilder encryptedText = new StringBuilder();
        char base;
        for (int i = 0; i < fileService.myFileReader(path).length; i++) {
            char c = fileService.myFileReader(Runner.readPath)[i];
            if (Character.isLetter(c)) {
                base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) (base + (c - base + shift) % 26));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    public String decrypt(String path,int shift) throws IOException {
        FileService fileService = new FileService();
        StringBuilder encryptedText = new StringBuilder();
        char base;
        char [] chars = fileService.myFileReader(path);
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                base = Character.isLowerCase(c) ? 'a' : 'A';
                encryptedText.append((char) (base + (c - base - shift) % 26));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
    public String bruteForce(String path) throws IOException{
        StringBuilder bruteForceText = new StringBuilder();
        for (int shift = 0; shift < 26; shift++) {
            String decryptedText = decrypt(path,shift);
            bruteForceText.append(" Зсув ").append(shift).append(": ").append(decryptedText).append("\n");
        }
        return bruteForceText.toString();
    }
}
