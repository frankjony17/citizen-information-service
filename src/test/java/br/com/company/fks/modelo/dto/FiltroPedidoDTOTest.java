package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiltroPedidoDTOTest {
    @InjectMocks
    private FiltroPedidoDTO dto;

    @Mock
    private Calendar periodoInicialDataAbertura;
    @Mock
    private Calendar periodoFinalDataAbertura;
    @Mock
    private Calendar periodoInicialPrazoAtendimento;
    @Mock
    private Calendar periodoFinalPrazoAtendimento;
    @Mock
    private Calendar prazoVencidoFKS;
    @Mock
    private Calendar prazoVencidoEsic;
    @Mock
    private Calendar periodoInicialVencimentoEsic;
    @Mock
    private Calendar periodoFinalVencimentoEsic;

    @Test
    public void FiltroPedidoDTO(){
        dto.getOffset();
        dto.setOffset(1);
        dto.getLimit();
        dto.setLimit(1);
        dto.getIdStatusTramitacao();
        dto.setIdStatusTramitacao(1L);
        dto.getProtocolo();
        dto.setProtocolo("protocolo");
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getIdSubUnidade();
        dto.setIdSubUnidade(1L);
        dto.getPeriodoInicialDataAbertura();
        dto.setPeriodoInicialDataAbertura(periodoInicialDataAbertura);
        dto.getPeriodoFinalDataAbertura();
        dto.setPeriodoFinalDataAbertura(periodoFinalDataAbertura);
        dto.getPeriodoInicialPrazoAtendimento();
        dto.setPeriodoInicialPrazoAtendimento(periodoInicialPrazoAtendimento);
        dto.getPeriodoFinalPrazoAtendimento();
        dto.setPeriodoFinalPrazoAtendimento(periodoFinalPrazoAtendimento);
        dto.getPrazoVencidoFKS();
        dto.setPrazoVencidoFKS(prazoVencidoFKS);
        dto.getPrazoProrrogadoFKS();
        dto.setPrazoProrrogadoFKS(true);
        dto.getNomeSolicitante();
        dto.setNomeSolicitante("nomeSolicitante");
        dto.getTipoPessoa();
        dto.setTipoPessoa("tipoPessoa");
        dto.getIdStatusSolicitacao();
        dto.setIdStatusSolicitacao(1L);
        dto.getIdStatusSituacao();
        dto.setIdStatusSituacao(1L);
        dto.getIdOrigemSolicitacao();
        dto.setIdOrigemSolicitacao(1L);
        dto.getIdSituacaoPedido();
        dto.setIdSituacaoPedido(1L);
        dto.getIdComplementoSituacao();
        dto.setIdComplementoSituacao(1L);
        dto.getIdTema();
        dto.setIdTema(1L);
        dto.getIdSubTema();
        dto.setIdSubTema(1L);
        dto.getIdAtendente();
        dto.setIdAtendente(1L);
        dto.getIdClassificacaoConteudo();
        dto.setIdClassificacaoConteudo(1L);
        dto.getTextoSolicitacao();
        dto.setTextoSolicitacao("textoSolicitacao");
        dto.getTextoResposta();
        dto.setTextoResposta("textoResposta");
        dto.getPrazoVencidoEsic();
        dto.setPrazoVencidoEsic(prazoVencidoEsic);
        dto.getPrazoProrrogadoEsic();
        dto.setPrazoProrrogadoEsic(true);
        dto.getPeriodoInicialVencimentoEsic();
        dto.setPeriodoInicialVencimentoEsic(periodoInicialVencimentoEsic);
        dto.getPeriodoFinalVencimentoEsic();
        dto.setPeriodoFinalVencimentoEsic(periodoFinalVencimentoEsic);
        dto.getIdPalavraChave();
        dto.setIdPalavraChave(1L);
        dto.getIdDemandasComigo();
        dto.setIdDemandasComigo(1);
    }

}