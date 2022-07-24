package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioAcessoPerfilAcessoRepository extends JpaRepository<UsuarioAcessoPerfilAcesso, Long> {

    UsuarioAcessoPerfilAcesso findByUsuarioAcessosId(Long usuarioAcessosId);

    List<UsuarioAcessoPerfilAcesso> findAllByUsuarioAcessosCpfUsuario (String cpf);

    UsuarioAcessoPerfilAcesso findFirstByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel(String perfilNome, Unidade unidade, String papel);

    int countByPerfilAcessosNomePerfilAndUsuarioAcessosUnidadeAndPapel(String perfilNome, Unidade unidade, String papel);

    List<UsuarioAcessoPerfilAcesso> findByPerfilAcessosNomePerfil(String nomePerfil);

    UsuarioAcessoPerfilAcesso findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfil(String cpfUsuario, String nomePerfil);

    UsuarioAcessoPerfilAcesso findFirstByUsuarioAcessosCpfUsuarioAndPerfilAcessosNomePerfilAndPapel(String cpfUsuario, String nomePerfil, String papel);

    List<UsuarioAcessoPerfilAcesso> findUsuarioAcessoPerfilAcessoByUsuarioAcessosUnidadeNomeUnidade(String nomeUnidade);

    List<UsuarioAcessoPerfilAcesso> findAllByUsuarioAcessosUnidadeIdAndPerfilAcessosIn (Long idUnidade, List<PerfilAcessos> perfilAcessosList);

    UsuarioAcessoPerfilAcesso findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil (Long idUnidade, String nomePerfil);

    List<UsuarioAcessoPerfilAcesso> findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfilOrderByPapel (Long idUnidade, String nomePerfil);

    @Query("SELECT usuarioPerfis.assinaturaUsuario FROM UsuarioAcessoPerfilAcesso usuarioPerfis " +
            "JOIN usuarioPerfis.usuarioAcessos usuario " +
            "JOIN usuarioPerfis.perfilAcessos perfil " +
            "WHERE usuario.cpfUsuario LIKE :cpf AND perfil.nomePerfil LIKE :perfil")
    String obterAssinatura (@Param("cpf") String cpf, @Param("perfil") String perfil);
}
