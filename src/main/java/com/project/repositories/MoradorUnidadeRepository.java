package com.project.repositories;

import com.project.models.MoradorUnidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoradorUnidadeRepository extends JpaRepository<MoradorUnidadeModel, Long> {

    Optional<MoradorUnidadeModel> findByMorador_IdAndUnidade_Id(Integer moradorId, Integer unidadeId);
}