package org.example;

import java.util.ArrayList;
import java.util.List;

public class DeepCopyDemo {

    // Address class represents a simple object with one property 'city'
    static class Address {
        String city;

        // Constructor to create a new Address object with a given city
        Address(String c) {
            city = c;
        }

        // Copy constructor: creates a NEW Address object from an existing one
        // This ensures that we don't share the same reference between Person copies
        Address(Address other) {
            this.city = other.city;
        }
    }

    static class Person {
        String name;
        List<String> tags;
        Address address;

        // Constructor to create a Person object with name, tags, and address
        Person(String name, List<String> tags, Address address) {
            this.name = name;
            this.tags = tags;
            this.address = address;
        }

        // Deep copy method: creates a NEW Person with copies of mutable fields
        public static Person copyOf(Person other) {
            return new Person(
                    other.name,                        // Strings are immutable, safe to reuse
                    new ArrayList<>(other.tags),        // Creates a NEW list with copied elements (deep copy of tags)
                    new Address(other.address)          // Calls Address copy constructor (deep copy of address)
            );
        }
    }

    public static class Demo {
        public static void main(String[] args) {
            List<String> tags = new ArrayList<>();
            tags.add("gamer");

            // Original person p1
            Person p1 = new Person("Ravi", tags, new Address("Delhi"));

            // Deep copied person p2
            Person p2 = Person.copyOf(p1);

            System.out.println(p1.name);       // Ravi
            System.out.println(p2.name);       // No change

            // Modifying p2's tags and address
            p2.tags.add("Programmer");      // Only affects p2's tag list
            p2.address.city = "Mumbai";     // Only affects p2's address object

            // Printing to verify deep copy
            System.out.println(p1.tags);        // p1 remains unaffected
            System.out.println(p2.tags);        // p2 has an extra tag

            System.out.println(p1.address.city); // p1's city is still Delhi
            System.out.println(p2.address.city); // p2's city changed to Mumbai
        }
    }
}
