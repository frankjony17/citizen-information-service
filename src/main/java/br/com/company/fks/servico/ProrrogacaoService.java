package br.com.company.fks.servico;

import br.com.company.fks.repositorio.MotivoProrrogacaoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.ProrrogacaoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.MotivoProrrogacao;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Prorrogacao;
import br.com.company.fks.modelo.dto.ProrrogacaoCadastroDTO;
import br.com.company.fks.utils.DataUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class ProrrogacaoService {

    private static final String PRAZO_PRORROGADO = "Vencimento Unidade prorrogado - ";

    private static final String PRAZO_ESIC = "Vencimento e-SIC prorrogado - ";

    private String nomeMotivoProrrogacao;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private ProrrogacaoRepository prorrogacaoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MotivoProrrogacaoRepository motivoProrrogacaoRepository;

    @Autowired
    private FeriadoService feriadoService;

    @Transactional
    public void criarProrrogacao(ProrrogacaoCadastroDTO prorrogacaoCadastroDTO) throws IntegracaoException {
        validarPeenchimentoCamposObrigatorios(prorrogacaoCadastroDTO);
        Prorrogacao prorrogacao = new Prorrogacao();
        prorrogacao.setId(null);
        Pedido pedido = pedidoRepository.findById(prorrogacaoCadastroDTO.getIdPedido());
        verificaDataProrrogacao(prorrogacaoCadastroDTO, pedido);
        verificaPrazoProrrogadoEsicOuFKS(prorrogacaoCadastroDTO, pedido);
        pedidoRepository.save(pedido);
        prorrogacao.setESic(verificaTipoProrrogacao(prorrogacaoCadastroDTO));
        prorrogacao.setPedido(pedido);
        prorrogacao.setJustificativaProrrogacao(prorrogacaoCadastroDTO.getJustificativaProrrogacao());
        MotivoProrrogacao motivoProrrogacao = new MotivoProrrogacao();
        motivoProrrogacao.setId(prorrogacaoCadastroDTO.getIdMotivoProrrogacao());
        prorrogacao.setMotivoProrrogacao(motivoProrrogacao);
        prorrogacaoRepository.save(prorrogacao);
        andamentoService.gerarAndamentoSolicitacao(pedido, false, verificaObservacaoDaProrrogacao(prorrogacao, prorrogacaoCadastroDTO));
    }

    public String verificaObservacaoDaProrrogacao(Prorrogacao prorrogacao, ProrrogacaoCadastroDTO prorrogacaoCadastroDTO) {
        MotivoProrrogacao motivoProrrogacao = motivoProrrogacaoRepository.findOne(prorrogacaoCadastroDTO.getIdMotivoProrrogacao());
        nomeMotivoProrrogacao = motivoProrrogacao.getNome();
        if(prorrogacao.isESic()) {
            return PRAZO_ESIC.concat(nomeMotivoProrrogacao);
        } else {
            return PRAZO_PRORROGADO.concat(nomeMotivoProrrogacao);
        }
    }

    public boolean verificaTipoProrrogacao(ProrrogacaoCadastroDTO prorrogacaoCadastroDTO) {
        return prorrogacaoCadastroDTO.isESic();
        }


    public void verificaDataProrrogacao(ProrrogacaoCadastroDTO prorrogacaoCadastroDTO, Pedido pedido) {
        List<Calendar> listaFeriados = feriadoService.listaFeriadosFKS();
        if(verificaTipoProrrogacao(prorrogacaoCadastroDTO)) {
            pedido.setPrazoAtendimento(DataUtil.getDataHoraFinalDia(DataUtil.addDays(pedido.getPrazoAtendimento(), 10)));
        } else {
            pedido.setVencimentoUnidade(DataUtil.getDataHoraFinalDia(DataUtil.somarDiasUteis(pedido.getVencimentoUnidade(), 5, listaFeriados)));
        }
    }

    public void verificaPrazoProrrogadoEsicOuFKS(ProrrogacaoCadastroDTO prorrogacaoCadastroDTO, Pedido pedido) {
        if(verificaTipoProrrogacao(prorrogacaoCadastroDTO)) {
            pedido.setStatusPrazoAtendimentoEsicProrrogado(true);
        } else {
            pedido.setStatusVencimentoUnidadeProrrogado(true);
        }
    }

    private void validarPeenchimentoCamposObrigatorios(ProrrogacaoCadastroDTO prorrogacaoCadastroDTO) throws IntegracaoException {
        if (prorrogacaoCadastroDTO.getIdMotivoProrrogacao() == null) {
            throw new IntegracaoException("O campo 'Motivo da Prorrogação' é de preenchimento obrigatório.");
        }
        if (StringUtils.isEmpty(prorrogacaoCadastroDTO.getJustificativaProrrogacao())) {
            throw new IntegracaoException("O campo 'Justificativa da Prorrogação' é de preenchimento obrigatório.");
        }
    }

    public ProrrogacaoCadastroDTO consultarProrrogacao(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido);
        Prorrogacao prorrogacao = prorrogacaoRepository.consultarProrrogacaoPorIdPedido(pedido, false);
        ProrrogacaoCadastroDTO prorrogacaoCadastroDTO = new ProrrogacaoCadastroDTO();
        prorrogacaoCadastroDTO.setJustificativaProrrogacao(prorrogacao.getJustificativaProrrogacao());
        prorrogacaoCadastroDTO.setIdMotivoProrrogacao(prorrogacao.getMotivoProrrogacao().getId());
        prorrogacaoCadastroDTO.setNovoVencimentoUnidade(pedido.getVencimentoUnidade());
        prorrogacaoCadastroDTO.setIdPedido(prorrogacao.getPedido().getId());
        return prorrogacaoCadastroDTO;
    }

    public ProrrogacaoCadastroDTO consultarProrrogacaoEsic(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido);
        Prorrogacao prorrogacao = prorrogacaoRepository.consultarProrrogacaoPorIdPedido(pedido, true);
        ProrrogacaoCadastroDTO prorrogacaoCadastroDTO = new ProrrogacaoCadastroDTO();
        prorrogacaoCadastroDTO.setNovoVencimentoUnidade(pedido.getVencimentoUnidade());
        prorrogacaoCadastroDTO.setJustificativaProrrogacao(prorrogacao.getJustificativaProrrogacao());
        prorrogacaoCadastroDTO.setIdMotivoProrrogacao(prorrogacao.getMotivoProrrogacao().getId());
        prorrogacaoCadastroDTO.setIdPedido(prorrogacao.getPedido().getId());
        prorrogacaoCadastroDTO.setPrevisaoEsic(pedido.getPrazoAtendimento());
        return prorrogacaoCadastroDTO;
    }
}
