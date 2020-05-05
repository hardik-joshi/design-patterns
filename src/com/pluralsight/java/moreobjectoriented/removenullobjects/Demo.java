package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

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
        LocalDate sellingDate = LocalDate.now().minus(40, ChronoUnit.DAYS);
        Warranty moneyBack1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(30));
        Warranty warranty1 = new TimeLimitedWarranty(sellingDate, Duration.ofDays(365));

        Article item1 = new Article(moneyBack1, warranty1);

        this.claimWarranty(item1);

        Article item2 = new Article(Warranty.VOID, Warranty.lifetime(sellingDate));

        this.claimWarranty(item2);
    }

    public static void main(String[] args) {
        new Demo().run();
    }
}
