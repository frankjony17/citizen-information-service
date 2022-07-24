package br.com.company.fks.servico;

import br.com.company.fks.repositorio.ClassificacaoTipoRespostaRepository;
import br.com.company.fks.modelo.ClassificacaoTipoResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificacaoTipoRespostaService {

    @Autowired
    private ClassificacaoTipoRespostaRepository classificacaoTipoRespostaRepository;

    public List<ClassificacaoTipoResposta> buscarTodasClassificacaoTipoResposta() {
        return classificacaoTipoRespostaRepository.findAllByDescricao();
    }

    public List<ClassificacaoTipoResposta> buscarPorTipoResposta(Long idTipoResposta) {
        return classificacaoTipoRespostaRepository.findAllByTipoResposta(idTipoResposta);
    }
}


