package com.invilens.bakery.bakery;

import com.invilens.bakery.dto.BakeryRequest;
import com.invilens.bakery.dto.BakeryResponse;
import com.invilens.bakery.dto.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public List<BakeryResponse> findAll(){
        return bakeryService.allProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BakeryResponse> findById(@PathVariable Integer id) {
       return ResponseEntity.ok(bakeryService.findById(id));
    }

    @PostMapping("/purchase")
    public void bakeryPurchase(
            @RequestBody @Valid List<PurchaseRequest> purchaseRequest) {
        bakeryService.purchaseProduct(purchaseRequest);
    }

}
