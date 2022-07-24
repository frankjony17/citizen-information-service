package br.com.company.fks.servico;

import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.gov.cgu.esic.pedido.ResponseArquivo;
import br.gov.cgu.esic.pedido.ResponsePedido;
import br.com.company.fks.modelo.InstanciaRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.SituacaoRecurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.TipoRecurso;
import br.com.company.fks.command.ImportacaoRecursoServiceCommandImpl;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.wsdl.ConsultaAnexoPedido;
import br.gov.cgu.esic.recurso.ResponseRecurso;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

@Service
public class ImportacaoRecursoService {

    private static final String EM_TRAMITACAO = "Em Tramitação";

    private static final String RESPONDIDO = "Respondido";

    private static final String DEFERIDO = "Deferido";

    private ConsultaPedido consultaPedido = new ConsultaPedido();

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ImportacaoPedidoService importacaoPedidoService;

    @Autowired
    private ConsultaAnexoPedido consultaAnexoPedido;

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    @Transactional
    public void sincronizarBaseDeDadosRecursos(ResponseRecurso responseRecurso) throws IOException, ServiceException {
        String protocoloPedido = responseRecurso.getProtocoloPedido();
        List<Recurso> listaRecurso = recursoRepository.recuperarRecursoPeloProtocolo(protocoloPedido);
        gerarAndamentoRecursoOrAplicarDadosDoRecurso(listaRecurso, responseRecurso);
        if (responseRecurso.getCodInstancia() == 2) {
            boolean existe = false;
            Recurso recurso = listaRecurso.stream().filter(r -> r.getInstanciaRecurso().getId() == 2).findAny().orElse(null);
            if (recurso != null) {
                existe = true;
                aplicarDadosDoRecursoProvenientesDoESic(recurso, responseRecurso);
            }
            if (!existe) {
                recurso = criarNovoRecurso(responseRecurso);
                aplicarDadosDoRecursoProvenientesDoESic(recurso, responseRecurso);
                andamentoRecursoService.gerarAndamentoRecurso(recurso, true, null);
                if(recurso.getStatusSolicitacao().getId() == null) { recurso.setStatusSolicitacao(null); }
                recursoRepository.save(recurso);
            }
        }
    }

    private void gerarAndamentoRecursoOrAplicarDadosDoRecurso (List<Recurso> listaRecurso, ResponseRecurso responseRecurso) throws IOException, ServiceException {
        Recurso recurso;
        if (listaRecurso.isEmpty() && responseRecurso.getCodInstancia() == 1) {
            recurso = criarNovoRecurso(responseRecurso);
            aplicarDadosDoRecursoProvenientesDoESic(recurso, responseRecurso);
            andamentoRecursoService.gerarAndamentoRecurso(recurso, true, null);
            recursoRepository.save(recurso);
        } else if (responseRecurso.getCodInstancia() == 1) {
            Recurso rec = listaRecurso.stream().filter(r -> r.getInstanciaRecurso().getId().equals(1L)).findAny().orElse(null);
            if (rec != null) {
                recurso = rec;
                aplicarDadosDoRecursoProvenientesDoESic(recurso, responseRecurso);
            }
        }
    }

    private Recurso criarNovoRecurso(ResponseRecurso responseRecurso) throws IOException, ServiceException {
        Recurso recurso = new Recurso();
        if (pedidoRepository.recuperarPedidoPeloProtocolo(responseRecurso.getProtocoloPedido()) == null) {
            ResponsePedido[] pedidos = consultaPedido.consultaPedido(responseRecurso.getProtocoloPedido());
            for (ResponsePedido pedidoImportacao : pedidos) {
                ResponseArquivo[] arquivos = consultaAnexoPedido.consultaAnexosPedido(pedidoImportacao.getProtocolo());
                importacaoPedidoService.sincronizarBaseDeDadosPedidos(pedidoImportacao, arquivos);
            }
        }
        setRecurso(recurso, responseRecurso);
        return recurso;
    }

