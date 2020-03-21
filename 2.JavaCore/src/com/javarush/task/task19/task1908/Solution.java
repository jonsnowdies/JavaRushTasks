package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        BufferedReader bf = new BufferedReader(new FileReader(name1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(name2));

        String s = bf.readLine();
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            bw.write(matcher.group() + " ");
        }
        bw.close();
        bf.close();
    }
}
