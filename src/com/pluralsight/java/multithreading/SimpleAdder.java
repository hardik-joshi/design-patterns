package com.pluralsight.java.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SimpleAdder {
    public static void main(String[] args) {
        String[] inFiles = {
                ".\\src\\com\\pluralsight\\java\\multithreading\\file1.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file2.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file3.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file4.txt",
                ".\\src\\com\\pluralsight\\java\\multithreading\\file5.txt"
        };
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i]);
            results[i] = es.submit(adder);
        }

        for(Future<Integer> result : results) {
            try {
                int value = result.get();
                System.out.println("Total: " + value);
            } catch (ExecutionException e) {
                Throwable adderEx = e.getCause();
                adderEx.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
