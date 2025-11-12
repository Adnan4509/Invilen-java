package com.invilen.order.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OrderReport(
        LocalDate date,
        BigDecimal totalSales
) {
}
