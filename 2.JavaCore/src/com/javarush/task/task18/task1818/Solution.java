package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream(reader.readLine(), true);
        FileInputStream inputStream2 = new FileInputStream(reader.readLine());

        int a = inputStream2.available();
        byte[] buffer = new byte[a];
        inputStream2.read(buffer);
        outputStream.write(buffer);
        inputStream2.close();

        FileInputStream inputStream3 = new FileInputStream(reader.readLine());
        int b = inputStream3.available();
        buffer = new byte[b];
        inputStream3.read(buffer);
        outputStream.write(buffer);
        inputStream3.close();
        outputStream.close();
    }
}
