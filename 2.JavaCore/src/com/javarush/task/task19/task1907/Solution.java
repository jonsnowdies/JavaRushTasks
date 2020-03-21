package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();*/

     /*   FileReader fileReader = new FileReader(name);
        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) {
            int i = fileReader.read();
            sb.append((char) i);
        }
        String s = sb.toString();
        String[] arr = s.split("\\W");
        int count = 0;
        for (String str : arr) {
            if (str.equals("world")) count++;
        }
        System.out.println(count);
        fileReader.close();*/

        BufferedReader br = new BufferedReader(new FileReader("D:\\Dwnldd\\test\\1.txt"));
        while (br.ready()) {
            int count = 0;
            String s = br.readLine();
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                count++;
            }
            System.out.println(count);
        }
        br.close();
    }
}
