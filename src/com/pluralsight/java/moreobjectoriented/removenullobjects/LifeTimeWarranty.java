package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;

public class LifeTimeWarranty implements Warranty {
    private LocalDate issuedOn;

    public LifeTimeWarranty(LocalDate issuedOn) {
        this.issuedOn = issuedOn;
    }

    @Override
    public boolean isValidOn(LocalDate date) {
        return this.issuedOn.compareTo(date) <= 0;
    }
}
