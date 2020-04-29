package com.pluralsight.java.moreobjectoriented.immutableandvalueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Money implements Comparable<Money> {
    private BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
    }

    public void scale(double factor) {
        this.amount = this.amount.multiply(new BigDecimal(factor)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public int compareTo(Money other) {
        return this.compareAmountTo(this.currency.compareTo(other.currency), other);
    }

    private int compareAmountTo(int currencyCompare, Money other) {
        return currencyCompare == 0 ? this.amount.compareTo(other.amount) : currencyCompare;
    }

    @Override
    public String toString() {
        return this.amount + " " + this.currency;
    }
}
