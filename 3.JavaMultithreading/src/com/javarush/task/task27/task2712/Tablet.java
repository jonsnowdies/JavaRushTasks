package com.javarush.task.task27.task2712;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {

    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    private final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        logger.log(Level.SEVERE, "Console is unavailable.");
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}
