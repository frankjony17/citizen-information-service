package br.com.company.fks.servico;

import br.com.company.fks.repositorio.TipoRespostaRepository;
import br.com.company.fks.modelo.TipoResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRespostaService {

    @Autowired
    private TipoRespostaRepository tipoRespostaRepository;

    public List<TipoResposta> buscarTodasDescricaoTipoResposta() {
        return tipoRespostaRepository.findAllOrderByDescricao();
    }
}
