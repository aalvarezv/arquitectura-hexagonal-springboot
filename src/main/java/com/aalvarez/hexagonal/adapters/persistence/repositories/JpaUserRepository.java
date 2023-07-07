package com.aalvarez.hexagonal.adapters.persistence.repositories;

import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
