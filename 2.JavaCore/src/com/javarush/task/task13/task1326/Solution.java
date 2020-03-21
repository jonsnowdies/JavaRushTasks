package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<Integer> evenNumbers = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (br.ready()) {
            int i = Integer.parseInt(br.readLine());
            if (i%2 == 0) {
                evenNumbers.add(i);
            }

        }

        reader.close();
        br.close();

        Collections.sort(evenNumbers);
        for (int i = 0; i < evenNumbers.size(); i++) {
            System.out.println(evenNumbers.get(i));
        }


    }
}
