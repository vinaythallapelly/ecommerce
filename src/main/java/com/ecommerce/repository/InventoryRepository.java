package com.ecommerce.repository;

import com.ecommerce.entity.InventoryAddEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryAddEntity,Integer>{

}
