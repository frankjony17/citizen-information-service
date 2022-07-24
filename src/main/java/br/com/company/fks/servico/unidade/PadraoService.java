package br.com.company.fks.servico.unidade;

import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.servico.usuario.UsuarioAcessosService;
import br.com.company.fks.integracao.ConsultaSIAPE.DadosFuncionais;
import br.com.company.fks.integracao.ConsultaSIAPE.ConsultaSIAPE_PortType;
import br.com.company.fks.integracao.ConsultaSIAPE.ConsultaSIAPE_ServiceLocator;
import br.com.company.fks.integracao.ConsultaSIAPE.ArrayDadosFuncionais;
import br.com.company.fks.integracao.ConsultaSIAPE.ArrayOfDadosFuncionais;
import br.com.company.fks.modelo.OrgaoSiorg;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.dto.acessosiorg.ResponsaveisDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadePadraoDTO;
import br.com.company.fks.utils.EntityConverter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.Optional;

@Service
public class PadraoService {

    private static final Logger LOGGER = Logger.getLogger(PadraoService.class);
    private static final String FKS_AUTORIDADE_MAXIMA = "FKS.AUTORIDADE.MAXIMA";
    private static final String FKS_AUTORIDADE_HIERARQUICA = "FKS.AUTORIDADE.HIERARQUICA";
    private static final String TITULAR = "TITULAR";
    private static final String SUBSTITUTO = "SUBSTITUTO";

    @Value("${siape.siglaSistema}")
    private String siapeSiglaSistema;

    @Value("${siape.nomeSistema}")
    private String siapeNomeSistema;

    @Value("${siape.senha}")
    private String siapeSenha;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private OrgaoSiorgService orgaoSiorgService;

    @Autowired
    private UnidadeSiorgService unidadeSiorgService;

    @Autowired
    private UsuarioAcessosService usuarioAcessosService;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    /**
     * Obter cadastro no banco de dados, Orgao, Unidade, Subunidade, Usuario, Perfil, etc.
     *
     * @param unidade Unidade.
     * @return UnidadePadraoDTO.
     */
    public UnidadePadraoDTO obterCadastroNoBancoDados(Unidade unidade) {
        UnidadePadraoDTO unidadePadraoDTO = new UnidadePadraoDTO();
        unidadePadraoDTO.setOrgao(orgaoSiorgService.obterOrgaoSiorgDTO(unidade.getOrgaoSiorg()));
        unidadePadraoDTO.setUnidade(unidadeSiorgService.montarUnidadeDTO(unidade));
        usuarioAcessosService.obterUsuariosNoBancoDadosService(unidadePadraoDTO, unidade.getId());
        unidadePadraoDTO.setResponsavelRecurso(obterResponsaveis(unidade, Optional.empty(), Optional.empty()));
        unidadePadraoDTO.setUsuarioAutoridadeHierarquicaList(usuarioAcessosService.obterUsuariosPorPerfilService(FKS_AUTORIDADE_HIERARQUICA, Optional.empty()));
        unidadePadraoDTO.setUsuarioAutoridadeMaximaList(usuarioAcessosService.obterUsuariosPorPerfilService(FKS_AUTORIDADE_MAXIMA, Optional.empty()));
        if (!unidade.getCodigoUnidade().equals("0000")) {
            unidadePadraoDTO.setSubunidadeList(orgaoSiorgService.listarSubunidadeSiorgPorUnidadeCodigoUg(unidade.getCodigoUnidade()));
        }
        return unidadePadraoDTO;
    }

    /**
     * Criar um novo Orgao, Unidade, Subunidade, Usuario, Perfil, etc.
     *
     * @param unidadePadraoDTO
     */
    @Transactional
    public void salvar(UnidadePadraoDTO unidadePadraoDTO) {
        OrgaoSiorg orgaoSiorg = orgaoSiorgService.encontrarOrgaoSiorg(unidadePadraoDTO.getOrgao());
        Unidade unidade = unidadeSiorgService.newUnidade(unidadePadraoDTO.getUnidade(), orgaoSiorg);
        if (unidadePadraoDTO.getUnidade().getSubunidade() != null) {
            unidadeSiorgService.newSubunidades(unidadePadraoDTO.getUnidade().getSubunidade(), unidade);
        }
        usuarioAcessosService.newAutoridadeUsuarioService(unidadePadraoDTO.getUsuarioAutoridadeHierarquica(), unidade, TITULAR);
        usuarioAcessosService.newAutoridadeUsuarioService(unidadePadraoDTO.getUsuarioAutoridadeMaxima(), unidade, TITULAR);
        if (unidadePadraoDTO.getSubstitutoAutoridadeHierarquica() != null) {
            usuarioAcessosService.newAutoridadeUsuarioService(unidadePadraoDTO.getSubstitutoAutoridadeHierarquica(), unidade, SUBSTITUTO);
        }
        if (unidadePadraoDTO.getSubstitutoAutoridadeMaxima() != null) {
            usuarioAcessosService.newAutoridadeUsuarioService(unidadePadraoDTO.getSubstitutoAutoridadeMaxima(), unidade, SUBSTITUTO);
        }
        obterResponsaveis(unidade, Optional.of(unidadePadraoDTO.getResponsavelRecurso()), Optional.of(true));
    }

