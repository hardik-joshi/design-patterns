package com.designpattern.builderpattern.pizzas;

public class Demo {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza
                .Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

        System.out.println(nyPizza.toString());

        System.out.println(calzone.toString());
    }
}
