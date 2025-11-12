package com.invilens.pharmacy.dto;

import com.invilens.pharmacy.pharmacy.Medicine;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public Medicine toEntity(PharmacyRequest request) {
        Medicine medicine = new Medicine();
        medicine.setName(request.name());
        medicine.setDescription(request.description());
        medicine.setBrand(request.brand());
        medicine.setDosage(request.dosage());
        medicine.setAvailableQuantity(request.quantity());
        medicine.setPrice(request.price());
        medicine.setCategory(request.category());
        medicine.setExpiry_date(request.expiry_date());

        return medicine;
    }

    public static PharmacyResponse toResponse(Medicine medicine) {
        return new PharmacyResponse(
                medicine.getId(),
                medicine.getName(),
                medicine.getDescription(),
                medicine.getBrand(),
                medicine.getDosage(),
                medicine.getAvailableQuantity(),
                medicine.getPrice(),
                medicine.getExpiry_date(),
                medicine.getCategory()
        );
    }

    public PurchaseResponse toPurchaseResponse(Medicine product, double quantity) {
        return new PurchaseResponse(
                product.getId(),
                product.getName(),
                product.getBrand(),
                quantity,
                product.getPrice(),
                product.getExpiry_date()
        );
    }
}
