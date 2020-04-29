package com.pluralsight.java.moreobjectoriented.immutableandvalueobjects;

import java.math.BigDecimal;

public class Demo {
    private boolean isHappyHour;
    private Money reserve(Money cost) {
        Money finalCost = isHappyHour ? cost.scale(.5) : cost;
        System.out.println("Reserving an item costing " + finalCost);
        return finalCost;
    }

    private void buy(Money wallet, Money cost) {
        boolean enoughMoney = wallet.compareTo(cost) >= 0;
        Money finalCost = this.reserve(cost);
        boolean finalEnough = wallet.compareTo(finalCost) >= 0;

        if(finalEnough && !enoughMoney)
            System.out.println("Only this time, you will pay " + finalCost + " with your " + wallet);
        else if(finalEnough)
            System.out.println("You will pay " + finalCost + " with your " + wallet);
        else
            System.out.println("You cannot pay " + finalCost + " with your " + wallet);
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
        this.isHappyHour = true;
        this.buy(usd7, usd10);
    }

    public static void main(String[] args) {
        new Demo().run();
    }
}
