package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Subtema;
import br.com.company.fks.modelo.Tema;
import br.com.company.fks.modelo.dto.ConsultaGlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.GlossarioDeAssuntoDTO;
import br.com.company.fks.modelo.dto.GlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.SubtemaDTO;
import br.com.company.fks.modelo.dto.TemaDTO;
import br.com.company.fks.modelo.dto.AsuntoSubtemaPalavraChaveDTO;
import br.com.company.fks.servico.TemaService;
import br.com.company.fks.utils.ControllerUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/tema", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TemaController {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Subtema.class);

    private static final String ERRO_EXPORTAR_ASSUNTO_SUBASUNTO_PALAVRACHAVE = "ERRO_EXPORTAR_ASSUNTO_SUBASUNTO_PALAVRACHAVE";

    @Autowired
    private TemaService temaService;

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<List<GlossarioDeAssuntoDTO>> salvar(@RequestBody List<GlossarioDeAssuntoDTO> glossarioAssuntoDTOList) {
        ResponseEntity responseEntity;
        try {
            temaService.salvar(glossarioAssuntoDTOList);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("ERRO AO SALVAR A TEMA", e);
            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public ResponseEntity<GlossarioDeTemaDTO> editar(@RequestBody GlossarioDeTemaDTO glossarioDeTemaDTO) {
        ResponseEntity responseEntity;
        try {
            temaService.editar(glossarioDeTemaDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            LOGGER.error("ERRO AO SALVAR A TEMA", e);
            String errorMessage = ControllerUtil.criarObjetoJson("errorMessage", e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/buscarTodosGlossarioTemas", method = RequestMethod.GET)
    public ResponseEntity buscar(@PathVariable Long id) {
        return new ResponseEntity<>(temaService.buscar(id), HttpStatus.OK);
    }

    @RequestMapping(value = "buscarPorSubtema/{id}", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<SubtemaDTO>>> buscarPorSubtemas(@PathVariable("id") Long idTema) {
        List<Subtema> listaSubTema = temaService.buscarPorSubTema(idTema);
        return new ResponseEntity<>(RespostaBuilder.getBuilder().setResultado(listaSubTema).build(), HttpStatus.OK);
    }

    @RequestMapping(value = "buscarTodosTemas", method = {RequestMethod.GET})
    public ResponseEntity<Resposta<List<TemaDTO>>> buscarTodosTemas() {
        List<Tema> listaSubTema = temaService.buscarTodostemas();
        Resposta<List<TemaDTO>> resposta = RespostaBuilder.getBuilder().setResultado(listaSubTema).build();
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @RequestMapping(value = "/detalharTema/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subtema> detalharTema(@PathVariable Long id) {
        Subtema subtema = temaService.detalharTema(id);
        return new ResponseEntity<>(subtema, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodasPalavrasChaves", method = RequestMethod.GET)
    public ResponseEntity<List<PalavraChave>> buscarTodasPalavrasChaves() {
        return new ResponseEntity<>(temaService.buscarTodasPalavrasChaves(), HttpStatus.OK);
    }

    @RequestMapping(value = "filtrarGlossarioDeTemas", method=RequestMethod.GET)
    public ResponseEntity<Resposta<List<AsuntoSubtemaPalavraChaveDTO>>> findGlossarioDeTemas(@RequestParam(value = "consultar") String consultar) {
        ResponseEntity responseEntity = null;
        try {
            ConsultaGlossarioDeTemaDTO consulta = ControllerUtil.montarFiltroDTO(consultar, ConsultaGlossarioDeTemaDTO.class);
            responseEntity = new ResponseEntity<>(temaService.filtrarGlossarioDeTemas(consulta), HttpStatus.OK);
        } catch (ObjectMapperException ie) {
            LOGGER.error("Erro findGlossarioDeTemas: {}", ie);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/exportar", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportarConsultaGlossarioDeAsuntoSubtemaPalavraChave(@RequestParam(value = "filtro") String filtro) {
        ResponseEntity responseEntity;
        try {
            ConsultaGlossarioDeTemaDTO consultaGlossarioDeTemaDTO = ControllerUtil.montarFiltroDTO(filtro, ConsultaGlossarioDeTemaDTO.class);
            byte[] bytes = temaService.exportarGlossarioDeAsuntoSubtemaPalavraChave(consultaGlossarioDeTemaDTO);
            String arquivoBase64 = new Base64().encodeAsString(bytes);
            responseEntity = new ResponseEntity<>(ControllerUtil.criarObjetoJson("arquivoBase64", arquivoBase64), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error(ERRO_EXPORTAR_ASSUNTO_SUBASUNTO_PALAVRACHAVE, ie);
            Resposta<List<AsuntoSubtemaPalavraChaveDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ObjectMapperException ome) {
            LOGGER.error(ERRO_EXPORTAR_ASSUNTO_SUBASUNTO_PALAVRACHAVE, ome);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException io) {
            LOGGER.error(ERRO_EXPORTAR_ASSUNTO_SUBASUNTO_PALAVRACHAVE, io);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
