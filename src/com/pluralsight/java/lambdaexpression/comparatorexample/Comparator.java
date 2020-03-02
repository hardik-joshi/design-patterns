package com.pluralsight.java.lambdaexpression.comparatorexample;

@FunctionalInterface
public interface Comparator<T> {
    public int compare(T t1, T t2);
}
