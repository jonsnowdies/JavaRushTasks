package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        String s1 = "", s2 = "";
        String next1 = "", next2 = "";

        while (true) {
            if (s1 == null) {
                lines.add(new LineItem(Type.ADDED, s2));
                break;
            }
            if (s2 == null) {
                lines.add(new LineItem(Type.REMOVED, s1));
                break;
            }


            if (s1.equals("")) s1 = reader1.readLine();
            if (s1.equals("")) s1 = reader1.readLine();
            if (s2.equals("")) s2 = reader2.readLine();
            if (s2.equals("")) s2 = reader2.readLine();
            if (next1 != null) {
                if (next1.equals("")) next1 = reader1.readLine();
                if (next1 != null && next1.equals("")) next1 = reader1.readLine();
            }
            if (next2 != null) {
                if (next2.equals("")) next2 = reader2.readLine();
                if (next2 != null && next2.equals("")) next2 = reader2.readLine();
            }

            if (s1.equals(s2)) {
                lines.add(new LineItem(Type.SAME, s1));
                s1 = next1;
                next1 = "";
                s2 = next2;
                next2 = "";
            } else if (next1 != null && next1.equals(s2)) {
                lines.add(new LineItem(Type.REMOVED, s1));
                s1 = next1;
                next1 = "";
            } else if (next2 != null && next2.equals(s1)) {
                lines.add(new LineItem(Type.ADDED, s2));
                s2 = next2;
                next2 = "";
            }
        }
        reader1.close();
        reader2.close();

        for (LineItem item : lines) {
            System.out.println(lines.indexOf(item) + 1 + ". " + item.type + " = " + item.line);

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
