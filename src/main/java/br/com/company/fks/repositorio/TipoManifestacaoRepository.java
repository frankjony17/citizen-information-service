package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.TipoManifestacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoManifestacaoRepository extends JpaRepository<TipoManifestacao, Long> {

    @Query("SELECT distinct t from TipoManifestacao t order by t.nome asc")
    List<TipoManifestacao> findAllOrderByNome();



}
