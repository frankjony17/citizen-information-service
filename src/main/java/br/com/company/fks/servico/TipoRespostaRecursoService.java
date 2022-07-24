package br.com.company.fks.servico;

import br.com.company.fks.repositorio.TipoRespostaRecursoRepository;
import br.com.company.fks.modelo.TipoRespostaRecurso;
import br.com.company.fks.modelo.dto.TipoRespostaRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoRespostaRecursoService {

    @Autowired
    private TipoRespostaRecursoRepository tipoRespostaRecursoRepository;

    public List<TipoRespostaRecursoDTO> consultaTipoRespostaRecurso() {
        List<TipoRespostaRecurso> listaTipoRespostaRecurso = tipoRespostaRecursoRepository.findAll();
        return converterParaTipoRespostaRecursoDTO(listaTipoRespostaRecurso);
    }

    private List<TipoRespostaRecursoDTO> converterParaTipoRespostaRecursoDTO(List<TipoRespostaRecurso> listaTipoRespostaRecurso) {
        List<TipoRespostaRecursoDTO> listaTipoRespostaRecursoDTO = new ArrayList<>();
        for (TipoRespostaRecurso tipoRespostaRecurso : listaTipoRespostaRecurso) {
            TipoRespostaRecursoDTO tipoRespostaRecursoDTO = new TipoRespostaRecursoDTO();
            tipoRespostaRecursoDTO.setId(tipoRespostaRecurso.getId());
            tipoRespostaRecursoDTO.setDescricao(tipoRespostaRecurso.getDescricao());
            listaTipoRespostaRecursoDTO.add(tipoRespostaRecursoDTO);
        }
        return listaTipoRespostaRecursoDTO;
    }
}
