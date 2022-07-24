package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PropostaRespostaDTOTest {
    @InjectMocks
    private PropostaRespostaDTO dto;

    @Test
    public void PropostaRespostaDTO(){
        List<Unidade> listaUnidade = new ArrayList<>();
        List<Subunidade> listaSubunidade = new ArrayList<>();
        List<UsuarioAcessos> listaUsuarioAcessos = new ArrayList<>();
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getObservacao();
        dto.setObservacao("observacao");
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
        dto.getIdStatusSolicitacao();
        dto.setIdStatusSolicitacao(1L);
        dto.getNomeStatusSolicitacaoPedido();
        dto.setNomeStatusSolicitacaoPedido("nomeStatusSolicitacaoPedido");
        dto.getPropostaResposta();
        dto.setPropostaResposta("propostaResposta");
        dto.getListaUnidade();
        dto.setListaUnidade(listaUnidade);
        dto.getListaSubunidade();
        dto.setListaSubunidade(listaSubunidade);
        dto.getListaUsuarioAcessos();
        dto.setListaUsuarioAcessos(listaUsuarioAcessos);
    }

}