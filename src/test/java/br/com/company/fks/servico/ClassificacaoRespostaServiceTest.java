package br.com.company.fks.servico;

import br.com.company.fks.modelo.ClassificacaoResposta;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.TipoClassificacaoResposta;
import br.com.company.fks.modelo.dto.ClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.ConsultaClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.TipoClassificacaoRespostaAllDTO;
import br.com.company.fks.repositorio.ClassificacaoRespostaRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.TipoClassificacaoRespostaRepository;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 24/07/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(XSSFCell.class)
public class ClassificacaoRespostaServiceTest {
    @InjectMocks
    private ClassificacaoRespostaService classificacaoRespostaService;

    @Mock
    private ClassificacaoRespostaRepository classificacaoRespostaRepository;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClassificacaoRespostaDTO classificacaoRespostaDTO;

    @Mock
    private ClassificacaoResposta classificacaoResposta;

    @Mock
    private TipoClassificacaoResposta tipoClassificacaoResposta;

    @Mock
    private ConsultaClassificacaoRespostaDTO consultaClassificacaoRespostaDTO;

    @Mock
    private List<ClassificacaoResposta> classificacaoRespostaList;

    @Mock
    private Pedido pedido;

    @Mock
    private TipoClassificacaoRespostaAllDTO tipoClassificacaoRespostaAllDTO;

    @Mock
    private TipoClassificacaoRespostaRepository tipoClassificacaoRespostaRepository;

    @Mock
    private CellStyle cellStyle;

    @Mock
    private XSSFFont xssfFont;

    @Mock
    private XSSFRow xssfRow;

    @Mock
    private XSSFSheet xssfSheet;


    @Test
    public void salvarTest(){
        List<ClassificacaoRespostaDTO> listClassificacaoRespostas = new ArrayList<>();
        listClassificacaoRespostas.add(classificacaoRespostaDTO);
        when(classificacaoRespostaRepository.save(any(ClassificacaoResposta.class))).thenReturn(classificacaoResposta);
        when(classificacaoRespostaDTO.getTipoClassificacaoResposta()).thenReturn(tipoClassificacaoResposta);
        when(tipoClassificacaoResposta.getId()).thenReturn(1L);
        classificacaoRespostaService.salvar(listClassificacaoRespostas);
    }

    @Test
    public void excluirClassificacaoRespostaTest(){
        Mockito.doNothing().when(classificacaoRespostaRepository).delete(anyLong());
        classificacaoRespostaService.excluirClassificacaoResposta(1L);
    }

    @Test
    public void excluirClassificacaoRespostaIf(){
        classificacaoRespostaService.excluirClassificacaoResposta(null);
    }

    @Test
    public void alterarStatusClassificacaoResposta(){
        when(classificacaoRespostaRepository.findOne(1L)).thenReturn(classificacaoResposta);
        when(classificacaoRespostaRepository.save(classificacaoResposta)).thenReturn(classificacaoResposta);
        classificacaoRespostaService.alterarStatusClassificacaoResposta(1L, true);
    }


    @Test
    public void buscarClassificacaoRespostaTest(){
        when(classificacaoRespostaRepository.findById(anyLong())).thenReturn(classificacaoResposta);
        assertEquals(classificacaoRespostaService.buscarClassificacaoResposta(1L),classificacaoResposta);
    }

//    @Test
//    @SneakyThrows
//    public void consultaClassificacaoRespostaTest(){
//        List<TipoClassificacaoRespostaAllDTO> tipoClassificacaoRespostaAllDTOS = new ArrayList<>();
//        tipoClassificacaoRespostaAllDTOS.add(tipoClassificacaoRespostaAllDTO);
//        classificacaoRespostaService.consultaClassificacaoResposta(consultaClassificacaoRespostaDTO);
//    }
//
//    @Test
//    public void exportarClassificacaoResposta() throws IOException, IntegracaoException {
//        List<TipoClassificacaoRespostaAllDTO> tipoClassificacaoRespostaAllDTOS = new ArrayList<>();
//        tipoClassificacaoRespostaAllDTOS.add(tipoClassificacaoRespostaAllDTO);
//        List<ClassificacaoResposta> classificacaoRespostaList = new ArrayList<>();
//        classificacaoRespostaList.add(classificacaoResposta);
//        classificacaoRespostaList.add(1, classificacaoResposta);
//        List<TipoClassificacaoResposta> tipoClassificacaoRespostaList = new ArrayList<>();
//        tipoClassificacaoRespostaList.add(tipoClassificacaoResposta);
//        when(tipoClassificacaoRespostaAllDTO.getClassificacaoResposta()).thenReturn(classificacaoRespostaList);
//        when(tipoClassificacaoRespostaAllDTO.getDescricao()).thenReturn("descricao");
//        Assert.assertNotNull(classificacaoRespostaService.exportarClassificacaoResposta(consultaClassificacaoRespostaDTO));
//    }
//
//    @Test
//    public void exportarClassificacaoRespostaNaoentrandoNoIfeNoFor() throws IOException, IntegracaoException {
//        List<TipoClassificacaoRespostaAllDTO> tipoClassificacaoRespostaAllDTOS = new ArrayList<>();
//        tipoClassificacaoRespostaAllDTOS.add(tipoClassificacaoRespostaAllDTO);
//        List<ClassificacaoResposta> classificacaoRespostaList = new ArrayList<>();
//        List<TipoClassificacaoResposta> tipoClassificacaoRespostaList = new ArrayList<>();
//        tipoClassificacaoRespostaList.add(tipoClassificacaoResposta);
//        when(tipoClassificacaoRespostaRepository.findTipoClassificacaoResposta(1L, "nomeClassificacao")).thenReturn(tipoClassificacaoRespostaList);
//        when(tipoClassificacaoRespostaAllDTO.getClassificacaoResposta()).thenReturn(classificacaoRespostaList);
//        when(tipoClassificacaoRespostaAllDTO.getDescricao()).thenReturn("descricao");
//        Assert.assertNotNull(classificacaoRespostaService.exportarClassificacaoResposta(consultaClassificacaoRespostaDTO));
//    }


