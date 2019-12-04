package com.designpattern.singletonpattern.naivesingletonsinglethreaded;

public final class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value){
        //The following code emulated slow initialization
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if(instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
