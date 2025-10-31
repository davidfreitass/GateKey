package com.project.applications;

import com.project.entities.RegistroAcesso;
import com.project.models.RegistroAcessoModel;
import com.project.repositories.RegistroAcessoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

    @Service
    public class RegistroAcessoApplication {

        private final RegistroAcessoRepository repository;

        public RegistroAcessoApplication(RegistroAcessoRepository repository) {
            this.repository = repository;
        }

        public RegistroAcessoModel salvar(RegistroAcessoModel registroAcessoModel) {
            return repository.save(registroAcessoModel);
        }

        public List<RegistroAcessoModel> listarTodos() {
            return repository.findAll();
        }

        public Optional<RegistroAcessoModel> buscarPorId(Integer id) {
            return repository.findById(id);
        }

        public void deletar(Integer id) {
            repository.deleteById(id);
        }
    }


