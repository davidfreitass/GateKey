package com.project.repositories;


import com.project.models.MoradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<MoradorModel,Integer> {

}
