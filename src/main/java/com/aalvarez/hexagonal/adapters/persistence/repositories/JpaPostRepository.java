package com.aalvarez.hexagonal.adapters.persistence.repositories;

import com.aalvarez.hexagonal.adapters.persistence.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository  extends JpaRepository<PostEntity, Long> {
}
