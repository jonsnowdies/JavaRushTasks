package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("end")) {
            list.add(fileName);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(list.get(i)));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(list.get(i).split(".part")[0], true));
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        }
        reader.close();

    }
}
