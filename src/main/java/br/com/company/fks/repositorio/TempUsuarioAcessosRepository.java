package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TempUsuarioAcessos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TempUsuarioAcessosRepository extends JpaRepository<TempUsuarioAcessos, Long>{

    @Query("SELECT DISTINCT u from TempUsuarioAcessos u LEFT JOIN u.tempPerfisAcessos p " +
            "WHERE " +
            "(:perfilNome IS NULL OR p.perfilNome = :perfilNome) AND " +
            "(:usuarioCpf IS NULL OR u.usuarioCpf = :usuarioCpf) AND " +
            "(:unidadeId IS NULL OR p.perfilUnidadeId = :unidadeId) AND " +
            "(:subunidadeIds IS NULL OR p.perfilSubunidadesIds LIKE %:subunidadeIds%) AND " +
            "(:perfilStatus IS NULL OR p.perfilAtivo = :perfilStatus) AND " +
            "(:existeAcessos IS NULL OR p.perfilExisteAcessos = :existeAcessos) ORDER BY u.usuarioNome ASC")
    Page<TempUsuarioAcessos> findUsuariosPerfis (
            @Param("perfilNome") String perfilNome,
            @Param("usuarioCpf") String usuarioCpf,
            @Param("unidadeId") Long unidadeId,
            @Param("subunidadeIds") String subunidadeIds,
            @Param("perfilStatus") Boolean perfilStatus,
            @Param("existeAcessos") Boolean existeAcessos,
            Pageable pageable
    );
}
