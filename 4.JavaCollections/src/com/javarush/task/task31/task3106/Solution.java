package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultNameFile = args[0];
        List<String> fileNamePart = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            fileNamePart.add(args[i]);
        }

        Collections.sort(fileNamePart);

        List<InputStream> inputStreamList = new ArrayList<>();
        for (String archivedFile : fileNamePart) {
            inputStreamList.add(new FileInputStream(archivedFile));
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreamList)))) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(resultNameFile)) {
                System.out.println(zipInputStream.getNextEntry().toString());
                byte[] buffer = new byte[1024];
                int length;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
            }
        }
    }
}
