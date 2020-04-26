package com.pluralsight.java.moreobjectoriented.branchingoverboolean;

import java.math.BigDecimal;

public class Account {
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;

    public Account() {
        balance = BigDecimal.ZERO;
    }

    public void holderVerified() {
        isVerified = true;
    }

    public void closeAccount() {
        isClosed = true;
    }

    public void deposit(BigDecimal amount) {
        if (!isClosed)
            return; // Or do something more meaningful
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!isVerified)
            return; // Or do something more meaningful
        if (!isClosed)
            return;
        this.balance = this.balance.subtract(amount);
    }
}
