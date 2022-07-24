package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.UsuarioAcessos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PropostaRespostaRecursoDTOTest {

    @InjectMocks
    private PropostaRespostaRecursoDTO dto;

    @Test
    public void PropostaRespostaRecursoDTO(){
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        dto.getIdRecurso();
        dto.setIdRecurso(1L);
        dto.getObservacao();
        dto.setObservacao("observacao");
        dto.getIdStatusSolicitacaoRecurso();
        dto.setIdStatusSolicitacaoRecurso(1L);
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getPropostaResposta();
        dto.setPropostaResposta("propostaResposta");
        dto.getUsuarioAcessosList();
        dto.setUsuarioAcessosList(usuarioAcessosList);
    }

}