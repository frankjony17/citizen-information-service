package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.UsuarioAcessos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface UsuarioAcessosRepository extends JpaRepository<UsuarioAcessos, Long> {

    List<UsuarioAcessos> findByUnidadeId(Long idUnidade);

    UsuarioAcessos findFirstByCpfUsuario(String cpfUsuario);

    @Query(value = "SELECT * FROM tb_usuario_acessos u "+
            "JOIN tb_usuario_acesso_perfil_acesso up ON u.id_usuario_acessos = up.id_usuario_acessos "+
            "JOIN tb_usuario_acessos_subunidade us ON u.id_usuario_acessos = us.id_usuario_acessos "+
            "JOIN tb_perfil_acessos p ON p.id_perfil_acessos = up.id_perfil_acessos "+
            "WHERE (p.nm_nome_perfil LIKE :nomePerfil1 OR p.nm_nome_perfil LIKE :nomePerfil2) AND us.id_subunidade = :subunidadeId", nativeQuery = true)
    List<UsuarioAcessos> findUsuarioBySubunidadeIdAndAndPerfil (
            @Param("nomePerfil1") String nomePerfil1,
            @Param("nomePerfil2") String nomePerfil2,
            @Param("subunidadeId") Long subunidadeId
    );

    List<UsuarioAcessos> findAllByCpfUsuarioIsNotIn (Set<String> cpfList);

}
