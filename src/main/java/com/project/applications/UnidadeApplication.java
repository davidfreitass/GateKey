package com.project.applications;

import com.project.entities.Unidade;
import com.project.models.UnidadeModel;
import com.project.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeApplication {

        private final UnidadeRepository repository;

        public UnidadeApplication(UnidadeRepository repository) {
            this.repository = repository;
        }

        public UnidadeModel salvar(UnidadeModel unidadeModel) {
            return repository.save(unidadeModel);
        }

        public List<UnidadeModel> listarTodos() {
            return repository.findAll();
        }

        public Optional<UnidadeModel> buscarPorId(Integer id) {
            return repository.findById(id);
        }

        public void deletar(Integer id) {
            repository.deleteById(id);
        }
    }