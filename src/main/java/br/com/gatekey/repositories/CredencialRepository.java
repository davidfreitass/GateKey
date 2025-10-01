package br.com.gatekey.repositories;

import br.com.gatekey.entities.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial, Integer> {
}
