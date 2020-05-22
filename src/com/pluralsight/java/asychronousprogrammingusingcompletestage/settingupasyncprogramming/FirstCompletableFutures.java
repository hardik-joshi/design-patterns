package com.pluralsight.java.asychronousprogrammingusingcompletestage.settingupasyncprogramming;

import java.util.concurrent.CompletableFuture;

public class FirstCompletableFutures {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> System.out.println("I am running asynchronously"));
        Thread.sleep(100);
    }
}
