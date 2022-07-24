package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.ClassificacaoRespostaRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.TipoClassificacaoRespostaRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.ClassificacaoResposta;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.TipoClassificacaoResposta;
import br.com.company.fks.modelo.dto.ClassificacaoRespostaDTO;
import br.com.company.fks.modelo.dto.TipoClassificacaoRespostaAllDTO;
import br.com.company.fks.modelo.dto.ConsultaClassificacaoRespostaDTO;
import br.com.company.fks.utils.Constants;
import br.com.company.fks.utils.ExceptionsUtil;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificacaoRespostaService {

    @Autowired
    private ClassificacaoRespostaRepository classificacaoRespostaRepository;

    @Autowired
    private TipoClassificacaoRespostaRepository tipoClassificacaoRespostaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void salvar(List<ClassificacaoRespostaDTO> listaClassificacaoRespostaDTO) {
        listaClassificacaoRespostaDTO.forEach(cr -> {
            ClassificacaoResposta classificacaoResposta = new ClassificacaoResposta();
            classificacaoResposta.setId(cr.getId());
            classificacaoResposta.setTipoClassificacaoResposta(new TipoClassificacaoResposta());
            classificacaoResposta.getTipoClassificacaoResposta().setId(cr.getTipoClassificacaoResposta().getId());
            classificacaoResposta.setDescricao(cr.getDescricao());
            classificacaoResposta.setStatusClassificacaoResposta(true);
            classificacaoRespostaRepository.save(classificacaoResposta);
        });
    }

    @Transactional
    public void editar(ClassificacaoRespostaDTO classificacaoRespostaDTO) {
        ClassificacaoResposta classificacaoResposta = classificacaoRespostaRepository.findById(classificacaoRespostaDTO.getId());
        classificacaoResposta.setDescricao(classificacaoRespostaDTO.getDescricao());
        classificacaoResposta.setTipoClassificacaoResposta(classificacaoRespostaDTO.getTipoClassificacaoResposta());
        classificacaoRespostaRepository.save(classificacaoResposta);
    }

    public void excluirClassificacaoResposta(Long id) {
        if (id != null) {
            classificacaoRespostaRepository.delete(id);
        }
    }

    public void alterarStatusClassificacaoResposta(Long id, boolean status) {
        ClassificacaoResposta classificacaoResposta = classificacaoRespostaRepository.findOne(id);
        classificacaoResposta.setStatusClassificacaoResposta(status);
        classificacaoRespostaRepository.save(classificacaoResposta);
    }

    public ClassificacaoResposta buscarClassificacaoResposta(Long id) {
        return classificacaoRespostaRepository.findById(id);
    }

    public Resposta<List<TipoClassificacaoRespostaAllDTO>> consultaClassificacaoResposta(ConsultaClassificacaoRespostaDTO parms) throws IntegracaoException {
        Resposta<List<TipoClassificacaoRespostaAllDTO>> resposta = new Resposta<>();
        resposta.setResultado(obterTipoClassificacaoRespostaDto(parms));
        resposta.setTotalElementos(tipoClassificacaoRespostaRepository.countTipoClassificacaoResposta(parms.getIdTipoClassificacaoResposta(), parms.getNomeClassificacao()));
        return resposta;
    }

    private List<TipoClassificacaoRespostaAllDTO> obterTipoClassificacaoRespostaDto(ConsultaClassificacaoRespostaDTO parms) {
        List<TipoClassificacaoRespostaAllDTO> tipoClassificacaoRespostaList = new ArrayList<>();
        tipoClassificacaoRespostaRepository.findTipoClassificacaoResposta(parms.getIdTipoClassificacaoResposta(), parms.getNomeClassificacao(), new PageRequest(parms.getOffset(), parms.getLimit())).forEach(t -> {
            TipoClassificacaoRespostaAllDTO dto = new TipoClassificacaoRespostaAllDTO();
            dto.setId(t.getId());
            dto.setDescricao(t.getDescricao());
            dto.setClassificacaoResposta(t.getClassificacaoRespostas());
            tipoClassificacaoRespostaList.add(dto);
        });
        return tipoClassificacaoRespostaList;
    }

    public List<ClassificacaoResposta> buscarTodasOrientacaoSolicitacao (){
        return classificacaoRespostaRepository.findAllByDescricaoSolicitante();
    }

    public List<ClassificacaoResposta> buscarTodasTransparenciaAtiva (){
        return classificacaoRespostaRepository.findAllByDescricaoTranparenciaAtiva();
    }

    public List<ClassificacaoResposta> buscarTodasTransparenciaPassiva (){
        return classificacaoRespostaRepository.findAllByDescricaoTranparenciaPassiva();
    }

    public List<ClassificacaoResposta> buscarTodasAcessoNegado (){
        return classificacaoRespostaRepository.findAllByDescricaoAcessoNegado();
    }

    public List<ClassificacaoResposta> buscarRespostaClassificada(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        List<ClassificacaoResposta> classificacaoRespostaList = new ArrayList<>();
        pedido.getClassificacaoResposta().forEach(cr -> classificacaoRespostaList.add(classificacaoRespostaRepository.findById(cr.getId())));
        return classificacaoRespostaList;
    }

    public byte[] exportarClassificacaoResposta(ConsultaClassificacaoRespostaDTO parms) throws IntegracaoException, IOException {
        List<TipoClassificacaoRespostaAllDTO> tipoClassificacaoRespostaAllDTOS = obterTipoClassificacaoRespostaDto(parms);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Consultar Classificação Resposta");
        XSSFFont headerFont = xssfWorkbook.createFont();
        headerFont.setBold(true);
        CellStyle headerStyle = xssfWorkbook.createCellStyle();
        setHeaderStyle(headerStyle, headerFont);
        CellStyle borderStyle = xssfWorkbook.createCellStyle();
        setBorderStyle(borderStyle);
        XSSFRow xssfRow = xssfSheet.createRow(Constants.ZERO);
        updateCell(xssfRow, headerStyle);
        criarLinhasPlanilha(xssfSheet, tipoClassificacaoRespostaAllDTOS, borderStyle);
        xssfSheet.autoSizeColumn(Constants.ZERO);
        xssfSheet.autoSizeColumn(Constants.UM);
        ExceptionsUtil.exceptionXssf(byteArrayOutputStream, xssfWorkbook);
        return byteArrayOutputStream.toByteArray();
    }

    private CellStyle setHeaderStyle (CellStyle headerStyle, XSSFFont headerFont) {
        headerStyle.setFillBackgroundColor(IndexedColors.CORAL.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        return headerStyle;
    }

    private CellStyle setBorderStyle (CellStyle borderStyle) {
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return borderStyle;
    }

    private void updateCell (XSSFRow xssfRow, CellStyle headerStyle) {
        Cell cell = xssfRow.createCell(Constants.ZERO);
        cell.setCellValue("Tipo Classificação Resposta");
        cell.setCellStyle(headerStyle);
        cell = xssfRow.createCell(Constants.UM);
        cell.setCellValue("Classificação Resposta");
        cell.setCellStyle(headerStyle);
    }

    private void criarLinhasPlanilha(XSSFSheet xssfSheet, List<TipoClassificacaoRespostaAllDTO> tipoClassificacaoRespostaAllDTOS, CellStyle borderStyle) {
        int row = Constants.UM;
        for (TipoClassificacaoRespostaAllDTO tipoClassificacaoRespostaDTO : tipoClassificacaoRespostaAllDTOS) {
            row = obterLinhas(row, xssfSheet, tipoClassificacaoRespostaDTO, borderStyle);
            if (tipoClassificacaoRespostaDTO.getClassificacaoResposta().size() > 1) {
                xssfSheet.addMergedRegion(new CellRangeAddress(row - tipoClassificacaoRespostaDTO.getClassificacaoResposta().size(), row - 1, 0, 0));
            }
        }
    }

    private int obterLinhas(int r, XSSFSheet xssfSheet, TipoClassificacaoRespostaAllDTO tipoClassificacaoRespostaDTO, CellStyle borderStyle) {
        int row = r;
        for (ClassificacaoResposta classificacaoResposta : tipoClassificacaoRespostaDTO.getClassificacaoResposta()) {
            Cell cell;
            XSSFRow xssfRow = xssfSheet.createRow(row);
            cell = xssfRow.createCell(Constants.ZERO);
            cell.setCellValue(tipoClassificacaoRespostaDTO.getDescricao());
            cell.setCellStyle(borderStyle);
            cell = xssfRow.createCell(Constants.UM);
            cell.setCellValue(classificacaoResposta.getDescricao());
            cell.setCellStyle(borderStyle);
            row += 1;
        }
        return row;
    }
}
