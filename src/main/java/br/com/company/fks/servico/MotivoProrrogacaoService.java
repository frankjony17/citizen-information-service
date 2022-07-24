package br.com.company.fks.servico;

import br.com.company.fks.repositorio.MotivoProrrogacaoRepository;
import br.com.company.fks.modelo.MotivoProrrogacao;
import br.com.company.fks.modelo.dto.MotivoProrrogacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotivoProrrogacaoService {

    @Autowired
    private MotivoProrrogacaoRepository motivoProrrogacaoRepository;

    public List<MotivoProrrogacaoDTO> consultarMotivoProrrogacao() {
        List<MotivoProrrogacao> listaMotivoProrrogacao = motivoProrrogacaoRepository.findAll();
        return converterParaMotivoProrrogacaoDTO(listaMotivoProrrogacao);
    }

    private List<MotivoProrrogacaoDTO> converterParaMotivoProrrogacaoDTO(List<MotivoProrrogacao> listaMotivoProrrogacao) {
        List<MotivoProrrogacaoDTO> listaMotivoProrrogacaoDTO = new ArrayList<>();
        for (MotivoProrrogacao motivoProrrogacao : listaMotivoProrrogacao) {
            MotivoProrrogacaoDTO motivoProrrogacaoDTO = new MotivoProrrogacaoDTO();
            motivoProrrogacaoDTO.setId(motivoProrrogacao.getId());
            motivoProrrogacaoDTO.setNome(motivoProrrogacao.getNome());
            listaMotivoProrrogacaoDTO.add(motivoProrrogacaoDTO);
        }
        return listaMotivoProrrogacaoDTO;
    }
}
