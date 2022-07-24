package br.com.company.fks.modelo.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FiltroRecursoDTOTest {
    @InjectMocks
    private FiltroRecursoDTO dto;
    @Mock
    private Calendar periodoInicialDataAbertura;
    @Mock
    private Calendar periodoFinalDataAbertura;
    @Mock
    private Calendar periodoInicialPrazoAtendimento;
    @Mock
    private Calendar periodoFinalPrazoAtendimento;
    @Mock
    private Calendar periodoInicialDecisaoCgu;
    @Mock
    private Calendar periodoFinalDecisaoCgu;
    @Mock
    private Calendar periodoInicialDecisaoCmri;
    @Mock
    private Calendar periodoFinalDecisaoCmri;
    @Mock
    private Calendar periodoInicialVencimentoEsic;
    @Mock
    private Calendar periodoFinalVencimentoEsic;
    @Mock
    private Calendar prazoVencidoFKS;
    @Mock
    private Calendar prazoVencidoEsic;

    @Test
    public void FiltroRecursoDTO(){
        dto.getIdDemandasComigo();
        dto.setIdDemandasComigo(1);
        dto.getOffset();
        dto.setOffset(1);
        dto.getLimit();
        dto.setLimit(1);
        dto.getIdStatusTramitacao();
        dto.setIdStatusTramitacao(1L);
        dto.getIdStatusSolicitacao();
        dto.setIdStatusSolicitacao(1L);
        dto.getProtocolo();
        dto.setProtocolo("protocolo");
        dto.getIdTipoResposta();
        dto.setIdTipoResposta(1L);
        dto.getIdUnidade();
        dto.setIdUnidade(1L);
        dto.getIdSubunidade();
        dto.setIdSubunidade(1L);
        dto.getPeriodoInicialDataAbertura();
        dto.setPeriodoInicialDataAbertura(periodoInicialDataAbertura);
        dto.getPeriodoFinalDataAbertura();
        dto.setPeriodoFinalDataAbertura(periodoFinalDataAbertura);
        dto.getPeriodoInicialPrazoAtendimento();
        dto.setPeriodoInicialPrazoAtendimento(periodoInicialPrazoAtendimento);
        dto.getPeriodoFinalPrazoAtendimento();
        dto.setPeriodoFinalPrazoAtendimento(periodoFinalPrazoAtendimento);
        dto.getTipoPessoa();
        dto.setTipoPessoa("tipoPessoa");
        dto.getIdInstanciaRecurso();
        dto.setIdInstanciaRecurso(1L);
        dto.getPeriodoInicialDecisaoCgu();
        dto.setPeriodoInicialDecisaoCgu(periodoInicialDecisaoCgu);
        dto.getPeriodoFinalDecisaoCgu();
        dto.setPeriodoFinalDecisaoCgu(periodoFinalDecisaoCgu);
        dto.getPeriodoInicialDecisaoCmri();
        dto.setPeriodoInicialDecisaoCmri(periodoInicialDecisaoCmri);
        dto.getPeriodoFinalDecisaoCmri();
        dto.setPeriodoFinalDecisaoCmri(periodoFinalDecisaoCmri);
        dto.getPeriodoInicialVencimentoEsic();
        dto.setPeriodoInicialVencimentoEsic(periodoInicialVencimentoEsic);
        dto.getPeriodoFinalVencimentoEsic();
        dto.setPeriodoFinalVencimentoEsic(periodoFinalVencimentoEsic);
        dto.getIdSituacaoRecurso();
        dto.setIdSituacaoRecurso(1L);
        dto.getIdTipoRecurso();
        dto.setIdTipoRecurso(1L);
        dto.getDescricaoJustificativa();
        dto.setDescricaoJustificativa("descricaoJustificativa");
        dto.getNomeSolicitante();
        dto.setNomeSolicitante("nomeSolicitante");
        dto.getPrazoVencidoFKS();
        dto.setPrazoVencidoFKS(prazoVencidoFKS);
        dto.getPrazoVencidoEsic();
        dto.setPrazoVencidoEsic(prazoVencidoEsic);
    }

}