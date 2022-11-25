package Week9;

import week5.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {

        // define array of 5 integers

        int[] myNumber = {1, 2, 3, 4, 5};

        for(int i = 0; i < 5; i++){
            System.out.print(myNumber[i] + " ");
        }

        System.out.println();

        int j = 0;

        while (j < 5){
            System.out.print(myNumber[j] + " ");
            j++;
        }

        System.out.println();

        //array of 3 strings (Important remember)

        String[] names = new String[3];
        System.out.println(Arrays.toString(names));

        names[0] = "Ruchi";
        names[1] = "Praise";
        names[2] = "Tirry";

        System.out.println(Arrays.toString(names));

        for( int i = 0; i < names.length; i++){
            System.out.print(names[i] + " ");
        }

        System.out.println();
        //define array of 3 persons

        Person[] group = {
                new Person("Ruchi", "123 abc St.", 20),
                new Person("Praise", "123 abc St.", 20),
                new Person("Tirry", "456 abc St.", 20)
        };

        //for ... each loop
        for(Person person: group){
            System.out.println(person);
            //Override super class (Polymorphism)

        }

        Person person = new Person("Ruchi", "123 abc St.", 20);
        // right hand side object, left side, object variable

        //Person person1 = null;
        //person1.getName();

        String [] myGroup = new String[] {"Praise", "Ruchi", "Tirry"};

        myGroup = Arrays.copyOf(myGroup, 10);
        myGroup[3] = "Phuc";
        myGroup[4] = "Jihyung";

        System.out.println(Arrays.toString(myGroup));

        ArrayList<Person> group1 = new ArrayList<>();
        group1.add(new Person("Ruchi", "123 abc St.", 20));
        group1.add(new Person("Praise", "123 abc St.", 20));
        group1.add(new Person("Tirry", "456 abc St.", 20));
        System.out.println("Size : " + group1.size());

        for(Person person1: group1){
            System.out.println(person1);
        }

        //Remove first Person

        group1.remove(0);

        System.out.println("Size : " + group1.size());

        group1.clear();
        System.out.println("Size : " + group1.size());

        for(Person person1: group1){
            System.out.println(person1);
        }
    }
}
