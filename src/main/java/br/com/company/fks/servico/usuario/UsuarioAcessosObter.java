package br.com.company.fks.servico.usuario;

import br.com.company.fks.repositorio.PerfilAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioAcessosObter {
    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private PerfilAcessosRepository perfilAcessosRepository;

    @Autowired
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Autowired
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private UsuarioAcessosBuscar usuarioAcessosBuscar;

     PerfilAcessos obterPerfilAcesso (String nomePerfil) {
        PerfilAcessos perfilAcessos = perfilAcessosRepository.findByNomePerfil(nomePerfil);
        if (perfilAcessos == null) {
            perfilAcessos = new PerfilAcessos();
            perfilAcessos.setNomePerfil(nomePerfil);
            perfilAcessos.setDescricaoPerfil(nomePerfil);
            perfilAcessos = perfilAcessosRepository.save(perfilAcessos);
        }
        return perfilAcessos;
    }

    public void obterUsuariosNoBancoDados (UnidadePadraoDTO unidadePadraoDTO, Long idUnidade) {
        usuarioAcessosRepository.findByUnidadeId(idUnidade).forEach(u -> {
            obterAutoridadeMaxima(unidadePadraoDTO, usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(u.getCpfUsuario(), "FKS.AUTORIDADE.MAXIMA"));
            obterAutoridadeHierarquica(unidadePadraoDTO, usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(u.getCpfUsuario(), "FKS.AUTORIDADE.HIERARQUICA"));
        });
    }

    private void obterAutoridadeMaxima (UnidadePadraoDTO unidadePadraoDTO, UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso) {
        if (usuarioAcessoPerfilAcesso != null) {
            UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = usuarioAcessosCriar.montarUsuarioSiapeAcessoDTO(
                    usuarioAcessoPerfilAcesso.getUsuarioAcessos(),
                    usuarioAcessoPerfilAcesso.getPerfilAcessos().getNomePerfil(),
                    usuarioAcessoPerfilAcesso.getAssinaturaUsuario(),
                    usuarioAcessoPerfilAcesso.getIsAtivo()
            );
            if (usuarioAcessoPerfilAcesso.getPapel().equals("TITULAR")) {
                unidadePadraoDTO.setUsuarioAutoridadeMaxima(usuarioSiapeAcessoDTO);
            }
            else {
                unidadePadraoDTO.setSubstitutoAutoridadeMaxima(usuarioSiapeAcessoDTO);
            }
        }
    }

    private void obterAutoridadeHierarquica(UnidadePadraoDTO unidadePadraoDTO, UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso) {
        if (usuarioAcessoPerfilAcesso != null) {
            UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = usuarioAcessosCriar.montarUsuarioSiapeAcessoDTO(
                    usuarioAcessoPerfilAcesso.getUsuarioAcessos(),
                    usuarioAcessoPerfilAcesso.getPerfilAcessos().getNomePerfil(),
                    usuarioAcessoPerfilAcesso.getAssinaturaUsuario(),
                    usuarioAcessoPerfilAcesso.getIsAtivo()
            );
            if (usuarioAcessoPerfilAcesso.getPapel().equals("TITULAR")) {
                unidadePadraoDTO.setUsuarioAutoridadeHierarquica(usuarioSiapeAcessoDTO);
            } else {
                unidadePadraoDTO.setSubstitutoAutoridadeHierarquica((usuarioSiapeAcessoDTO));
            }
        }
    }

    private void obterUsuarioDoAcesso (List<UsuarioSiapeAcessoDTO> usuarioSiapeAcessoDTOList, UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO, List<UsuarioAcessoPerfilAcesso> usuarioPerfilBancoDadosList, Optional optionalId) {
        String unidade = usuarioAcessosBuscar.usuarioExisteNoBancoDados(usuarioPerfilBancoDadosList, usuarioSiapeAcessoDTO);
        if (!unidade.equals("NO")) {
            usuarioSiapeAcessoDTO.setNome(usuarioSiapeAcessoDTO.getNome().concat(" [").concat(unidade).concat("]"));
        }
        if (!optionalId.isPresent()) {

            usuarioSiapeAcessoDTOList.add(usuarioSiapeAcessoDTO);
        } else {
            if (!usuarioSiapeAcessoDTO.getId().equals(optionalId.get())) {
                usuarioSiapeAcessoDTOList.add(usuarioSiapeAcessoDTO);
            }
        }
    }

    public List<UsuarioSiapeAcessoDTO> obterUsuariosPorPerfil (String nomePerfil, Optional optionalId) {
        List<UsuarioSiapeAcessoDTO> usuarioSiapeAcessoDTOList = new ArrayList<>();
        List<UsuarioAcessoPerfilAcesso> usuarioPerfilBancoDadosList = usuarioAcessoPerfilAcessoRepository.findAll();
        List<Object> usuarioAcessoList = acessosClienteSistemaServiceImpl.buscarUsuarios(null, null, nomePerfil, null, null, null, null, null, null);
        for (Object usuario : usuarioAcessoList) {
            UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = entityConverter.converter(usuario, UsuarioSiapeAcessoDTO.class);
            salvarTelefonePerfil(usuarioSiapeAcessoDTO, nomePerfil);
            obterUsuarioDoAcesso(usuarioSiapeAcessoDTOList, usuarioSiapeAcessoDTO, usuarioPerfilBancoDadosList, optionalId);
        }
        obterUsuarioNoBancoDadosQueNaoEstanNoAcessos(usuarioSiapeAcessoDTOList, usuarioPerfilBancoDadosList, usuarioAcessoList);
        return usuarioSiapeAcessoDTOList;
    }

    private void obterUsuarioNoBancoDadosQueNaoEstanNoAcessos (List<UsuarioSiapeAcessoDTO> usuarioSiapeAcessoDTOList, List<UsuarioAcessoPerfilAcesso> usuarioPerfilBancoDadosList, List<Object> usuarioAcessoList) {
        for (UsuarioAcessoPerfilAcesso usuarioPerfil : usuarioPerfilBancoDadosList) {
            if (!usuarioAcessosBuscar.existeUsuarioDeAcessosNoBancoDados(usuarioPerfil.getUsuarioAcessos().getCpfUsuario(), usuarioAcessoList)) {
                UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
                usuarioSiapeAcessoDTO.setId(usuarioPerfil.getUsuarioAcessos().getId());
                usuarioSiapeAcessoDTO.setCpf(usuarioPerfil.getUsuarioAcessos().getCpfUsuario());
                usuarioSiapeAcessoDTO.setNome(usuarioPerfil.getUsuarioAcessos().getNomeUsuario().concat(" [Usuário inexistente no acessos]"));
                usuarioSiapeAcessoDTO.setCargo(usuarioPerfil.getUsuarioAcessos().getCargoUsuario());
                usuarioSiapeAcessoDTO.setAtivo(usuarioPerfil.getIsAtivo().toString());
                usuarioSiapeAcessoDTO.setEmail(usuarioPerfil.getUsuarioAcessos().getEmailUsuario());
                usuarioSiapeAcessoDTO.setFuncao(usuarioPerfil.getUsuarioAcessos().getFuncaoUsuario());
                usuarioSiapeAcessoDTO.setPerfil(usuarioPerfil.getUsuarioAcessos().getPerfilUsuario());
                usuarioSiapeAcessoDTO.setAssinatura(usuarioPerfil.getAssinaturaUsuario());
                usuarioSiapeAcessoDTO.pushTelefone(usuarioPerfil.getUsuarioAcessos().getTelefoneUsuario());
                usuarioSiapeAcessoDTOList.add(usuarioSiapeAcessoDTO);
            }
        }
    }

    private String stringTelefone (UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO) {
        String celular = "";
        String telefone = "";
        if (usuarioSiapeAcessoDTO.getTelefoneTrabalho() != null) {
            telefone = usuarioSiapeAcessoDTO.getTelefoneTrabalho().concat(", ");
        }
        if (usuarioSiapeAcessoDTO.getTelefoneCelular() != null) {
            celular = usuarioSiapeAcessoDTO.getTelefoneCelular();
        }
        return telefone.concat(celular);
    }

    public UsuarioSiapeAcessoDTO salvarTelefonePerfil(UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO, String nomePerfil) {
        usuarioSiapeAcessoDTO.setPerfil(nomePerfil);
        usuarioSiapeAcessoDTO.pushTelefone(stringTelefone(usuarioSiapeAcessoDTO));
        return usuarioSiapeAcessoDTO;
    }

}

