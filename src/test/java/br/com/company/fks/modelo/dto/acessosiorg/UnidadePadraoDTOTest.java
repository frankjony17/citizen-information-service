package br.com.company.fks.modelo.dto.acessosiorg;

import br.com.company.fks.modelo.dto.SalvarPerfilDTO;
import br.com.company.fks.modelo.dto.SalvarUsuarioDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class UnidadePadraoDTOTest {

    @InjectMocks
    private UnidadePadraoDTO dto;

    @Test
    public void UnidadePadraoDTO(){
        List<UsuarioSiapeAcessoDTO> usuarioAutoridadeHierarquicaList = new ArrayList<>();
        List<UsuarioSiapeAcessoDTO> usuarioAutoridadeMaximaList = new ArrayList<>();
        List<UnidadeSiorgDTO> subunidadeList = new ArrayList<>();
        OrgaoSiorgDTO orgao = new OrgaoSiorgDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        UsuarioSiapeAcessoDTO substitutoAutoridadeHierarquica = new UsuarioSiapeAcessoDTO();
        UsuarioSiapeAcessoDTO substitutoAutoridadeMaxima = new UsuarioSiapeAcessoDTO();
        UsuarioSiapeAcessoDTO usuarioAutoridadeHierarquica = new UsuarioSiapeAcessoDTO();
        UsuarioSiapeAcessoDTO usuarioAutoridadeMaxima = new UsuarioSiapeAcessoDTO();
        ResponsaveisDTO responsavelRecurso = new ResponsaveisDTO();
        SalvarUsuarioDTO salvarUsuarioDTO = new SalvarUsuarioDTO();
        SalvarPerfilDTO salvarPerfilDTO = new SalvarPerfilDTO();
        dto.getOrgao();
        dto.setOrgao(orgao);
        dto.getUnidade();
        dto.setUnidade(unidade);
        dto.getSubstitutoAutoridadeHierarquica();
        dto.setSubstitutoAutoridadeHierarquica(substitutoAutoridadeHierarquica);
        dto.getSubstitutoAutoridadeMaxima();
        dto.setSubstitutoAutoridadeMaxima(substitutoAutoridadeMaxima);
        dto.getUsuarioAutoridadeHierarquica();
        dto.setUsuarioAutoridadeHierarquica(usuarioAutoridadeHierarquica);
        dto.getUsuarioAutoridadeMaxima();
        dto.setUsuarioAutoridadeMaxima(usuarioAutoridadeMaxima);
        dto.getUsuarioAutoridadeHierarquicaList();
        dto.setUsuarioAutoridadeHierarquicaList(usuarioAutoridadeHierarquicaList);
        dto.getUsuarioAutoridadeMaximaList();
        dto.setUsuarioAutoridadeMaximaList(usuarioAutoridadeMaximaList);
        dto.getResponsavelRecurso();
        dto.setResponsavelRecurso(responsavelRecurso);
        dto.getSubunidadeList();
        dto.setSubunidadeList(subunidadeList);
        dto.getSalvarUsuarioDTO();
        dto.setSalvarUsuarioDTO(salvarUsuarioDTO);
        dto.getSalvarPerfilDTO();
        dto.setSalvarPerfilDTO(salvarPerfilDTO);
        dto.getUsuarioAtivo();
        dto.setUsuarioAtivo(true);

    }

}