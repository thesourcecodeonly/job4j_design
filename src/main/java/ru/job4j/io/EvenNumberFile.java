package ru.job4j.io;

import java.io.FileInputStream;
public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lines = text.toString().split(System.lineSeparator());
        for (String line: lines) {
            int n = Integer.parseInt(line);
            if (n % 2 == 0) {
                System.out.println(n + " - чётное");
            } else {
                System.out.println(n + " - нечётное");
            }
        }
    }
}