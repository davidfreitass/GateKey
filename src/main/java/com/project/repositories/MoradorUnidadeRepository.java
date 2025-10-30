package com.project.repositories;

import com.project.entities.MoradorUnidade;
import com.project.entities.MoradorUnidadeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorUnidadeRepository extends JpaRepository<MoradorUnidade, MoradorUnidadeId> {
}
