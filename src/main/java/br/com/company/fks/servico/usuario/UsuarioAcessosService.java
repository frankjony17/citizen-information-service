package br.com.company.fks.servico.usuario;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.TempUsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroUsuarioDTO;
import br.com.company.fks.modelo.dto.UsuarioPerfilAcessoDTO;
import br.com.company.fks.modelo.dto.UsuariosAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.AutoridadeResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.ResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAcessosService {

    private static final String AM = "FKS.AUTORIDADE.MAXIMA";
    private static final String AH = "FKS.AUTORIDADE.HIERARQUICA";
    private static final String TITULAR = "TITULAR";
    private static final String SUBSTITUTO = "SUBSTITUTO";
    private static final String CODIGO_MODULO = "FKS";

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private UsuarioAcessosObter usuarioAcessosObter;

    @Autowired
    private UsuarioAcessosBuscar usuarioAcessosBuscar;

    @Autowired
    private UsuarioAcessosEditar usuarioAcessosEditar;

    @Autowired
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Autowired
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private TempUsuarioAcessosRepository tempUsuarioAcessosRepository;

    @Autowired
    private UsuarioAcessosListar usuarioAcessosListar;

    @Autowired
    private UsuarioRelatorioService usuarioRelatorioService;

    public static final String ERROR_MESSAGE = "errorMessage";

    private static final Logger LOGGER = Logger.getLogger(UnidadeService.class);

    public Resposta<List<UsuariosAcessoDTO>> consultarUsuarioService(FiltroUsuarioDTO parms){
        Resposta<List<UsuariosAcessoDTO>> resposta = new Resposta<>();
        resposta.setResultado(usuarioRelatorioService.montarUsuariosAcessoDTO(parms));
        resposta.setTotalElementos(tempUsuarioAcessosRepository.count());
        return resposta;
    }

    public AutoridadeResponsaveisDTO getAutoridadesNResponsaveisService(Long id){
        Responsaveis responsaveis = responsaveisRepository.findByUnidadeId(id);
        ResponsaveisDTO responsaveisDTO = new ResponsaveisDTO();
        responsaveisDTO.setResponsavelRecursoTerceiraInstancia(responsaveis.getResponsavelRecursoTerceiraInstancia());
        responsaveisDTO.setResponsavelRecursoQuartaInstancia(responsaveis.getResponsavelRecursoQuartaInstancia());
        UnidadePadraoDTO unidadePadraoDTO = new UnidadePadraoDTO();
        usuarioAcessosObter.obterUsuariosNoBancoDados(unidadePadraoDTO, id);
        UsuarioSiapeAcessoDTO titularH = unidadePadraoDTO.getUsuarioAutoridadeHierarquica();
        UsuarioSiapeAcessoDTO titularM = unidadePadraoDTO.getUsuarioAutoridadeMaxima();
        AutoridadeResponsaveisDTO autoridadeResponsaveisDTO = new AutoridadeResponsaveisDTO();
        autoridadeResponsaveisDTO.setResponsavelRecurso(responsaveisDTO);
        autoridadeResponsaveisDTO.setUsuarioAutoridadeHierarquica(titularH);
        autoridadeResponsaveisDTO.setUsuarioAutoridadeMaxima(titularM);
        return autoridadeResponsaveisDTO;
    }

    public UsuarioPerfilAcessoDTO detalharUsuarioService(String cpf, String nomePerfil) {
        return usuarioAcessosBuscar.detalharUsuario(cpf, nomePerfil);
    }

    public ResponseEntity salvarUsuarioService(UsuarioParametrosDTO parametros){
        ResponseEntity responseEntity;
        try {
            usuarioAcessosCriar.salvar(parametros);
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException ie) {
            LOGGER.error("ERRO AO SALVAR O USUARIO", ie);
            String errorMessage = ControllerUtil.criarObjetoJson(ERROR_MESSAGE, ie.getMessage());
            responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public List<PerfilAcessoEnum> listarTodosPerfils() {
        return Arrays.asList(PerfilAcessoEnum.values());
    }

    public ResponseEntity<String> atualizaPerfilUsuario(String cpf, String perfil) {
        String response = "OK";
        UsuarioAcessoPerfilAcesso usuarioPerfil = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(cpf, perfil);
        if (usuarioPerfil != null) {
            response = atualizaPerfil(usuarioPerfil, perfil, response);
        }
        else {
            addUsuario(cpf, perfil);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private String atualizaPerfil(UsuarioAcessoPerfilAcesso usuarioPerfil, String perfil, String response) {
        boolean bool = true;
        if (usuarioPerfil.getIsAtivo() && (perfil.equals(AM) || perfil.equals(AH)) && usuarioPerfil.getPapel().equals(TITULAR)) {
            int usr = usuarioAcessoPerfilAcessoRepository.countByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel(perfil, usuarioPerfil.getUsuarioAcessos().getUnidade(), SUBSTITUTO);
            if (usr == 0) {
                bool = false;
                response = "autoridade_sem_substituto";
            }
        }
        if (bool) {
            usuarioPerfil.setIsAtivo(!usuarioPerfil.getIsAtivo());
            usuarioAcessoPerfilAcessoRepository.save(usuarioPerfil);
        }
        return response;
    }

    private void addUsuario (String cpf, String perfil) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(cpf);
        if (usuarioAcessos == null) {
            List<Object> usuarioAcessoList = acessosClienteSistemaServiceImpl.buscarUsuarios(cpf, null, null, null, null, null, null, null, CODIGO_MODULO);
            UsuariosAcessoDTO usuario = entityConverter.converter(usuarioAcessoList.get(0), UsuariosAcessoDTO.class);
            usuarioAcessos = getUsuario(usuario);
        }
        UsuarioParametrosDTO parms = new UsuarioParametrosDTO();
        parms.setCpf(cpf);
        parms.setNomePerfil(perfil);
        parms.setUnidade(null);
        parms.setSubunidades(null);
        parms.setUsuario(usuarioAcessos);
        parms.setAssinaturaUsuario("");
        usuarioAcessosCriar.salvar(parms);
    }

    private UsuarioAcessos getUsuario (UsuariosAcessoDTO usuario) {
        UsuarioAcessos usuarioAcessos = new UsuarioAcessos();
        usuarioAcessos.setCpfUsuario(usuario.getCpf());
        usuarioAcessos.setNomeUsuario(usuario.getNome());
        usuarioAcessos.setEmailUsuario(usuario.getEmail());
        usuarioAcessos.setCodigoUsuario(usuario.getCpf());
        usuarioAcessos.setUnidade(null);
        return usuarioAcessos;
    }

    public List<UsuarioAcessos> buscarUsuarioPontoFocalPorSubunidadeService(Long idSubunidade) {
        return usuarioAcessosBuscar.buscarUsuarioPontoFocalPorSubunidade(idSubunidade);
    }

    public List<UsuarioAcessos> buscarUsuarioTecnicoPorSubunidadeService(){
        return usuarioAcessosBuscar.buscarUsuarioTecnicoPorSubunidade();
    }

    public void editarUsuarioPerfilService (UsuarioParametrosDTO parametrosDTO) {
        usuarioAcessosEditar.editarUsuarioPerfil(parametrosDTO);
    }

    public List<UsuarioSiapeAcessoDTO> obterUsuariosPorPerfilService(String nomePerfil){
        return usuarioAcessosObter.obterUsuariosPorPerfil(nomePerfil, Optional.empty());
    }

    public void obterUsuariosNoBancoDadosService (UnidadePadraoDTO unidadePadraoDTO, Long idUnidade){
        usuarioAcessosObter.obterUsuariosNoBancoDados(unidadePadraoDTO, idUnidade);
    }

    public List<UsuarioSiapeAcessoDTO> obterUsuariosPorPerfilService (String nomePerfil, Optional optionalId){
        return usuarioAcessosObter.obterUsuariosPorPerfil(nomePerfil, optionalId);
    }

    public void editarAutoridadeUsuarioService (UsuarioSiapeAcessoDTO usuario, Unidade unidade, String papel){
        usuarioAcessosEditar.editarAutoridadeUsuario(usuario, unidade, papel);
    }

    public void desvincularUsuarioDaUnidadeService (String perfil, Unidade unidade, String papel){
        usuarioAcessosEditar.desvincularUsuarioDaUnidade(perfil, unidade, papel);
    }

    public void newAutoridadeUsuarioService (UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO, Unidade unidade, String papel){
        usuarioAcessosCriar.newAutoridadeUsuario(usuarioSiapeAcessoDTO, unidade, papel);
    }

    public List<UsuarioAcessos> buscarUsuarioAutoridade(Long idUnidade, String perfil) {
        List<UsuarioAcessos> usuarioAcessosList = new ArrayList<>();
        usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfilOrderByPapel(idUnidade, perfil).forEach(u -> usuarioAcessosList.add(u.getUsuarioAcessos()));
        return usuarioAcessosList;
    }
}

