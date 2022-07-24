package br.com.company.fks.servico.usuario;

import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.TempPerfisAcessos;
import br.com.company.fks.modelo.TempUsuarioAcessos;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessoSubunidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.UsuarioDetalhadoDTO;
import br.com.company.fks.modelo.dto.UsuariosAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.TempPerfisAcessosRepository;
import br.com.company.fks.repositorio.TempUsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UsuarioAcessosCriar {

    @Autowired
    private SubunidadeRepository subunidadeRepository;

    @Autowired
    private UsuarioAcessosObter usuarioAcessosObter;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private TempUsuarioAcessosRepository tempUsuarioAcessosRepository;

    @Autowired
    private TempPerfisAcessosRepository tempPerfisAcessosRepository;

    public UsuarioAcessos montaUsuarioAcessos(UsuarioDetalhadoDTO usuarioDetalhadoDTO){
        UsuarioAcessos usuario = new UsuarioAcessos();
        usuario.setId(usuarioDetalhadoDTO.getId());
        usuario.setNomeUsuario(usuarioDetalhadoDTO.getNome());
        usuario.setTelefoneUsuario(usuarioDetalhadoDTO.getTelefoneCelular());
        usuario.setCpfUsuario(usuarioDetalhadoDTO.getCpf());
        usuario.setCargoUsuario(usuarioDetalhadoDTO.getCargo());
        usuario.setEmailUsuario(usuarioDetalhadoDTO.getEmail());
        usuario.setUnidade(usuarioDetalhadoDTO.getUnidade());
        return usuario;
    }

    public void salvar(UsuarioParametrosDTO parametros) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(parametros.getUsuario().getCpfUsuario());
        if (usuarioAcessos != null ) {
            usuarioAcessos = preencherUsuario(usuarioAcessos, parametros);
        }
        else {
            UsuarioAcessos newUsuario = new UsuarioAcessos();
            usuarioAcessos = preencherUsuario(newUsuario, parametros);
        }
        preencherSubunidades(parametros, usuarioAcessos);
        newPerfilUsuario(usuarioAcessos, parametros.getNomePerfil(), "ATRIBUIDO", parametros.getAssinaturaUsuario());
    }

    private void preencherSubunidades (UsuarioParametrosDTO parametros, UsuarioAcessos usuarioAcessos) {
        usuarioAcessosSubunidadeRepository.findAllByUsuarioAcessosCpfUsuario(usuarioAcessos.getCpfUsuario()).forEach(us -> {
            usuarioAcessosSubunidadeRepository.delete(us.getId());
        });
        if (parametros.getSubunidades() != null) {
            parametros.getSubunidades().forEach(s -> {
                Subunidade subunidade = subunidadeRepository.findOne(s.getId());
                UsuarioAcessoSubunidade usuarioAcessoSubunidade = new UsuarioAcessoSubunidade();
                usuarioAcessoSubunidade.setSubunidade(subunidade);
                usuarioAcessoSubunidade.setUsuarioAcessos(usuarioAcessos);
                usuarioAcessoSubunidade.setStatusSubunidade(true);
                usuarioAcessosSubunidadeRepository.save(usuarioAcessoSubunidade);
            });
        }
    }

    public UsuarioAcessos preencherUsuario(UsuarioAcessos usuarioAcessos, UsuarioParametrosDTO parametros){
        usuarioAcessos.setNomeUsuario(parametros.getUsuario().getNomeUsuario());
        usuarioAcessos.setCpfUsuario(parametros.getUsuario().getCpfUsuario());
        usuarioAcessos.setEmailUsuario(parametros.getUsuario().getEmailUsuario());
        usuarioAcessos.setTelefoneUsuario(parametros.getUsuario().getTelefoneUsuario());
        usuarioAcessos.setCargoUsuario(parametros.getUsuario().getCargoUsuario());
        usuarioAcessos.setFuncaoUsuario(parametros.getUsuario().getFuncaoUsuario());
        usuarioAcessos.setUnidade(parametros.getUnidade());
        return usuarioAcessosRepository.save(usuarioAcessos);
    }

    private void newPerfilUsuario (UsuarioAcessos usuarioAcessos, String nomePerfil, String papel, String assinatura) {
        PerfilAcessos perfilAcessos = usuarioAcessosObter.obterPerfilAcesso(nomePerfil);
        UsuarioAcessoPerfilAcesso up = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfilAndPapel(
                usuarioAcessos.getCpfUsuario(),
                nomePerfil,
                papel
        );
        if (up == null) {
            up = new UsuarioAcessoPerfilAcesso();
        }
        up.setIsAtivo(true);
        up.setPapel(papel);
        up.setPerfilAcessos(perfilAcessos);
        up.setUsuarioAcessos(usuarioAcessos);
        up.setAssinaturaUsuario(assinatura);
        usuarioAcessoPerfilAcessoRepository.save(up);
    }

    @Transactional
    public void newAutoridadeUsuario (UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO, Unidade unidade, String papel) {
        if (usuarioSiapeAcessoDTO.getCpf() != null) {
            UsuarioAcessos usuarioAcessos = new UsuarioAcessos();
            usuarioAcessos.setCpfUsuario(usuarioSiapeAcessoDTO.getCpf());
            usuarioAcessos.setNomeUsuario(usuarioSiapeAcessoDTO.getNome());
            usuarioAcessos.setEmailUsuario(usuarioSiapeAcessoDTO.getEmail());
            usuarioAcessos.setTelefoneUsuario(usuarioSiapeAcessoDTO.getTelefone());
            usuarioAcessos.setCargoUsuario(usuarioSiapeAcessoDTO.getCargo());
            usuarioAcessos.setFuncaoUsuario(usuarioSiapeAcessoDTO.getFuncao());
            usuarioAcessos.setUnidade(unidade);
            UsuarioAcessos usuarioSave = usuarioAcessosRepository.save(usuarioAcessos);
            newPerfilUsuario(usuarioSave, usuarioSiapeAcessoDTO.getPerfil(), papel, usuarioSiapeAcessoDTO.getAssinatura());
        }
    }

    public UsuarioSiapeAcessoDTO montarUsuarioSiapeAcessoDTO (UsuarioAcessos usuarioBancoDados, String nomePerfil, String assinatura, Boolean ativo) {
        UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO = new UsuarioSiapeAcessoDTO();
        usuarioSiapeAcessoDTO.setId(usuarioBancoDados.getId());
        usuarioSiapeAcessoDTO.setCpf(usuarioBancoDados.getCpfUsuario());
        usuarioSiapeAcessoDTO.setNome(usuarioBancoDados.getNomeUsuario());
        usuarioSiapeAcessoDTO.setEmail(usuarioBancoDados.getEmailUsuario());
        usuarioSiapeAcessoDTO.pushTelefone(usuarioBancoDados.getTelefoneUsuario());
        usuarioSiapeAcessoDTO.setCargo(usuarioBancoDados.getCargoUsuario());
        usuarioSiapeAcessoDTO.setAssinatura(assinatura);
        usuarioSiapeAcessoDTO.setAtivo(ativo.toString());
        usuarioSiapeAcessoDTO.setPerfil(nomePerfil);
        return usuarioSiapeAcessoDTO;
    }

    public void editarAssinatura (String cpfUsuario, String nomePerfil, String assinatura) {
        UsuarioAcessoPerfilAcesso usuarioPerfil = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(cpfUsuario, nomePerfil);
        if (usuarioPerfil != null) {
            usuarioPerfil.setAssinaturaUsuario(assinatura);
            usuarioAcessoPerfilAcessoRepository.save(usuarioPerfil);
        }
    }

    public void cadastrarUsuarioPerfisTemp (UsuariosAcessoDTO usuario) {
        TempUsuarioAcessos tempUsuarioAcessos = new TempUsuarioAcessos();
        tempUsuarioAcessos.setId(usuario.getId());
        tempUsuarioAcessos.setUsuarioCpf(usuario.getCpf());
        tempUsuarioAcessos.setUsuarioNome(usuario.getNome());
        tempUsuarioAcessos.setUsuarioEmail(usuario.getEmail());
        tempUsuarioAcessos.setUsuarioAtivo(usuario.getAtivo());
        tempUsuarioAcessos.setUsuarioTelefoneTrabalho(usuario.getTelefoneTrabalho());
        tempUsuarioAcessos.setUsuarioTelefoneCelular(usuario.getTelefoneCelular());
        tempUsuarioAcessos.setUsuarioExisteAcessos(usuario.getExisteAcessos());
        TempPerfisAcessos tempPerfisAcessos = new TempPerfisAcessos();
        TempUsuarioAcessos tempSave = tempUsuarioAcessosRepository.save(tempUsuarioAcessos);
        getPerfis(usuario, tempPerfisAcessos, tempSave);
    }

    private void getPerfis (UsuariosAcessoDTO usuario, TempPerfisAcessos tempPerfisAcessos, TempUsuarioAcessos tempUsuarioAcessos) {
        usuario.getPerfil().forEach(p -> {
            tempPerfisAcessos.setId(p.getPerfil().getId());
            tempPerfisAcessos.setPerfilNome(p.getPerfil().getNome());
            tempPerfisAcessos.setPerfilDescricao(p.getPerfil().getDescricao());
            tempPerfisAcessos.setPerfilUnidadeId(p.getPerfil().getUnidade() != null ? p.getPerfil().getUnidade().getId() : null);
            if (p.getPerfil().getSubunidades() != null) {
                tempPerfisAcessos.setPerfilSubunidadesIds(getIds(p.getPerfil().getSubunidades().stream().map(Subunidade::getId).collect(Collectors.toList())));
            } else {
                tempPerfisAcessos.setPerfilSubunidadesIds("");
            }
            tempPerfisAcessos.setPerfilExcluido(p.getPerfil().getExcluido());
            tempPerfisAcessos.setPerfilExisteAcessos(p.getPerfil().getExisteAcessos());
            tempPerfisAcessos.setPerfilAtivo(p.getPerfil().getAtivo());
            tempPerfisAcessos.setTempUsuarioAcessos(tempUsuarioAcessos);
            tempPerfisAcessosRepository.save(tempPerfisAcessos);
        });
    }

    private String getIds (List<Long> idsLong) {
        StringBuilder stringBuilder = new StringBuilder();
        idsLong.forEach(id -> {
            stringBuilder.append("#");
            stringBuilder.append(id);
        });
        stringBuilder.append("#");
        return stringBuilder.toString();
    }
}