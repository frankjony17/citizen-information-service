package br.com.company.fks.servico.usuario;

import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioAcessosEditar {

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private UsuarioAcessosCriar usuarioAcessosCriar;

    @Transactional
    public void editarAutoridadeUsuario (UsuarioSiapeAcessoDTO usuario, Unidade unidade, String papel) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuario.getCpf());
        if (usuarioAcessos != null) {
            UsuarioAcessoPerfilAcesso usuarioPerfil = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(usuarioAcessos.getCpfUsuario(),usuario.getPerfil());
            if (usuarioAcessos.getUnidade() != null && usuarioAcessos.getUnidade().getCodigoUnidade().equals(unidade.getCodigoUnidade())) {
                String query = verificarPapel(usuarioPerfil, papel);
                if (query.equals("SIM_PAPEL")) {
                    upgradeUsuario(usuarioAcessos, usuario, unidade);
                } else {
                    trocarPapel(usuarioPerfil, usuario, unidade, papel);
                    upgradeUsuario(usuarioAcessos, usuario, unidade);
                }
            } else {
                desvincularUsuarioDaUnidade(usuario.getPerfil(), unidade, papel);
                upgradeUsuario(usuarioAcessos, usuario, unidade);
            }
        } else {
            desvincularUsuarioDaUnidade(usuario.getPerfil(), unidade, papel);
            usuarioAcessosCriar.newAutoridadeUsuario(usuario, unidade, papel); // Crio novo usuário é vinculo a ele.
        }
    }

    /**
     * Desvincular Usuário da Unidade.
     * @param perfil Perfil nome.
     * @param unidade Unidade.
     * @param papel Papel.
     */
    public void desvincularUsuarioDaUnidade (String perfil, Unidade unidade, String papel) {
        UsuarioAcessoPerfilAcesso usuarioPerfilLigadoUnidade = usuarioAcessoPerfilAcessoRepository.findFirstByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel(perfil, unidade, papel);
        if (usuarioPerfilLigadoUnidade != null) {
            usuarioPerfilLigadoUnidade.getUsuarioAcessos().setUnidade(null); // Desvinculado a unidade do usuário.
            usuarioAcessoPerfilAcessoRepository.save(usuarioPerfilLigadoUnidade);
        }
    }

    /**
     * Editar Usuário e vincular a Unidade.
     * @param usuarioAcessos Usuário no banco de dados.
     * @param usuario Usuário recebido pelo cliente.
     * @param unidade Unidade.
     */
    private void upgradeUsuario (UsuarioAcessos usuarioAcessos, UsuarioSiapeAcessoDTO usuario, Unidade unidade) {
        usuarioAcessos.setEmailUsuario(usuario.getEmail());
        usuarioAcessos.setCargoUsuario(usuario.getCargo());
        usuarioAcessos.setFuncaoUsuario(usuario.getFuncao());
        usuarioAcessos.setTelefoneUsuario(usuario.getTelefone());
        usuarioAcessos.setUnidade(unidade);
        usuarioAcessosCriar.editarAssinatura(usuario.getCpf(), usuario.getPerfil(), usuario.getAssinatura());
        usuarioAcessosRepository.save(usuarioAcessos);
    }

    private void trocarPapel (UsuarioAcessoPerfilAcesso usuarioPerfil, UsuarioSiapeAcessoDTO usuario, Unidade unidade, String papel) {
        usuarioPerfil.setPapel(papel);
        usuarioPerfil = usuarioAcessoPerfilAcessoRepository.save(usuarioPerfil);
        upgradeUsuario(usuarioPerfil.getUsuarioAcessos(), usuario, unidade);
    }

    private String verificarPapel (UsuarioAcessoPerfilAcesso usuarioPerfil, String papel) {
        String acoes = "NAO_PAPEL";
        // Mesmo papel?.
        if (usuarioPerfil.getPapel().equals(papel)) {
            acoes = "SIM_PAPEL"; // Sim mesmo papel.
        }
        return acoes;
    }

    @Transactional
    public void editarUsuarioPerfil (UsuarioParametrosDTO parametrosDTO) {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(parametrosDTO.getCpf());
        usuarioAcessos.setPerfilUsuario(parametrosDTO.getNomePerfil());
        usuarioAcessosRepository.save(usuarioAcessos);
    }

}

