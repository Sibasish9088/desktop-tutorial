package org.example;
import java.util.*;

public class ShallowCopyDemo {

    static class Address {
        String city;
        Address(String c){ city = c; }
    }

    static class Person {
        String name;
        List<String> tags;
        Address address;

        Person(String name, List<String> tags, Address address) {
            this.name = name;
            this.tags = tags;
            this.address = address;
        }

        // Shallow copy: simply copy references
        public static Person copyOf(Person other) {
            return new Person(other.name, other.tags, other.address);
        }
    }

    public static class Demo {
        public static void main(String[] args) {
            List<String> tags = new ArrayList<>();
            tags.add("gamer");
            Person p1 = new Person("Ravi", tags, new Address("Delhi"));

            Person p2 = Person.copyOf(p1); // shallow copy

            p2.name = "Vik";               // reassign field -> doesn't affect p1.name
            p2.tags.add("programmer");     // mutates shared list -> visible in p1
            p2.address.city = "Mumbai";    // mutates shared Address -> visible in p1

            System.out.println(p1.name);       // Ravi
            System.out.println(p2.name);       // Vik

            System.out.println(p1.tags);       // [gamer, programmer]  <-- changed
            System.out.println(p2.tags);       // [gamer, programmer]

            System.out.println(p1.address.city); // Mumbai  <-- changed
            System.out.println(p2.address.city); // Mumbai
        }
    }

}
