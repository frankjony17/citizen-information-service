package br.com.company.fks.servico;

import br.com.company.fks.modelo.MotivoProrrogacao;
import br.com.company.fks.modelo.dto.MotivoProrrogacaoDTO;
import br.com.company.fks.repositorio.MotivoProrrogacaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MotivoProrrogacaoServiceTest {
    @InjectMocks
    private MotivoProrrogacaoService motivoProrrogacaoService;
    @Mock
    private MotivoProrrogacaoRepository motivoProrrogacaoRepository;
    @Mock
    private List<MotivoProrrogacaoDTO> motivoProrrogacaoDTOList;

    @Test
    public void consultarMotivoProrrogacaoTest(){
        List<MotivoProrrogacao> motivoProrrogacaoList = new ArrayList<>();
        motivoProrrogacaoList.add(new MotivoProrrogacao());
        when(motivoProrrogacaoRepository.findAll()).thenReturn(motivoProrrogacaoList);
        List<MotivoProrrogacaoDTO> retorno = motivoProrrogacaoService.consultarMotivoProrrogacao();
        assertEquals(1,retorno.size());
    }


}
