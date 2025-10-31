package com.project.repositories;




import com.project.models.DispositivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoModel, Integer>  {

}