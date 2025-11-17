package com.invilen.order.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;


public record OrderReport(
        Timestamp date,
        long totalOrders,
        BigDecimal totalSales,
        BigDecimal avgOrderValue
) {
}
