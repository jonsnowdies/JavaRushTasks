package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse h: horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h: horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (Horse h: horses) {
            if (h.getDistance() > max) {
                max = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName()+ "!");
    }

    public static void main(String[] args) throws InterruptedException {

        Horse h1 = new Horse("Лошадь1", 3, 0);
        Horse h2 = new Horse("Лошадь2", 3, 0);
        Horse h3 = new Horse("Лошадь3", 3, 0);

        List<Horse> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }
}
