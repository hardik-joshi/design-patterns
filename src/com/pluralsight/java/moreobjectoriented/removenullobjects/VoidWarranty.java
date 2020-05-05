package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;

public class VoidWarranty implements Warranty {

    @Override
    public Warranty on(LocalDate date) {
        return this;
    }

    @Override
    public void claim(Runnable action) {
    }
}
