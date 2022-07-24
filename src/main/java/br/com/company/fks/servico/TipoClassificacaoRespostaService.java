package br.com.company.fks.servico;

import br.com.company.fks.repositorio.TipoClassificacaoRespostaRepository;
import br.com.company.fks.modelo.TipoClassificacaoResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoClassificacaoRespostaService {
    @Autowired
    private TipoClassificacaoRespostaRepository tipoClassificacaoRespostaRepository;

    public void salvarTipoClassificacaoResposta(TipoClassificacaoResposta tipoClassificacaoResposta){
        tipoClassificacaoRespostaRepository.save(tipoClassificacaoResposta);
    }

    public List<TipoClassificacaoResposta> buscarTodosTiposClassificacaoResposta(){
        return tipoClassificacaoRespostaRepository.findAllOrderByNome();
    }

}
