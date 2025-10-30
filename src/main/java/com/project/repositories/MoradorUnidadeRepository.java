package com.project.repositories;

import com.project.entities.MoradorUnidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MoradorUnidadeRepository extends JpaRepository<MoradorUnidade, Long> {

    Optional<MoradorUnidade> findByIdMoradorAndIdUnidade(Integer idMorador, Integer idUnidade);
}