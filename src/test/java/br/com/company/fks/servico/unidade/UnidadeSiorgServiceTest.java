package br.com.company.fks.servico.unidade;

import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class UnidadeSiorgServiceTest {

    @InjectMocks
    private UnidadeSiorgService unidadeSiorgService;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private SubunidadeRepository subunidadeRepository;

    @Mock
    private Unidade unidade;

    @Mock
    private UnidadeDTO unidadeDTO;

    @Mock
    private OrgaoSiorg orgaoSiorg;

    @Mock
    private Subunidade subunidade;

    @Mock
    private SubunidadeDTO subunidadeDTO;

    @Test
    public void obterUnidadeDataBase(){
        List<Unidade> unidadeList = new ArrayList<>();
        when(unidadeRepository.findByOrgaoSiorgCodigoOrgao("codigoOrgao")).thenReturn(unidadeList);
        unidadeSiorgService.obterUnidadeDataBase("codigoOrgao");
    }

    @Test
    public void obterUnidadeDataBaseFor(){
        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(unidadeRepository.findByOrgaoSiorgCodigoOrgao("codigoOrgao")).thenReturn(unidadeList);
        unidadeSiorgService.obterUnidadeDataBase("codigoOrgao");
    }

    @Test
    public void obterUnidadeDataBaseForDoMontarSubunidade(){
        List<Unidade> unidadeList = new ArrayList<>();
        unidadeList.add(unidade);
        when(unidadeRepository.findByOrgaoSiorgCodigoOrgao("codigoOrgao")).thenReturn(unidadeList);
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        when(subunidade.getId()).thenReturn(1L);
        when(subunidade.getNomeSubunidade()).thenReturn("nomeSubunidade");
        unidadeSiorgService.obterUnidadeDataBase("codigoOrgao");
    }

    @Test
    public void existeCadastroNoBancoDados(){
        unidadeSiorgService.existeCadastroNoBancoDados("codigoUnidade");
    }

    @Test
    public void newUnidade(){
        unidadeSiorgService.newUnidade(unidadeDTO, orgaoSiorg);
    }

    @Test
    public void newSubunidades(){
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        subunidadeDTOList.add(subunidadeDTO);
        when(subunidadeDTO.getNomeUnidade()).thenReturn("nomeUnidade");
        when(subunidadeDTO.getCodigoUnidade()).thenReturn("codigoUnidade");
        when(subunidadeRepository.save(subunidade)).thenReturn(subunidade);
        unidadeSiorgService.newSubunidades(subunidadeDTOList, unidade);
    }

    @Test
    public void newSubunidadesFor(){
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        unidadeSiorgService.newSubunidades(subunidadeDTOList, unidade);
    }

    @Test
    public void desativarSubunidades(){
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        when(subunidadeRepository.save(subunidade)).thenReturn(subunidade);
        unidadeSiorgService.desativarSubunidades(unidade);
    }

    @Test
    public void editarSubunidade(){
        unidadeSiorgService.editarSubunidade(unidadeDTO, unidade);
    }

    @Test
    public void editarSubunidadeIf(){
        when(unidadeDTO.getSubunidade()).thenReturn(null);
        unidadeSiorgService.editarSubunidade(unidadeDTO, unidade);
    }

    @Test
    public void editarSubunidadeFor(){
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        subunidadeDTOList.add(subunidadeDTO);
        when(unidadeDTO.getSubunidade()).thenReturn(subunidadeDTOList);
        when(subunidadeRepository.findFirstByCodigoSubunidade("codigoUnidade")).thenReturn(subunidade);
        when(subunidadeDTO.getCodigoUnidade()).thenReturn("codigoUnidade");
        unidadeSiorgService.editarSubunidade(unidadeDTO, unidade);
    }

    @Test
    public void editarSubunidadeElse(){
        List<SubunidadeDTO> subunidadeDTOList = new ArrayList<>();
        subunidadeDTOList.add(subunidadeDTO);
        when(unidadeDTO.getSubunidade()).thenReturn(subunidadeDTOList);
        unidadeSiorgService.editarSubunidade(unidadeDTO, unidade);
    }



    @Test
    public void alterarEstadoUnidade(){
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        when(unidadeRepository.save(unidade)).thenReturn(unidade);
        unidadeSiorgService.alterarEstadoUnidade(1L, true);
    }

    @Test
    public void alterarEstadoUnidadeFor(){
        when(unidadeRepository.findOne(1L)).thenReturn(unidade);
        List<Subunidade> subunidadeList = new ArrayList<>();
        subunidadeList.add(subunidade);
        when(unidade.getSubunidade()).thenReturn(subunidadeList);
        when(unidadeRepository.save(unidade)).thenReturn(unidade);
        unidadeSiorgService.alterarEstadoUnidade(1L, true);
    }

    @Test
    public void desativarSubunidadesFor(){
        unidadeSiorgService.desativarSubunidades(unidade);
    }

}