package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileReader file1 = new FileReader(fileName1);
        FileReader file2 = new FileReader(fileName2);

        BufferedReader br1 = new BufferedReader(file1);
        String s1;
        while ((s1 = br1.readLine()) != null) {
            allLines.add(s1);
        }

        BufferedReader br2 = new BufferedReader(file2);
        String s2;
        while ((s2 = br2.readLine()) != null) {
            forRemoveLines.add(s2);
        }

//        allLines = Files.readAllLines(Paths.get(br1.readLine()));
//        forRemoveLines = Files.readAllLines(Paths.get(br2.readLine()));

        reader.close();
        file1.close();
        file2.close();
        Solution s = new Solution();
        s.joinData();
        System.out.println(allLines);

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
