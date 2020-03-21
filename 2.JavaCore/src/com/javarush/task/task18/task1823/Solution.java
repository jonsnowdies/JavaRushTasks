package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!(name = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(name);
            readThread.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        ArrayList<Integer> list = new ArrayList<>(); //байты из каждого файла складываем сюда
        String fileName;

        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);

                for (int i = 0; i < buffer.length; i++) {
                    list.add((int) buffer[i]);
                }

                int maxFrequencyByte = 0;
                for (int i : list) {
                    if (Collections.frequency(list, maxFrequencyByte) < Collections.frequency(list, i)) { //находим наиболее часто повторяющийся байт
                        maxFrequencyByte = i;
                        resultMap.put(fileName, maxFrequencyByte);
                    }
                }
                inputStream.close();

            } catch (IOException e) { }
        }

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
    }
}
