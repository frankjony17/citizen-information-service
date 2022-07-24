package br.com.company.fks.servico;

import br.com.company.fks.repositorio.SituacaoRecursoRepository;
import br.com.company.fks.modelo.SituacaoRecurso;
import br.com.company.fks.modelo.dto.SituacaoRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SituacaoRecursoService {

    @Autowired
    private SituacaoRecursoRepository situacaoRecursoRepository;

    public List<SituacaoRecursoDTO> consultaSituacaoRecurso() {
        List<SituacaoRecurso> listaSituacaoRecurso = situacaoRecursoRepository.findAll();
        return converterParaSituacaoRecursoDTO(listaSituacaoRecurso);
    }

    private List<SituacaoRecursoDTO> converterParaSituacaoRecursoDTO(List<SituacaoRecurso> listaSituacaoRecurso) {
        List<SituacaoRecursoDTO> listaSituacaoRecursoDTO = new ArrayList<>();
        for (SituacaoRecurso situacaoRecurso : listaSituacaoRecurso) {
            SituacaoRecursoDTO situacaoRecursoDTO = new SituacaoRecursoDTO();
            situacaoRecursoDTO.setId(situacaoRecurso.getId());
            situacaoRecursoDTO.setNome(situacaoRecurso.getNome());
            listaSituacaoRecursoDTO.add(situacaoRecursoDTO);
        }
        return listaSituacaoRecursoDTO;
    }
}
