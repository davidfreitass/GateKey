package com.project.repositories;

import com.project.models.CredencialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CredencialRepository extends JpaRepository<CredencialModel, Integer> {
}
