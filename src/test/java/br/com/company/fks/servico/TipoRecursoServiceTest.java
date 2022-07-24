package br.com.company.fks.servico;

import br.com.company.fks.modelo.TipoRecurso;
import br.com.company.fks.modelo.dto.TipoRecursoDTO;
import br.com.company.fks.repositorio.TipoRecursoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 03/09/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class TipoRecursoServiceTest {
        @InjectMocks
        private TipoRecursoService tipoRecursoService;

        @Mock
        private TipoRecursoRepository tipoRecursoRepository;

        @Mock
        private List<TipoRecursoDTO> tipoRecursoDTOList;

        @Mock
        private TipoRecurso tipoRecurso;


    @Test
    public void consultaTipoRecurso() {
        List<TipoRecurso> tipoRecursos = new ArrayList<>();
        tipoRecursos.add(tipoRecurso);
        when(tipoRecursoRepository.findAll()).thenReturn(tipoRecursos);
        when(tipoRecurso.getId()).thenReturn(1L);
        when(tipoRecurso.getNome()).thenReturn("nome");
        tipoRecursoService.consultaTipoRecurso();

    }
}