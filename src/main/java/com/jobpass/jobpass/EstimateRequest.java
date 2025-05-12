package com.jobpass.jobpass;

public record EstimateRequest(
    boolean includePassport,
    boolean includeDocument,
    boolean includeMedical,
    boolean includeVisa,
    boolean includeEpsExam,
    boolean includeAirfare
) {

    public boolean isIncludePassport() {
        return includePassport;
    }

    public boolean isIncludeDocument() {
        return includeDocument;
    }

    public boolean isIncludeMedical() {
        return includeMedical;
    }

    public boolean isIncludeVisa() {
        return includeVisa;
    }

    public boolean isIncludeEpsExam() {
        return includeEpsExam;
    }

    public boolean isIncludeAirfare() {
        return includeAirfare;
    }
}
