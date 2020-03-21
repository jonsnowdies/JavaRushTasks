package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(name1);
        FileWriter fileWriter = new FileWriter(name2);

        while (fileReader.ready()) {
            fileReader.skip(1);
            int data = fileReader.read();
            fileWriter.write(data);
        }
        fileWriter.close();
        fileReader.close();
    }
}
