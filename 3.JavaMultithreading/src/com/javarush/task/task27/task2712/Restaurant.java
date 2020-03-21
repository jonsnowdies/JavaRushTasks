package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
        }
    }
}
