package com.jobpass.jobpass;

import java.math.BigDecimal;

public record EstimateResult(
    String countryCode,
    String countryName,
    BigDecimal totalCost,
    String currency,
    Detail detail
) {

    public record Detail(
        BigDecimal passportFee,
        BigDecimal documentFee,
        BigDecimal medicalFee,
        BigDecimal visaFee,
        BigDecimal epsExamFee,
        BigDecimal airfare
    ) {}
}
