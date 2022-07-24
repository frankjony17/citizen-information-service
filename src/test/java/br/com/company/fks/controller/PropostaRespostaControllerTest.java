package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.servico.PropostaRespostaService;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static  org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PropostaRespostaControllerTest {
    @InjectMocks
    private PropostaRespostaController propostaRespostaController;
    @Mock
    private PropostaRespostaService propostaRespostaService;
    @Mock
    private PropostaRespostaDTO propostaRespostaDTO;
    @Mock
    private PedidoRepository pedidoRepository;


    @Test
    public void enviarTest() throws IntegracaoException {
        Mockito.doNothing().when(propostaRespostaService).enviar(any(PropostaRespostaDTO.class));
        propostaRespostaController.enviar(propostaRespostaDTO);
    }

    @Test
    public void excluirRespostaFKSTest(){
        Mockito.doNothing().when(propostaRespostaService).excluirRespostaFKS(anyLong());
        propostaRespostaController.excluirRespostaFKS(1L);
    }

    @Test
    public void buscarDadosEncaminhamento(){
        Assert.notNull(propostaRespostaController.buscarDadosEncaminhamento(1L));
    }

    @Test
    public void obterAssinatura(){
        propostaRespostaController.obterAssinatura(1L);
    }

    @Test
    public void buscarRespostaFKS(){
        Pedido pedido = new Pedido();
        pedido.setRespostaEsic("resposta teste");
        when(pedidoRepository.findById(1L)).thenReturn(pedido);
        ResponseEntity<RespostaDTO> response = propostaRespostaController.buscarRespostaFKS(1L);
        assertEquals(response.getBody().getResposta(), "resposta teste");
    }
}
