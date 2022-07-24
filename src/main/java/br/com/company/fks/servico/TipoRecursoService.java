package br.com.company.fks.servico;

import br.com.company.fks.repositorio.TipoRecursoRepository;
import br.com.company.fks.modelo.TipoRecurso;
import br.com.company.fks.modelo.dto.TipoRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoRecursoService {

    @Autowired
    private TipoRecursoRepository tipoRecursoRepository;

    public List<TipoRecursoDTO> consultaTipoRecurso() {
        List<TipoRecurso> listaTipoRecurso = tipoRecursoRepository.findAll();
        return converterParaTipoRecursoDTO(listaTipoRecurso);
    }

    private List<TipoRecursoDTO> converterParaTipoRecursoDTO(List<TipoRecurso> listaTipoRecurso) {
        List<TipoRecursoDTO> listaTipoRecursoDTO = new ArrayList<>();
        for (TipoRecurso tipoRecurso : listaTipoRecurso) {
            TipoRecursoDTO tipoRecursoDTO = new TipoRecursoDTO();
            tipoRecursoDTO.setId(tipoRecurso.getId());
            tipoRecursoDTO.setNome(tipoRecurso.getNome());
            listaTipoRecursoDTO.add(tipoRecursoDTO);
        }
        return listaTipoRecursoDTO;
    }
}
