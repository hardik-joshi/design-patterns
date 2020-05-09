package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;
import java.util.Optional;

public class VoidWarranty implements Warranty {

    @Override
    public Warranty on(LocalDate date) {
        return this;
    }

    @Override
    public void claim(Runnable action) {
    }

    @Override
    public Optional<Warranty> filter(LocalDate date) {
        return Optional.empty();
    }
}
