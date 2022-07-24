package br.com.company.fks.controller;

import br.gov.mpog.acessos.cliente.servico.AcessosClienteSistemaService;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.excecao.ObjectMapperException;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Subunidade;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.FiltroUnidadeDTO;
import br.com.company.fks.modelo.dto.UnidadeDTO;
import br.com.company.fks.modelo.dto.UnidadeSubunidadeDTO;
import br.com.company.fks.modelo.dto.UsuarioAcessosDTO;
import br.com.company.fks.modelo.dto.acessosiorg.ResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.modelo.dto.usuarioacesso.UsuarioParametrosDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.SubunidadeRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.servico.unidade.OrgaoSiorgService;
import br.com.company.fks.servico.unidade.PadraoService;
import br.com.company.fks.servico.unidade.UnidadeSiorgService;
import br.com.company.fks.servico.usuario.UsuarioAcessosService;
import br.com.company.fks.utils.ControllerUtil;
import br.com.company.fks.utils.EntityConverter;
import io.jsonwebtoken.lang.Assert;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 14/08/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ControllerUtil.class})
public class UnidadeControllerTest {
    @InjectMocks
    private UnidadeController unidadeController;

    @Mock
    private UnidadeService unidadeService;

    @Mock
    private UnidadeSubunidadeDTO unidadeSubunidadeDTO;

    @Mock
    private ControllerUtil controllerUtil;

    @Mock
    private FiltroUnidadeDTO filtroUnidadeDTO;

    @Mock
    private PadraoService padraoService;

    @Mock
    private Unidade unidade;

    @Mock
    private Subunidade subunidade;

    @Mock
    private List<UnidadeDTO> unidadeDTOList;

    @Mock
    private UsuarioAcessosDTO usuarioAcessosDTO;

    @Mock
    private UsuarioAcessos usuarioAcessos;

    @Mock
    private List<Subunidade> subunidadeList;

    @Mock
    private AcessosClienteSistemaService acessosClienteSistemaService;

    @Mock
    List<Object> listaUnidadeDTO;

    @Mock
   private UnidadePadraoDTO unidadePadraoDTO;

    @Mock
    private UnidadeRepository unidadeRepository;

    @Mock
    private UnidadeSiorgService unidadeSiorgService;

    @Mock
    private UsuarioParametrosDTO parametrosDTO;

    @Mock
    private UsuarioAcessosService usuarioAcessosService;

    @Mock
    private UsuarioParametrosDTO usuarioParametrosDTO;

    @Mock
    private OrgaoSiorgService orgaoSiorgService;

    @Mock
    private ResponsaveisRepository responsaveisRepository;

    @Mock
    private Responsaveis responsaveis;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private ResponsaveisDTO responsaveisDTO;

    @Mock
    private SubunidadeRepository subunidadeRepository;

    @Test
    public void obterOrgao(){
        unidadeController.obterOrgao();
    }

    @Test
    public void obterUnidade(){
        unidadeController.obterUnidade("codigoOrgao");
    }

    @Test
    public void obterTudoUnidade(){
        unidadeController.obterTudoUnidade();
    }

    @Test
    public void obterOrgaoSiorg(){
        unidadeController.obterOrgaoSiorg();
    }

    @Test
    public void obterUnidadeSiorg(){
        unidadeController.obterUnidadeSiorg("codigoORgao");
    }

    @Test
    public void obterSubunidadeSiorg(){
        when(unidadeSiorgService.existeCadastroNoBancoDados("codigoUnidade")).thenReturn(unidade);
        unidadeController.obterSubunidadeSiorg("codigoUnidade");
    }

    @Test
    public void obterSubunidadeSiorgNull(){
        unidadeController.obterSubunidadeSiorg("codigoUnidade");
    }

    @Test
    public void obterSubunidade(){
        unidadeController.obterSubunidade("codigoUnidade");
    }

