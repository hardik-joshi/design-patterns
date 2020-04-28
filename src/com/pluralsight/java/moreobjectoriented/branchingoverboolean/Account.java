package com.pluralsight.java.moreobjectoriented.branchingoverboolean;

import com.pluralsight.java.moreobjectoriented.branchingoverboolean.accountstates.Active;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;
    private AccountState state;

    public Account(AccountUnfrozen onUnfrozen) {
        addToBalance(BigDecimal.ZERO);
        this.state = new Active(onUnfrozen);
    }

    public void holderVerified() {
        this.state = this.state.holderVerified();
    }

    public void closeAccount() {
        this.state = this.state.closeAccount();
    }

    public void freezeAccount() {
        this.state = this.state.freezeAccount();
    }

    public void deposit(BigDecimal amount) {
        this.state = this.state.deposit(amount, this::addToBalance);
    }

    private void addToBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.state = this.state.withdraw(balance, amount, this::subtractFromBalance);
    }

    private void subtractFromBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}
