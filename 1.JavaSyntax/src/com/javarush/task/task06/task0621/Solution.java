package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String gfatherName = reader.readLine();
        Cat gfather = new Cat(gfatherName);
        
        String gmotherName = reader.readLine();
        Cat gmother = new Cat(gmotherName);
        
        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, gfather);
        
        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, gmother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);
        
        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(gfather);
        System.out.println(gmother);
        System.out.println(fatherName);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent1;
        private Cat parent2;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent1) {
            this.name = name;
            this.parent1 = parent1;
        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }

        @Override
        public String toString() {
            if (parent1 == null && parent2 == null)
                return "The cat's name is " + name + ", no mother, no father";
            else  if (parent1 == null)
                return "The cat's name is " + name + ", no mother, father is " + parent2.name;
            else if (parent2 == null)
                return "The cat's name is " + name + ", no father, mother is " + parent1.name;
            else
                return "The cat's name is " + name + ", mother is " + parent1.name + ", father is " + parent2.name;
        }
    }

}
