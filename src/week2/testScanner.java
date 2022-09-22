package week2;

import java.util.Scanner;

public class testScanner {
    public static void main(String[] args) {
        //using Scanner
        Scanner myObj = new Scanner(System.in);
        //Clear standard input
        //myObj.nextLine();

        System.out.print("Enter name : ");
        //String input
        String name = myObj.nextLine();

        System.out.print("Enter age: ");
        //Numerical input
        int age = myObj.nextInt();

        System.out.print("Enter salary: ");
        double salary = myObj.nextDouble();

        System.out.println("Name : " + name + " Age : " + age + " Salary : " + salary);


        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Salary : " + salary);
    }
}