    @Test
    public void subunidadeEUnidade(){
        when(subunidadeRepository.countSubunidadeByCodigoSubunidade("codigoSubunidade")).thenReturn(1L);
        unidadeController.subunidadeEUnidade("codigo");
    }

    @Test
    public void obterUsuarioPorPerfilAcesso(){
        unidadeController.obterUsuarioPorPerfilAcesso("nomePerfil");
    }

    @Test
    public void buscaCargoFuncaoSiapPorUsuario(){
        unidadeController.buscaCargoFuncaoSiapPorUsuario("cpf");
    }

    @Test
    public void obterUsuarioSubstitutoPorPerfilAcesso(){
        unidadeController.obterUsuarioSubstitutoPorPerfilAcesso("nomePerfil", 1L);
    }

    @Test
    public void obterResponsavelRecurso(){
        when(responsaveisRepository.findTopByOrderByIdDesc()).thenReturn(responsaveis);
        when(entityConverter.converter(responsaveis, ResponsaveisDTO.class)).thenReturn(responsaveisDTO);
        unidadeController.obterResponsavelRecurso();
    }

    @Test
    public void obterResponsavelRecursoResponsaveisNull(){
        when(responsaveisRepository.findTopByOrderByIdDesc()).thenReturn(null);
        unidadeController.obterResponsavelRecurso();
    }

    @Test
    @SneakyThrows
    public void salvar() {
        unidadeController.salvar(unidadePadraoDTO);
    }

    @Test
    @SneakyThrows
    public void salvarIntegracaoException() {
        Mockito.doThrow(IntegracaoException.class).when(unidadeService).salvar(unidadeSubunidadeDTO);
        unidadeController.salvar(unidadePadraoDTO);
    }

    @Test
    public void buscarUnidade() {
        when(unidadeService.buscarUnidade(anyLong())).thenReturn(unidade);
        unidadeController.buscarUnidade(1L);
    }

    @Test
    public void alterarEstadoUnidade(){
        unidadeSiorgService.alterarEstadoUnidade(1L, true);
        unidadeController.alterarEstadoUnidade(1L, true);
    }

    @Test
    public void obterCadastro(){
        when(unidadeRepository.findByCodigoUnidade("codigo")).thenReturn(unidade);
        when(padraoService.obterCadastroNoBancoDados(unidade)).thenReturn(unidadePadraoDTO);
        unidadeController.obterCadastro("codigoUnidade");
    }

    @Test
    @SneakyThrows
    public void editar() {
        Mockito.doNothing().when(unidadeService).editar(unidade);
        unidadeController.editar(unidadePadraoDTO);
    }
    @Test
    @SneakyThrows
    public void editarIntegracaoException() {
        Mockito.doThrow(IntegracaoException.class).when(unidadeService).editar(unidade);
        unidadeController.editar(unidadePadraoDTO);
    }

    @Test
    public void editarPerfilUsuario(){
        usuarioAcessosService.editarUsuarioPerfilService(usuarioParametrosDTO);
        unidadeController.editarPerfilUsuario(parametrosDTO);
    }

    @Test
    public void detalharUnidade() {
        when(unidadeService.detalharUnidade(anyLong())).thenReturn(subunidade);
        unidadeController.detalharUnidade(1L);
    }

    @Test
    public void BuscarUnidade() {
        when(unidadeService.buscarListaUnidade()).thenReturn(unidadeDTOList);
        unidadeController.buscarUnidadeList();
    }

    @Test
    @SneakyThrows
    public void atribuirUnidadeUsuario() {
        when(unidadeService.atribuirUnidadeUsuario(usuarioAcessosDTO)).thenReturn(usuarioAcessos);
        unidadeController.atribuirUnidadeUsuario(usuarioAcessosDTO);
    }

    @Test
    @SneakyThrows
    public void atribuirUnidadeUsuarioIntegracaoException() {
        Mockito.doThrow(IntegracaoException.class).when(unidadeService).atribuirUnidadeUsuario(usuarioAcessosDTO);
        unidadeController.atribuirUnidadeUsuario(usuarioAcessosDTO);
    }

