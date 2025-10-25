package com.invilens.bakery.bakery;

import com.invilens.bakery.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BakeryService {
    private final BakeryRepository bakeryRepository;

    public Integer productCreated(BakeryRequest request) {
        var product = bakeryRepository.save(Mapper.toEntity(request));
        return product.getId();
    }

    public List<BakeryResponse> allProducts() {
        return bakeryRepository.findAll()
                .stream()
                .map(Mapper::toResponse)
                .collect(Collectors.toList());
    }

    public BakeryResponse findById(Integer id) {
        return Mapper.toResponse(bakeryRepository.findById(id).orElseThrow());
    }

    public void purchaseProduct(List<PurchaseRequest> request) {
        var productsIds = request
                .stream()
                .map(PurchaseRequest::productId)
                .toList();
        var storedProducts = bakeryRepository.findAllById(productsIds)
                .stream()
                .sorted(Comparator.comparing(Bakery::getId))
                .toList();
        if (productsIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exists");
        }

        var storeRequest = request
                .stream()
                .sorted(Comparator.comparing(PurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<PurchaseResponse>();
        for(int i=0; i < storedProducts.size(); i++){
            var product = storedProducts.get(i);
            var productRequest = storeRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            bakeryRepository.save(product);
            purchasedProducts.add(Mapper.toPurchaseResponse(product, productRequest.quantity()));
        }
//        return purchasedProducts;

    }
}
