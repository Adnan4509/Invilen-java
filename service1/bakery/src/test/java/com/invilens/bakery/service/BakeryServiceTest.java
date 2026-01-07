package com.invilens.bakery.service;

import com.invilens.bakery.Repository.BakeryRepository;
import com.invilens.bakery.Category;
import com.invilens.bakery.dto.BakeryRequest;
import com.invilens.bakery.dto.Mapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BakeryServiceTest {

    @Autowired
    private BakeryRepository bakeryRepository;

    static Stream<BakeryRequest> bakeryRequestProvider() {
        Category category = new Category();
        category.setId(1);

        return Stream.of(
                new BakeryRequest(
                        "Rich chocolate sponge with ganache frosting",
                        "Chocolate Cake",
                        "1 kg",
                        10.0,
                        BigDecimal.valueOf(599.00),
                        category
                )
        );
    }

    @ParameterizedTest
    @MethodSource("bakeryRequestProvider")
    public void productCreatedTest(BakeryRequest request) {
        assertNotNull(bakeryRepository.save(Mapper.toEntity(request)));
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2"
    })
    public void findByIdTest(int id) {
        assertNotNull(bakeryRepository.findById(id));
    }

    @ParameterizedTest
    @CsvSource({
            "0,10",
            "1,20"
    })
    public void allProductsTest(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        assertNotNull(bakeryRepository.findAll(pageable));
    }

}
