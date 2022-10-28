package week5;

public class Student extends Person {

    private String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String tempStr = "Student{" +
                "id='" + id + '\'' +
                '}';

        tempStr = tempStr + super.toString();
        return tempStr;
    }

    public static void main(String[] args) {
        Student student1 = new Student("jc940702");
        student1.setName("Joey");
        student1.setAddress("2534 street");
        student1.setAge(30);
        System.out.println(student1.toString());
    }


}


