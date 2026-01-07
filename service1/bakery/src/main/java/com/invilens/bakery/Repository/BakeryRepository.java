package com.invilens.bakery.Repository;

import com.invilens.bakery.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Integer> {
}
