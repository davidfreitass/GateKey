package com.project.applications;

import com.project.entities.RegistroAcesso;
import com.project.models.RegistroAcessoModel;
import com.project.repositories.RegistroAcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistroAcessoApplication {

    private final RegistroAcessoRepository repository;

    public RegistroAcessoApplication(RegistroAcessoRepository repository) {
        this.repository = repository;
    }

    public RegistroAcesso salvar(RegistroAcesso registroAcesso) {

        RegistroAcessoModel modelParaSalvar = this.converterParaEntidade(registroAcesso);

        RegistroAcessoModel modelSalvo = repository.save(modelParaSalvar);

        return this.converterParaDTO(modelSalvo);
    }

    public List<RegistroAcesso> listarTodos() {
        List<RegistroAcessoModel> listaDeModels = repository.findAll();

        return listaDeModels.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<RegistroAcesso> buscarPorId(Integer id) {
        Optional<RegistroAcessoModel> modelEncontrado = repository.findById(id);

        return modelEncontrado.map(this::converterParaDTO);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    private RegistroAcessoModel converterParaEntidade(RegistroAcesso dto) {
        RegistroAcessoModel model = new RegistroAcessoModel();
        model.setId(dto.getId());
        model.setDataHora(dto.getDataHora());
        model.setSituacao(dto.getSituacao());
        return model;
    }


    private RegistroAcesso converterParaDTO(RegistroAcessoModel model) {
        RegistroAcesso dto = new RegistroAcesso();
         dto.setId(model.getId());
         dto.setDataHora(model.getDataHora());
         dto.setSituacao(model.getSituacao());
        return dto;
    }
}