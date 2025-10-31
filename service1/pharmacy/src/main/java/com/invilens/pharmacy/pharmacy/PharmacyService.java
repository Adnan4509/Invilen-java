package com.invilens.pharmacy.pharmacy;

import com.invilens.pharmacy.dto.Mapper;
import com.invilens.pharmacy.dto.PharmacyRequest;
import com.invilens.pharmacy.dto.PharmacyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

       return ResponseEntity.ok(mapper.toResponse(repository.findById(id).orElseThrow()));
    }
}
