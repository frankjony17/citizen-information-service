package br.com.company.fks.controller;

import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.RespostaAssinadaDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.RespostaAssinadaService;
import br.com.company.fks.utils.EntityConverter;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RespostaAssinadaControllerTest {
    @InjectMocks
     private  RespostaAssinadaController respostaAssinadaController;
    @Mock
    private RespostaAssinadaService respostaAssinadaService;
    @Mock
    private RespostaAssinadaDTO respostaAssinadaDTO;
    @Mock
    private RespostaDTO respostaDTO;
    @Mock
    private EntityConverter entityConverter;
    @Mock
    private Pedido pedido;

    @Test
    public void enviarTest(){
        Mockito.doNothing().when(respostaAssinadaService).enviar(respostaAssinadaDTO);
        respostaAssinadaController.enviar(respostaAssinadaDTO);
    }

    @Test
    public void salvarTest(){
        Mockito.doNothing().when(respostaAssinadaService).salvar(respostaAssinadaDTO);
        respostaAssinadaController.salvar(respostaAssinadaDTO);
    }

    @Test
    public void buscarRespostaTest(){
        when(respostaAssinadaService.buscarResposta(anyLong())).thenReturn(respostaDTO);
        respostaAssinadaController.buscarResposta(1L);
    }

    @Test
    @SneakyThrows
    public void editarFeriadoFKSTestTry(){
        when(entityConverter.converterStrict(respostaAssinadaDTO,Pedido.class)).thenReturn(pedido);
        Mockito.doNothing().when(respostaAssinadaService).editarResposta(respostaAssinadaDTO);
        respostaAssinadaController.editarFeriadoFKS(respostaAssinadaDTO);
    }

    @Test
    @SneakyThrows
    public void editarFeriadoFKSTestCatch(){
        when(entityConverter.converterStrict(respostaAssinadaDTO,Pedido.class)).thenReturn(pedido);
        Mockito.doThrow(IntegracaoException.class).when(respostaAssinadaService).editarResposta(respostaAssinadaDTO);
        respostaAssinadaController.editarFeriadoFKS(respostaAssinadaDTO);
    }

    @Test
    public void buscarDadosEncaminhamento() {
        when(respostaAssinadaService.buscarDadosEncaminhamento(anyLong())).thenReturn(respostaAssinadaDTO);
        ResponseEntity<RespostaAssinadaDTO> response = respostaAssinadaController.buscarDadosEncaminhamento(1L);
        Assert.assertNotNull(response);
    }

}
