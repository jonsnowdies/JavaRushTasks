package com.javarush.task.task15.task1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("введи первое");
        try {
            A = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
        }
//        System.out.println("введи второе");
        try {
            B = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
        }
        try {
            reader.close();
        } catch (IOException e) {
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }


}
