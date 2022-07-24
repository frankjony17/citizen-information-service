package br.com.company.fks.servico.unidade;

import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadeSiorgService {

    /**JPA UnidadeRepository*/
    @Autowired
    private UnidadeRepository unidadeRepository;

    /**JPA UnidadeRepository*/
    @Autowired
    private SubunidadeRepository subunidadeRepository;

    /**
     * Obter unidades do banco de dados
     * @param codigoOrgao Código de Órgão no Siorg.
     * @return List<UnidadeSiorgDTO>
     */
    public List<UnidadeDTO> obterUnidadeDataBase (String codigoOrgao) {
        List<UnidadeDTO> unidadeDTOList = new ArrayList<>();
        List<Unidade> unidadeList = unidadeRepository.findByOrgaoSiorgCodigoOrgao(codigoOrgao);
        for (Unidade unidade : unidadeList) {
            unidadeDTOList.add(montarUnidadeDTO(unidade));
        }
        return unidadeDTOList;
    }

    /**
     * Pesquisar unidade no banco de dados por código de unidade.
     * @param codigoUnidade Código de unidade.
     * @return Unidade
     */
    public Unidade existeCadastroNoBancoDados (String codigoUnidade) {
        return unidadeRepository.findByCodigoUnidade(codigoUnidade);
    }

    /**
     * Criar uma nova Unidade no banco de dados.
     * @param unidadeDTO Dados de Unidade.
     * @param orgaoSiorg Entity OrgaoSiorgDTO.
     * @return Unidade.
     */
    public Unidade newUnidade (UnidadeDTO unidadeDTO, OrgaoSiorg orgaoSiorg) {
        Unidade unidade = new Unidade();
        unidade.setId(unidadeDTO.getId());
        unidade.setNomeUnidade(unidadeDTO.getNomeUnidade());
        unidade.setCodigoUnidade(unidadeDTO.getCodigoUnidade());
        unidade.setSiglaUnidade(unidadeDTO.getSiglaUnidade());
        unidade.setStatusUnidade(true);
        unidade.setOrgaoSiorg(orgaoSiorg);
        // Devolve Unidade.
        return unidadeRepository.save(unidade);
    }

    /**
     * Criar novas Subunidade no banco de dados.
     * @param subunidadeDTOList Dados de SubunidadeDTO.
     * @param unidade Entity Unidade.
     */
    public void newSubunidades (List<SubunidadeDTO> subunidadeDTOList, Unidade unidade) {
        // Criar novas Subunidades.
        for (SubunidadeDTO subunidadeDTO : subunidadeDTOList) {
            Subunidade subunidade = new Subunidade();
            subunidade.setNomeSubunidade(subunidadeDTO.getNomeUnidade());
            subunidade.setCodigoSubunidade(subunidadeDTO.getCodigoUnidade());
            subunidade.setSiglaSubunidade(subunidadeDTO.getSiglaUnidade());
            subunidade.setStatusSubunidade(true);
            subunidade.setUnidade(unidade);
            // Save.
            subunidadeRepository.save(subunidade);
        }
    }

    /**
     * Obter UnidadeDTO pela Subunidade.
     * @param unidade unidade.
     * @return List<SubunidadeDTO>
     */
    public UnidadeDTO montarUnidadeDTO (Unidade unidade) {
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setNomeUnidade(unidade.getNomeUnidade());
        unidadeDTO.setSiglaUnidade(unidade.getSiglaUnidade());
        unidadeDTO.setCodigoUnidade(unidade.getCodigoUnidade());
        unidadeDTO.setSubunidade(montarSubunidadeDTO(unidade.getSubunidade()));
        unidadeDTO.setStatusUnidade(unidade.getStatusUnidade());
        return unidadeDTO;
    }

    /**
     * Editar status da SubUnidade.
     * @param unidadeDTO unidadeDTO.
     * @param unidade unidade.
     */
    @Transactional
    public void editarSubunidade (UnidadeDTO unidadeDTO, Unidade unidade) {
        desativarSubunidades(unidade);
        //
        if (unidadeDTO.getSubunidade() != null) {
            for (SubunidadeDTO subunidadeDTO : unidadeDTO.getSubunidade()) {
                Subunidade subunidade = subunidadeRepository.findFirstByCodigoSubunidade(subunidadeDTO.getCodigoUnidade());
                if (subunidade != null) {
                    subunidade.setStatusSubunidade(true);
                }
                else {
                    subunidade = new Subunidade();
                    subunidade.setNomeSubunidade(subunidadeDTO.getNomeUnidade());
                    subunidade.setSiglaSubunidade(subunidadeDTO.getSiglaUnidade());
                    subunidade.setCodigoSubunidade(subunidadeDTO.getCodigoUnidade());
                    subunidade.setStatusSubunidade(true);
                    subunidade.setUnidade(unidade);
                }
                subunidadeRepository.save(subunidade);
            }
        }
    }

    /**
     * Editar status da Unidade.
     * @param id Unidade ID.
     * @param estado Status Boolean.
     */
    public void alterarEstadoUnidade (Long id, Boolean estado) {
        Unidade unidade = unidadeRepository.findOne(id);
        for (Subunidade subunidade : unidade.getSubunidade()) {
            subunidade.setStatusSubunidade(estado);
        }
        unidade.setStatusUnidade(estado);
        unidadeRepository.save(unidade);
    }

    /**
     * Desativar subunidades.
     * @param unidade
     */
    public void desativarSubunidades (Unidade unidade) {
        for (Subunidade subunidade : unidade.getSubunidade()) {
            subunidade.setStatusSubunidade(false);
            subunidadeRepository.save(subunidade);
        }
    }

    /**
     * Obter SubunidadeDTO pela Subunidade.
     * @param subunidadeList Lista da Subunidade.
     * @return List<SubunidadeDTO>
     */
    private List<SubunidadeDTO> montarSubunidadeDTO (List<Subunidade> subunidadeList) {
        List<SubunidadeDTO> subunidadeDTOS = new ArrayList<>();
        for (Subunidade subunidade : subunidadeList) {
            SubunidadeDTO subunidadeDTO = new SubunidadeDTO();
            subunidadeDTO.setId(subunidade.getId());
            subunidadeDTO.setNomeUnidade(subunidade.getNomeSubunidade());
            subunidadeDTO.setSiglaUnidade(subunidade.getSiglaSubunidade());
            subunidadeDTO.setCodigoUnidade(subunidade.getCodigoSubunidade());
            subunidadeDTOS.add(subunidadeDTO);
        }
        return subunidadeDTOS;
    }
}
