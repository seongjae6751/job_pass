package com.jobpass.jobpass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "비용 계산기")
public interface EstimateApi {
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
        }
    )
    @Operation(summary = "비용 계산")
    @GetMapping("/estimate/{countryCode}")
    EstimateResult estimateCost(
        @PathVariable String countryCode,
        @RequestParam boolean passport,
        @RequestParam boolean document,
        @RequestParam boolean medical,
        @RequestParam boolean visa,
        @RequestParam boolean epsExam,
        @RequestParam boolean airfare
    );
}
