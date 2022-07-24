package br.com.company.fks.servico;

import br.com.company.fks.repositorio.StatusSolicitacaoRecursoRepository;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusSolicitacaoRecursoService {

    @Autowired
    private StatusSolicitacaoRecursoRepository statusSolicitacaoRecursoRepository;

    public List<StatusSolicitacaoRecursoDTO> consultarStatusSolicitacao() {
        List<StatusSolicitacaoRecurso> listaStatusSolicitacaoRecurso = statusSolicitacaoRecursoRepository.findAll();
        return converterParaStatusSolicitacaoRecursoDTO(listaStatusSolicitacaoRecurso);
    }

    private List<StatusSolicitacaoRecursoDTO> converterParaStatusSolicitacaoRecursoDTO(List<StatusSolicitacaoRecurso> listaStatusSolicitacaoRecurso) {
        List<StatusSolicitacaoRecursoDTO> listaStatusSolicitacaoRecursoDTO = new ArrayList<>();
        for (StatusSolicitacaoRecurso statusSolicitacaoRecurso : listaStatusSolicitacaoRecurso) {
            StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO = new StatusSolicitacaoRecursoDTO();
            statusSolicitacaoRecursoDTO.setId(statusSolicitacaoRecurso.getId());
            statusSolicitacaoRecursoDTO.setNome(statusSolicitacaoRecurso.getNome());
            listaStatusSolicitacaoRecursoDTO.add(statusSolicitacaoRecursoDTO);
        }
        return listaStatusSolicitacaoRecursoDTO;
    }
}
