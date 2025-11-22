package com.invilen.order.product;

import com.invilen.order.bakery.BakeryClient;
import com.invilen.order.pharmacy.PharmacyClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class ProductServiceResolver {

    private final BakeryClient bakeryClient;
    private final PharmacyClient pharmacyClient;


    public ProductClient getClient(String type) {
        return switch (type) {
            case "BAKERY" -> bakeryClient;
            case "PHARMACY" -> pharmacyClient;
            default -> throw new RuntimeException("Unknown product type");
        };
    }
}
