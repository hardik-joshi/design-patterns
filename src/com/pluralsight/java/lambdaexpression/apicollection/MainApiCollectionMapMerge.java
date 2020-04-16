package com.pluralsight.java.lambdaexpression.apicollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApiCollectionMapMerge {
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

        Map<City, List<Person>> map1 = new HashMap<>();

        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(mumbai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(mumbai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map1");
        map1.forEach(((city, people) -> System.out.println(city + " : " + people)));

        Map<City, List<Person>> map2 = new HashMap<>();

        map2.computeIfAbsent(mumbai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(boston, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(boston, city -> new ArrayList<>()).add(p6);

        System.out.println("Map2");
        map2.forEach(((city, people) -> System.out.println(city + " : " + people)));

        map2.forEach(
                (city, people) -> {
                    map1.merge(city, people,
                            (peopleFromMap1, peopleFromMap2) -> {
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            }
                    );
                }
        );

        System.out.println("Map1 after merge");
        map1.forEach(((city, people) -> System.out.println(city + " : " + people)));
    }
}
