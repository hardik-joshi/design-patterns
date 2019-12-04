package com.designpattern.singletonpattern.naivesingletonmultithreaded;

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
//        if(instance == null) {
//            instance = new Singleton(value);
//        }
//        return instance;

        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
