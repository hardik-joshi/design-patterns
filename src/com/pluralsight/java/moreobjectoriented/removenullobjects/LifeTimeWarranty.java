package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;

public class LifeTimeWarranty implements Warranty {
    private LocalDate issuedOn;

    public LifeTimeWarranty(LocalDate issuedOn) {
        this.issuedOn = issuedOn;
    }

    @Override
    public Warranty on(LocalDate date) {
        return date.compareTo(this.issuedOn) < 0 ? Warranty.VOID : this   ;
    }
}
