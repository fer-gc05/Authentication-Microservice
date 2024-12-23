package com.security.microservice.repositories;

import com.security.microservice.models.Role;
import com.security.microservice.models.RoleList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleList name);
}
