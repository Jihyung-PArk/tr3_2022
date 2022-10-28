package week5;

public class Person {

    private String name;
    private String address;
    private int age;

    public Person() {

        name = "Unknown";
        address = "Unknown";
        age = 10;
    }

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override //polymorphism
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        Person person1 = new Person();

        System.out.println(person1.getName());
        System.out.println(person1.toString());

        Person person2 = new Person("Joey", "123 street", 30);

        System.out.println(person2.getName());
        System.out.println(person2.toString());

        String str1 = new String("Joey");
        String str2 = new String("Joey");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));


    }
}
