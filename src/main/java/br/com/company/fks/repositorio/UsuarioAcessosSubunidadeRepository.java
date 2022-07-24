package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.UsuarioAcessoSubunidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioAcessosSubunidadeRepository extends JpaRepository<UsuarioAcessoSubunidade, Long> {

    List<UsuarioAcessoSubunidade> findAllByUsuarioAcessosCpfUsuario (String cpf);

    @Query("SELECT DISTINCT us FROM UsuarioAcessoSubunidade us JOIN us.subunidade su JOIN us.usuarioAcessos ua WHERE ua.cpfUsuario =:cpfUsuario")
    List<UsuarioAcessoSubunidade> findDistinctByUsuarioAcessosCpfUsuario (@Param("cpfUsuario") String cpf);

    UsuarioAcessoSubunidade findFirstByUsuarioAcessosCpfUsuario (String cpf);
}
