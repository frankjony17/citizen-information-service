package br.com.company.fks.servico;

import br.com.company.fks.modelo.Orgao;
import br.com.company.fks.repositorio.OrgaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrgaoServiceTest {

    @InjectMocks
    private OrgaoService orgaoService;
    @Mock
    private OrgaoRepository orgaoRepository;
    @Mock
    private List<Orgao> orgaoList;


    @Test
    public void buscarTodasDescricaoOrgaoTest(){
        when(orgaoRepository.findAllOrderByDescricao()).thenReturn(orgaoList);
        assertEquals(orgaoService.buscarTodasDescricaoOrgao(),orgaoList);

    }

}
