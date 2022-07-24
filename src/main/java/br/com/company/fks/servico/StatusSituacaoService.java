package br.com.company.fks.servico;

import br.com.company.fks.repositorio.StatusSituacaoRepository;
import br.com.company.fks.modelo.StatusSituacao;
import br.com.company.fks.modelo.dto.StatusSituacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusSituacaoService {

    @Autowired
    private StatusSituacaoRepository statusSituacaoRepository;

    public List<StatusSituacaoDTO> consultarStatusSituacao() {
        List<StatusSituacao> listaStatusSituacao= statusSituacaoRepository.findAll();
        return converterParaStatusTramitacaoDTO(listaStatusSituacao);
    }

    private List<StatusSituacaoDTO> converterParaStatusTramitacaoDTO(List<StatusSituacao> listaStatusTramitacao) {

        List<StatusSituacaoDTO> listaStatusSituacaoDTO = new ArrayList<>();
        for (StatusSituacao statusSituacao : listaStatusTramitacao) {
            StatusSituacaoDTO statusSituacaoDTO = new StatusSituacaoDTO();
            statusSituacaoDTO.setId(statusSituacao.getId());
            statusSituacaoDTO.setNome(statusSituacao.getNome());
            listaStatusSituacaoDTO.add(statusSituacaoDTO);
        }
        return listaStatusSituacaoDTO;
    }
}
