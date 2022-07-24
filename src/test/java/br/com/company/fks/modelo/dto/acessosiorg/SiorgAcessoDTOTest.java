package br.com.company.fks.modelo.dto.acessosiorg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SiorgAcessoDTOTest {

    @InjectMocks
    private SiorgAcessoDTO dto;

    @Test
    public void SiorgAcessoDTO(){
        SiorgAcessoDTO organizacaoSuperior = new SiorgAcessoDTO();
        dto.getId();
        dto.setId("id");
        dto.getNome();
        dto.setNome("nome");
        dto.getSigla();
        dto.setSigla("sigla");
        dto.getSiglaCompleta();
        dto.setSiglaCompleta("siglaCompleta");
        dto.getCnpj();
        dto.setCnpj("cnpj");
        dto.getAtivo();
        dto.setAtivo(true);
        dto.getTipoOrganizacao();
        dto.setTipoOrganizacao("tipoOrganizacao");
        dto.getAdministradores();
        dto.setAdministradores("administradores");
        dto.getCodigoUg();
        dto.setCodigoUg("codigoUg");
        dto.getTipoAdministracao();
        dto.setTipoAdministracao("tipoAdministracao");
        dto.getEndereco();
        dto.setEndereco("endereco");
        dto.getLdapOu();
        dto.setLdapOu("ldapOu");
        dto.getExcluido();
        dto.setExcluido(true);
        dto.getOrigem();
        dto.setOrigem("origem");
        dto.getTipoAdministracaoId();
        dto.setTipoAdministracaoId(1L);
        dto.getPoderId();
        dto.setPoderId(1L);
        dto.getEsferaId();
        dto.setEsferaId(1L);
        dto.getStrAtivo();
        dto.setStrAtivo("strAtivo");
        dto.getTextoPesquisa();
        dto.setTextoPesquisa("textoPesquisa");
        dto.getOrganizacaoSuperior();
        dto.setOrganizacaoSuperior(organizacaoSuperior);
        dto.getJurisdicoes();
        dto.setJurisdicoes("jurisdicoes");
        dto.getIdOrganizacaoSuperior();
        dto.setIdOrganizacaoSuperior(1L);
        dto.getIdGrupoUnidade();
        dto.setIdGrupoUnidade(1L);
        dto.getSemGrupoUnidade();
        dto.setSemGrupoUnidade(true);
    }

}