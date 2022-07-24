package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoRelatorioDTOTest {

    @InjectMocks
    private PedidoRelatorioDTO dto;
    @Mock
    private Calendar dataRegistro;
    @Mock
    private Calendar dataRespostaESic;
    @Mock
    private Calendar vencimentoUnidade;
    @Mock
    private Calendar vencimentoEsic;

    @Test
    public void pedidoRelatorio(){
        dto.getProtocolo();
        dto.setProtocolo("protocolo");
        dto.getStatusTramitacao();
        dto.setStatusTramitacao("statusTramitacao");
        dto.getStatusSolicitacao();
        dto.setStatusSolicitacao("statusSolicitacao");
        dto.getUnidade();
        dto.setUnidade("unidade");
        dto.getSubUnidade();
        dto.setSubUnidade("subUnidade");
        dto.getDataRegistro();
        dto.setDataRegistro(dataRegistro);
        dto.getDataRespostaESic();
        dto.setDataRespostaESic(dataRespostaESic);
        dto.getVencimentoUnidade();
        dto.setVencimentoUnidade(vencimentoUnidade);
        dto.getVencimentoEsic();
        dto.setVencimentoEsic(vencimentoEsic);
        dto.getAssunto();
        dto.setAssunto("assunto");
        dto.getSubAssunto();
        dto.setSubAssunto("subAssunto");
        dto.getPalavraChave();
        dto.setPalavraChave("palavraChave");
        dto.getAtendente();
        dto.setAtendente("atendente");
        dto.getNomeSolicitante();
        dto.setNomeSolicitante("nomeSolicitante");
        dto.getClassificacaoConteudo();
        dto.setClassificacaoConteudo("classificacaoConteudo");
        dto.getResumoSolicitacao();
        dto.setResumoSolicitacao("resumoSolicitacao");
        dto.getDescricaoPedido();
        dto.setDescricaoPedido("descricaoPedido");
        dto.getResposta();
        dto.setResposta("resposta");
        dto.getRecurso1Instancia();
        dto.setRecurso1Instancia("recurso1Instancia");
        dto.getRespostaRecurso1Instancia();
        dto.setRespostaRecurso1Instancia("respostaRecurso1Instancia");
        dto.getRecurso2Instancia();
        dto.setRecurso2Instancia("recurso2Instancia");
        dto.getRespostaRecurso2Instancia();
        dto.setRespostaRecurso2Instancia("respostaRecurso2Instancia");


    }

}