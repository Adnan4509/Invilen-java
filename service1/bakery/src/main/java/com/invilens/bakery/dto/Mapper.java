package com.invilens.bakery.dto;

import com.invilens.bakery.bakery.Bakery;
import jakarta.validation.constraints.NotNull;

public class Mapper {
    public static Bakery toEntity(BakeryRequest request) {
          Bakery bakery = new Bakery();
          bakery.setName(request.name());
          bakery.setDescription(request.description());
          bakery.setWeight(request.weight());
          bakery.setPrice(request.price());
          bakery.setAvailableQuantity(request.Quantity());
          bakery.setCategory(request.category());
          return bakery;
    }

    public static BakeryResponse toResponse(Bakery bakery) {
        return new BakeryResponse(
                bakery.getId(),
                bakery.getDescription(),
                bakery.getName(),
                bakery.getWeight(),
                bakery.getAvailableQuantity(),
                bakery.getPrice(),
                bakery.getCategory()
        );
    }

    public static PurchaseResponse toPurchaseResponse(Bakery product, double quantity) {
        return new PurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
