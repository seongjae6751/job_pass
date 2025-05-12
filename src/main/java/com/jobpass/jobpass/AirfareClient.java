package com.jobpass.jobpass;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AirfareClient {
    BigDecimal getAirfare(String originCode, LocalDate date);
}
