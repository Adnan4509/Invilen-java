package com.invilens.pharmacy.pharmacy;

import com.invilens.pharmacy.dto.*;
import com.invilens.pharmacy.exception.ProductNotFoundException;
import com.invilens.pharmacy.exception.ProductPurchaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PharmacyService {

    private final PharmacyRepository repository;
    private final Mapper mapper;

    public ResponseEntity<Integer> AddMedicine(PharmacyRequest request) {
        var medicine = repository.save(mapper.toEntity(request));
        return ResponseEntity.ok(medicine.getId());
    }

    public Page<PharmacyResponse> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable)
                .map(Mapper::toResponse);
    }

    public ResponseEntity<PharmacyResponse> findByid(Integer id) {

       return ResponseEntity.ok(Mapper.toResponse(repository.findById(id).orElseThrow(
               () ->  new ProductNotFoundException("No product found with the provided Id")
       )));
    }

    public List<PurchaseResponse> ProductPurchased(List<PurchaseRequest> request)  {
        var productIds = request
                .stream()
                .map(PurchaseRequest::productId)
                .toList();
        var storedProducts = repository.findAllById(productIds)
                .stream()
                .sorted(Comparator.comparing(Medicine::getId))
                .toList();
        Set<Integer> uniqueIds = new HashSet<>(productIds);
        if (uniqueIds.size() != productIds.size()) {
            throw new ProductPurchaseException("Duplicate entry not allowed for product Ids");
        }
        if (productIds.size() != storedProducts.size()) {
            throw new ProductNotFoundException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(PurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<PurchaseResponse>();
        for(int i=0; i<storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var requestedProduct = sortedRequest.get(i);
            if (product.getAvailableQuantity() < requestedProduct.quantity()) {
                throw new ProductPurchaseException("Insufficient product quantity in stock");
            }
            var newQuantity = product.getAvailableQuantity()-requestedProduct.quantity();
            product.setAvailableQuantity(newQuantity);
            repository.save(product);
            purchasedProducts.add(mapper.toPurchaseResponse(product, requestedProduct.quantity()));
        }
        return purchasedProducts;
    }

}
