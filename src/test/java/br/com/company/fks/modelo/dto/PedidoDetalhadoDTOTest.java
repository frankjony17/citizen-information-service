package br.com.company.fks.modelo.dto;

import br.com.company.fks.modelo.Tema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoDetalhadoDTOTest {

    @InjectMocks
    private PedidoDetalhadoDTO dto;

    @Mock
    private Calendar dataAbertura;
    @Mock
    private Calendar vencimentoUnidade;
    @Mock
    private Calendar vencimentoESic;
    @Mock
    private Calendar dataRespostaEsic;
    @Mock
    private Calendar dataEntradaProtocoloSistemaFKS;
    @Mock
    private Calendar vencimentoUnidadeProrrodadoFKS;
    @Mock
    private Calendar dataLimiteBotaoProrrogacao;
    @Mock
    private Calendar dataLimiteBotaoEouv;

    @Test
    public void pedidoDetalhadoDTO(){
        List<Long> idPedido = new ArrayList<>();
        List<AnexoPedidoDetalhadoDTO> anexos = new ArrayList<>();
        SolicitanteDTO solicitanteDTO = new SolicitanteDTO();
        Tema tema = new Tema();
        dto.getIdPedido();
        dto.setIdPedido(1L);
        dto.getIdRecurso();
        dto.setIdRecurso(idPedido);
        dto.getProtocolo();
        dto.setProtocolo("protocolo");
        dto.getNomeStatusSolicitacao();
        dto.setNomeStatusSolicitacao("nomeStatusSolicitacao");
        dto.getDataAbertura();
        dto.setDataAbertura(dataAbertura);
        dto.getVencimentoUnidade();
        dto.setVencimentoUnidade(vencimentoUnidade);
        dto.getSolicitanteDTO();
        dto.setSolicitanteDTO(solicitanteDTO);
        dto.getNomeSituacaoPedido();
        dto.setNomeSituacaoPedido("nomeSituacaoPedido");
        dto.getResumoSolicitacao();
        dto.setResumoSolicitacao("resumoSolicitacao");
        dto.getDetalhamentoSolicitacao();
        dto.setDetalhamentoSolicitacao("detalhamentoSolicitacao");
        dto.getObservacao();
        dto.setObservacao("observacao");
        dto.getFormaRecebimento();
        dto.setFormaRecebimento("formaRecebimento");
        dto.getVencimentoESic();
        dto.setVencimentoESic(vencimentoESic);
        dto.getRespostaFKS();
        dto.setRespostaFKS("respostaFKS");
        dto.getDataRespostaEsic();
        dto.setDataRespostaEsic(dataRespostaEsic);
        dto.getOrgaoVinculado();
        dto.setOrgaoVinculado("orgaoVinculado");
        dto.getPossuiTratamentoFinal();
        dto.setPossuiTratamentoFinal(true);
        dto.getDataEntradaProtocoloSistemaFKS();
        dto.setDataEntradaProtocoloSistemaFKS(dataEntradaProtocoloSistemaFKS);
        dto.getVencimentoUnidadeProrrodadoFKS();
        dto.setVencimentoUnidadeProrrodadoFKS(vencimentoUnidadeProrrodadoFKS);
        dto.getIsDevolver();
        dto.setIsDevolver(true);
        dto.getIsClassificacaoRespostaSic();
        dto.setIsClassificacaoRespostaSic(true);
        dto.getDataLimiteBotaoProrrogacao();
        dto.setDataLimiteBotaoProrrogacao(dataLimiteBotaoProrrogacao);
        dto.getDataLimiteBotaoEouv();
        dto.setDataLimiteBotaoEouv(dataLimiteBotaoEouv);
        dto.getAnexos();
        dto.setAnexos(anexos);
        dto.getResposta();
        dto.setResposta("resposta");
        dto.getPerfilUsuario();
        dto.setPerfilUsuario("perfilUsuario");
        dto.getPropostaResposta();
        dto.setPropostaResposta("propostaResposta");
        dto.getTema();
        dto.setTema(tema);
        dto.getStatusQueAssinou();
        dto.setStatusQueAssinou("statusQueAssinou");
        dto.getCodigoUnidade();
        dto.setCodigoUnidade("codigoUnidade");
        dto.getCodigoSubunidade();
        dto.setCodigoSubunidade("codigoSubunidade");
    }

}