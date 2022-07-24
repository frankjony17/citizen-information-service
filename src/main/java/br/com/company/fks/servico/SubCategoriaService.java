package br.com.company.fks.servico;

import br.com.company.fks.repositorio.SubCategoriaRepository;
import br.com.company.fks.modelo.SubCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoriaService {
    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    public List<SubCategoria> buscarTodasSubCategoria() {
        return subCategoriaRepository.findAllByDescricao();
    }

    public List<SubCategoria> buscarPorCategoria(Long idCategoria) {
        return subCategoriaRepository.findAllByCategoria(idCategoria);
    }
}