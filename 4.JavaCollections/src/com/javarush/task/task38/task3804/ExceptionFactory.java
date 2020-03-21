package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getFactoryClass(Enum type) {

        if (type == null) {
            return new IllegalArgumentException();
        }

        String message = type.name().charAt(0) + type.name().substring(1).replaceAll("_", " ").toLowerCase();

        if (type instanceof ApplicationExceptionMessage) {
            return new Exception(message);
        } else if (type instanceof DatabaseExceptionMessage) {
            return new RuntimeException(message);
        } else if (type instanceof UserExceptionMessage) {
            return new Error(message);
        }

        return new IllegalArgumentException();
    }
}

