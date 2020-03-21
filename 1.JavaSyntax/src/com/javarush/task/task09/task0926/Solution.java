package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] arrayOfArrays = {5, 2, 4, 7, 0};
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] myArray = new int[arrayOfArrays[i]];
            for (int j = 0; j < myArray.length; j++) {
                myArray[j] = (int)(Math.random() * 100);
            }
            list.add(myArray);
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
