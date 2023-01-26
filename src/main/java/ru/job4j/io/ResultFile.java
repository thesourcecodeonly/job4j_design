package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            for (int i = 0; i < size; i++) {
                out.write("\n".getBytes());
                for (int j = 0; j < size; j++) {
                    table[j][i] = (j + 1) * (i + 1);
                    String s = String.valueOf((j + 1) * (i + 1));
                    out.write(s.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }
}