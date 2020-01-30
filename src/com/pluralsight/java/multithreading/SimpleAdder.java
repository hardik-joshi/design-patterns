package com.pluralsight.java.multithreading;

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
        Thread[] threads = new Thread[inFiles.length];
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        for(Thread thread : threads)
            thread.join();
    }
}
