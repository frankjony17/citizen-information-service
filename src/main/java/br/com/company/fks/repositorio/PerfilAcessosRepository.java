package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.PerfilAcessos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilAcessosRepository extends JpaRepository<PerfilAcessos, Long>{

    PerfilAcessos findByNomePerfil(String nomePerfil);

    PerfilAcessos findById(Long id);

    List<PerfilAcessos> findAlByNomePerfilIn (List<String> nomePerfisList);
}
