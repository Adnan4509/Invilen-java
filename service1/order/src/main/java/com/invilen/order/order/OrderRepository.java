package com.invilen.order.order;

import com.invilen.order.dto.OrderReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = """
            SELECT
                DATE(created_date) AS order_date,
                COUNT(*) AS total_orders,
                SUM(total_amount) AS total_sales,
                AVG(total_amount) AS avg_order_value
            FROM order_table
            WHERE created_date BETWEEN :startDate AND :endDate
            GROUP BY DATE(created_date)
            ORDER BY order_date ASC;
    """, nativeQuery = true)
    List<OrderReport> findDailySalesReport(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query(value = """
            SELECT
                DATE_TRUNC('week', created_date) AS month,
                COUNT(*) AS total_orders,
            	SUM(total_amount) AS total_sales,
                AVG(total_amount) AS avg_order_value
            FROM order_table
            GROUP BY DATE_TRUNC('week', created_date)
            ORDER BY month;
            """, nativeQuery = true)
    List<OrderReport> findWeeklySalesReport(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );


    @Query(value = """
            SELECT
                DATE_TRUNC('month', created_date) AS month,
                COUNT(*) AS total_orders,
            	SUM(total_amount) AS total_sales,
                AVG(total_amount) AS avg_order_value
            FROM order_table
            GROUP BY DATE_TRUNC('month', created_date)
            ORDER BY month;
            """, nativeQuery = true)
    List<OrderReport> findMonthlySalesReport();

    @Query(value = """
            SELECT
                DATE_TRUNC('month', created_date) AS month,
                COUNT(*) AS total_orders,
            	SUM(total_amount) AS total_sales,
                AVG(total_amount) AS avg_order_value
            FROM order_table
            GROUP BY DATE_TRUNC('month', created_date)
            ORDER BY month;
            """, nativeQuery = true)
    List<OrderReport> findYearlySalesReport();



}
