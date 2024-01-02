package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.orderservice.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
