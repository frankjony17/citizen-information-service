package br.com.company.fks.servico;

import br.com.company.fks.modelo.ClassificarRespostaSic;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.ClassificarRespostaSicDTO;
import br.com.company.fks.repositorio.ClassificarRespostaSicRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClassificarRespostaSicServiceTest {

    @InjectMocks
    private ClassificarRespostaSicService classificarRespostaSicService;

    @Mock
    private ClassificarRespostaSicRepository classificarRespostaSicRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private Pedido pedido;

    @Mock
    private ClassificarRespostaSic classificarRespostaSic;

    @Mock
    private ClassificarRespostaSicDTO classificarRespostaSicDTO;


    @Test
    public void salvarTestElse(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getClassificarRespostaSic()).thenReturn(classificarRespostaSic);
        when(pedido.getClassificarRespostaSic()).thenReturn(classificarRespostaSic);
        when(classificarRespostaSic.getId()).thenReturn(1L);
        when(classificarRespostaSicRepository.findById(anyLong())).thenReturn(classificarRespostaSic);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        when(classificarRespostaSicRepository.save(any(ClassificarRespostaSic.class))).thenReturn(classificarRespostaSic);
        classificarRespostaSicService.salvar(classificarRespostaSicDTO);
    }

    @Test
    public void salvarTestIf(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getClassificarRespostaSic()).thenReturn(null);
        when(classificarRespostaSic.getId()).thenReturn(1L);
        when(classificarRespostaSicRepository.findById(anyLong())).thenReturn(classificarRespostaSic);
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);
        when(classificarRespostaSicRepository.save(any(ClassificarRespostaSic.class))).thenReturn(classificarRespostaSic);
        classificarRespostaSicService.salvar(classificarRespostaSicDTO);
    }

    @Test
    public void buscarRespostaTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getRespostaEsic()).thenReturn("teste");
        classificarRespostaSicService.buscarResposta(1L);
    }

    @Test
    public void buscarClassificacaoRespostaSicTest(){
        when(classificarRespostaSicRepository.findById(anyLong())).thenReturn(classificarRespostaSic);
        classificarRespostaSicService.buscarClassificacaoRespostaSic(1L);
    }

    @Test
    @SneakyThrows
    public void EditarClassificacaoSicTest(){
        when(classificarRespostaSicRepository.save(any(ClassificarRespostaSic.class))).thenReturn(classificarRespostaSic);
        classificarRespostaSicService.editarClassificacaoSic(classificarRespostaSic);
    }

    @Test
    public void buscarClassificacaoRespostaESicTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getClassificarRespostaSic()).thenReturn(classificarRespostaSic);
        classificarRespostaSicService.buscarClassificacaoRespostaESic(1L);
    }



















}
