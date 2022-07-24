package br.com.company.fks.servico;

import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.SolicitanteRepository;
import br.com.company.fks.repositorio.custom.PedidoCustomRepositorio;
import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.gov.cgu.esic.pedido.ResponseSolicitante;
import br.com.company.fks.modelo.Anexo;
import br.com.company.fks.modelo.Feriado;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.SituacaoPedido;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusTramitacao;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.wsdl.AnexoUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ImportacaoPedidoService {

    public static final int PRAZO_ATENDIMENTO = 10;

    @Autowired
    private PedidoCustomRepositorio pedidoCustomRepositorio;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private FeriadoRepository feriadoRepository;

    @Autowired
    private AnexoUtils anexoUtils;

    @Transactional
    public void sincronizarBaseDeDadosPedidos(ResponsePedido responsePedido, ResponseArquivo[] arquivos) {
        String protocolo = responsePedido.getProtocolo();
        Pedido pedido = pedidoRepository.recuperarPedidoPeloProtocolo(protocolo);

        if (pedido == null) {
            pedido = criarNovoPedido(responsePedido);
            aplicarDadosDoPedidoProvenientesDoESic(pedido, responsePedido);
            aplicarDadosDoSolicitanteProvenientesDoESic(pedido, responsePedido.getSolicitante());
            aplicarDadosDosAnexosProvenientesDoESic(pedido, arquivos);

            if (pedido.getAndamentos() == null) {
                pedido.setAndamentos(new ArrayList<>());
            }

            pedido.getAndamentos().add(andamentoService.gerarAndamentoSolicitacao(pedido, true, null));

            pedidoRepository.save(pedido);
        } else {
            aplicarDadosDoPedidoProvenientesDoESic(pedido, responsePedido);
            aplicarDadosDoSolicitanteProvenientesDoESic(pedido, responsePedido.getSolicitante());
            aplicarDadosDosAnexosProvenientesDoESic(pedido, arquivos);
        }
    }

    private Pedido criarNovoPedido(ResponsePedido responsePedido) {
        Calendar dataEntradaProtocoloSistemaFKS = Calendar.getInstance();
        Pedido pedido = new Pedido();
        pedido.setStatusTramitacao(definirStatusTramitacao(responsePedido));
        pedido.setStatusSolicitacao(definirStatusSolicitacao(responsePedido));
        pedido.setSituacaoPedido(definirSituacaoPedido(responsePedido.getSituacao()));
        pedido.setVencimentoUnidade(calcularPrazoVencimentoUnidade(responsePedido.getDataRegistro()));
        pedido.setDataEntradaProtocoloSistemaFKS(dataEntradaProtocoloSistemaFKS);
        pedido.setStatusPrazoAtendimentoEsicProrrogado(false);
        pedido.setStatusVencimentoUnidadeProrrogado(false);
        pedido.setIsDevolver(false);
        return pedido;
    }

    private Calendar calcularPrazoVencimentoUnidade(Calendar dataCientificacao) {
        List<Calendar> feriados = recuperarListaFeriados();

        Calendar primeiroDiaUtil;

        if (DataUtil.isDiaUtil(dataCientificacao, feriados)) {
            if (DataUtil.isAntes19Hs(dataCientificacao)) {
                primeiroDiaUtil = DataUtil.recuperarProximoDiaUtil(dataCientificacao, feriados);
            } else {
                primeiroDiaUtil = DataUtil.recuperarProximoDiaUtil(dataCientificacao, feriados);
                primeiroDiaUtil = DataUtil.somarDiasUteis(primeiroDiaUtil, 1, feriados);
            }
        } else {
            Calendar proximoDiaUtil = DataUtil.recuperarProximoDiaUtil(dataCientificacao, feriados);
            primeiroDiaUtil = DataUtil.recuperarProximoDiaUtil(proximoDiaUtil, feriados);
        }
        Calendar calendar = DataUtil.somarDiasUteis(primeiroDiaUtil, PRAZO_ATENDIMENTO - 1, feriados);

        return DataUtil.getDataHoraFinalDiaImportacao(calendar);
    }

    private List<Calendar> recuperarListaFeriados() {
        List<Calendar> listaCalendar = new ArrayList<>();
        List<Feriado> listaFeriado = feriadoRepository.findAll();
        for (Feriado feriado : listaFeriado) {
            listaCalendar.add(feriado.getDataFeriado());
        }
        return listaCalendar;
    }

    private StatusTramitacao definirStatusTramitacao(ResponsePedido responsePedido) {
        StatusTramitacao statusTramitacao = new StatusTramitacao();
        if (responsePedido.getSituacao().equals("Em Tramitação")) {
            statusTramitacao.setId(1L);
        } else if (responsePedido.getSituacao().equals("Respondido")) {
            statusTramitacao.setId(5L);
        }

        return statusTramitacao;
    }

    private StatusSolicitacao definirStatusSolicitacao(ResponsePedido responsePedido) {
        StatusSolicitacao statusSolicitacao = new StatusSolicitacao();
        if (responsePedido.getSituacao().equals("Em Tramitação")) {
            statusSolicitacao.setId(1L);
        } else if (responsePedido.getSituacao().equals("Respondido")) {
            statusSolicitacao.setId(9L);
        }

        return statusSolicitacao;
    }

    private SituacaoPedido definirSituacaoPedido(String situacao) {
        SituacaoPedido situacaoPedido = null;
        if (StringUtils.isNotEmpty(situacao)) {
            situacaoPedido = new SituacaoPedido();
            if (SituacaoPedido.EM_TRAMITACAO.equalsIgnoreCase(situacao)) {
                situacaoPedido.setId(1L);
            }
            if (SituacaoPedido.RESPONDIDO.equalsIgnoreCase(situacao)) {
                situacaoPedido.setId(2L);
            }
        }
        return situacaoPedido;
    }

    private void aplicarDadosDoPedidoProvenientesDoESic(Pedido pedido, ResponsePedido responsePedido) {
        pedido.setProtocolo(responsePedido.getProtocolo());
        pedido.setDataRegistro(responsePedido.getDataRegistro());
        pedido.setDescricaoPedido(responsePedido.getDescricaoPedido());
        pedido.setCodigoSiorgOrgaoSuperior(responsePedido.getCodSiorgOrgaoSuperior());
        pedido.setOrgaoSuperior(responsePedido.getOrgaoSuperior());
        pedido.setOrgaoVinculado(responsePedido.getOrgaoVinculado());
        pedido.setPrazoAtendimento(responsePedido.getPrazoAtendimento());
        pedido.setFormaRecebimento(responsePedido.getFormaRecebimento());
        pedido.setSituacaoStatus(responsePedido.getSituacaoStatus());
        pedido.setEmAtendimento(responsePedido.getEmAtendimento());
        pedido.setQuantidadeAnexos(responsePedido.getQtdAnexos());
        pedido.setResumoSolicitacao(responsePedido.getResumoSolicitacao());
        pedido.setDataUltimoReencaminhamento(responsePedido.getDataUltimoReencaminhamento());
    }

    private void aplicarDadosDoSolicitanteProvenientesDoESic(Pedido pedido, ResponseSolicitante responseSolicitante) {
        Solicitante solicitante = solicitanteRepository.findByCpfOuCnpj(responseSolicitante.getCPFouCNPJ());
        if (solicitante == null) {
            solicitante = new Solicitante();
            solicitante.setTipoPessoa(responseSolicitante.getTipoPessoa());
            solicitante.setNome(responseSolicitante.getNome());
            solicitante.setCpfOuCnpj(responseSolicitante.getCPFouCNPJ());
            solicitante.setDocumentoIdentificacao(responseSolicitante.getDocumentoIdentificacao());
            solicitante.setSexo(responseSolicitante.getSexo());
            solicitante.setProfissao(responseSolicitante.getProfissao());
            solicitante.setEmail(responseSolicitante.getEmail());
            solicitante.setDdd(responseSolicitante.getDDD());
            solicitante.setTelefone(responseSolicitante.getTelefone());
            solicitante.setEndereco(responseSolicitante.getEndereco());
            solicitante.setUf(responseSolicitante.getUF());
            solicitante.setPais(responseSolicitante.getPais());
            solicitante.setCidade(responseSolicitante.getCidade());
            solicitante.setCep(responseSolicitante.getCEP());
            pedido.setSolicitante(solicitante);
            solicitanteRepository.save(solicitante);
        } else {
            preencheDadosSolicitanteEsic(pedido, responseSolicitante, solicitante);
        }

    }

    private void preencheDadosSolicitanteEsic(Pedido pedido, ResponseSolicitante responseSolicitante, Solicitante solicitante) {
        solicitante.setTipoPessoa(responseSolicitante.getTipoPessoa());
        solicitante.setNome(responseSolicitante.getNome());
        solicitante.setCpfOuCnpj(responseSolicitante.getCPFouCNPJ());
        solicitante.setDocumentoIdentificacao(responseSolicitante.getDocumentoIdentificacao());
        solicitante.setSexo(responseSolicitante.getSexo());
        solicitante.setProfissao(responseSolicitante.getProfissao());
        solicitante.setEmail(responseSolicitante.getEmail());
        solicitante.setDdd(responseSolicitante.getDDD());
        solicitante.setTelefone(responseSolicitante.getTelefone());
        solicitante.setEndereco(responseSolicitante.getEndereco());
        solicitante.setUf(responseSolicitante.getUF());
        solicitante.setPais(responseSolicitante.getPais());
        solicitante.setCidade(responseSolicitante.getCidade());
        solicitante.setCep(responseSolicitante.getCEP());
        pedido.setSolicitante(solicitante);
    }

    private void aplicarDadosDosAnexosProvenientesDoESic(Pedido pedido, ResponseArquivo[] arquivos) {
        pedido.getAnexos().clear();

        for (ResponseArquivo arquivo : arquivos) {
            File file = anexoUtils.getFile(pedido.getProtocolo(), arquivo.getNomeArquivo());
            Anexo anexo = new Anexo();
            anexo.setNome(arquivo.getNomeArquivo());
            anexo.setTamanho(file.length());
            anexo.setExtensao(FilenameUtils.getExtension(file.getName()));
            pedido.addAnexo(anexo);
        }
    }
}
