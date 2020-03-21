package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solution = new Solution[2];
        for (int i = 0; i < solution.length; i++) {
            solution[i] = new Solution();
            solution[i].innerClasses[0] = solution[i].new InnerClass();
            solution[i].innerClasses[1] = solution[i].new InnerClass();
        }
        return solution;
    }

    public static void main(String[] args) {

    }
}
