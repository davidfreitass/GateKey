package br.com.gatekey.repositories;




import br.com.gatekey.entities.RegistroAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroAcessoRepository extends JpaRepository<RegistroAcesso, Integer>{

}