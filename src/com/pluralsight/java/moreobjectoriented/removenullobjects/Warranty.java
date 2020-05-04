package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;

public interface Warranty {
    boolean isValidOn(LocalDate date);

    Warranty VOID = new VoidWarranty();
}
