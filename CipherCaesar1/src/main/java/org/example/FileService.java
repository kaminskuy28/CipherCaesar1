package org.example;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
public class FileService {
    public char[] myFileReader(String path) throws IOException {
        String line1 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line1 = line;
            }
        } catch (IIOException e) {
            System.out.println("Виникла помилка при спробі прочитати файл " + e.getMessage());
        }
        return line1.toCharArray();
    }

    public void myFileWriter(String file,String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(file);
        }
    }
}
