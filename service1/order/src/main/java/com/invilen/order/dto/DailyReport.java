package com.invilen.order.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public record DailyReport (
    Date date,
    long totalOrders,
    BigDecimal totalSales,
    BigDecimal avgOrderValue
) {}
