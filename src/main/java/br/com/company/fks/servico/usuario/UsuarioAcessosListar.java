package br.com.company.fks.servico.usuario;

import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.PerfilDTO;
import br.com.company.fks.modelo.dto.PerfilAcessosDTO;
import br.com.company.fks.modelo.dto.UsuarioDTO;
import br.com.company.fks.modelo.dto.UsuariosAcessoDTO;
import br.com.company.fks.repositorio.TempPerfisAcessosRepository;
import br.com.company.fks.repositorio.TempUsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import br.com.company.fks.utils.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioAcessosListar {

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Autowired
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Autowired
    private TempUsuarioAcessosRepository tempUsuarioAcessosRepository;

    @Autowired
    private TempPerfisAcessosRepository tempPerfisAcessosRepository;

    private static final String CODIGO_MODULO = "FKS";

    public void obterTodosUsuarios () {
        tempPerfisAcessosRepository.deleteAllInBatch();
        tempUsuarioAcessosRepository.deleteAllInBatch();
        List<Object> usuarioAcessoList = acessosClienteSistemaServiceImpl.buscarUsuarios(null, null, null, null, null, null, null, null, CODIGO_MODULO);
        Set<String> cpfList = new HashSet<>();
        usuarioAcessoList.forEach(ua -> {
            UsuariosAcessoDTO usuarioDto = entityConverter.converter(ua, UsuariosAcessoDTO.class);
            getPerfis(usuarioDto, cpfList);
            usuarioAcessosCriar.cadastrarUsuarioPerfisTemp(usuarioDto);
        });
        getUsuariosInexistentesNoAcessos(cpfList);
    }

    private void getPerfis (UsuariosAcessoDTO usuarioDto, Set<String> cpfList) {
        List<PerfilAcessosDTO> perfisUsuarioList = new ArrayList<>();
        acessosClienteSistemaServiceImpl.buscarPerfis(usuarioDto.getCpf(), null, null, null, null,null, CODIGO_MODULO).forEach(pu -> {
            PerfilAcessosDTO perfilAcessosDto = new PerfilAcessosDTO();
            PerfilDTO perfilDTO = entityConverter.converter(pu, PerfilDTO.class);
            UsuarioAcessos usuarioDB = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioDto.getCpf());
            if (usuarioDB != null) {
                usuarioDto.setId(usuarioDB.getId());
            }
            setUnidade(usuarioDB, perfilDTO, cpfList, true);
            getStatusPerfis(usuarioDB, perfilDTO);
            perfilAcessosDto.setPerfil(perfilDTO);
            perfisUsuarioList.add(perfilAcessosDto);
        });
        usuarioDto.setPerfil(perfisUsuarioList);
    }

    private void getUsuariosInexistentesNoAcessos (Set<String> cpfList) {
        usuarioAcessosRepository.findAllByCpfUsuarioIsNotIn(cpfList).forEach(u -> {
            UsuariosAcessoDTO usuario = new UsuariosAcessoDTO();
            usuario.setId(u.getId());
            usuario.setCpf(u.getCpfUsuario());
            usuario.setNome(u.getNomeUsuario());
            usuario.setEmail(u.getEmailUsuario());
            usuario.setTelefoneTrabalho(u.getTelefoneUsuario());
            getPerfisNoBancoDados(usuario);
            usuarioAcessosCriar.cadastrarUsuarioPerfisTemp(usuario);
        });
    }

    private void getPerfisNoBancoDados (UsuariosAcessoDTO usuario) {
        List<PerfilAcessosDTO> perfisUsuarioList = new ArrayList<>();
        usuarioAcessoPerfilAcessoRepository.findAllByUsuarioAcessosCpfUsuario(usuario.getCpf()).forEach(up -> {
            PerfilDTO perfilDTO = new PerfilDTO();
            perfilDTO.setId(up.getId());
            perfilDTO.setAtivo(up.getIsAtivo());
            perfilDTO.setExcluido(true);
            perfilDTO.setNome(up.getPerfilAcessos().getNomePerfil());
            perfilDTO.setDescricao(up.getPerfilAcessos().getDescricaoPerfil());
            perfilDTO.setExisteAcessos(false);
            setUnidade(up.getUsuarioAcessos(), perfilDTO, new HashSet<>(), false);
            PerfilAcessosDTO perfilAcessosDto = new PerfilAcessosDTO();
            perfilAcessosDto.setPerfil(perfilDTO);
            perfisUsuarioList.add(perfilAcessosDto);
        });
        usuario.setPerfil(perfisUsuarioList);
    }

    private void getStatusPerfis (UsuarioAcessos usuarioBD, PerfilDTO perfilDTO) {
        boolean status = false;
        if (usuarioBD != null) {
            UsuarioAcessoPerfilAcesso usuarioPerfil = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(usuarioBD.getCpfUsuario(), perfilDTO.getNome());
            if (usuarioPerfil != null) {
                status = usuarioPerfil.getIsAtivo();
            }
        }
        perfilDTO.setAtivo(status);
        perfilDTO.setExisteAcessos(true);
        perfilDTO.setExcluido(false);
    }

    private void setUnidade (UsuarioAcessos usuarioBD, PerfilDTO perfilDTO, Set<String> cpfList, boolean bool) {
        if (usuarioBD != null) {
            usuarioAcessoPerfilAcessoRepository.findAllByUsuarioAcessosCpfUsuario(usuarioBD.getCpfUsuario()).forEach(up -> {
                List<Subunidade> subunidadeList = new ArrayList<>();
                if (up.getPerfilAcessos().getNomePerfil().equals(perfilDTO.getNome())) {
                    usuarioAcessosSubunidadeRepository.findDistinctByUsuarioAcessosCpfUsuario(usuarioBD.getCpfUsuario()).forEach(us -> subunidadeList.add(us.getSubunidade()));
                    perfilDTO.setUnidade(usuarioBD.getUnidade());
                    perfilDTO.setSubunidades(subunidadeList);
                    perfilDTO.setId(up.getId());
                }
            });
            if  (bool) {
                cpfList.add(usuarioBD.getCpfUsuario());
            }
        }
    }

    public List<UsuarioDTO> listarTodosUsuarios () {
        Set<String> cpfList = new HashSet<>();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
        acessosClienteSistemaServiceImpl.buscarUsuarios(null, null, null, null, null, null, null, null, CODIGO_MODULO).forEach(o -> {
            UsuariosAcessoDTO usuario = entityConverter.converter(o, UsuariosAcessoDTO.class);
            cpfList.add(usuario.getCpf());
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCpf(usuario.getCpf());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTOList.add(usuarioDTO);
        });
        usuarioAcessosRepository.findAllByCpfUsuarioIsNotIn(cpfList).forEach(u -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setCpf(u.getCpfUsuario());
            usuarioDTO.setNome(u.getNomeUsuario());
            usuarioDTOList.add(usuarioDTO);
        });
        return usuarioDTOList;
    }
}

