package com.javarush.task.task39.task3904;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

/*
Лестница
*/
public class Solution {
    private static int n = 70;
    static Map<Integer, Long> map = new HashMap<Integer, Long>(){{
        put(0, 1L);
        put(1, 1L);
        put(2, 2L);
        put(3, 4L);
    }};

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long count = ((numberOfPossibleAscents(n - 3) + numberOfPossibleAscents(n - 2) + numberOfPossibleAscents(n - 1)));

            map.put(n, count);

            return count;
        }
    }
}

