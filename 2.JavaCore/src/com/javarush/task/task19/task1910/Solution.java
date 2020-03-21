package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

        BufferedReader br = new BufferedReader(new FileReader(name1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(name2));

        while (br.ready()) {
            String s = br.readLine();
            Pattern pattern = Pattern.compile("\\p{Punct}");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                bw.write(matcher.replaceAll(""));
            }
        }

        bw.close();
        br.close();
    }
}
