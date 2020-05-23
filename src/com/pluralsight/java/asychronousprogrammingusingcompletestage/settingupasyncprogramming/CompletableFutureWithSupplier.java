package com.pluralsight.java.asychronousprogrammingusingcompletestage.settingupasyncprogramming;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureWithSupplier {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> Thread.currentThread().getName();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        String string = completableFuture.join();
        System.out.println("Result: " + string);
    }
}
