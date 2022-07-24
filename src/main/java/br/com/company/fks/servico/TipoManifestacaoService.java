package br.com.company.fks.servico;

import br.com.company.fks.repositorio.TipoManifestacaoRepository;
import br.com.company.fks.modelo.TipoManifestacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoManifestacaoService {

    @Autowired
    private TipoManifestacaoRepository tipoManifestacaoRepository;

    public List<TipoManifestacao> buscaTodosTipoManifestacao() {
        return tipoManifestacaoRepository.findAllOrderByNome();
    }

}
