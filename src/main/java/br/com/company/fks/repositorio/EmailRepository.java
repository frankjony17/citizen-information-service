package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT DISTINCT email.assuntoEmail FROM Email email WHERE email.assuntoEmail IS NOT NULL")
    List<String> findAssuntoEmail ();

    List<Email> findAllByTipoAlerta (Integer tipoAlerta);

    @Query("SELECT DISTINCT email FROM Email email LEFT JOIN email.perfis emailPerfil LEFT JOIN emailPerfil.perfilAcessos perfil " +
            "WHERE (:tipoSolicitacao IS NULL OR email.tipoSolicitacao = :tipoSolicitacao) " +
            "AND (:tipoAlerta IS NULL OR email.tipoAlerta = :tipoAlerta) " +
            "AND (:assuntoEmail IS NULL OR email.assuntoEmail = :assuntoEmail) " +
            "AND ((:ids) IS NULL OR perfil.id IN (:ids))")
    Page<Email> findEmailPerfis (@Param("tipoSolicitacao") Integer tipoSolicitacao, @Param("tipoAlerta") Integer tipoAlerta, @Param("assuntoEmail") String assuntoEmail, @Param("ids") List<Long> ids, Pageable pageable);

    @Query("SELECT COUNT(DISTINCT email.id) FROM Email email LEFT JOIN email.perfis emailPerfil LEFT JOIN emailPerfil.perfilAcessos perfil " +
            "WHERE (:tipoSolicitacao IS NULL OR email.tipoSolicitacao = :tipoSolicitacao) " +
            "AND (:tipoAlerta IS NULL OR email.tipoAlerta = :tipoAlerta) " +
            "AND (:assuntoEmail IS NULL OR email.assuntoEmail = :assuntoEmail) " +
            "AND ((:ids) IS NULL OR perfil.id IN (:ids))")
    Long countEmailPerfis (@Param("tipoSolicitacao") Integer tipoSolicitacao, @Param("tipoAlerta") Integer tipoAlerta, @Param("assuntoEmail") String assuntoEmail, @Param("ids") List<Long> ids);
}