    @Test
    @SneakyThrows
    public void EditarTest(){
        when(classificacaoRespostaRepository.findById(1L)).thenReturn(classificacaoResposta);
        when(classificacaoRespostaDTO.getId()).thenReturn(1L);
        when(classificacaoRespostaDTO.getDescricao()).thenReturn("descricao");
        when(classificacaoRespostaDTO.getTipoClassificacaoResposta()).thenReturn(tipoClassificacaoResposta);
        when(classificacaoRespostaRepository.save(any(ClassificacaoResposta.class))).thenReturn(classificacaoResposta);
        classificacaoRespostaService.editar(classificacaoRespostaDTO);
    }

    @Test
    public void buscarTodasOrientacaoSolicitacaoTest(){
        when(classificacaoRespostaRepository.findAllByDescricaoSolicitante()).thenReturn(classificacaoRespostaList);
        classificacaoRespostaService.buscarTodasOrientacaoSolicitacao();
    }

    @Test
    public void buscarTodasTransparenciaAtivaTest(){
        when(classificacaoRespostaRepository.findAllByDescricaoTranparenciaAtiva()).thenReturn(classificacaoRespostaList);
        classificacaoRespostaService.buscarTodasTransparenciaAtiva();
    }

    @Test
    public void buscarTodasTransparenciaPassivaTest(){
        when(classificacaoRespostaRepository.findAllByDescricaoTranparenciaPassiva()).thenReturn(classificacaoRespostaList);
        classificacaoRespostaService.buscarTodasTransparenciaPassiva();
    }


    @Test
    public void buscarTodasAcessoNegadoTest(){
        when(classificacaoRespostaRepository.findAllByDescricaoAcessoNegado()).thenReturn(classificacaoRespostaList);
        classificacaoRespostaService.buscarTodasAcessoNegado();
    }

    @Test
    public void buscarRespostaClassificadaTest(){
        when(pedidoRepository.findById(anyLong())).thenReturn(pedido);
        when(pedido.getClassificacaoResposta()).thenReturn(classificacaoRespostaList);
        classificacaoRespostaService.buscarRespostaClassificada(1L);
    }

    @Test
    public void setHeaderStyle() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ClassificacaoRespostaService.class.getDeclaredMethod("setHeaderStyle", CellStyle.class, XSSFFont.class);
        method.setAccessible(true);
        CellStyle estilo = (CellStyle)method.invoke(classificacaoRespostaService, cellStyle, xssfFont);
        assertNotNull(estilo);
    }

    @Test
    public void setBorderStyle() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = ClassificacaoRespostaService.class.getDeclaredMethod("setBorderStyle", CellStyle.class);
        method.setAccessible(true);
        CellStyle estilo = (CellStyle)method.invoke(classificacaoRespostaService, cellStyle);
        assertNotNull(estilo);
    }

    @Test
    public void updateCell() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        XSSFCell xssfCell = PowerMockito.mock(XSSFCell.class);
        when(xssfRow.createCell(anyInt())).thenReturn(xssfCell);
        Method method = ClassificacaoRespostaService.class.getDeclaredMethod("updateCell", XSSFRow.class, CellStyle.class);
        method.setAccessible(true);
        method.invoke(classificacaoRespostaService, xssfRow,cellStyle);
        verify(xssfRow, times(2)).createCell(anyInt());
    }

    @Test
    public void obterLinhas() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        XSSFCell cell = PowerMockito.mock(XSSFCell.class);
        List<ClassificacaoResposta> lista = new ArrayList<>();
        lista.add(classificacaoResposta);
        lista.add(classificacaoResposta);
        lista.add(classificacaoResposta);

        when(xssfSheet.createRow(anyInt())).thenReturn(xssfRow);
        when(xssfRow.createCell(anyInt())).thenReturn(cell);
        when(tipoClassificacaoRespostaAllDTO.getDescricao()).thenReturn("descricao");
        when(classificacaoResposta.getDescricao()).thenReturn("descricao");
        when(tipoClassificacaoRespostaAllDTO.getClassificacaoResposta()).thenReturn(lista);

        Method method = ClassificacaoRespostaService.class.getDeclaredMethod("obterLinhas", int.class, XSSFSheet.class, TipoClassificacaoRespostaAllDTO.class, CellStyle.class);
        method.setAccessible(true);
        int row = (int)method.invoke(classificacaoRespostaService, 3, xssfSheet, tipoClassificacaoRespostaAllDTO, cellStyle);

        Assert.assertEquals(6, row);
    }
}