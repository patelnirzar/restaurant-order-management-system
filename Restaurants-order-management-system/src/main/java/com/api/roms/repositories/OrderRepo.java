package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {

}
