package br.com.company.fks.servico;

import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.servico.unidade.PadraoService;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.integracao.ConsultaSIAPE.DadosFuncionais;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessoSubunidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroUnidadeDTO;
import br.com.company.fks.modelo.dto.SubunidadeAcessosDTO;
import br.com.company.fks.modelo.dto.UnidadeDTO;
import br.com.company.fks.modelo.dto.UnidadeRelatorioDTO;
import br.com.company.fks.modelo.dto.UnidadeSubunidadeDTO;
import br.com.company.fks.modelo.dto.UsuarioAcessosDTO;
import br.com.company.fks.repositorio.OrgaoSiorgRepository;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import br.com.company.fks.utils.Constants;
import br.com.company.fks.utils.ExceptionsUtil;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private OrgaoSiorgRepository orgaoSiorgRepository;

    @Autowired
    private SubunidadeRepository subunidadeRepository;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private PadraoService padraoService;

    @Autowired
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Transactional
    public void salvar(UnidadeSubunidadeDTO unidadeSubunidadeDTO) throws IntegracaoException {
        Unidade unidade;
        Subunidade subunidade;
        unidade = new Unidade();
        unidade.setNomeUnidade(unidadeSubunidadeDTO.getNome());
        unidade.setCodigoUnidade(unidadeSubunidadeDTO.getCodigoUg());
        unidade.setSiglaUnidade(unidadeSubunidadeDTO.getSiglaUnidade());
        unidadeRepository.save(unidade);
        List<br.com.company.fks.modelo.dto.SubunidadeDTO> listaSubunidades = unidadeSubunidadeDTO.getSubunidade();
        for (br.com.company.fks.modelo.dto.SubunidadeDTO subunidades : listaSubunidades) {
            subunidade = new Subunidade();
            subunidade.setCodigoSubunidade(subunidades.getCodigoUg());
            subunidade.setNomeSubunidade(subunidades.getNome());
            subunidade.setSiglaSubunidade(subunidades.getSigla());
            subunidade.setUnidade(unidade);
            subunidadeRepository.save(subunidade);
        }
    }

    public Unidade buscarUnidade(Long id) {
        return unidadeRepository.findOne(id);
    }

    @Transactional
    public void editar(Unidade unidade) throws IntegracaoException {
        Unidade unidadeTemp = unidadeRepository.findOne(unidade.getId());
        limpaSubunidades(unidadeTemp);
        unidadeTemp.setSubunidade(unidade.getSubunidade());
        populaSubunidade(unidadeTemp);
        unidadeRepository.save(unidadeTemp);
    }

    private void limpaSubunidades(Unidade unidade) {
        for (Subunidade subunidade : unidade.getSubunidade()) {
            subunidadeRepository.delete(subunidade.getId());
        }
    }

    private void populaSubunidade(Unidade unidade) {
        for (Subunidade subunidade : unidade.getSubunidade()) {
            subunidade.setUnidade(unidade);
        }
    }

    public Subunidade detalharUnidade(Long id) {
        return subunidadeRepository.buscarUnidadeSubunidadePorId(id);
    }

    public List<UnidadeDTO> buscarListaUnidade() {
        List<Unidade> listaUnidade = unidadeRepository.findAll();
        List<UnidadeDTO> listaUnidadeDTO = new ArrayList<>();
        for (Unidade unidade : listaUnidade) {
            UnidadeDTO unidadeDTO = montarListaUnidadeDTO(unidade);
            listaUnidadeDTO.add(unidadeDTO);
        }
        return listaUnidadeDTO;
    }

    public List<Subunidade> buscarListaSubunidade(Long id) {
        Unidade unidade = unidadeRepository.findOne(id);
        return unidade.getSubunidade();
    }

    public UnidadeDTO montarListaUnidadeDTO(Unidade unidade) {
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setCodigoUnidade(unidade.getCodigoUnidade());
        unidadeDTO.setNomeUnidade(unidade.getNomeUnidade());
        unidadeDTO.setSiglaUnidade(unidade.getSiglaUnidade());
        unidadeDTO.setStatusUnidade(unidade.getStatusUnidade());
        unidadeDTO.setSubunidade(unidade.getSubunidade());
        for (Subunidade subunidade : unidadeDTO.getSubunidade()) {
            subunidade.setUnidade(unidade);
        }
        return unidadeDTO;
    }

    @Transactional
    public UsuarioAcessos atribuirUnidadeUsuario(UsuarioAcessosDTO usuarioAcessosDTO) throws IntegracaoException {
        UsuarioAcessos usuarioAcessos = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioAcessosDTO.getUsuario().getCodigoUsuario());
        if (usuarioAcessos == null) {
            usuarioAcessos = new UsuarioAcessos();
        }

        if (usuarioAcessosDTO.getUsuario().getPerfilUsuario().equals("FKS.RESPONDENTE") || usuarioAcessosDTO.getUsuario().getPerfilUsuario().equals("FKS.TECNICO")) {
            if (getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf()) == null) {
                usuarioAcessos.setNomeUsuario(usuarioAcessosDTO.getUsuario().getNomeUsuario());
                usuarioAcessos.setCodigoUsuario(usuarioAcessosDTO.getUsuario().getCodigoUsuario());
                usuarioAcessos.setEmailUsuario(usuarioAcessosDTO.getUsuario().getEmailUsuario());
                usuarioAcessos.setTelefoneUsuario(usuarioAcessosDTO.getUsuario().getTelefoneUsuario());
                usuarioAcessos.setPerfilUsuario(usuarioAcessosDTO.getUsuario().getPerfilUsuario());
                return usuarioAcessosRepository.save(usuarioAcessos);
            }
        } else if (usuarioAcessos.getUnidade() == null) {
            Unidade unidade = unidadeRepository.findOne(usuarioAcessosDTO.getIdUnidade());
            usuarioAcessos.setUnidade(unidade);
            usuarioAcessos.setNomeUsuario(usuarioAcessosDTO.getUsuario().getNomeUsuario());
            usuarioAcessos.setCodigoUsuario(usuarioAcessosDTO.getUsuario().getCodigoUsuario());
            usuarioAcessos.setEmailUsuario(usuarioAcessosDTO.getUsuario().getEmailUsuario());
            usuarioAcessos.setTelefoneUsuario(usuarioAcessosDTO.getUsuario().getTelefoneUsuario());
            usuarioAcessos.setPerfilUsuario(usuarioAcessosDTO.getUsuario().getPerfilUsuario());
            return usuarioAcessosRepository.save(usuarioAcessos);
        }
        throw new IntegracaoException("Usuário já cadastrado na unidade/subunidade");
    }

    public byte[] exportarConsultaUnidade(FiltroUnidadeDTO fitro) throws IntegracaoException, IOException {
        List<UnidadeRelatorioDTO> unidadeRelatorioDTOList = new ArrayList<>();

        orgaoSiorgRepository.findOrgaoUnidadeSubunidade(fitro.getOrgaoId(), fitro.getUnidadeId(),
                !fitro.getSubunidade().isEmpty() ? fitro.getSubunidade().stream().map(SubunidadeDTO::getId).collect(Collectors.toList()) : null
        ).forEach(o -> unidadeRelatorioDTOList.addAll(obterUnidadeRelatorioDTO(o)));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Consulta de Unidades");
        criarLinhaCabecalho(xssfSheet);
        criarLinhasPlanilha(xssfSheet, unidadeRelatorioDTOList);
        ExceptionsUtil.exceptionXssf(byteArrayOutputStream, xssfWorkbook);
        return byteArrayOutputStream.toByteArray();
    }

    private List<UnidadeRelatorioDTO> obterUnidadeRelatorioDTO(OrgaoSiorg orgao) {
        List<UnidadeRelatorioDTO> arrayList = new ArrayList<>();
        orgao.getUnidades().forEach(u -> u.getSubunidade().forEach(s -> {
                UnidadeRelatorioDTO unidadeRelatorioDTO = new UnidadeRelatorioDTO();
                unidadeRelatorioDTO.setNomeOrgao(orgao.getNomeOrgao());
                unidadeRelatorioDTO.setNomeSubunidade(s.getNomeSubunidade());
                unidadeRelatorioDTO.setNomeUnidade(s.getUnidade().getNomeUnidade());
                arrayList.add(unidadeRelatorioDTO);
            })
        );
        return arrayList;
    }

    private void criarLinhasPlanilha(XSSFSheet xssfSheet, List<UnidadeRelatorioDTO> listaUnidadeRelatorioDTO) {
        int row = Constants.UM;
        for (UnidadeRelatorioDTO unidadeRelatorioDTO : listaUnidadeRelatorioDTO) {
            XSSFRow xssfRow = xssfSheet.createRow(row);
            preencherLinhaPlanilha(xssfRow, unidadeRelatorioDTO);
            row = row + 1;
        }
    }

    private void preencherLinhaPlanilha(XSSFRow xssfRow, UnidadeRelatorioDTO unidadeRelatorioDTO) {
        xssfRow.createCell(Constants.ZERO).setCellValue(unidadeRelatorioDTO.getNomeOrgao());
        xssfRow.createCell(Constants.UM).setCellValue(unidadeRelatorioDTO.getNomeUnidade());
        xssfRow.createCell(Constants.DOIS).setCellValue(unidadeRelatorioDTO.getNomeSubunidade());
    }

    private void criarLinhaCabecalho(XSSFSheet xssfSheet) {
        XSSFRow xssfRow = xssfSheet.createRow(Constants.ZERO);
        xssfRow.createCell(Constants.ZERO).setCellValue("Órgão");
        xssfRow.createCell(Constants.UM).setCellValue("Unidade");
        xssfRow.createCell(Constants.DOIS).setCellValue("Subunidade");
    }

    public void alterarStatusSubUnidade(Long idSubunidade, boolean statusSubunidade) {
        Subunidade subunidade = subunidadeRepository.findOne(idSubunidade);
        subunidade.setStatusSubunidade(statusSubunidade);
        subunidadeRepository.save(subunidade);
    }

    public List<SubunidadeAcessosDTO> montarListaSubunidade(Long idUnidade) {
        Unidade unidade = unidadeRepository.findOne(idUnidade);
        List<Subunidade> subunidadeList = unidade.getSubunidade();
        List<SubunidadeAcessosDTO> subunidadeAcessosDTOList = new ArrayList<>();
        for (Subunidade subunidade : subunidadeList) {
            SubunidadeAcessosDTO subunidadeAcessosDTO = new SubunidadeAcessosDTO();
            subunidadeAcessosDTO.setCodigoSubunidade(subunidade.getCodigoSubunidade());
            subunidadeAcessosDTO.setNomeSubunidade(subunidade.getNomeSubunidade());
            subunidadeAcessosDTOList.add(subunidadeAcessosDTO);
        }
        return subunidadeAcessosDTOList;
    }

    public List<Subunidade> buscarListaSubunidadePorUsuarioLogado() {
        List<Subunidade> listaSubunidade = null;
        if (usuarioLogadoUtil.getPerfil().equals("FKS.PONTO.FOCAL")) {
            listaSubunidade = buscarListaSubunidade(usuarioLogadoUtil.getUsuario().getUnidade().getId());
        }
        return listaSubunidade;
    }

    public UnidadeDTO buscarUnidadeVinculadaASubunidade(Long idPedido) {
        Unidade unidade = usuarioLogadoUtil.getUsuario().getUnidade();
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setCodigoUnidade(unidade.getCodigoUnidade());
        unidadeDTO.setNomeUnidade(unidade.getNomeUnidade());
        unidadeDTO.setSiglaUnidade(unidade.getSiglaUnidade());
        unidadeDTO.setStatusUnidade(unidade.getStatusUnidade());
        unidadeDTO.setSubunidade(unidade.getSubunidade());
        return unidadeDTO;
    }

    public UnidadeDTO buscarUnidadeSic() {
        Unidade unidade = unidadeRepository.findByCodigoUnidade("0000");
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setCodigoUnidade(unidade.getCodigoUnidade());
        unidadeDTO.setNomeUnidade(unidade.getNomeUnidade());
        unidadeDTO.setSiglaUnidade(unidade.getSiglaUnidade());
        unidadeDTO.setStatusUnidade(unidade.getStatusUnidade());
        unidadeDTO.setSubunidade(unidade.getSubunidade());
        return unidadeDTO;
    }

    public Subunidade buscarSubunidadeRespondente() {
        return getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf());
    }

    public Unidade buscaUnidadePeloNome(String nome) {
        return unidadeRepository.buscaUnidadePeloNome(nome);
    }

    public Map<String, String> buscaCargoFuncaoSiapPorCpf(String cpf) {
        Map<String, String> result = new HashMap<>();
        DadosFuncionais dadosFuncionais = padraoService.obterDadosFuncionais(cpf);
        if (dadosFuncionais != null) {
            result.put("cargo", dadosFuncionais.getNomeCargo());
            result.put("funcao", dadosFuncionais.getNomeFuncao());
        }
        return result;
    }

    public Subunidade getOneSubunidadePeloUsuarioCpf (String cpf) {
        Subunidade subunidade = null;
        UsuarioAcessoSubunidade usuarioAcessoSubunidade = usuarioAcessosSubunidadeRepository.findFirstByUsuarioAcessosCpfUsuario(cpf);
        if (usuarioAcessoSubunidade != null) {
            subunidade = usuarioAcessoSubunidade.getSubunidade();
        }
        return subunidade;
    }
}
