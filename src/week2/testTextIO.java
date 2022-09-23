package week2;

import textio.TextIO;

public class testTextIO {
    public static void main(String[] args) {

        TextIO.put("Enter name : ");
        //String input
        String name = TextIO.getln();

        TextIO.put("Enter age : ");
        //Int input
        int age = TextIO.getlnInt();

        TextIO.put("Enter salary : ");
        //Double input
        double salary = TextIO.getlnDouble();

        //output to standard output

        TextIO.putln("Name : " + name + " Age : " + age + " Salary : " + salary);

        TextIO.putln("Name : " + name);
        TextIO.putln("Age : " + age);
        TextIO.putln("Salary : " + salary);
    }
}
