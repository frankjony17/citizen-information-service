package br.com.company.fks.servico;

import br.com.company.fks.modelo.SituacaoPedido;
import br.com.company.fks.modelo.dto.SituacaoPedidoDTO;
import br.com.company.fks.repositorio.SituacaoPedidoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by christian-tavares on 21/03/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class SituacaoPedidoServiceTest {

    @InjectMocks
    private SituacaoPedidoService situacaoPedidoService;

    @Mock
    private SituacaoPedidoRepository situacaoPedidoRepository;

    @Test
    public void consultarSituacaoPedidoTest() {
        List<SituacaoPedido> situacaoPedidoList = new ArrayList<>();
        situacaoPedidoList.add(new SituacaoPedido());

        when(situacaoPedidoRepository.findAll()).thenReturn(situacaoPedidoList);

        List<SituacaoPedidoDTO> retorno = situacaoPedidoService.consultarSituacaoPedido();

        assertEquals(1, retorno.size());
    }
}
