package br.com.company.fks.servico;

import br.com.company.fks.repositorio.StatusTramitacaoRecursoRepository;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.dto.StatusTramitacaoRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusTramitacaoRecursoService {

    @Autowired
    private StatusTramitacaoRecursoRepository statusTramitacaoRecursoRepository;

    public List<StatusTramitacaoRecursoDTO> consultarStatusTramitacao() {
        List<StatusTramitacaoRecurso> listaStatusTramitacaoRecurso = statusTramitacaoRecursoRepository.findAll();
        return converterParaStatusTramitacaoRecursoDTO(listaStatusTramitacaoRecurso);
    }

    private List<StatusTramitacaoRecursoDTO> converterParaStatusTramitacaoRecursoDTO(List<StatusTramitacaoRecurso> listaStatusTramitacaoRecurso) {

        List<StatusTramitacaoRecursoDTO> listaStatusTramitacaoRecursoDTO = new ArrayList<>();
        for (StatusTramitacaoRecurso statusTramitacaoRecurso : listaStatusTramitacaoRecurso) {
            StatusTramitacaoRecursoDTO statusTramitacaoRecursoDTO = new StatusTramitacaoRecursoDTO();
            statusTramitacaoRecursoDTO.setId(statusTramitacaoRecurso.getId());
            statusTramitacaoRecursoDTO.setNome(statusTramitacaoRecurso.getNome());
            listaStatusTramitacaoRecursoDTO.add(statusTramitacaoRecursoDTO);
        }
        return listaStatusTramitacaoRecursoDTO;
    }
}
