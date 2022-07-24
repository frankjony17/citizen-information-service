package br.com.company.fks.servico;

import br.com.company.fks.modelo.TipoClassificacaoResposta;
import br.com.company.fks.repositorio.TipoClassificacaoRespostaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class TipoClassificacaoRespostaServiceTest {
    @InjectMocks
    private TipoClassificacaoRespostaService tipoClassificacaoRespostaService;

    @Mock
    private TipoClassificacaoRespostaRepository tipoClassificacaoRespostaRepository;

    @Mock
    private  TipoClassificacaoResposta tipoClassificacaoResposta;

    @Mock
    private List<TipoClassificacaoResposta> tipoClassificacaoRespostas;

    @Test
    public void salvarTipoClassificacaoRespostaTest(){
        when(tipoClassificacaoRespostaRepository.save(any(TipoClassificacaoResposta.class))).thenReturn(tipoClassificacaoResposta);
        tipoClassificacaoRespostaService.salvarTipoClassificacaoResposta(tipoClassificacaoResposta);
    }

    @Test
    public void buscarTodosTiposClassificacaoRespostaTest(){
        when(tipoClassificacaoRespostaRepository.findAllOrderByNome()).thenReturn(tipoClassificacaoRespostas);
        tipoClassificacaoRespostaService.buscarTodosTiposClassificacaoResposta();
    }
}
