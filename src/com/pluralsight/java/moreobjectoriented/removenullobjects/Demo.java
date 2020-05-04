package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;

public class Demo {
    public void claimWarranty(Article article) {
        LocalDate today = LocalDate.now();

        if(article.getMoneyBackGuarantee().isValidOn(today)) {
            System.out.println("Offer money back.");
        }

        if(article.getExpressWarranty().isValidOn(today)) {
            System.out.println("Offer repair");
        }

        System.out.println("-------------------");
    }

    private void run() {

    }

    public static void main(String[] args) {
        new Demo().run();
    }
}
