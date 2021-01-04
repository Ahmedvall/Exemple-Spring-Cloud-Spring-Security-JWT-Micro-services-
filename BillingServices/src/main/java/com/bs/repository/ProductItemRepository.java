package com.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
