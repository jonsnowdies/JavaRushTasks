package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] big = new int[20];
        int[] small = new int[10];
        int[] small2 = new int[10];

        for (int i = 0; i < big.length; i++) {
            String s = reader.readLine();
            big[i] = Integer.parseInt(s);
        }
        System.arraycopy(big, 0, small, 0, 10);
        System.arraycopy(big, 10, small2, 0, 10);

        for (int i = 0; i < small2.length; i++)
            System.out.println(small2[i]);
    }
}
