package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.custom.RecursoCustomRepositorio;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.Solicitante;
import br.com.company.fks.modelo.dto.ConsultaRecursoDTO;
import br.com.company.fks.modelo.dto.FiltroRecursoDTO;
import br.com.company.fks.modelo.dto.RecursoDetalhadoDTO;
import br.com.company.fks.modelo.dto.RecursoRelatorioDTO;
import br.com.company.fks.modelo.dto.SolicitanteDTO;
import br.com.company.fks.modelo.dto.StatusSolicitacaoRecursoDTO;
import br.com.company.fks.utils.Constants;
import br.com.company.fks.utils.DataUtil;
import br.com.company.fks.utils.ExceptionsUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class RecursoService {

    @Autowired
    private RecursoCustomRepositorio recursoCustomRepositorio;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    public Resposta<List<ConsultaRecursoDTO>> consultarRecurso(FiltroRecursoDTO filtroRecursoDTO) throws IntegracaoException {
        List<ConsultaRecursoDTO> listaConsultaRecursoDTO = recursoCustomRepositorio.efetuarConsultaPaginadaFiltroRecurso(filtroRecursoDTO,false);
        Long totalElementos = recursoCustomRepositorio.efetuarConsultaContadorTotalRecurso(filtroRecursoDTO);
        Resposta<List<ConsultaRecursoDTO>> resposta = new Resposta<>();
        resposta.setResultado(listaConsultaRecursoDTO);
        resposta.setTotalElementos(totalElementos);
        return resposta;
    }

    public RecursoDetalhadoDTO detalharRecurso(Long idPedido, String instanciaRecurso) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        List<Recurso> listaRecurso = recursoRepository.buscarIdRecurso(pedido);
        Recurso recurso = null;
        if (instanciaRecurso.equals("primeiraInstancia")) {
            for (Recurso recursos : listaRecurso) {
                if (recursos.getInstanciaRecurso().getId() == 1) {
                    recurso = recursoCustomRepositorio.detalharRecurso(recursos.getId());
                }
            }
        } else if (instanciaRecurso.equals("segundaInstancia")) {
            for (Recurso recursos : listaRecurso) {
                if (recursos.getInstanciaRecurso().getId() == 2) {
                    recurso = recursoCustomRepositorio.detalharRecurso(recursos.getId());
                }
            }
        }

        if (recurso != null) {
            RecursoDetalhadoDTO recursoDetalhadoDTO = new RecursoDetalhadoDTO();
            recursoDetalhadoDTO.setIdRecurso(recurso.getId());
            recursoDetalhadoDTO.setProtocolo(recurso.getProtocoloPedido());
            recursoDetalhadoDTO.setNomeStatusSolicitacao(recurso.getStatusSolicitacao().getNome());
            recursoDetalhadoDTO.setDataAbertura(recurso.getDataAbertura());
            recursoDetalhadoDTO.setVencimentoUnidade(recurso.getVencimentoUnidade());
            recursoDetalhadoDTO.setSolicitanteDTO(montarSolicitanteDTO(recurso.getPedido().getSolicitante()));
            recursoDetalhadoDTO.setNomeTipoRecurso(recurso.getTipoRecurso().getNome());
            recursoDetalhadoDTO.setNomeSituacaoRecurso(recurso.getSituacaoRecurso().getNome());
            recursoDetalhadoDTO.setDataPrazoAtendimento(recurso.getDataPrazoAtendimento());
            recursoDetalhadoDTO.setJustificativa(recurso.getDescricaoJustificativa());
            recursoDetalhadoDTO.setPropostaResposta(recurso.getPropostaResposta());
            recursoDetalhadoDTO.setRespostaESic(historicoTratamentoRecursoService.recuperarRespostaRecurso(recurso.getId()));
            recursoDetalhadoDTO.setStatusRespostaAssinada(recurso.getStatusRespostaAssinada());
            recursoDetalhadoDTO.setObservacao(andamentoRecursoService.buscarObservacaoAndamentoRecurso(recurso.getId()));
            return recursoDetalhadoDTO;
        } else {
            return null;
        }

    }

    public SolicitanteDTO montarSolicitanteDTO(Solicitante solicitante) {
        SolicitanteDTO solicitanteDTO = new SolicitanteDTO();
        solicitanteDTO.setTipoPessoa(solicitante.getTipoPessoa());
        solicitanteDTO.setCpfOuCnpj(solicitante.getCpfOuCnpj());
        solicitanteDTO.setNome(solicitante.getNome());
        solicitanteDTO.setDocumentoIdentificacao(solicitante.getDocumentoIdentificacao());
        solicitanteDTO.setSexo(solicitante.getSexo());
        solicitanteDTO.setProfissao(solicitante.getProfissao());
        solicitanteDTO.setEmail(solicitante.getEmail());
        solicitanteDTO.setDdd(solicitante.getDdd());
        solicitanteDTO.setTelefone(solicitante.getTelefone());
        solicitanteDTO.setEndereco(solicitante.getEndereco());
        solicitanteDTO.setUf(solicitante.getUf());
        solicitanteDTO.setPais(solicitante.getPais());
        solicitanteDTO.setCidade(solicitante.getCidade());
        solicitanteDTO.setCep(solicitante.getCep());
        return solicitanteDTO;
    }

    public StatusSolicitacaoRecursoDTO buscarStatusSolicitacaoRecurso(Long idRecurso) {
        Recurso recurso = recursoCustomRepositorio.detalharRecurso(idRecurso);
        StatusSolicitacaoRecursoDTO statusSolicitacaoRecursoDTO = new StatusSolicitacaoRecursoDTO();
        statusSolicitacaoRecursoDTO.setId(recurso.getId());
        statusSolicitacaoRecursoDTO.setNome(recurso.getStatusSolicitacao().getNome());
        return statusSolicitacaoRecursoDTO;
    }

    public byte[] exportarConsultaRecurso(FiltroRecursoDTO filtroRecursoDTO) throws IntegracaoException, IOException {
        List<Recurso> listaRecurso = recursoCustomRepositorio.efetuarConsultaPaginadaRecurso(filtroRecursoDTO,true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Consulta de Recursos");
        criarLinhaCabecalho(xssfSheet);
        criarLinhasPlanilha(xssfSheet, montarRecursoRelatorioDTOList(listaRecurso));
        ExceptionsUtil.exceptionXssf(byteArrayOutputStream, xssfWorkbook);
        return byteArrayOutputStream.toByteArray();
    }

    public RecursoRelatorioDTO montarRecursoRelatorioDTO(Recurso recurso) {
        RecursoRelatorioDTO recursoRelatorioDTO = new RecursoRelatorioDTO();
        recursoRelatorioDTO.setProtocolo(recurso.getProtocoloPedido());
        recursoRelatorioDTO.setNomeStatusTramitacao(recurso.getStatusTramitacao().getNome());
        recursoRelatorioDTO.setNomeStatusSolicitacao(recurso.getStatusSolicitacao().getNome());
        recursoRelatorioDTO.setNomeTipoSituacaoRecurso(recurso.getSituacaoRecurso().getNome());
        recursoRelatorioDTO.setDataAbertura(recurso.getDataAbertura());
        recursoRelatorioDTO.setNomeSolicitante(recurso.getPedido().getSolicitante().getNome());
        recursoRelatorioDTO.setPrazoAtendimento(recurso.getDataPrazoAtendimento());
        recursoRelatorioDTO.setNomeInstanciaRecurso(recurso.getInstanciaRecurso().getNome());
        recursoRelatorioDTO.setVencimentoESic(recurso.getVencimentoUnidade());
        recursoRelatorioDTO.setNomeTipoRecurso(recurso.getTipoRecurso().getNome());
        recursoRelatorioDTO.setJustificativa(recurso.getDescricaoJustificativa());
        return recursoRelatorioDTO;
    }

    public List<RecursoRelatorioDTO> montarRecursoRelatorioDTOList(List <Recurso> recursos) {
        List<RecursoRelatorioDTO> retorno = new ArrayList<>();
        for (Recurso recurso:recursos) {
            retorno.add(montarRecursoRelatorioDTO(recurso));
        }
        return retorno;
    }


    private void criarLinhaCabecalho(XSSFSheet xssfSheet) {
        XSSFRow xssfRow = xssfSheet.createRow(Constants.ZERO);
        xssfRow.createCell(Constants.ZERO).setCellValue("Protocolo");
        xssfRow.createCell(Constants.UM).setCellValue("Status da Tramitação");
        xssfRow.createCell(Constants.DOIS).setCellValue("Status da Solicitação");
        xssfRow.createCell(Constants.TRES).setCellValue("Situação do Recurso");
        xssfRow.createCell(Constants.QUATRO).setCellValue("Data de Abertura");
        xssfRow.createCell(Constants.CINCO).setCellValue("Nome Solicitante");
        xssfRow.createCell(Constants.SEIS).setCellValue("Prazo Atendimento");
        xssfRow.createCell(Constants.SETE).setCellValue("Instância do Recurso");
        xssfRow.createCell(Constants.OITO).setCellValue("Vencimento e-SIC");
        xssfRow.createCell(Constants.NOVE).setCellValue("Tipo do Recurso");
        xssfRow.createCell(Constants.DEZ).setCellValue("Justificativa");
    }

    private void criarLinhasPlanilha(XSSFSheet xssfSheet, List<RecursoRelatorioDTO> listaRecursoRelatorioDTO) {
        int row = Constants.UM;
        for (RecursoRelatorioDTO recursoRelatorioDTO : listaRecursoRelatorioDTO) {
            XSSFRow xssfRow = xssfSheet.createRow(row);
            preencherLinhaPlanilha(xssfRow, recursoRelatorioDTO);
            row = row + 1;
        }
    }

    private void preencherLinhaPlanilha(XSSFRow xssfRow, RecursoRelatorioDTO recursoRelatorioDTO) {
        xssfRow.createCell(Constants.ZERO).setCellValue(recursoRelatorioDTO.getProtocolo());
        xssfRow.createCell(Constants.UM).setCellValue(recursoRelatorioDTO.getNomeStatusTramitacao());
        xssfRow.createCell(Constants.DOIS).setCellValue(recursoRelatorioDTO.getNomeStatusSolicitacao());
        xssfRow.createCell(Constants.TRES).setCellValue(recursoRelatorioDTO.getNomeTipoSituacaoRecurso());
        xssfRow.createCell(Constants.QUATRO).setCellValue(DataUtil.getDataFormatada(recursoRelatorioDTO.getDataAbertura()));
        xssfRow.createCell(Constants.CINCO).setCellValue(recursoRelatorioDTO.getNomeSolicitante());
        xssfRow.createCell(Constants.SEIS).setCellValue(DataUtil.getDataFormatada(recursoRelatorioDTO.getPrazoAtendimento()));
        xssfRow.createCell(Constants.SETE).setCellValue(recursoRelatorioDTO.getNomeInstanciaRecurso());
        xssfRow.createCell(Constants.OITO).setCellValue(DataUtil.getDataFormatada(recursoRelatorioDTO.getVencimentoESic()));
        xssfRow.createCell(Constants.NOVE).setCellValue(recursoRelatorioDTO.getNomeTipoRecurso());
        xssfRow.createCell(Constants.DEZ).setCellValue(recursoRelatorioDTO.getJustificativa());
    }

    public List<Long> buscarIdRecurso(Long idPedido) {
        Pedido pedido = pedidoRepository.findOne(idPedido);
        List<Recurso> listaRecurso = recursoRepository.buscarIdRecurso(pedido);
        List<Long> listaIdRecurso = new ArrayList<>();
        if (!listaRecurso.isEmpty()) {
            for (Recurso recurso : listaRecurso) {
                listaIdRecurso.add(recurso.getId());
            }
            return listaIdRecurso;
        }
        return null;
    }

    public Long buscarIdPedido(Long idRecurso) {
        Recurso recurso = recursoRepository.buscarIdPedido(idRecurso);
        return recurso.getPedido().getId();
    }

    public Boolean consultarStatusRespostaAssinada(Long idRecurso) {
        Recurso recurso = recursoRepository.findOne(idRecurso);
        return recurso.getStatusRespostaAssinada();
    }
}