    private void setRecurso (Recurso recurso, ResponseRecurso responseRecurso) {
        recurso.setPedido(pedidoRepository.recuperarPedidoPeloProtocolo(responseRecurso.getProtocoloPedido()));
        recurso.setStatusTramitacao(definirStatusTramitacaoRecurso(responseRecurso));
        recurso.setStatusSolicitacao(definirStatusSolicitacaoRecurso(responseRecurso));
        recurso.setSituacaoRecurso(definirSituacaoRecurso(responseRecurso.getSituacao()));
        recurso.setTipoRecurso(definirTipoRecurso(responseRecurso.getTipoRecurso()));
        recurso.setDataPrazoAtendimento(responseRecurso.getPrazoAtendimento());
        recurso.setVencimentoUnidade(DataUtil.addDays(responseRecurso.getPrazoAtendimento(), -1));
        recurso.setInstanciaRecurso(definirInstanciaRecurso(responseRecurso.getCodInstancia()));
    }

    private StatusTramitacaoRecurso definirStatusTramitacaoRecurso(ResponseRecurso responseRecurso) {
        StatusTramitacaoRecurso statusTramitacaoRecurso = new StatusTramitacaoRecurso();
        if (responseRecurso.getSituacao().equals(RESPONDIDO)) {
            statusTramitacaoRecurso.setId(4L);
        }
        else {
            statusTramitacaoRecurso.setId(1L);
        }
        return statusTramitacaoRecurso;
    }

    private StatusSolicitacaoRecurso definirStatusSolicitacaoRecurso(ResponseRecurso responseRecurso) {
        StatusSolicitacaoRecurso statusSolicitacaoRecurso = new StatusSolicitacaoRecurso();
        if (responseRecurso.getCodInstancia() == 1) {
            if (responseRecurso.getSituacao().equals(RESPONDIDO)) {
                statusSolicitacaoRecurso.setId(8L);
            } else {
                statusSolicitacaoRecurso.setId(1L);
            }
        }
        if (responseRecurso.getCodInstancia() == 2) {
            switch (responseRecurso.getSituacao()) {
                case EM_TRAMITACAO:
                case DEFERIDO: statusSolicitacaoRecurso.setId(9L); break;
                case RESPONDIDO: statusSolicitacaoRecurso.setId(16L); break;
                default: break;
            }
        }
        return statusSolicitacaoRecurso;
    }

    private SituacaoRecurso definirSituacaoRecurso(String situacao) {
        SituacaoRecurso situacaoRecurso = null;
        if (StringUtils.isNotEmpty(situacao)) {
            situacaoRecurso = new SituacaoRecurso();
            if (SituacaoRecurso.EM_TRAMITACAO.equalsIgnoreCase(situacao)) {
                situacaoRecurso.setId(1L);
            }
            if (SituacaoRecurso.RESPONDIDO.equalsIgnoreCase(situacao)) {
                situacaoRecurso.setId(2L);
            }
            if (SituacaoRecurso.DEFERIDO.equalsIgnoreCase(situacao)) {
                situacaoRecurso.setId(3L);
            }
            if (SituacaoRecurso.NAO_RESPONDIDO.equalsIgnoreCase(situacao)) {
                situacaoRecurso.setId(1L);
            }
        }
        return situacaoRecurso;
    }

    private TipoRecurso definirTipoRecurso(String tipo) {
        TipoRecurso tipoRecurso = null;
        if (StringUtils.isNotEmpty(tipo)) {
            tipoRecurso = new TipoRecurso();
            ImportacaoRecursoServiceCommandImpl serviceCommand = new ImportacaoRecursoServiceCommandImpl();
            serviceCommand.definirTipoRecurso(tipo, tipoRecurso);
        }
        return tipoRecurso;
    }

    private InstanciaRecurso definirInstanciaRecurso(int codigoInstancia) {
        InstanciaRecurso instanciaRecurso = new InstanciaRecurso();
        Integer id = codigoInstancia;
        instanciaRecurso.setId(id.longValue());
        return instanciaRecurso;
    }

    private void aplicarDadosDoRecursoProvenientesDoESic(Recurso recurso, ResponseRecurso responseRecurso) {
        recurso.setProtocoloPedido(responseRecurso.getProtocoloPedido());
        recurso.setDataAbertura(responseRecurso.getDataAbertura());
        recurso.setDataPrazoAtendimento(responseRecurso.getPrazoAtendimento());
        recurso.setDescricaoJustificativa(responseRecurso.getJustificativa());
        recurso.setQuantidadeAnexos(responseRecurso.getQtdAnexos());
    }
}
