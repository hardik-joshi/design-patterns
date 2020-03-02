package com.pluralsight.java.lambdaexpression.comparatorexample;

import java.util.function.Function;

public class MainComparator {
    public static void main(String[] args) {
        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        // Instead of writing above code we can write Function which will take Person and return Integer or String
        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p -> p.getLastName();
        Function<Person, String> f3 = p -> p.getFirstName();

        // We can use f1 in the parameter or we can also simplify p -> p.getAge() we can even simplify by method
        // reference Person::getAge
        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);
        Comparator<Person> cmpPersonFirstName = Comparator.comparing(Person::getFirstName);
    }
}
