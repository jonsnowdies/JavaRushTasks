package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    private ArrayList<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {
            Solution solution = new Solution();
            solution.fillFileList(path.getPath());
            solution.fileList.sort(Comparator.comparing(File::getName));

            for (File file : solution.fileList) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    while (fileInputStream.available() > 0) {
                        fileOutputStream.write(fileInputStream.read());
                    }
                    fileOutputStream.write(System.lineSeparator().getBytes());
                }
            }
        }
    }

    private void fillFileList(String path) {
        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
            } else if (file.length() > 50) {
                FileUtils.deleteFile(file);
            } else {
                fileList.add(file);
            }
        }

    }
}
