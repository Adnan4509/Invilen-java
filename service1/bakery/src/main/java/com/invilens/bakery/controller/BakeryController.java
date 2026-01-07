package com.invilens.bakery.controller;

import com.invilens.bakery.Service.BakeryService;
import com.invilens.bakery.dto.BakeryRequest;
import com.invilens.bakery.dto.BakeryResponse;
import com.invilens.bakery.dto.PurchaseRequest;
import com.invilens.bakery.dto.PurchaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bakery")
@RequiredArgsConstructor
public class BakeryController {
    private final BakeryService bakeryService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid BakeryRequest request) {
        return ResponseEntity.ok(bakeryService.productCreated(request));
    }

    @GetMapping
    public Page<BakeryResponse> findAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        return bakeryService.allProducts(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BakeryResponse> findById(@PathVariable Integer id) {
       return ResponseEntity.ok(bakeryService.findById(id));
    }

    @PostMapping("/purchase")
    public List<PurchaseResponse> bakeryPurchase(
            @RequestBody @Valid List<PurchaseRequest> purchaseRequest) {
        return bakeryService.purchaseProduct(purchaseRequest);
    }

}
