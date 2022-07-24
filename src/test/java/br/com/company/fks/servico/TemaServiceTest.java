package br.com.company.fks.servico;

import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Subtema;
import br.com.company.fks.modelo.Tema;
import br.com.company.fks.modelo.dto.ConsultaGlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.GlossarioDeAssuntoDTO;
import br.com.company.fks.modelo.dto.GlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.SubtemaDTO;
import br.com.company.fks.repositorio.PalavraChaveRepository;
import br.com.company.fks.repositorio.SubtemaRepository;
import br.com.company.fks.repositorio.TemaRepository;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 04/09/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(XSSFCell.class)
public class TemaServiceTest {
    @InjectMocks
    private TemaService temaService;

    @Mock
    private SubtemaRepository subtemaRepository;

    @Mock
    private TemaRepository temaRepository;

    @Mock
    private PalavraChaveRepository palavraChaveRepository;

    @Mock
    private GlossarioDeTemaDTO glossarioDeTemaDTO;

    @Mock
    private SubtemaDTO subtemaDTO;

    @Mock
    private Tema tema;

    @Mock
    private List<SubtemaDTO> subtemaDTOList;

    @Mock
    private List<PalavraChave> palavraChaveList;

    @Mock
    private Subtema subtema;

    @Mock
    private ConsultaGlossarioDeTemaDTO consultaGlossarioDeTemaDTO;

    @Mock
    private List<Tema> temaList;

    @Mock
    private List<Subtema> subtemaList;

    @Mock
    private PalavraChave palavraChave;

    @Mock
    private CellStyle cellStyle;

    @Mock
    private XSSFFont xssfFont;

    @Mock
    private XSSFRow xssfRow;

    @Mock
    private XSSFSheet xssfSheet;

    @Mock
    private GlossarioDeAssuntoDTO glossarioDeAssuntoDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private ByteArrayOutputStream byteArrayOutputStream;

    @Test
    public void salvar() {
        List<GlossarioDeAssuntoDTO> mockList = new ArrayList<>();
        mockList.add(mock(GlossarioDeAssuntoDTO.class));
        mockList.add(mock(GlossarioDeAssuntoDTO.class));
        mockList.add(mock(GlossarioDeAssuntoDTO.class));
        mockList.add(mock(GlossarioDeAssuntoDTO.class));
        mockList.add(mock(GlossarioDeAssuntoDTO.class));
        TemaService mockTemaService = Mockito.spy(temaService);
        mockTemaService.salvar(mockList);
        verify(mockTemaService, times(5)).seveTemaSubtemaPalavrasChaves(any(GlossarioDeAssuntoDTO.class));
    }

    @Test
    public void buscarSubTemaPorNome(){
        temaService.buscarSubTemaPorNome("teste");
    }

    @Test
    public void buscarTodasPalavrasChaves() {
        when(palavraChaveRepository.findAll()).thenReturn(palavraChaveList);
        temaService.buscarTodasPalavrasChaves();
    }

    @Test
    public void buscar() {
        when(subtemaRepository.findById(1L)).thenReturn(subtema);
        temaService.buscar(1L);
    }


    @Test
    public void buscarTodostemas() {
        when(temaRepository.findAll()).thenReturn(temaList);
        temaService.buscarTodostemas();
    }

    @Test
    public void buscarPorSubTema() {
        when(subtemaRepository.findAllByTema(1L)).thenReturn(subtemaList);
        temaService.buscarPorSubTema(1L);
    }

    @Test
    public void detalharTema() {
        when(subtemaRepository.buscarSubtemaPorId(1L)).thenReturn(subtema);
        temaService.detalharTema(1L);
    }

    @Test
    @SneakyThrows
    public void editar() {
        List<PalavraChave> palavraChaves = new ArrayList<>();
        palavraChaves.add(palavraChave);
        palavraChaves.add(palavraChave);
        when(glossarioDeTemaDTO.getId()).thenReturn(1L);
        when(subtemaRepository.findOne(1L)).thenReturn(subtema);
        when(glossarioDeTemaDTO.getNomeSubtema()).thenReturn("teste");
        when(subtemaRepository.save(subtema)).thenReturn(subtema);
        when(subtemaRepository.findOne(1L)).thenReturn(subtema);
        when(glossarioDeTemaDTO.getPalavrasChaves()).thenReturn(palavraChaves);
        temaService.editar(glossarioDeTemaDTO);
    }
    @Test
    @SneakyThrows
    public void editarPalavraChaveIdNulo() {
        List<PalavraChave> palavraChaves = new ArrayList<>();
        palavraChaves.add(palavraChave);
        palavraChaves.add(palavraChave);
        when(glossarioDeTemaDTO.getId()).thenReturn(1L);
        when(subtemaRepository.findOne(1L)).thenReturn(subtema);
        when(glossarioDeTemaDTO.getNomeSubtema()).thenReturn("teste");
        when(subtemaRepository.save(subtema)).thenReturn(subtema);
        when(subtemaRepository.findOne(1L)).thenReturn(subtema);
        when(palavraChave.getId()).thenReturn(null);
        when(glossarioDeTemaDTO.getPalavrasChaves()).thenReturn(palavraChaves);
        temaService.editar(glossarioDeTemaDTO);
    }

