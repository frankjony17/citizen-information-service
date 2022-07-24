package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.custom.ArmazenamentoArquivoCustomRepositorio;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.AlteracaoPedidoRecursoDTO;
import br.com.company.fks.modelo.dto.AndamentoPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaHistoricoPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaPedidoDTO;
import br.com.company.fks.modelo.dto.ConsultaPedidoDulplicadoDTO;
import br.com.company.fks.modelo.dto.FiltroPedidoDTO;
import br.com.company.fks.modelo.dto.PedidoDetalhadoDTO;
import br.com.company.fks.modelo.dto.PedidoTemaDTO;
import br.com.company.fks.modelo.dto.RespostaPedidoDTO;
import br.com.company.fks.modelo.dto.StatusSolicitacaoDTO;
import br.com.company.fks.modelo.dto.TemaSubtemaPalavraChaveDTO;
import br.com.company.fks.servico.AndamentoService;
import br.com.company.fks.servico.HistoricoTratamentoService;
import br.com.company.fks.servico.PedidoService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.wsdl.AnexoUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping(value = "/pedido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PedidoController {

    private static final String ERRO_EXPORTAR_CONSULTA_PEDIDO = "ERRO EXPORTAR CONSULTA PEDIDO";

    private static final Logger LOGGER = Logger.getLogger(PedidoService.class);

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ArmazenamentoArquivoCustomRepositorio armazenamentoArquivoCustomRepositorio;

    @Autowired
    private AndamentoService andamentoService;

    @Autowired
    private HistoricoTratamentoService historicoTratamentoService;

    @Autowired
    private AnexoUtils anexoUtils;

    @Autowired
    private RecursoRepository recursoRepository;

    public static final String ERRO_CONSULTA_PEDIDO = "ERRO CONSULTA PEDIDO";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Resposta<List<ConsultaPedidoDTO>>> consultarPedido(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            FiltroPedidoDTO filtroPedidoDTO = ControllerUtil.montarFiltroDTO(filtro, FiltroPedidoDTO.class);
            responseEntity = new ResponseEntity<>(pedidoService.consultarPedido(filtroPedidoDTO), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error(ERRO_CONSULTA_PEDIDO, ie);
            Resposta<List<ConsultaPedidoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (ObjectMapperException ome) {
            LOGGER.error(ERRO_CONSULTA_PEDIDO, ome);
            Resposta<List<ConsultaPedidoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ome.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/exportar", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportarConsultaPedido(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            FiltroPedidoDTO filtroPedidoDTO = ControllerUtil.montarFiltroDTO(filtro, FiltroPedidoDTO.class);
            byte[] bytes = pedidoService.exportarConsultaPedido(filtroPedidoDTO);
            String arquivoBase64 = new Base64().encodeAsString(bytes);
            responseEntity = new ResponseEntity<>(ControllerUtil.criarObjetoJson("arquivoBase64", arquivoBase64), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_PEDIDO, ie);
            Resposta<List<ConsultaPedidoDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ObjectMapperException ome) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_PEDIDO, ome);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException ioe) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_PEDIDO, ioe);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PedidoDetalhadoDTO> detalharPedido(@PathVariable Long id) {
        armazenamentoArquivoCustomRepositorio.init();
        PedidoDetalhadoDTO pedidoDetalhadoDTO = pedidoService.detalharPedido(id);
        return new ResponseEntity<>(pedidoDetalhadoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/enviarPedidoRevisao/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> enviarPedidoRevisao(@PathVariable Long id) {
        try {
            pedidoService.enviarPedidoRevisao(id);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO ENVIAR PEDIDO PARA REVISÃO", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/andamentoPedido", method = RequestMethod.GET)
    public ResponseEntity<Object> consultarAndamentoPedido(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "offset", required = true) Integer offset, @RequestParam(value = "limit", required = true) Integer limit) {
        Page<AndamentoPedidoDTO> listaAndamentoPedidoDTO = andamentoService.consultarAndamentoPedido(id, offset, limit);
        return new ResponseEntity<>(listaAndamentoPedidoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/historicoPedido", method = RequestMethod.GET)
    public ResponseEntity<Object> consultarHistoricoPedido(@RequestParam(value = "id", required = true) Long id,@RequestParam(value = "offset", required = true) Integer offset, @RequestParam(value = "limit", required = true) Integer limit) {
        Page<ConsultaHistoricoPedidoDTO> listaConsultaHistoricoPedidoDTO = historicoTratamentoService.consultarHistoricoPedido(id, offset, limit);
        return new ResponseEntity<>(listaConsultaHistoricoPedidoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/downloadAnexo", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadAnexo(@RequestParam(value = "protocolo") String protocolo,
                                                @RequestParam(value = "nome") String nome) {
        ResponseEntity responseEntity;
        try {
            File file = anexoUtils.getFile(protocolo, nome);
            byte[] bytes = Files.readAllBytes(file.toPath());
            String arquivoBase64 = new Base64().encodeAsString(bytes);
            responseEntity = new ResponseEntity<>(ControllerUtil.criarObjetoJson("arquivoBase64", arquivoBase64), HttpStatus.OK);
        } catch (IOException e) {
            LOGGER.error("ERRO NO DOWNLOAD DO ANEXO DE PEDIDO", e);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @RequestMapping(value = "/respostaPedido", method = RequestMethod.POST)
    public ResponseEntity<Object> salvarResposta(@RequestBody RespostaPedidoDTO respostaPedidoDTO) {
        try {
            pedidoService.salvarResposta(respostaPedidoDTO);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO SALVAR", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/cancelarResposta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> cancelarResposta(@PathVariable Long id) {
        try {
            pedidoService.cancelarResposta(id);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO CANCELAR", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarRespostaPedido/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscarRespostaPedido(@PathVariable Long id) {
        return null;
    }

    @RequestMapping(value = "/entregarResposta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> entregarResposta(@PathVariable Long id) {
        try {
            pedidoService.entregarResposta(id);
        } catch (IntegracaoException e) {
            LOGGER.error("ERRO AO ENTREGAR RESPOSTA", e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/associarPedidoTema", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> associarPedidoTema(@RequestBody PedidoTemaDTO pedidoTemaDTO) {
        pedidoService.associarPedidoTema(pedidoTemaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "consultarStatusRespostaAssinada/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> consultarStatusRespostaAssinada(@PathVariable Long idPedido) {
        Boolean statusRespostaAssinada = pedidoService.consultarStatusRespostaAssinada(idPedido);
        return new ResponseEntity<>(statusRespostaAssinada, HttpStatus.OK);
    }

    @RequestMapping(value = "verificaTema/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> verificaTema(@PathVariable Long idPedido) {
        Boolean statusTema = pedidoService.verificaTema(idPedido);
        return new ResponseEntity<>(statusTema, HttpStatus.OK);
    }

    @RequestMapping(value = "consultarStatusSolicitacao/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<StatusSolicitacaoDTO> buscarStratusSolicitacao(@PathVariable Long idPedido) {
        StatusSolicitacaoDTO statusSolicitacaoDTO = pedidoService.buscarStatusSolicitacao(idPedido);
        return new ResponseEntity<>(statusSolicitacaoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/telaAdministrativa", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarPeloProtocolo(@RequestParam(value = "protocolo") String protocolo) {
        List<Recurso> recursoList = recursoRepository.buscarProtocoloPedido(protocolo);
        if (!recursoList.isEmpty()) {
            return new ResponseEntity<>(pedidoService.buscarPeloProtocoloRecurso(protocolo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(pedidoService.buscarPeloProtocoloPedido(protocolo), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/buscarStatusPedido", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarStatusSolicitacaoPedido(@RequestParam(value = "status") String status) {
        return new ResponseEntity<>(pedidoService.definirStatusPedido(status), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarStatusRecurso", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarStatusSolicitacaoRecurso(@RequestParam(value = "status") String status,
                                                            @RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(pedidoService.definirStatusRecurso(status, id), HttpStatus.OK);
    }

    @RequestMapping(value = "/consultarPedidoSolicitante", method = RequestMethod.GET)
    public ResponseEntity<Object> consultarPedidoSolicitante(@RequestParam(value = "idSolicitante", required = true) Long idSolicitante,
                                                        @RequestParam(value = "offset", required = true) Integer offset,
                                                        @RequestParam(value = "limit", required = true) Integer limit) {
        Page<ConsultaPedidoDulplicadoDTO> listaConsultaPedidoDetalhadoDTO = pedidoService.consultarPedidoSolicitante(idSolicitante, offset, limit);
        return new ResponseEntity<>(listaConsultaPedidoDetalhadoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/alterarPedidoRecurso", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AlteracaoPedidoRecursoDTO> alterarPedidoRecurso(@RequestBody AlteracaoPedidoRecursoDTO alteracaoPedidoRecursoDTO) {
        pedidoService.alterarPedidoRecurso(alteracaoPedidoRecursoDTO);
        return new ResponseEntity<>(alteracaoPedidoRecursoDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodosTemasSubtemasPalavraChavePedido/{id}", method = {RequestMethod.GET})
    public ResponseEntity<TemaSubtemaPalavraChaveDTO> buscarTodosTemasSubtemasPalavraChavePedido(@PathVariable Long id){
        return new ResponseEntity<>(pedidoService.buscarTodosTemasSubtemasPalavraChavePedido(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUltimaUnidade/{id}", method = {RequestMethod.GET})
    public ResponseEntity<Object> buscarUltimaUnidade(@PathVariable Long id){
        return new ResponseEntity<>(pedidoService.buscarUltimaUnidade(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/alterarPedidoEouv", method = RequestMethod.POST)
    public ResponseEntity<List<ConsultaPedidoDTO>> alterarVencimentoEouv(@RequestBody List<ConsultaPedidoDTO> consultaPedidoDTOS) {
        pedidoService.salvarPedidoVencimentoEouv(consultaPedidoDTOS);
        return new ResponseEntity<>(consultaPedidoDTOS, HttpStatus.OK);
    }
}
