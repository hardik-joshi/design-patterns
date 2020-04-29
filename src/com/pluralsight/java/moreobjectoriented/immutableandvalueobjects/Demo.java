package com.pluralsight.java.moreobjectoriented.immutableandvalueobjects;

import java.math.BigDecimal;

public class Demo {
    private boolean isHappyHours;
    private void reserve(Money cost) {
        if (isHappyHours) {
            cost.scale(.5);
        }
        System.out.println("Reserving an item costing " + cost);
    }

    private void buy(Money wallet, Money cost) {
        boolean enoughMoney = wallet.compareTo(cost) >= 0;
        this.reserve(cost);

        if(enoughMoney)
            System.out.println("You will pay " + cost + " with your " + wallet);
        else
            System.out.println("You cannot pay " + cost + " with your " + wallet);
    }

    public void run() {
        Currency usd = new Currency("USD");
        Money usd12 = new Money(new BigDecimal(12), usd);
        Money usd10 = new Money(new BigDecimal(10), usd);
        Money usd7 = new Money(new BigDecimal(7), usd);

        this.buy(usd12, usd10);
        System.out.println();
        this.buy(usd7, usd10);
        System.out.println();
        this.isHappyHours = true;
        this.buy(usd7, usd10);
    }

    public static void main(String[] args) {
        new Demo().run();
    }
}
