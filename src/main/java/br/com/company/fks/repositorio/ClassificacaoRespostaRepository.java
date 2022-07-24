package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.ClassificacaoResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificacaoRespostaRepository extends JpaRepository<ClassificacaoResposta, Long> {

    @Query("SELECT distinct c FROM ClassificacaoResposta c " +
            "WHERE c.tipoClassificacaoResposta.id = 1 AND c.statusClassificacaoResposta = true")
    List<ClassificacaoResposta> findAllByDescricaoSolicitante();

    @Query("SELECT distinct c1 FROM ClassificacaoResposta c1 " +
            "WHERE c1.tipoClassificacaoResposta.id = 2 AND c1.statusClassificacaoResposta = true")
    List<ClassificacaoResposta> findAllByDescricaoTranparenciaAtiva();

    @Query("SELECT distinct c FROM ClassificacaoResposta c " +
            "WHERE c.tipoClassificacaoResposta.id = 3 AND c.statusClassificacaoResposta = true")
    List<ClassificacaoResposta> findAllByDescricaoTranparenciaPassiva();

    @Query("SELECT distinct c FROM ClassificacaoResposta c " +
            "WHERE c.tipoClassificacaoResposta.id = 4 AND c.statusClassificacaoResposta = true")
    List<ClassificacaoResposta> findAllByDescricaoAcessoNegado();

    ClassificacaoResposta findById(Long id);
}