    @Test
    public void setStyleTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TemaService.class.getDeclaredMethod("setStyle", CellStyle.class, XSSFFont.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(temaService, cellStyle, xssfFont));
    }

    @Test
    public void setBorderTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TemaService.class.getDeclaredMethod("setBorder", CellStyle.class);
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(temaService, cellStyle));
    }

    @Test
    public void updateCellTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        XSSFCell xssfCell = PowerMockito.mock(XSSFCell.class);
        when(xssfRow.createCell(anyInt())).thenReturn(xssfCell);

        Method method = TemaService.class.getDeclaredMethod("updateCell", XSSFRow.class, CellStyle.class);
        method.setAccessible(true);
        method.invoke(temaService, xssfRow, cellStyle);
        verify(xssfRow, times(3)).createCell(anyInt());
    }

    @Test
    public void obterLinhasPalavrasChaves() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        XSSFSheet xssfSheet = mock(XSSFSheet.class);
        XSSFCell xssfCell = PowerMockito.mock(XSSFCell.class);

        when(xssfSheet.createRow(anyInt())).thenReturn(xssfRow);
        when(xssfRow.createCell(anyInt())).thenReturn(xssfCell);

        List<PalavraChave> palavras = new ArrayList<>();
        palavras.add(palavraChave);
        palavras.add(palavraChave);
        palavras.add(palavraChave);
        when(subtemaDTO.getPalavrasChaves()).thenReturn(palavras);

        Method method = TemaService.class.getDeclaredMethod("obterLinhasPalavrasChaves", int.class, XSSFSheet.class, SubtemaDTO.class, CellStyle.class);
        method.setAccessible(true);
        int rows = (int)method.invoke(temaService, 1, xssfSheet, subtemaDTO, cellStyle);

        Assert.assertEquals(4, rows);
    }

    @Test
    public void Tema() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<PalavraChave> lista = new ArrayList<>();
        lista.add(palavraChave);
        lista.add(palavraChave);

        when(subtemaRepository.findByNomeSubtema(anyString())).thenReturn(null);
        when(temaRepository.save(tema)).thenReturn(tema);
        when(subtemaDTO.getNomeSubtema()).thenReturn("nomeSubtema");
        when(subtemaDTO.getPalavrasChaves()).thenReturn(lista);

        Method method = TemaService.class.getDeclaredMethod("newTema", Tema.class, GlossarioDeAssuntoDTO.class, SubtemaDTO.class);
        method.setAccessible(true);
        Subtema sub = (Subtema)method.invoke(temaService, tema, glossarioDeAssuntoDTO, subtemaDTO);
        Assert.assertEquals("nomeSubtema", sub.getNomeSubtema());
    }

    @Test
    public void newSubTema() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<PalavraChave> lista = new ArrayList<>();
        lista.add(palavraChave);
        lista.add(palavraChave);

        when(subtemaRepository.findByNomeSubtema(anyString())).thenReturn(null);
        when(temaRepository.save(tema)).thenReturn(tema);
        when(subtemaDTO.getNomeSubtema()).thenReturn("nomeSubtema");
        when(subtemaDTO.getPalavrasChaves()).thenReturn(lista);

        Method method = TemaService.class.getDeclaredMethod("newSubtema", SubtemaDTO.class, Tema.class);
        method.setAccessible(true);
        Subtema sub = (Subtema)method.invoke(temaService, subtemaDTO, tema);
        Assert.assertEquals("nomeSubtema", sub.getNomeSubtema());
    }

    @Test
    public void newSubTemaElse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<PalavraChave> lista = new ArrayList<>();
        lista.add(palavraChave);
        lista.add(palavraChave);

        when(subtemaRepository.findByNomeSubtema(anyString())).thenReturn(subtema);
        when(temaRepository.save(tema)).thenReturn(tema);
        when(subtemaDTO.getNomeSubtema()).thenReturn("nomeSubtema");
        when(subtemaDTO.getPalavrasChaves()).thenReturn(lista);
        when(subtema.getTema()).thenReturn(tema);

        Method method = TemaService.class.getDeclaredMethod("newSubtema", SubtemaDTO.class, Tema.class);
        method.setAccessible(true);
        Subtema sub = (Subtema)method.invoke(temaService, subtemaDTO, tema);
        assertNotNull(sub.getPalavrasChaves());
    }

    @Test
    public void autosizeColumnTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = TemaService.class.getDeclaredMethod("autoSizeColumn", XSSFSheet.class);
        method.setAccessible(true);
        method.invoke(temaService, xssfSheet);
        verify(xssfSheet, times(3)).autoSizeColumn(anyInt());
    }

    @Test(expected = IllegalArgumentException.class)
    public void exportarGlossarioDeAsuntoSubtemaPalavraChaveTest() throws Exception {
        byte [] bytes = new byte[1];
        when(byteArrayOutputStream.toByteArray()).thenReturn(bytes);
        temaService.exportarGlossarioDeAsuntoSubtemaPalavraChave(consultaGlossarioDeTemaDTO);
    }

    @Test
    public void getSubtemaTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Subtema> listaSubtema = new ArrayList<>();
        listaSubtema.add(subtema);
        listaSubtema.add(subtema);
        List<SubtemaDTO> listaDTO = new ArrayList<>();
        listaDTO.add(subtemaDTO);
        when(subtema.getTema()).thenReturn(tema);
        when(tema.getNomeTema()).thenReturn("nomeTema");
        Method method = TemaService.class.getDeclaredMethod("getSubtema", List.class, List.class, Long.class);
        method.setAccessible(true);
        method.invoke(temaService, listaDTO, listaSubtema, 1L);
        Assert.assertEquals(3, listaDTO.size());
    }

}