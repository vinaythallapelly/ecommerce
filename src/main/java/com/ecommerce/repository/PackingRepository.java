package com.ecommerce.repository;

import com.ecommerce.entity.PackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingRepository extends JpaRepository<PackingEntity,Integer> {
}
