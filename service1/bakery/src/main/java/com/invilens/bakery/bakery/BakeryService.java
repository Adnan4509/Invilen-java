package com.invilens.bakery.bakery;

import com.invilens.bakery.dto.BakeryRequest;
import com.invilens.bakery.dto.BakeryResponse;
import com.invilens.bakery.dto.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
