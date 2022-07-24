package br.com.company.fks.servico;

import br.com.company.fks.repositorio.OrgaoRepository;
import br.com.company.fks.modelo.Orgao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository orgaoRepository;

    public List<Orgao> buscarTodasDescricaoOrgao() {
        return orgaoRepository.findAllOrderByDescricao();

    }
}
