package com.pluralsight.java.moreobjectoriented.branchingoverboolean;

import java.math.BigDecimal;

public class Account {
    private boolean isVerified;
    private boolean isClosed;
    private boolean isFrozen;
    private BigDecimal balance;

    private AccountUnfrozen onUnfrozen;

    public Account(AccountUnfrozen onUnfrozen) {
        this.balance = BigDecimal.ZERO;
        this.onUnfrozen = onUnfrozen;
    }

    public void holderVerified() {
        this.isVerified = true;
    }

    public void closeAccount() {
        this.isClosed = true;
    }

    public void freezeAccount() {
        if (this.isClosed)
            return; // Account must not be closed
        if (!this.isVerified)
            return; // Account must be verified first
        this.isFrozen = true;
    }

    public void deposit(BigDecimal amount) {
        if (!this.isClosed)
            return; // Or do something more meaningful
        if(this.isFrozen) {
            this.isFrozen = false;
            this.onUnfrozen.handle();
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!isVerified)
            return; // Or do something more meaningful
        if (!isClosed)
            return;
        if(this.isFrozen) {
            this.isFrozen = false;
            this.onUnfrozen.handle();
        }
        this.balance = this.balance.subtract(amount);
    }
}
