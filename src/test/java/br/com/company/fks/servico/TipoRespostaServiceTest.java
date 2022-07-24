package br.com.company.fks.servico;

import br.com.company.fks.modelo.TipoResposta;
import br.com.company.fks.repositorio.TipoRespostaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 25/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class TipoRespostaServiceTest {

    @InjectMocks
    private TipoRespostaService tipoRespostaService;

    @Mock
    private TipoRespostaRepository tipoRespostaRepository;

    @Mock
    private List<TipoResposta> tipoRespostaList;

    @Test
    public void buscarTodasDescricaoTipoRespostaTest(){
        when(tipoRespostaRepository.findAllOrderByDescricao()).thenReturn(tipoRespostaList);
        tipoRespostaService.buscarTodasDescricaoTipoResposta();
    }
}
