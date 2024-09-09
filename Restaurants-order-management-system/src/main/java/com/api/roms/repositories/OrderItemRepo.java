package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, String> {

}
