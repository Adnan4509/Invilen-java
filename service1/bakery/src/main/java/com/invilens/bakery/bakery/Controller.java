package com.invilens.bakery.bakery;

import com.invilens.bakery.dto.BakeryRequest;
import com.invilens.bakery.dto.BakeryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bakery")
@RequiredArgsConstructor
public class Controller {
    private final BakeryService bakeryService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody BakeryRequest request) {
        return ResponseEntity.ok(bakeryService.productCreated(request));
    }

    @GetMapping
    public List<BakeryResponse> findAll(){
        return bakeryService.allProducts();
    }

}
