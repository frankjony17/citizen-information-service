package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.Feriado;
import br.com.company.fks.modelo.dto.FeriadoDTO;
import br.com.company.fks.modelo.dto.ConsultaFeriadoDTO;
import br.com.company.fks.servico.FeriadoService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class,ObjectMapperException.class})

public class FeriadoControllerTest {
    @InjectMocks
    private FeriadoController feriadoController;
    @Mock
    private FeriadoService feriadoService;
    @Mock
    private Feriado feriado;
    @Mock
    private EntityConverter entityConverter;
    @Mock
    private FeriadoDTO feriadoDTO;
    @Mock
    private ConsultaFeriadoDTO consultaFeriadoDTO;
    @Mock
    private ControllerUtil controllerUtil;
    @Mock
    private Resposta<List<FeriadoDTO>> cadastrolist;

    @Test
    public void salvarTest() throws IntegracaoException {
        when(entityConverter.converterStrict(feriadoDTO,Feriado.class)).thenReturn(feriado);
        Mockito.doThrow(IntegracaoException.class).when(feriadoService).salvar(any(Feriado.class));
        feriadoController.salvar(feriadoDTO);
    }
    @Test
    public void salvarTest2() throws IntegracaoException {
        when(entityConverter.converterStrict(feriadoDTO,Feriado.class)).thenReturn(feriado);
        Mockito.doNothing().when(feriadoService).salvar(any(Feriado.class));
        feriadoController.salvar(feriadoDTO);
    }

    @Test
    public void consultarFeriadoTest() throws ObjectMapperException, IntegracaoException {

        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("Consultar",ConsultaFeriadoDTO.class)).thenReturn(consultaFeriadoDTO);
        when(feriadoService.consultarFeriado(any(ConsultaFeriadoDTO.class))).thenReturn(cadastrolist);
        feriadoController.consultarFeriado("teste");

    }
    @Test
    public void consultarFeriadoTestCatch()throws ObjectMapperException, IntegracaoException{
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("Consultar",ConsultaFeriadoDTO.class)).thenReturn(consultaFeriadoDTO);
        Mockito.doThrow(IntegracaoException.class).when(feriadoService).consultarFeriado(any(ConsultaFeriadoDTO.class));
        feriadoController.consultarFeriado("teste");
    }

    @Test
    public void consultarFeriadoTestCatch2()throws ObjectMapperException, IntegracaoException {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("Consultar",ConsultaFeriadoDTO.class)).thenReturn(consultaFeriadoDTO);
        Mockito.doThrow(ObjectMapperException.class).when(feriadoService).consultarFeriado(any(ConsultaFeriadoDTO.class));
        feriadoController.consultarFeriado("teste");

    }

    @Test
    public void buscarFeriadoTest(){
        when(feriadoService.buscarFeriado(anyLong())).thenReturn(feriadoDTO);
        feriadoController.buscarFeriado(5L);
    }

    @Test
    public void deletarFeriadoTest(){
        Mockito.doNothing().when(feriadoService).deletarFeriado(anyLong());
        feriadoController.deletarFeriado(4L);
    }

    @Test
    public void editarFeriadoFKSTest() throws IntegracaoException {
        when(entityConverter.converterStrict(feriadoDTO, Feriado.class)).thenReturn(feriado);
        Mockito.doNothing().when(feriadoService).editarFeriadoFKS(any(Feriado.class));
        feriadoController.editarFeriadoFKS(feriadoDTO);

    }
    @Test
    public void editarFeriadoFKSTestCatch()throws IntegracaoException {
        when(entityConverter.converterStrict(feriadoDTO, Feriado.class)).thenReturn(feriado);
        Mockito.doThrow(IntegracaoException.class).when(feriadoService).editarFeriadoFKS(any(Feriado.class));
        feriadoController.editarFeriadoFKS(feriadoDTO);
    }

}
