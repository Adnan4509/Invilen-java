package com.invilens.pharmacy.pharmacy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String brand;
    private String dosage;
    private Double availableQuantity;
    private BigDecimal price;
    private LocalDate expiry_date;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
