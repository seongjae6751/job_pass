package com.jobpass.jobpass;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCostRepository extends JpaRepository<CountryCost, Long> {
    Optional<CountryCost> findByCountryCode(String countryCode);
}
