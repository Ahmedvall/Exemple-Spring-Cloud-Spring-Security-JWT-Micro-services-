package com.bs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bs.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
