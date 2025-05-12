package com.jobpass.jobpass;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EstimateController {

    private final EstimateService estimateService;

    @GetMapping("/estimate/{countryCode}")
    public EstimateResult estimateCost(
        @PathVariable String countryCode,
        @RequestParam boolean passport,
        @RequestParam boolean document,
        @RequestParam boolean medical,
        @RequestParam boolean visa,
        @RequestParam boolean epsExam,
        @RequestParam boolean airfare
    ) {
        EstimateRequest request = new EstimateRequest(passport, document, medical, visa, epsExam, airfare);
        return estimateService.calculateTotalCost(countryCode, request);
    }
}
