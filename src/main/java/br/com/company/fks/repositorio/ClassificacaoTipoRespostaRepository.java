package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.ClassificacaoTipoResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificacaoTipoRespostaRepository extends JpaRepository<ClassificacaoTipoResposta, Long> {

    @Query("SELECT distinct ctr from ClassificacaoTipoResposta ctr order by ctr.descricao ASC ")
    List<ClassificacaoTipoResposta> findAllByDescricao();

    @Query("select distinct ctr from ClassificacaoTipoResposta ctr where ctr.tipoResposta.id = :tipoResposta")
    List<ClassificacaoTipoResposta> findAllByTipoResposta(@Param("tipoResposta") Long idTipoResposta);


}
