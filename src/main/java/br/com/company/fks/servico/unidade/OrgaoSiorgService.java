package br.com.company.fks.servico.unidade;

import br.com.company.fks.repositorio.OrgaoSiorgRepository;
import br.com.company.fks.repositorio.TempOrgaoSiorgAcessoRepository;
import br.com.company.fks.repositorio.TempUnidadeSiorgAcessoRepository;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.TempOrgaoSiorgAcesso;
import br.com.company.fks.modelo.TempUnidadeSiorgAcesso;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoUnidadeSubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SiorgAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeSiorgDTO;
import br.com.company.fks.utils.RequestUtils;
import br.com.company.fks.utils.URLIntegracaoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrgaoSiorgService {

    private static final String CODIGO_UNIDADE_PAI = "26";
    private List<SiorgAcessoDTO> siorgAcessoList;
    private List<SiorgAcessoDTO> siorgUnidadesList;

    @Autowired
    private RequestUtils requestUtils;

    @Autowired
    private URLIntegracaoUtils urlIntegracaoUtils;

    @Autowired
    private OrgaoSiorgRepository orgaoSiorgRepository;

    @Autowired
    private TempOrgaoSiorgAcessoRepository tempOrgaoSiorgAcessoRepository;

    @Autowired
    private TempUnidadeSiorgAcessoRepository tempUnidadeSiorgAcessoRepository;

    public List<UnidadeSiorgDTO> listarOrgaoSiorg () {
        List<UnidadeSiorgDTO> orgaoList = new ArrayList<>();
        List<TempOrgaoSiorgAcesso> orgaoSiorgAcessosList = tempOrgaoSiorgAcessoRepository.findAllByAtivoTrue();
        orgaoSiorgAcessosList.forEach(orgao -> {
            UnidadeSiorgDTO dto = new UnidadeSiorgDTO();
            dto.setNomeUnidade(orgao.getNome());
            dto.setSiglaUnidade(orgao.getSigla());
            dto.setCodigoUnidade(orgao.getCodigoUg());
            orgaoList.add(dto);
        });
        return orgaoList;
    }

    public List<UnidadeSiorgDTO> listarUnidadeSiorgPorOrgaoCodigoUg (String codigoUg) {
        return obterUnidadeDto(tempUnidadeSiorgAcessoRepository.findAllByTempOrgaoSiorgAcessoCodigoUgAndAtivoTrue(codigoUg));
    }

    public List<UnidadeSiorgDTO> listarSubunidadeSiorgPorUnidadeCodigoUg (String codigoUg) {
        int length = 0;
        TempUnidadeSiorgAcesso unidade = tempUnidadeSiorgAcessoRepository.findFirstByCodigoUg(codigoUg);
        List<TempUnidadeSiorgAcesso> unidadeSiorgAcessosList = tempUnidadeSiorgAcessoRepository.findAllByUnidadePaiIdAndAtivoTrue(unidade.getId());
        while (length < unidadeSiorgAcessosList.size()) {
            unidadeSiorgAcessosList.addAll(tempUnidadeSiorgAcessoRepository.findAllByUnidadePaiIdAndAtivoTrue(unidadeSiorgAcessosList.get(length).getId()));
            length++;
        }
        return obterUnidadeDto(unidadeSiorgAcessosList);
    }

    public Long existemOrgaosUnidades () {
        return tempUnidadeSiorgAcessoRepository.count();
    }

    public void limparOrgaosUnidadesDoBancoDados () {
        tempUnidadeSiorgAcessoRepository.deleteAllInBatch();
        tempOrgaoSiorgAcessoRepository.deleteAllInBatch();
    }

    public void doGetSiorgDoAcessos () {
        ResponseEntity<?> entity = requestUtils.doGet(urlIntegracaoUtils.getUrlOrgaoSiorgAcesso(), SiorgAcessoDTO[].class);
        this.siorgAcessoList = new ArrayList<>(Arrays.asList((SiorgAcessoDTO[]) entity.getBody()));
        List<SiorgAcessoDTO> unidadesList = new ArrayList<>();
        List<SiorgAcessoDTO> orgaoList = obterItem(CODIGO_UNIDADE_PAI, false);
        orgaoList.forEach(orgao -> unidadesList.addAll(obterItem(orgao.getCodigoUg(), true)));
        this.siorgUnidadesList = obterAll(unidadesList);
        criarNoBancoDeDados(orgaoList);
    }

    private List<SiorgAcessoDTO> obterAll (List<SiorgAcessoDTO> unidadesList) {
        int length = 0;
        while (length < unidadesList.size()) {
            unidadesList.addAll(obterItem(unidadesList.get(length).getCodigoUg(), true));
            length++;
        }
        return unidadesList;
    }

    private List<SiorgAcessoDTO> obterItem (String codigoUnidadePai, boolean pai) {
        List<SiorgAcessoDTO> itemList = new ArrayList<>();
        this.siorgAcessoList.forEach(item -> {
            if (item.getOrganizacaoSuperior() != null && item.getOrganizacaoSuperior().getCodigoUg().equals(codigoUnidadePai) && item.getAtivo()) {
                itemList.add(obterOganizacaoSuperior(item, pai));
            }
        });
        this.siorgAcessoList.removeAll(itemList);
        return itemList;
    }

    private SiorgAcessoDTO obterOganizacaoSuperior (SiorgAcessoDTO item, boolean pai) {
        if (pai) {
            SiorgAcessoDTO oganizacaoSuperior = item.getOrganizacaoSuperior();
            oganizacaoSuperior.setOrganizacaoSuperior(null);
            item.setOrganizacaoSuperior(oganizacaoSuperior);
        } else {
            item.setOrganizacaoSuperior(null);
        }
        return item;
    }

    private void criarNoBancoDeDados(List<SiorgAcessoDTO> orgaoList) {
        orgaoList.forEach(orgao -> {
            TempOrgaoSiorgAcesso orgaoSave;
            TempOrgaoSiorgAcesso tempOrgaoSiorgAcesso = new TempOrgaoSiorgAcesso();
            BeanUtils.copyProperties(orgao, tempOrgaoSiorgAcesso, "id");
            orgaoSave = tempOrgaoSiorgAcessoRepository.save(tempOrgaoSiorgAcesso);

            List<SiorgAcessoDTO> unidadeList = this.siorgUnidadesList.stream().filter(u -> (u.getOrganizacaoSuperior().getCodigoUg().equals(orgaoSave.getCodigoUg()) &&  u.getAtivo())).collect(Collectors.toList());
            unidadeList.forEach(unidade -> {
                TempUnidadeSiorgAcesso tempUnidadeSiorgAcesso = new TempUnidadeSiorgAcesso();
                BeanUtils.copyProperties(unidade, tempUnidadeSiorgAcesso, "id");
                tempUnidadeSiorgAcesso.setTempOrgaoSiorgAcesso(orgaoSave);
                 tempUnidadeSiorgAcessoRepository.save(tempUnidadeSiorgAcesso);
            });
            this.siorgUnidadesList.removeAll(unidadeList);
        });
        criarUnidadesAll();
    }

    private void criarUnidadesAll () {
        int length = 0;
        while (length < this.siorgUnidadesList.size()) {
            SiorgAcessoDTO unidade = this.siorgUnidadesList.get(length);
            TempUnidadeSiorgAcesso unidadePai = tempUnidadeSiorgAcessoRepository.findFirstByCodigoUg(unidade.getOrganizacaoSuperior().getCodigoUg());
            if (unidadePai != null) {
                TempUnidadeSiorgAcesso tempUnidadeSiorgAcesso = new TempUnidadeSiorgAcesso();
                BeanUtils.copyProperties(unidade, tempUnidadeSiorgAcesso, "id");
                tempUnidadeSiorgAcesso.setUnidadePaiId(unidadePai.getId());
                tempUnidadeSiorgAcesso.setTempOrgaoSiorgAcesso(unidadePai.getTempOrgaoSiorgAcesso());
                tempUnidadeSiorgAcessoRepository.save(tempUnidadeSiorgAcesso);
            } else {
                this.siorgUnidadesList.remove(unidade);
                this.siorgUnidadesList.add(unidade);
            }
            length++;
        }
    }

    private List<UnidadeSiorgDTO> obterUnidadeDto (List<TempUnidadeSiorgAcesso> unidadeSiorgAcessoList) {
        List<UnidadeSiorgDTO> unidadeList = new ArrayList<>();
        unidadeSiorgAcessoList.forEach(orgao -> {
            UnidadeSiorgDTO dto = new UnidadeSiorgDTO();
            dto.setNomeUnidade(orgao.getNome());
            dto.setSiglaUnidade(orgao.getSigla());
            dto.setCodigoUnidade(orgao.getCodigoUg());
            unidadeList.add(dto);
        });
        return unidadeList;
    }

    /**
     * Obter DTO da entidade.
     * @param orgaoSiorg Entidade.
     * @return OrgaoSiorgDTO.
     */
    public OrgaoSiorgDTO obterOrgaoSiorgDTO (OrgaoSiorg orgaoSiorg) {
        OrgaoSiorgDTO orgaoSiorgDTO = new OrgaoSiorgDTO();
        orgaoSiorgDTO.setId(orgaoSiorg.getId());
        orgaoSiorgDTO.setNomeUnidade(orgaoSiorg.getNomeOrgao());
        orgaoSiorgDTO.setSiglaUnidade(orgaoSiorg.getSiglaOrgao());
        orgaoSiorgDTO.setCodigoUnidade(orgaoSiorg.getCodigoOrgao());
        orgaoSiorgDTO.setStatusUnidade(orgaoSiorg.getStatusOrgao());
        return orgaoSiorgDTO;
    }

    /**
     * Se não existe no banco de dados, criar um novo OrgaoSiorg y retorna a ele.
     * @param orgaoSiorgDTO Dados da Órgão.
     * @return OrgaoSiorg.
     */
    public OrgaoSiorg encontrarOrgaoSiorg (OrgaoSiorgDTO orgaoSiorgDTO) {
        OrgaoSiorg orgaoSiorg = orgaoSiorgRepository.findByCodigoOrgao(orgaoSiorgDTO.getCodigoUnidade());
        if (orgaoSiorg == null) {
            orgaoSiorg = new OrgaoSiorg();
            orgaoSiorg.setNomeOrgao(orgaoSiorgDTO.getNomeUnidade());
            orgaoSiorg.setSiglaOrgao(orgaoSiorgDTO.getSiglaUnidade());
            orgaoSiorg.setCodigoOrgao(orgaoSiorgDTO.getCodigoUnidade());
            orgaoSiorg.setStatusOrgao(true);
            orgaoSiorg = orgaoSiorgRepository.save(orgaoSiorg);
        }
        return orgaoSiorg;
    }

    /**
     * Orgaos que estão presentes no banco de dados.
     * @return List<UnidadeSiorgDTO>
     */
    public List<OrgaoSiorgDTO> obterOrgaoDataBase () {
        List<OrgaoSiorgDTO> orgaoSiorgDTOList = new ArrayList<>();
        List<OrgaoSiorg> orgaoSiorgList = orgaoSiorgRepository.findAll();
        for (OrgaoSiorg orgaoSiorg : orgaoSiorgList) {
            if (!orgaoSiorg.getNomeOrgao().equals("SIC")) {
                orgaoSiorgDTOList.add(obterOrgaoSiorgDTO(orgaoSiorg));
            }
        }
        return orgaoSiorgDTOList;
    }

    /**
     * Filtra todos os orgãos e unidades do banco de dados.
     * @return List<OrgaoUnidadeSubunidadeDTO>
     */
    public List<OrgaoUnidadeSubunidadeDTO> obterTudoDataBase () {
        List<OrgaoSiorg> orgaoSiorgList = orgaoSiorgRepository.findAll();
        List<OrgaoUnidadeSubunidadeDTO> orgaoUnidadeSubunidadeDTOList = new ArrayList<>();
        for (OrgaoSiorg orgaoSiorg : orgaoSiorgList) {
            OrgaoUnidadeSubunidadeDTO orgaoUnidadeSubunidadeDTO = new OrgaoUnidadeSubunidadeDTO();
            orgaoUnidadeSubunidadeDTO.setId(orgaoSiorg.getId());
            orgaoUnidadeSubunidadeDTO.setNomeOrgao(orgaoSiorg.getNomeOrgao());
            orgaoUnidadeSubunidadeDTO.setSiglaOrgao(orgaoSiorg.getSiglaOrgao());
            orgaoUnidadeSubunidadeDTO.setUnidades(obterUnidade(orgaoSiorg.getUnidades()));
            orgaoUnidadeSubunidadeDTOList.add(orgaoUnidadeSubunidadeDTO);
        }
        return orgaoUnidadeSubunidadeDTOList;
    }

    /**
     * Monta unidade e retorna uma lista
     */
    private List<UnidadeDTO> obterUnidade (List<Unidade> unidadeList) {
        List<UnidadeDTO> unidadeDTOList = new ArrayList<>();
        for (Unidade unidade : unidadeList) {
            UnidadeDTO unidadeDTO = new UnidadeDTO();
            unidadeDTO.setId(unidade.getId());
            unidadeDTO.setNomeUnidade(unidade.getNomeUnidade());
            unidadeDTO.setSiglaUnidade(unidade.getSiglaUnidade());
            unidadeDTO.setCodigoUnidade(unidade.getCodigoUnidade());
            unidadeDTO.setStatusUnidade(unidade.getStatusUnidade());
            unidadeDTO.setSubunidade(obterSubunidades(unidade.getSubunidade()));
            unidadeDTOList.add(unidadeDTO);
        }
        return unidadeDTOList;
    }

    /**
     * Filtra todos os orgãos e unidades do banco de dados.
     * @return List<OrgaoUnidadeSubunidadeDTO>
     */
    private List<SubunidadeDTO> obterSubunidades (List<Subunidade> subunidadeList) {
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        for (Subunidade subunidade : subunidadeList) {
            SubunidadeDTO subunidadeDTO = new SubunidadeDTO();
            subunidadeDTO.setId(subunidade.getId());
            subunidadeDTO.setNomeUnidade(subunidade.getNomeSubunidade());
            subunidadeDTO.setCodigoUnidade(subunidade.getCodigoSubunidade());
            subunidadeDTO.setSiglaUnidade(subunidade.getSiglaSubunidade());
            subunidadeDTOList.add(subunidadeDTO);
        }
        return subunidadeDTOList;
    }
}



















