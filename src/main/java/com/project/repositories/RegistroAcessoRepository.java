package com.project.repositories;





import com.project.models.RegistroAcessoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAcessoRepository extends JpaRepository<RegistroAcessoModel, Integer>{

}