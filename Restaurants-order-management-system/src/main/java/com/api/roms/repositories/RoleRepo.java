package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
