package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            for (String word : line.split("\\s+")) {
                if (word.length() > 6)
                    sb.append(word + ",");
            }
        }
        writer.write(sb.toString(), 0, sb.length() - 1);
        writer.close();
        reader.close();
    }
}
