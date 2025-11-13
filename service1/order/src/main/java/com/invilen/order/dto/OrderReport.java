package com.invilen.order.dto;

import java.math.BigDecimal;
import java.sql.Date;


public record OrderReport(
        Date date,
        long totalOrders,
        BigDecimal totalSales,
        BigDecimal avgOrderValue
) {
}
