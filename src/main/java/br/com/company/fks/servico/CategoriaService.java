package br.com.company.fks.servico;

import br.com.company.fks.repositorio.CategoriaRepository;
import br.com.company.fks.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodasDescricaoCategoria() {
        return categoriaRepository.findAllOrderByDescricao();
    }
}
