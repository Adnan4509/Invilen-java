package com.invilens.pharmacy.pharmacy;

import com.invilens.pharmacy.dto.PharmacyRequest;
import com.invilens.pharmacy.dto.PharmacyResponse;
import com.invilens.pharmacy.dto.PurchaseRequest;
import com.invilens.pharmacy.dto.PurchaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pharmacy")
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @PostMapping
    public ResponseEntity<Integer> AddMedicine(
            @RequestBody @Valid PharmacyRequest request
    ) {
        return pharmacyService.AddMedicine(request);
    }

    @GetMapping
    public Page<PharmacyResponse> GetAllProducts(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return pharmacyService.findAll(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacyResponse> findById(
            @PathVariable Integer id
    ) {
        return pharmacyService.findByid(id);
    }

    @PostMapping("/purchase")
    public List<PurchaseResponse> purchaseProduct(@RequestBody List<PurchaseRequest> request) {
        return pharmacyService.ProductPurchased(request);
    }

}
