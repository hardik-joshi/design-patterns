package com.pluralsight.java.lambdaexpression.apicollection;

import java.util.*;

public class MainApiCollection {
    public static void main(String[] args) {
        Person p1 = new Person("Hardik", 29);
        Person p2 = new Person("Juhi", 28);
        Person p3 = new Person("Ruchi", 34);
        Person p4 = new Person("Nayna", 62);
        Person p5 = new Person("Ashok", 64);
        Person p6 = new Person("Kirit", 55);
        Person p7 = new Person("Riddhi", 24);

        City newYork = new City("New York");
        City london = new City("London");
        City boston = new City("Boston");
        City mumbai = new City("Mumbai");

        List<Person> personList = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
        personList.removeIf(person -> person.getAge() < 30);
        personList.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getAge()));
        personList.sort(Comparator.comparing(Person::getAge).reversed());
        personList.forEach(System.out::println);

    }
}
