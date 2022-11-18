package week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person = new Person("tony", "123 abc street", 40);

    @Test
    void getName() {
        assertEquals("tony", person.getName());
    }

    @Test
    void getAddress() {
        assertEquals("123 abc street", person.getAddress());
    }

    @Test
    void getAge() {
        assertEquals(40, person.getAge());
    }

    @Test
    void setName() {
        person.setName("Sarah");
        assertEquals("sarah", person.getName());
    }
}