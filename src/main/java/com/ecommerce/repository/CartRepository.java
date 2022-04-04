package com.ecommerce.repository;

import com.ecommerce.entity.CartEntity;
import com.ecommerce.entity.SkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Integer> {

    Optional<CartEntity> findBySkuEntity(Optional<SkuEntity> skuEntity);
}
