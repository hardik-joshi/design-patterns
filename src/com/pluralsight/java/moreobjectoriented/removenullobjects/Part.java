package com.pluralsight.java.moreobjectoriented.removenullobjects;

import java.time.LocalDate;

public class Part {
    private LocalDate installmentDate;
    private LocalDate defectDetectedOn;

    public Part(LocalDate installmentDate) {
        this(installmentDate, null);
    }

    private Part(LocalDate installmentDate, LocalDate defectDetectedOn) {
        this.installmentDate = installmentDate;
        this.defectDetectedOn = defectDetectedOn;
    }

    public Part defective(LocalDate detectedOn) {
        return new Part(this.installmentDate, detectedOn);
    }

    public LocalDate getDefectDetectedOn() {
        return defectDetectedOn;
    }

    public Warranty apply(Warranty partWarranty) {
        return this.defectDetectedOn == null ? Warranty.VOID
                : Warranty.lifetime(this.defectDetectedOn);
    }
}
