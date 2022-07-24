package br.com.company.fks.servico;

import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.dto.StatusSolicitacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusSolicitacaoService {

    @Autowired
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    public List<StatusSolicitacaoDTO> consultarStatusSolicitacao() {
        List<StatusSolicitacao> listaStatusSolicitacao = statusSolicitacaoRepository.findAll();
        return converterParaStatusSolicitacaoDTO(listaStatusSolicitacao);
    }

    private List<StatusSolicitacaoDTO> converterParaStatusSolicitacaoDTO(List<StatusSolicitacao> listaStatusSolicitacao) {
        List<StatusSolicitacaoDTO> listaStatusSolicitacaoDTO = new ArrayList<>();
        for (StatusSolicitacao statusSolicitacao : listaStatusSolicitacao) {
            StatusSolicitacaoDTO statusSolicitacaoDTO = new StatusSolicitacaoDTO();
            statusSolicitacaoDTO.setId(statusSolicitacao.getId());
            statusSolicitacaoDTO.setNome(statusSolicitacao.getNome());
            listaStatusSolicitacaoDTO.add(statusSolicitacaoDTO);
        }
        return listaStatusSolicitacaoDTO;
    }
}
