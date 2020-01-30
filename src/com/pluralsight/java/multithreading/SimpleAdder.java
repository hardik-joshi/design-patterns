package com.pluralsight.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleAdder {
    public static void main(String[] args) throws InterruptedException {
        String[] inFiles = {
                ".\\src\\com\\pluralsight\\java\\multithreading\\file1.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file2.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file3.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file4.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file5.txt"
        };
        String[] outFiles = {
                ".\\src\\com\\pluralsight\\java\\multithreading\\file1.out.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file2.out.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file3.out.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file4.out.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file5.out.txt"
        };
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            es.submit(adder);
        }
        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
