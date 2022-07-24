package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.PalavraChaveRepository;
import br.com.company.fks.repositorio.SubtemaRepository;
import br.com.company.fks.repositorio.TemaRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.PalavraChave;
import br.com.company.fks.modelo.Subtema;
import br.com.company.fks.modelo.Tema;
import br.com.company.fks.modelo.dto.GlossarioDeAssuntoDTO;
import br.com.company.fks.modelo.dto.GlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.SubtemaDTO;
import br.com.company.fks.modelo.dto.ConsultaGlossarioDeTemaDTO;
import br.com.company.fks.modelo.dto.AsuntoSubtemaPalavraChaveDTO;
import br.com.company.fks.modelo.dto.TemaDTO;
import br.com.company.fks.utils.Constants;
import br.com.company.fks.utils.ExceptionsUtil;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemaService {

    private static final String SUBTEMA_EXIST_FOR_OTHER_TEMA = "SUBTEMA-EXIST-FOR-OTHER-TEMA";
    @Autowired
    private SubtemaRepository subtemaRepository;

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private PalavraChaveRepository palavraChaveRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void salvar(List<GlossarioDeAssuntoDTO> glossarioAssuntoDTOList) {
        for (GlossarioDeAssuntoDTO temaSubPalCh : glossarioAssuntoDTOList)  {
            seveTemaSubtemaPalavrasChaves(temaSubPalCh);
        }
    }

    @Transactional
    public void editar(GlossarioDeTemaDTO glossarioDeTemaDTO) {
        Subtema subtema = subtemaRepository.findByNomeSubtemaDiferenteId(glossarioDeTemaDTO.getNomeSubtema(), glossarioDeTemaDTO.getId());
        if (subtema == null) {
            subtema = subtemaRepository.findOne(glossarioDeTemaDTO.getId());
            subtema.setNomeSubtema(glossarioDeTemaDTO.getNomeSubtema());
            subtemaRepository.save(subtema);
            List<PalavraChave> listaPalavraChave = glossarioDeTemaDTO.getPalavrasChaves();
            while (!subtema.getPalavrasChaves().isEmpty()) {
                subtema.getPalavrasChaves().remove(0);
            }
            for (PalavraChave palavraChave : listaPalavraChave) {
                subtema.getPalavrasChaves().add(palavraChave);
            }
        } else {
            throw new DataIntegrityViolationException(SUBTEMA_EXIST_FOR_OTHER_TEMA);
        }
        subtemaRepository.save(subtema);
    }

    public void seveTemaSubtemaPalavrasChaves (GlossarioDeAssuntoDTO temaSubPalCh) {
        Tema tema = buscarTemaPorNome(temaSubPalCh.getNomeTema());
        for (SubtemaDTO sub : temaSubPalCh.getSubtemas()) {
            Subtema subtema;
            if (tema==null) {
                tema = new Tema();
                subtema = newTema (tema, temaSubPalCh, sub);
            } else {
                subtema = newSubtema(sub, tema);
            }
            subtemaRepository.save(subtema);
        }
    }

    private Subtema newTema (Tema tema, GlossarioDeAssuntoDTO temaSubPalCh, SubtemaDTO sub) {
        Subtema subtema = buscarSubTemaPorNome(sub.getNomeSubtema());
        if (subtema==null) {
            tema.setNomeTema(temaSubPalCh.getNomeTema());
            Tema temaSalvo = temaRepository.save(tema);
            subtema = new Subtema();
            subtema.setNomeSubtema(sub.getNomeSubtema());
            subtema.setTema(temaSalvo);
            subtema.setPalavrasChaves(sub.getPalavrasChaves());
        } else {
            throw new DataIntegrityViolationException(SUBTEMA_EXIST_FOR_OTHER_TEMA);
        }
        return subtema;
    }

    private Subtema  newSubtema (SubtemaDTO sub, Tema tema) {
        Subtema subtema = buscarSubTemaPorNome(sub.getNomeSubtema());
        if (subtema==null) {
            subtema = new Subtema();
            subtema.setNomeSubtema(sub.getNomeSubtema());
            subtema.setTema(tema);
            subtema.setPalavrasChaves(sub.getPalavrasChaves());
        } else {
            if (subtema.getTema() == tema) {
                subtema.setPalavrasChaves(sub.getPalavrasChaves());
            } else {
                throw new DataIntegrityViolationException(SUBTEMA_EXIST_FOR_OTHER_TEMA);
            }
        }
        return subtema;
    }

    private Tema buscarTemaPorNome(String nomeTema){
        return temaRepository.findByNomeTema(nomeTema);
    }

    public Subtema buscarSubTemaPorNome(String nomeSubtema){
        return subtemaRepository.findByNomeSubtema(nomeSubtema);
    }

    public List<PalavraChave> buscarTodasPalavrasChaves(){
        return palavraChaveRepository.findAll();
    }

    public Subtema buscar(Long id) {
        return subtemaRepository.findById(id);
    }

    public Resposta<List<AsuntoSubtemaPalavraChaveDTO>> filtrarGlossarioDeTemas(ConsultaGlossarioDeTemaDTO parms) {
        List<AsuntoSubtemaPalavraChaveDTO> dtoList = new ArrayList<>();
        Resposta<List<AsuntoSubtemaPalavraChaveDTO>> resposta = new Resposta<>();

        temaRepository.findGlossarioDeTemas(parms.getIdTema(), parms.getNomeSubtema(), new PageRequest(parms.getOffset(), parms.getLimit())).forEach(t -> {
            AsuntoSubtemaPalavraChaveDTO dto = new AsuntoSubtemaPalavraChaveDTO();
            TemaDTO temaDto = new TemaDTO();
            BeanUtils.copyProperties(t, temaDto);
            dto.setTema(temaDto);
            dto.setSubtema(obterSubtemaDto(t.getSubtemas(), parms.getNomeSubtema(), parms.getIdPalavraChave()));
            dtoList.add(dto);
        });
        resposta.setResultado(dtoList);
        resposta.setTotalElementos(temaRepository.countGlossarioDeTemas(parms.getIdTema(), parms.getNomeSubtema()));
        return resposta;
    }

    public byte[] exportarGlossarioDeAsuntoSubtemaPalavraChave(ConsultaGlossarioDeTemaDTO consultaGlossarioDeTemaDTO) throws IntegracaoException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        try {
            Resposta<List<AsuntoSubtemaPalavraChaveDTO>> resposta = filtrarGlossarioDeTemas(consultaGlossarioDeTemaDTO);
            XSSFSheet xssfSheet = xssfWorkbook.createSheet("Consulta Glossário de Assuntos");
            XSSFFont headerFont = xssfWorkbook.createFont();
            headerFont.setBold(true);
            CellStyle headerStyle = setStyle(xssfWorkbook.createCellStyle(), headerFont);
            CellStyle borderStyle = setBorder(xssfWorkbook.createCellStyle());
            XSSFRow xssfRow = xssfSheet.createRow(Constants.ZERO);
            updateCell(xssfRow, headerStyle);
            criarLinhasPlanilha(xssfSheet, resposta.getResultado(), borderStyle);
            autoSizeColumn(xssfSheet);
            ExceptionsUtil.exceptionXssf(byteArrayOutputStream, xssfWorkbook);
        } finally {
            xssfWorkbook.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void autoSizeColumn (XSSFSheet xssfSheet) {
        xssfSheet.autoSizeColumn(Constants.ZERO);
        xssfSheet.autoSizeColumn(Constants.UM);
        xssfSheet.autoSizeColumn(Constants.DOIS);
    }

    private CellStyle setStyle (CellStyle headerStyle, XSSFFont headerFont) {
        headerStyle.setFillBackgroundColor(IndexedColors.CORAL.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        return headerStyle;
    }

    private CellStyle setBorder (CellStyle borderStyle) {
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return borderStyle;
    }

    private void updateCell (XSSFRow xssfRow, CellStyle headerStyle) {
        Cell cell = xssfRow.createCell(Constants.ZERO);
        cell.setCellValue("Assunto");
        cell.setCellStyle(headerStyle);
        cell = xssfRow.createCell(Constants.UM);
        cell.setCellValue("Subassunto");
        cell.setCellStyle(headerStyle);
        cell = xssfRow.createCell(Constants.DOIS);
        cell.setCellValue("Palavras-chave");
        cell.setCellStyle(headerStyle);
    }

    private void criarLinhasPlanilha(XSSFSheet xssfSheet, List<AsuntoSubtemaPalavraChaveDTO> asuntoSubtemaPalavraChaveDTOS, CellStyle borderStyle) {
        int lastRow = Constants.UM;
        int row = Constants.UM;
        for (AsuntoSubtemaPalavraChaveDTO asuntoSubtemaPalavraChaveDTO : asuntoSubtemaPalavraChaveDTOS) {
            row = obterLinhasSubtemas(row, xssfSheet, asuntoSubtemaPalavraChaveDTO, borderStyle);
            if (asuntoSubtemaPalavraChaveDTO.getSubtema().size() > 1) {
                xssfSheet.addMergedRegion(new CellRangeAddress(lastRow,row - 1, 0, 0));
            }
            lastRow = row;
        }
    }

    private int obterLinhasSubtemas(int r, XSSFSheet xssfSheet, AsuntoSubtemaPalavraChaveDTO asuntoSubtemaPalavraChaveDTO, CellStyle borderStyle) {
        int row = r;
        for (SubtemaDTO subtemaDTO : asuntoSubtemaPalavraChaveDTO.getSubtema()) {
            row = obterLinhasPalavrasChaves(row, xssfSheet, subtemaDTO, borderStyle);
            if (subtemaDTO.getPalavrasChaves().size() > 1) {
                xssfSheet.addMergedRegion(new CellRangeAddress(row - subtemaDTO.getPalavrasChaves().size(), row - 1, 1, 1));
            }
        }
        return row;
    }

    private int obterLinhasPalavrasChaves(int r, XSSFSheet xssfSheet, SubtemaDTO subtemaDTO, CellStyle borderStyle) {
        int row = r;
        for (PalavraChave palavraChave : subtemaDTO.getPalavrasChaves()) {
            Cell cell;
            XSSFRow xssfRow = xssfSheet.createRow(row);
            cell = xssfRow.createCell(Constants.ZERO);
            cell.setCellValue(subtemaDTO.getNomeTema());
            cell.setCellStyle(borderStyle);
            cell = xssfRow.createCell(Constants.UM);
            cell.setCellValue(subtemaDTO.getNomeSubtema());
            cell.setCellStyle(borderStyle);
            cell = xssfRow.createCell(Constants.DOIS);
            cell.setCellValue(palavraChave.getDescricao());
            cell.setCellStyle(borderStyle);
            row += 1;
        }
        return row;
    }

    public List<Tema> buscarTodostemas() {
        return temaRepository.findAll();
    }

    public List<Subtema> buscarPorSubTema(Long idTema) {
        return subtemaRepository.findAllByTema(idTema);
    }

    public Subtema detalharTema(Long id) {
        return subtemaRepository.buscarSubtemaPorId(id);
    }

    private List<SubtemaDTO> obterSubtemaDto (List<Subtema> subtemaList, String nome, Long id) {
        List<SubtemaDTO> subtemaDtoList = new ArrayList<>();
        if (nome != null) {
            getSubtema(subtemaDtoList, subtemaList.stream().filter(s -> s.getNomeSubtema().equals(nome)).collect(Collectors.toList()), id);
        } else {
            getSubtema(subtemaDtoList, subtemaList, id);
        }
        return subtemaDtoList;
    }

    private void getSubtema (List<SubtemaDTO> subtemaDtoList, List<Subtema> subtemaList, Long id) {
        subtemaList.forEach(s -> {
            List<PalavraChave> chaveList;
            SubtemaDTO dto = new SubtemaDTO();
            dto.setIdSubtemaDTO(s.getId());
            dto.setNomeSubtema(s.getNomeSubtema());
            if (id != null) {
                chaveList = s.getPalavrasChaves().stream().filter(pc -> pc.getId().equals(id)).collect(Collectors.toList());
            } else {
                chaveList = s.getPalavrasChaves();
            }
            dto.setPalavrasChaves(chaveList);
            dto.setNomeTema(s.getTema().getNomeTema());
            subtemaDtoList.add(dto);
        });
    }
}
