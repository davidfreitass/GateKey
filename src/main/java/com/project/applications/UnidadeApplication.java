package com.project.applications;

import com.project.entities.Credencial;
import com.project.entities.Unidade;
import com.project.models.CredencialModel;
import com.project.models.UnidadeModel;
import com.project.repositories.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeApplication {

        private final UnidadeRepository unidadeRepository;

        public UnidadeApplication(UnidadeRepository unidadeRepository) {
            this.unidadeRepository = unidadeRepository;
        }

        public Unidade salvar(Unidade unidade) {
            UnidadeModel model = unidade.toModel();
            UnidadeModel saved = unidadeRepository.save(model);

            return new Unidade(
                    saved.getId(),
                    saved.getNumero(),
                    saved.getBloco(),
                    saved.getTipo()
            );
        }

    public List<Unidade> listarTodos() {
        return unidadeRepository.findAll()
                .stream()
                .map(model -> new Unidade(
                        model.getId(),
                        model.getNumero(),
                        model.getBloco(),
                        model.getTipo()
                ))
                .toList();
    }

    public Optional<Unidade> buscarPorId(Integer id) {
        return unidadeRepository.findById(id)
                .map(model -> new Unidade(
                        model.getId(),
                        model.getNumero(),
                        model.getBloco(),
                        model.getTipo()
                ));
    }

        public void deletar(Integer id) {
            unidadeRepository.deleteById(id);
        }
    }