    @Transactional
    public void editar(UnidadePadraoDTO unidadePadraoDTO) {
        Unidade unidade = unidadeRepository.findByCodigoUnidade(unidadePadraoDTO.getUnidade().getCodigoUnidade());
        unidadeSiorgService.editarSubunidade(unidadePadraoDTO.getUnidade(), unidade);
        usuarioAcessosService.editarAutoridadeUsuarioService(unidadePadraoDTO.getUsuarioAutoridadeHierarquica(), unidade, TITULAR);
        usuarioAcessosService.editarAutoridadeUsuarioService(unidadePadraoDTO.getUsuarioAutoridadeMaxima(), unidade, TITULAR);
        if (unidadePadraoDTO.getSubstitutoAutoridadeHierarquica() != null) {
            usuarioAcessosService.editarAutoridadeUsuarioService(unidadePadraoDTO.getSubstitutoAutoridadeHierarquica(), unidade, SUBSTITUTO);
        } else {
            usuarioAcessosService.desvincularUsuarioDaUnidadeService(FKS_AUTORIDADE_HIERARQUICA, unidade, SUBSTITUTO);
        }
        if (unidadePadraoDTO.getSubstitutoAutoridadeMaxima() != null) {
            usuarioAcessosService.editarAutoridadeUsuarioService(unidadePadraoDTO.getSubstitutoAutoridadeMaxima(), unidade, SUBSTITUTO);
        } else {
            usuarioAcessosService.desvincularUsuarioDaUnidadeService(FKS_AUTORIDADE_MAXIMA, unidade, SUBSTITUTO);
        }
        obterResponsaveis(unidade, Optional.of(unidadePadraoDTO.getResponsavelRecurso()), Optional.of(true));
    }

    /**
     * Obter Responsaveis o criar um novo sem eli não existe.
     *
     * @param unidade              Unidade.
     * @param optionalResponsaveis Responsaveis (Optional).
     */
    private ResponsaveisDTO obterResponsaveis(Unidade unidade, Optional optionalResponsaveis, Optional optionalAction) {
        ResponsaveisDTO responsaveisDTO = new ResponsaveisDTO();
        Responsaveis responsaveis = responsaveisRepository.findTopByOrderByIdDesc();
        if (responsaveis == null && optionalResponsaveis.isPresent()) {
            responsaveis = new Responsaveis();
            responsaveis = editResponsaveis(responsaveis, (ResponsaveisDTO) optionalResponsaveis.get(), unidade);
        } else {
            if (optionalAction.isPresent() && optionalResponsaveis.isPresent()) {
                ResponsaveisDTO responsaveisDTO1 = (ResponsaveisDTO) optionalResponsaveis.get();
                if (responsaveisDTO1.getResponsavelRecursoAcao().equals("ALTERAR")) {
                    responsaveis = editResponsaveis(new Responsaveis(), responsaveisDTO1, unidade);
                }
            }
        }
        return responsaveis != null ? entityConverter.converter(responsaveis, ResponsaveisDTO.class) : responsaveisDTO;
    }

    /**
     * Edit Responsaveis.
     *
     * @param responsaveis    Instancia Responsaveis.
     * @param responsaveisDTO DTO.
     * @param unidade         Unidade.
     * @return Responsaveis.
     */
    private Responsaveis editResponsaveis(Responsaveis responsaveis, ResponsaveisDTO responsaveisDTO, Unidade unidade) {
        responsaveis.setResponsavelRecursoQuartaInstancia(responsaveisDTO.getResponsavelRecursoQuartaInstancia());
        responsaveis.setResponsavelRecursoTerceiraInstancia(responsaveisDTO.getResponsavelRecursoTerceiraInstancia());
        responsaveis.setUnidade(unidade);
        return responsaveisRepository.save(responsaveis);
    }

    public DadosFuncionais obterDadosFuncionais(String cpf) {
        DadosFuncionais dadosFuncionais = null;
        try {
            ConsultaSIAPE_ServiceLocator myServiceServiceLocator = new ConsultaSIAPE_ServiceLocator();
            ConsultaSIAPE_PortType webservice = myServiceServiceLocator.getConsultaSIAPEHttpPort();
            ArrayDadosFuncionais arrayDadosFuncionais = webservice.consultaDadosFuncionais("FKS", "Sistema de Demandas do Serviços de Inf. ao Cidadão", siapeSenha, cpf, "", "b", "c");
            if (arrayDadosFuncionais != null) {
                ArrayOfDadosFuncionais arrayOfDadosFuncionais = arrayDadosFuncionais.getDadosFuncionais();
                dadosFuncionais = arrayOfDadosFuncionais.getDadosFuncionais(0);
            }
        } catch (ServiceException e) {
            LOGGER.error(Level.ERROR, e);
        } catch (RemoteException e) {
            LOGGER.error(Level.ERROR, e);
        }
        return dadosFuncionais;
    }
}
