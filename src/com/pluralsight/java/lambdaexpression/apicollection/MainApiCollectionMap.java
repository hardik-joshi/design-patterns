package com.pluralsight.java.lambdaexpression.apicollection;

import java.util.*;

public class MainApiCollectionMap {
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

        Map<City, List<Person>> map = new HashMap<>();
        map.putIfAbsent(london, new ArrayList<>());
        map.get(london).add(p1);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

        System.out.println("People from London: " + map.getOrDefault(london, Collections.EMPTY_LIST));
        System.out.println("People from New York: " + map.getOrDefault(newYork, Collections.EMPTY_LIST));
    }
}
