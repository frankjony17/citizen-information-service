package br.com.company.fks.servico.usuario;

import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.gov.mpog.acessos.cliente.servico.AcessosClienteSistemaService;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.PerfilAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioDadosDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioLogadoDTO;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.utils.EntityConverter;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService {

    @Value(value = "${saml.config.idSistema}")
    private String idSistema;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private AcessosClienteSistemaService acessosClienteSistemaService;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private UnidadeService unidadeService;

    public UsuarioLogadoDTO getUsuarioLogadoPerfis() {
        UsuarioLogadoDTO usuarioLogado = new UsuarioLogadoDTO();
        usuarioLogado.setCpf(usuarioLogadoUtil.getCpf());
        usuarioLogado.setNome(usuarioLogadoUtil.getNome());
        setUsuarioLogado(usuarioLogado);
        usuarioLogado.setPerfis(obterPerfis());
        return usuarioLogado;
    }

    public UsuarioDadosDTO editarDados (UsuarioDadosDTO usuarioDadosDTO) {
        UsuarioDadosDTO dadosDTO = new UsuarioDadosDTO();
        if (usuarioDadosDTO.getId() != null) {
            UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findOne(usuarioDadosDTO.getId());
            usuarioAcessos.setEmailUsuario(usuarioDadosDTO.getEmail());
            usuarioAcessos.setTelefoneUsuario(usuarioDadosDTO.getTelefone());
            usuarioAcessosRepository.save(usuarioAcessos);
            dadosDTO.setEmail(usuarioDadosDTO.getEmail());
            dadosDTO.setTelefone(usuarioDadosDTO.getTelefone());
        }
        return dadosDTO;
    }

    private void setUsuarioLogado (UsuarioLogadoDTO usuarioLogado) {
        Responsaveis responsaveis = obterResponsabeis();
        if (usuarioLogadoUtil.getUsuario() != null) {
            usuarioLogado.setId(usuarioLogadoUtil.getUsuario().getId());
            usuarioLogado.setCargo(usuarioLogadoUtil.getUsuario().getCargoUsuario());
            usuarioLogado.setFuncao(usuarioLogadoUtil.getUsuario().getFuncaoUsuario());
            usuarioLogado.setEmail(usuarioLogadoUtil.getUsuario().getEmailUsuario());
            usuarioLogado.setTelefone(usuarioLogadoUtil.getUsuario().getTelefoneUsuario());
            usuarioLogado.setAutoridadeHierarquica(obterUsuarioPorPerfilUnidade("FKS.AUTORIDADE.HIERARQUICA"));
            usuarioLogado.setAutoridadeMaxima(obterUsuarioPorPerfilUnidade("FKS.AUTORIDADE.MAXIMA"));
            usuarioLogado.setResponsavelTercera(responsaveis != null ? responsaveis.getResponsavelRecursoTerceiraInstancia() : "");
            usuarioLogado.setResponsavelQuarta(responsaveis != null ? responsaveis.getResponsavelRecursoQuartaInstancia() : "");
            usuarioLogado.setAssinatura(usuarioAcessoPerfilAcessoRepository.obterAssinatura(usuarioLogadoUtil.getUsuario().getCpfUsuario(), usuarioLogadoUtil.getPerfil()));
            if (usuarioLogadoUtil.getUsuario().getUnidade() != null) {
                usuarioLogado.setUnidade(dtoUnidade(usuarioLogadoUtil.getUsuario().getUnidade()));
            }
            Subunidade subunidade = unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf());
            if (subunidade != null) { usuarioLogado.setSubunidade(Collections.singletonList(dtoSubunidade(subunidade))); }
        }
    }

    private SubunidadeDTO dtoSubunidade (Subunidade subunidade) {
        SubunidadeDTO subunidadeDTO = new SubunidadeDTO();
        subunidadeDTO.setId(subunidade.getId());
        subunidadeDTO.setNomeUnidade(subunidade.getNomeSubunidade());
        subunidadeDTO.setSiglaUnidade(subunidade.getSiglaSubunidade());
        subunidadeDTO.setCodigoUnidade(subunidade.getCodigoSubunidade());
        return subunidadeDTO;
    }

    private UnidadeDTO dtoUnidade (Unidade unidade) {
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        unidade.getSubunidade().forEach(s -> {
            SubunidadeDTO subunidadeDTO = new SubunidadeDTO();
            subunidadeDTO.setId(s.getId());
            subunidadeDTO.setNomeUnidade(s.getNomeSubunidade());
            subunidadeDTO.setSiglaUnidade(s.getSiglaSubunidade());
            subunidadeDTO.setCodigoUnidade(s.getCodigoSubunidade());
            subunidadeDTOList.add(subunidadeDTO);
        });
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setNomeUnidade(unidade.getNomeUnidade());
        unidadeDTO.setSiglaUnidade(unidade.getSiglaUnidade());
        unidadeDTO.setCodigoUnidade(unidade.getCodigoUnidade());
        unidadeDTO.setStatusUnidade(unidade.getStatusUnidade());
        unidadeDTO.setSubunidade(subunidadeDTOList);
        return unidadeDTO;
    }

    private Responsaveis obterResponsabeis () {
        return responsaveisRepository.findTopByOrderByIdDesc();
    }

    private String obterUsuarioPorPerfilUnidade(String perfil) {
        String usuarioNome = "";
        if (usuarioLogadoUtil.getUsuario().getUnidade() != null) {
            UsuarioAcessoPerfilAcesso usuarioPerfilLigadoUnidade = usuarioAcessoPerfilAcessoRepository.findFirstByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel(
                    perfil,
                    usuarioLogadoUtil.getUsuario().getUnidade(),
                    "TITULAR"
            );
            if (usuarioPerfilLigadoUnidade != null) {
                usuarioNome = usuarioPerfilLigadoUnidade.getUsuarioAcessos().getNomeUsuario();
            }
        }
        return usuarioNome;
    }

    /**
     * Obter perfis do usuário de Acessos.
     * @return List<PerfilAcessoDTO>.
     */
    private List<PerfilAcessoDTO> obterPerfis () {
        List<PerfilAcessoDTO> perfilAcessoDTOList = new ArrayList<>();
        List<Object> perfisList = acessosClienteSistemaService.buscarPerfis(usuarioLogadoUtil.getCpf(), null, null, null, null, null, null);
        for (Object perfil : perfisList) {
            PerfilAcessoDTO perfilAcessoDTO = entityConverter.converter(perfil, PerfilAcessoDTO.class);
            UsuarioAcessoPerfilAcesso usuarioPerfilBancoDados = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(
                    usuarioLogadoUtil.getCpf(),
                    perfilAcessoDTO.getNome()
            );
            if (usuarioPerfilBancoDados != null) {
                perfilAcessoDTO.setIsAtivo(usuarioPerfilBancoDados.getIsAtivo());
            } else {
                perfilAcessoDTO.setIsAtivo(false);
            }
            perfilAcessoDTOList.add(perfilAcessoDTO);
        }
        return perfilAcessoDTOList;
    }
}
