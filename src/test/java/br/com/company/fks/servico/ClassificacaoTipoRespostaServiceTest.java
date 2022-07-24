package br.com.company.fks.servico;

import br.com.company.fks.modelo.ClassificacaoTipoResposta;
import br.com.company.fks.repositorio.ClassificacaoTipoRespostaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClassificacaoTipoRespostaServiceTest {
    @InjectMocks
    private ClassificacaoTipoRespostaService classificacaoTipoRespostaService;

    @Mock
    private ClassificacaoTipoRespostaRepository classificacaoTipoRespostaRepository;
    @Mock
    private List<ClassificacaoTipoResposta>  classificacaoTipoRespostaList;

    @Test
    public void buscarTodasClassificacaoTipoRespostaTest(){
        when(classificacaoTipoRespostaRepository.findAllByDescricao()).thenReturn(classificacaoTipoRespostaList);
        classificacaoTipoRespostaService.buscarTodasClassificacaoTipoResposta();
    }
    @Test
    public void  buscarPorTipoRespostaTest(){
        when(classificacaoTipoRespostaRepository.findAllByTipoResposta(anyLong())).thenReturn(classificacaoTipoRespostaList);
        classificacaoTipoRespostaService.buscarPorTipoResposta(1L);
    }
}
