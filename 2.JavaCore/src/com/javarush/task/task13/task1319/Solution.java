package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(reader.readLine()));
        while (true) {
            String s = reader.readLine();
            bw.write(s);
            bw.newLine();
            if (s.equals("exit"))
                break;
        }
        bw.close();
        reader.close();
    }
}
