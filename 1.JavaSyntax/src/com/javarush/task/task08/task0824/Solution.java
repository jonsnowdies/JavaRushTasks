package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("Вася", true, 5);
        Human child2 = new Human("Света", false, 7);
        Human child3 = new Human("Рома", true, 8);

        Human father = new Human("Вячеслав", true, 35, child1, child2, child3);
        Human mother = new Human("Мария", false, 35, child1, child2, child3);

        Human grandpa = new Human("Борис", true, 60, father);
        Human grandma = new Human("Светлана", false, 58, father);
        Human grandpa1 = new Human("Святослав", true, 64, mother);
        Human grandma1 = new Human("Виолетта", false, 63, mother);

        ArrayList<Human> children = new ArrayList<>(Arrays.asList(child1, child2, child3, father, mother, grandpa, grandma, grandpa1, grandma1));
        for (Human a : children) {
            System.out.println(a);
        }
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, Human ... children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children.addAll(Arrays.asList(children));
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
