package com.jobpass.jobpass;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstimateService {

    private final CountryCostRepository countryCostRepository;
    private final AirfareClient airfareClient;

    public EstimateResult calculateTotalCost(String countryCode, EstimateRequest request) {

        // 1. 국가별 고정 비용 조회
        CountryCost cost = countryCostRepository.findByCountryCode(countryCode)
            .orElseThrow(() -> new IllegalArgumentException("Unsupported country: " + countryCode));

        // 2. 항목별 개별 금액 계산 (선택 여부에 따라 0 처리)
        BigDecimal passportFee = request.isIncludePassport() ? cost.getPassportFee() : BigDecimal.ZERO;
        BigDecimal documentFee = request.isIncludeDocument() ? cost.getDocumentFee() : BigDecimal.ZERO;
        BigDecimal medicalFee = request.isIncludeMedical() ? cost.getMedicalFee() : BigDecimal.ZERO;
        BigDecimal visaFee = request.isIncludeVisa() ? cost.getVisaFee() : BigDecimal.ZERO;
        BigDecimal epsExamFee = request.isIncludeEpsExam() ? cost.getEpsExamFee() : BigDecimal.ZERO;

        // 3. 항공료는 실시간 API 조회 (선택 여부 체크)
        BigDecimal airfare = BigDecimal.ZERO;
        if (request.isIncludeAirfare()) {
            airfare = airfareClient.getAirfare(countryCode, LocalDate.now());
        }

        // 4. 세부 항목 합산
        BigDecimal total = passportFee
            .add(documentFee)
            .add(medicalFee)
            .add(visaFee)
            .add(epsExamFee)
            .add(airfare);

        // 5. 결과 DTO 반환 (총합 + 상세 breakdown 포함)
        EstimateResult.Detail detail = new EstimateResult.Detail(
            passportFee, documentFee, medicalFee, visaFee, epsExamFee, airfare
        );

        return new EstimateResult(countryCode, cost.getCountryName(), total, "USD", detail);
    }
}
