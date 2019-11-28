package com.designpattern.builderpattern;

public class Demo {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts
                .Builder(4, 2)
                .calories(123)
                .fat(3)
                .sodium(12)
                .carbohydrate(45)
                .build();
    }
}
