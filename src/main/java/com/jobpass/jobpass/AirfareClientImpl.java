package com.jobpass.jobpass;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class AirfareClientImpl implements AirfareClient {

    private static final BigDecimal[] vietnamPrices = {
        new BigDecimal("2115000.00"),
        new BigDecimal("2232500.00"),
        new BigDecimal("2350000.00"),
        new BigDecimal("2467500.00"),
        new BigDecimal("2585000.00"),
        new BigDecimal("2702500.00"),
        new BigDecimal("2820000.00"),
        new BigDecimal("2937500.00"),
        new BigDecimal("3055000.00"),
        new BigDecimal("3172500.00")
    };

    private static final BigDecimal[] thailandPrices = {
        new BigDecimal("3150.00"),
        new BigDecimal("3325.00"),
        new BigDecimal("3500.00"),
        new BigDecimal("3675.00"),
        new BigDecimal("3850.00"),
        new BigDecimal("4025.00"),
        new BigDecimal("4200.00"),
        new BigDecimal("4375.00"),
        new BigDecimal("4550.00"),
        new BigDecimal("4725.00")
    };

    @Override
    public BigDecimal getAirfare(String countryCode, LocalDate date) {
        int index = (int) (date.toEpochDay() % 10); // 0~9 순환

        return switch (countryCode.toUpperCase()) {
            case "VN" -> vietnamPrices[index];
            case "TH" -> thailandPrices[index];
            default -> throw new IllegalArgumentException("Unsupported country code: " + countryCode);
        };
    }
}
