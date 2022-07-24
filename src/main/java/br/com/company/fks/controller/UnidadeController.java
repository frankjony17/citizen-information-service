package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.controller.builder.RespostaBuilder;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.ConsultaUnidadeDTO;
import br.com.company.fks.modelo.dto.FiltroUnidadeDTO;
import br.com.company.fks.modelo.dto.SubunidadeAcessosDTO;
import br.com.company.fks.modelo.dto.UsuarioAcessosDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.servico.unidade.OrgaoSiorgService;
import br.com.company.fks.servico.unidade.PadraoService;
import br.com.company.fks.servico.unidade.UnidadeSiorgService;
import br.com.company.fks.servico.usuario.UsuarioAcessosService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import br.gov.mpog.acessos.cliente.servico.AcessosClienteSistemaService;

import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoUnidadeSubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.ResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/unidade", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UnidadeController {

    public static final String ERROR_MESSAGE = "errorMessage";
    private static final Logger LOGGER = Logger.getLogger(UnidadeService.class);
    private static final String ERRO_EXPORTAR_CONSULTA_UNIDADE = "ERRO EXPORTAR CONSULTA UNIDADE";

    @Autowired
    private PadraoService padraoService;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private UnidadeService unidadeService;

    @Autowired
    private UsuarioAcessosService usuarioAcessosService;

    @Autowired
    private OrgaoSiorgService orgaoSiorgService;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private SubunidadeRepository subunidadeRepository;

    @Autowired
    private UnidadeSiorgService unidadeSiorgService;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private AcessosClienteSistemaService acessosClienteSistemaService;

    private static final String ERRO_EDITAR_UNIDADE = "ERRO AO EDITAR A UNIDADE";

    @RequestMapping(value="/orgao", method=RequestMethod.GET)
    public ResponseEntity<List<OrgaoSiorgDTO>> obterOrgao() {
        List<OrgaoSiorgDTO> orgaoSiorgDTOList = orgaoSiorgService.obterOrgaoDataBase();
        return new ResponseEntity<>(orgaoSiorgDTOList, HttpStatus.OK);
    }

    @RequestMapping(value="/unidade/{codigoOrgao}", method=RequestMethod.GET)
    public ResponseEntity<List<br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO>> obterUnidade(@PathVariable String codigoOrgao) {
        List<br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO> unidadeDTOList = unidadeSiorgService.obterUnidadeDataBase(codigoOrgao);
        return new ResponseEntity<>(unidadeDTOList, HttpStatus.OK);
    }

    @RequestMapping(value="/tudo", method=RequestMethod.GET)
    public ResponseEntity<List<OrgaoUnidadeSubunidadeDTO>> obterTudoUnidade() {
        ResponseEntity responseEntity;
        try {
            List<OrgaoUnidadeSubunidadeDTO> orgaoUnidadeSubunidadeDTOList = orgaoSiorgService.obterTudoDataBase();
            responseEntity = new ResponseEntity<>(orgaoUnidadeSubunidadeDTOList, HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.error(ERRO_EDITAR_UNIDADE, e);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * Obter Órgão de SIORG.
     * @return List<UnidadeSiorgDTO>
     */
    @RequestMapping(value="/siorg/orgao", method=RequestMethod.GET)
    public ResponseEntity<List<UnidadeSiorgDTO>> obterOrgaoSiorg() {
        List<UnidadeSiorgDTO> unidadeSiorgDTOList = orgaoSiorgService.listarOrgaoSiorg();
        return new ResponseEntity<>(unidadeSiorgDTOList, HttpStatus.OK);
    }

    /**
     * Obter Unidades no Siorg por código Órgão.
     * @param codigoOrgao Código Órgão.
     * @return List<UnidadeSiorgDTO>
     */
    @RequestMapping(value="/siorg/unidade/{codigoOrgao}", method=RequestMethod.GET)
    public ResponseEntity<List<UnidadeSiorgDTO>> obterUnidadeSiorg(@PathVariable String codigoOrgao) {
        List<UnidadeSiorgDTO> unidadeSiorgDTOList = orgaoSiorgService.listarUnidadeSiorgPorOrgaoCodigoUg(codigoOrgao);
        return new ResponseEntity<>(unidadeSiorgDTOList, HttpStatus.OK);
    }

    /**
     * Obter Subunidades no Siorg por código Unidade.
     * @param codigoUnidade Código Unidade.
     * @return List<UnidadeSiorgDTO>
     */
    @RequestMapping(value="/siorg/subunidade/{codigoUnidade}", method=RequestMethod.GET)
    public ResponseEntity<Object> obterSubunidadeSiorg(@PathVariable String codigoUnidade) {
        ResponseEntity<Object> responseEntity;
        Unidade unidade = unidadeSiorgService.existeCadastroNoBancoDados(codigoUnidade);
        if (unidade == null) {
            responseEntity = new ResponseEntity<>(orgaoSiorgService.listarSubunidadeSiorgPorUnidadeCodigoUg(codigoUnidade), HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>(padraoService.obterCadastroNoBancoDados(unidade), HttpStatus.OK);
        }
        return responseEntity;
    }

    @RequestMapping(value="/subunidade/{codigoUnidade}", method=RequestMethod.GET)
    public ResponseEntity<List<UnidadeSiorgDTO>> obterSubunidade(@PathVariable String codigoUnidade) {
        return new ResponseEntity<>(orgaoSiorgService.listarSubunidadeSiorgPorUnidadeCodigoUg(codigoUnidade), HttpStatus.OK);
    }

    @RequestMapping(value="/e/subunidade/{codigoUnidade}", method = RequestMethod.GET)
    public ResponseEntity<Object> subunidadeEUnidade(@PathVariable String codigoUnidade) {
        ResponseEntity<Object> responseEntity = new ResponseEntity<>("NAO", HttpStatus.OK);
        Long count = subunidadeRepository.countSubunidadeByCodigoSubunidade(codigoUnidade);
        /**
        * Se não existe Subunidade como Unidade.
         */
        if (count.intValue() > 0) {
            responseEntity = new ResponseEntity<>("UNIDADE-COMO-SUBUNIDADE", HttpStatus.OK);
        }
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    /**
     * Obter usuários pelo perfil específico, aqueles que existem no banco de dados não são incluídos na lista.
     * @param nomePerfil Identificador do nome do perfil. PerfilAcessoEnum
     * @return List<UsuarioSiapeAcessoDTO>
     */
    @RequestMapping(value="/acesso/usuarioPorPerfil", method = RequestMethod.POST)
    public ResponseEntity<List<UsuarioSiapeAcessoDTO>> obterUsuarioPorPerfilAcesso(@RequestBody String nomePerfil) {
        List<UsuarioSiapeAcessoDTO> usuarioSiapeAcessoDTOList = usuarioAcessosService.obterUsuariosPorPerfilService(nomePerfil);
        return new ResponseEntity<>(usuarioSiapeAcessoDTOList, HttpStatus.OK);
    }

    @RequestMapping(value = "/siap/buscaCargoFuncaoSiapPorUsuario/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> buscaCargoFuncaoSiapPorUsuario(@PathVariable String cpf) {
        return new ResponseEntity<>(unidadeService.buscaCargoFuncaoSiapPorCpf(cpf), HttpStatus.OK);
    }

    /**
     * Obter usuários pelo perfil específico, aqueles que existem no banco de dados e aqueles que correspondem ao
     * ID recebido pelo parâmetro não são incluídos na lista.
     * @param nomePerfil Identificador do nome do perfil. PerfilAcessoEnum
     * @param id Id do usuário a ser excluído da lista.
     * @return List<UsuarioSiapeAcessoDTO>
     */
    @RequestMapping(value="/acesso/usuarioSubstitutoPorPerfil/{nomePerfil}/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioSiapeAcessoDTO>> obterUsuarioSubstitutoPorPerfilAcesso(@PathVariable String nomePerfil, @PathVariable Long id) {
        List<UsuarioSiapeAcessoDTO> usuarioSiapeAcessoDTOList = usuarioAcessosService.obterUsuariosPorPerfilService(nomePerfil);
        return new ResponseEntity<>(usuarioSiapeAcessoDTOList, HttpStatus.OK);
    }

    @RequestMapping(value="/responsavel", method=RequestMethod.GET)
    public ResponseEntity<ResponsaveisDTO> obterResponsavelRecurso() {
        ResponsaveisDTO responsaveisDTO = new ResponsaveisDTO();
        Responsaveis responsaveis = responsaveisRepository.findTopByOrderByIdDesc();
        if (responsaveis != null) {
            responsaveisDTO = entityConverter.converter(responsaveis, ResponsaveisDTO.class);
        }
        return new ResponseEntity<>(responsaveisDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/salvar/tudo", method = RequestMethod.POST)
    public ResponseEntity salvar(@RequestBody UnidadePadraoDTO unidadePadraoDTO) {
        ResponseEntity responseEntity;
        try {
            padraoService.salvar(unidadePadraoDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.error("ERRO AO SALVAR A UNIDADE", e);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value="/estado/{id}/{estado}", method = RequestMethod.PUT)
    public ResponseEntity<Object> alterarEstadoUnidade(@PathVariable(value="id") Long id, @PathVariable(value="estado") Boolean estado) {
        unidadeSiorgService.alterarEstadoUnidade(id, estado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/obterCadastro/{codigoUnidade}", method=RequestMethod.GET)
    public ResponseEntity<UnidadePadraoDTO> obterCadastro(@PathVariable String codigoUnidade) {
        Unidade unidade = unidadeRepository.findByCodigoUnidade(codigoUnidade);
        UnidadePadraoDTO unidadePadraoDTO = padraoService.obterCadastroNoBancoDados(unidade);
        return new ResponseEntity<>(unidadePadraoDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/editar/tudo", method = RequestMethod.PUT)
    public ResponseEntity editar(@RequestBody UnidadePadraoDTO unidadePadraoDTO) {
        ResponseEntity responseEntity;
        try {
            padraoService.editar(unidadePadraoDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.error(ERRO_EDITAR_UNIDADE, e);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value="/usuario/editar/perfil", method = RequestMethod.PUT)
    public ResponseEntity editarPerfilUsuario(@RequestBody UsuarioParametrosDTO parametrosDTO) {
        ResponseEntity responseEntity;
        try {
            usuarioAcessosService.editarUsuarioPerfilService(parametrosDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            LOGGER.error(ERRO_EDITAR_UNIDADE, e);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, e.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Unidade> buscarUnidade(@PathVariable Long id) {
        Unidade unidade = unidadeService.buscarUnidade(id);
        return new ResponseEntity<>(unidade, HttpStatus.OK);
    }


    @RequestMapping(value = "/detalharUnidade/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subunidade> detalharUnidade(@PathVariable Long id) {
        Subunidade subunidade = unidadeService.detalharUnidade(id);
        return new ResponseEntity<>(subunidade, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarListaSiorg", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> buscarListaSiorg() {
        List<Object> listaUnidadeDTO = acessosClienteSistemaService.buscarUnidades(null, null, null, null, null, null, "56689", null, null);
        return new ResponseEntity<>(listaUnidadeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarListaUnidade", method = RequestMethod.GET)
    public ResponseEntity<List<br.com.company.fks.modelo.dto.UnidadeDTO>> buscarUnidadeList() {
        List<br.com.company.fks.modelo.dto.UnidadeDTO> listaUnidadeDTO = unidadeService.buscarListaUnidade();
        return new ResponseEntity<>(listaUnidadeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/atribuirUnidadeUsuario", method = RequestMethod.POST)
    public ResponseEntity<UsuarioAcessosDTO> atribuirUnidadeUsuario(@RequestBody UsuarioAcessosDTO usuarioAcessosDTO) {
        ResponseEntity responseEntity;
        try {
            unidadeService.atribuirUnidadeUsuario(usuarioAcessosDTO);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error("ERRO AO ATRIBUIR UNIDADE/SUBUNIDADE AO USUÁRIO", ie);

            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, ie.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/exportar", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportarConsultaUnidade(@RequestParam(value = "fitro") String fitro) {
        ResponseEntity responseEntity;
        try {
            FiltroUnidadeDTO fitroDto = ControllerUtil.montarFiltroDTO(fitro, FiltroUnidadeDTO.class);
            byte[] bytes = unidadeService.exportarConsultaUnidade(fitroDto);
            String arquivoBase64 = new Base64().encodeAsString(bytes);
            responseEntity = new ResponseEntity<>(ControllerUtil.criarObjetoJson("arquivoBase64", arquivoBase64), HttpStatus.OK);
        } catch (IntegracaoException ie) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_UNIDADE, ie);
            Resposta<List<ConsultaUnidadeDTO>> resposta = RespostaBuilder.getBuilder().setErro(ie.getMessage()).build();
            responseEntity = new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ObjectMapperException ome) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_UNIDADE, ome);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException ioe) {
            LOGGER.error(ERRO_EXPORTAR_CONSULTA_UNIDADE, ioe);
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/ativarDesativarSubunidade/{idSubunidade}/{statusSubunidade}", method = RequestMethod.PUT)
    public ResponseEntity<Object> ativaDesativaStatusSubunidade(@PathVariable(value = "idSubunidade") Long idSubunidade,
                                                           @PathVariable(value = "statusSubunidade") boolean statusSubunidade) {
        unidadeService.alterarStatusSubUnidade(idSubunidade, statusSubunidade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarTodasSubunidades/{idUnidade}", method = RequestMethod.GET)
    public ResponseEntity<List<Subunidade>> buscarTodasSubunidades(@PathVariable(value = "idUnidade") Long idUnidade) {
        return new ResponseEntity<>(unidadeService.buscarListaSubunidade(idUnidade), HttpStatus.OK);
    }

    @RequestMapping(value = "/montarSubunidades/{idUnidade}", method = RequestMethod.GET)
    public ResponseEntity<List<SubunidadeAcessosDTO>> montarSubunidadesSiorg(@PathVariable(value = "idUnidade") Long idUnidade) {
        return new ResponseEntity<>(unidadeService.montarListaSubunidade(idUnidade), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarListaSubunidadePorUsuarioLogado", method = RequestMethod.GET)
    public ResponseEntity<List<Subunidade>> buscarTodasSubunidades() {
        return new ResponseEntity<>(unidadeService.buscarListaSubunidadePorUsuarioLogado(), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUnidadeVinculadaASubunidade/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<br.com.company.fks.modelo.dto.UnidadeDTO> buscarUnidadeVinculadaASubunidade(@PathVariable(value = "idPedido") Long idPedido) {
        return new ResponseEntity<>(unidadeService.buscarUnidadeVinculadaASubunidade(idPedido), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUnidadeSic", method = RequestMethod.GET)
    public ResponseEntity<br.com.company.fks.modelo.dto.UnidadeDTO> buscarUnidadeVinculadaASubunidade() {
        return new ResponseEntity<>(unidadeService.buscarUnidadeSic(), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarSubunidadeRespondente", method = RequestMethod.GET)
    public ResponseEntity<Subunidade> buscarSubunidadeRespondente() {
        return new ResponseEntity<>(unidadeService.buscarSubunidadeRespondente(), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarUnidadePorNome", method = RequestMethod.GET)
    public ResponseEntity<Unidade>buscaUnidadePorNome(@RequestParam("nome")String nome){
        return new ResponseEntity<>(unidadeService.buscaUnidadePeloNome(nome), HttpStatus.OK);
    }

    @RequestMapping(value = "/loadOrgaoUnidadeSiorg", method = RequestMethod.GET)
    public void load() {
        orgaoSiorgService.doGetSiorgDoAcessos();
    }
}
