package com.pluralsight.java.moreobjectoriented.branchingoverboolean;

import java.math.BigDecimal;

public class Account {
    private boolean isVerified;
    private boolean isClosed;
    private BigDecimal balance;
    private Freezable freezable;

    public Account(AccountUnfrozen onUnfrozen) {
        this.balance = BigDecimal.ZERO;
        this.freezable = new FreezableActive(onUnfrozen);
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
        this.freezable = this.freezable.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        if (!this.isClosed)
            return; // Or do something more meaningful
        this.freezable = this.freezable.deposit();
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (!isVerified)
            return; // Or do something more meaningful
        if (!isClosed)
            return;
        this.freezable = this.freezable.withdraw() ;
        this.balance = this.balance.subtract(amount);
    }
}
