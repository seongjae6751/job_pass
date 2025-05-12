package com.jobpass.jobpass;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "country_costs")
public class CountryCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String countryCode;

    @Column(nullable = false)
    private String countryName;

    private BigDecimal passportFee;
    private BigDecimal documentFee;
    private BigDecimal medicalFee;
    private BigDecimal visaFee;
    private BigDecimal epsExamFee;
}
