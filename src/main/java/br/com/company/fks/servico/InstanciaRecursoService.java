package br.com.company.fks.servico;

import br.com.company.fks.repositorio.InstanciaRecursoRepository;
import br.com.company.fks.modelo.InstanciaRecurso;
import br.com.company.fks.modelo.dto.InstanciaRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstanciaRecursoService {

    @Autowired
    private InstanciaRecursoRepository instanciaRecursoRepository;

    public List<InstanciaRecursoDTO> consultaInstanciaRecurso() {
        List<InstanciaRecurso> listaInstanciaRecurso = instanciaRecursoRepository.findAll();
        return converterParaInstanciaRecursoDTO(listaInstanciaRecurso);
    }

    private List<InstanciaRecursoDTO> converterParaInstanciaRecursoDTO(List<InstanciaRecurso> listaInstanciaRecurso) {
        List<InstanciaRecursoDTO> listaInstanciaRecursoDTO = new ArrayList<>();
        for (InstanciaRecurso instanciaRecurso : listaInstanciaRecurso) {
            InstanciaRecursoDTO instanciaRecursoDTO = new InstanciaRecursoDTO();
            instanciaRecursoDTO.setId(instanciaRecurso.getId());
            instanciaRecursoDTO.setNome(instanciaRecurso.getNome());
            listaInstanciaRecursoDTO.add(instanciaRecursoDTO);
        }
        return listaInstanciaRecursoDTO;
    }
}