    @Test
    @SneakyThrows
    public void exportarConsultaUnidade() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroUnidadeDTO.class)).thenReturn(filtroUnidadeDTO);
        byte[] bytes = new byte[5];
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        when(unidadeService.exportarConsultaUnidade(filtroUnidadeDTO)).thenReturn(bytes);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn("teste");
        unidadeController.exportarConsultaUnidade("filtro");
    }
    @Test
    @SneakyThrows
    public void exportarConsultaUnidadeIntegracaoException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroUnidadeDTO.class)).thenReturn(filtroUnidadeDTO);
        byte[] bytes = new byte[5];
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        Mockito.doThrow(IntegracaoException.class).when(unidadeService).exportarConsultaUnidade(filtroUnidadeDTO);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn(null);
        unidadeController.exportarConsultaUnidade("filtro");
    }
    @Test
    @SneakyThrows
    public void exportarConsultaUnidadeObjectMapperException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroUnidadeDTO.class)).thenReturn(filtroUnidadeDTO);
        byte[] bytes = new byte[5];
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        Mockito.doThrow(ObjectMapperException.class).when(unidadeService).exportarConsultaUnidade(filtroUnidadeDTO);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn(null);
        unidadeController.exportarConsultaUnidade("filtro");
    }
    @Test
    @SneakyThrows
    public void exportarConsultaUnidadeIOException() {
        PowerMockito.mockStatic(ControllerUtil.class);
        when(controllerUtil.montarFiltroDTO("filtro",FiltroUnidadeDTO.class)).thenReturn(filtroUnidadeDTO);
        byte[] bytes = new byte[5];
        String arquivoBase64 = new Base64().encodeAsString(bytes);
        Mockito.doThrow(IOException.class).when(unidadeService).exportarConsultaUnidade(filtroUnidadeDTO);
        when(controllerUtil.criarObjetoJson("arquivoBase64",arquivoBase64)).thenReturn(null);
        unidadeController.exportarConsultaUnidade("filtro");
    }

    @Test
    public void ativaDesativaStatusSubunidade() {
        Mockito.doNothing().when(unidadeService).alterarStatusSubUnidade(anyLong(),anyBoolean());
        unidadeController.ativaDesativaStatusSubunidade(1L,true);
    }


    @Test
    public void buscarTodasSubunidadesPorId() {
        when(unidadeService.buscarListaSubunidade(anyLong())).thenReturn(subunidadeList);
        unidadeController.buscarTodasSubunidades(1L);
    }

    @Test
    public void buscarListaSiorg() {
        when(acessosClienteSistemaService.buscarUnidades(null, null, null, null, null, null, "56689", null, null)).thenReturn(listaUnidadeDTO);
        ResponseEntity<List<Object>> response = unidadeController.buscarListaSiorg();
        Assert.notNull(response);
    }

    @Test
    public void montarSubunidadesSiorg() {
        Assert.notNull(unidadeController.montarSubunidadesSiorg(1L));
    }

    @Test
    public void buscarTodasSubunidades() {
        Assert.notNull(unidadeController.buscarTodasSubunidades());
    }

    @Test
    public void buscarUnidadeVinculadaASubunidadePorId(){
        Assert.notNull(unidadeController.buscarUnidadeVinculadaASubunidade(1L));
    }

    @Test
    public void buscarUnidadeVinculadaASubunidade(){
        Assert.notNull(unidadeController.buscarUnidadeVinculadaASubunidade());
    }

    @Test
    public void buscarSubunidadeRespondente(){
        unidadeController.buscarSubunidadeRespondente();
    }

    @Test
    public void buscaUnidadePorNome(){
        unidadeController.buscaUnidadePorNome("nome");
    }

    @Test
    public void load(){
        orgaoSiorgService.doGetSiorgDoAcessos();
        unidadeController.load();
    }
}
