package br.com.company.fks.servico;

import br.com.company.fks.repositorio.StatusTramitacaoRepository;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.modelo.dto.StatusTramitacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusTramitacaoService {

    @Autowired
    private StatusTramitacaoRepository statusTramitacaoRepository;

    public List<StatusTramitacaoDTO> consultarStatusTramitacao() {
        List<StatusTramitacao> listaStatusTramitacao = statusTramitacaoRepository.findAll();
        return converterParaStatusTramitacaoDTO(listaStatusTramitacao);
    }

    private List<StatusTramitacaoDTO> converterParaStatusTramitacaoDTO(List<StatusTramitacao> listaStatusTramitacao) {

        List<StatusTramitacaoDTO> listaStatusTramitacaoDTO = new ArrayList<>();
        for (StatusTramitacao statusTramitacao : listaStatusTramitacao) {
            StatusTramitacaoDTO statusTramitacaoDTO = new StatusTramitacaoDTO();
            statusTramitacaoDTO.setId(statusTramitacao.getId());
            statusTramitacaoDTO.setNome(statusTramitacao.getNome());
            listaStatusTramitacaoDTO.add(statusTramitacaoDTO);
        }
        return listaStatusTramitacaoDTO;
    }
}
