package com.emart.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emart.order_service.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {



}
