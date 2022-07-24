package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Feriado;
import br.com.company.fks.modelo.dto.ConsultaFeriadoDTO;
import br.com.company.fks.modelo.dto.FeriadoDTO;
import br.com.company.fks.repositorio.FeriadoRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@Slf4j
@PrepareForTest(Calendar.class)
public class FeriadoServiceTest {
    @InjectMocks
    private FeriadoService feriadoService;
    @Mock
    private FeriadoRepository feriadoRepository;
    @Mock
    private Feriado feriado;
    @Mock
    private FeriadoDTO feriadoDTO;
    @Mock
    private ConsultaFeriadoDTO consultaFeriadoDTO;
    @Mock
    private Resposta<List<FeriadoDTO>> cadastrarFeriadoDTOListResposta;
    @Mock
    private List<FeriadoDTO> feriadoDTOList;
    @Mock
    private Page<FeriadoDTO> feriadoDTOPage;
    @Mock
    private List<Calendar> calendarList;
    @Mock
    private Calendar calendar;

    @Test
    public void deletarFeriadoTest() {
        feriadoService.deletarFeriado(1L);
    }

    @Test
    public void listaFeriadosFKSTest() {
        List<Calendar> teste = feriadoService.listaFeriadosFKS();
        assertNotNull(teste);
    }

    @Test
    public void testeEditarFeriado() throws IntegracaoException {
        feriadoService.editarFeriadoFKS(feriado);

    }


    @Test(expected = IntegracaoException.class)
    public void testeSalvarFeriado() throws IntegracaoException {
        List<Feriado> feriadoList = new ArrayList<>();
        when(feriadoRepository.findAll()).thenReturn(feriadoList);
        feriadoList.add(feriado);
        PowerMockito.mockStatic(Calendar.class);
        when(feriado.getDataFeriado()).thenReturn(calendar);
        when(calendar.get(calendar.DAY_OF_MONTH)).thenReturn(5);
        when(calendar.get(calendar.MONTH)).thenReturn(2);
        when(calendar.get(calendar.YEAR)).thenReturn(1);
        when(feriadoRepository.save(any(Feriado.class))).thenReturn(feriado);
        feriadoService.salvar(feriado);
    }

    @Test
    @SneakyThrows
    public void TestesalvarFeriadoUsandoDataNova() {
        when(feriadoRepository.save(any(Feriado.class))).thenReturn(feriado);
        feriadoService.salvar(feriado);
    }

    @Ignore
    @Test
    @SneakyThrows
    public void consultarFeriadoTest() {
        List<Feriado> content = new ArrayList<>();
        Pageable pageable = mock(Pageable.class);
        Page<Feriado> page = new PageImpl<Feriado>(content, pageable, 10L);

        when(consultaFeriadoDTO.getOffset()).thenReturn(10);
        when(consultaFeriadoDTO.getLimit()).thenReturn(20);

        when(consultaFeriadoDTO.getPeriodoInicialFeriado()).thenReturn(calendar);
        when(consultaFeriadoDTO.getPeriodoFinalFeriado()).thenReturn(calendar);
        when(feriadoRepository.findFeriados(eq(calendar), eq(calendar), eq(pageable))).thenReturn(page);
        Resposta<List<FeriadoDTO>> resposta = feriadoService.consultarFeriado(consultaFeriadoDTO);

        Assert.assertTrue(resposta.getResultado().isEmpty());
    }

    @Test
    @SneakyThrows
    public void buscarFeriadoTest() {
        PowerMockito.whenNew(FeriadoDTO.class).withAnyArguments().thenReturn(feriadoDTO);
        when(feriadoRepository.findOne(anyLong())).thenReturn(feriado);
        feriadoService.buscarFeriado(1L);
    }


}
