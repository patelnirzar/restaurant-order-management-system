package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Orders;


public interface OrderRepo extends JpaRepository<Orders, String> {

}
