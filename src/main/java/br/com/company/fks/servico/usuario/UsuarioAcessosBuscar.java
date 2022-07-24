package br.com.company.fks.servico.usuario;

import br.gov.mpog.acessos.cliente.servico.impl.AcessosClienteSistemaServiceImpl;
import br.com.company.fks.integracao.ConsultaSIAPE.DadosFuncionais;
import br.com.company.fks.modelo.Responsaveis;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.UsuarioPerfilAcessoDTO;
import br.com.company.fks.modelo.dto.acessosiorg.OrgaoSiorgDTO;
import br.com.company.fks.modelo.dto.acessosiorg.SubunidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UnidadeDTO;
import br.com.company.fks.modelo.dto.acessosiorg.UsuarioSiapeAcessoDTO;
import br.com.company.fks.repositorio.ResponsaveisRepository;
import br.com.company.fks.repositorio.UnidadeRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.repositorio.UsuarioAcessosSubunidadeRepository;
import br.com.company.fks.servico.UnidadeService;
import br.com.company.fks.servico.unidade.PadraoService;
import br.com.company.fks.utils.EntityConverter;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class UsuarioAcessosBuscar {

    @Autowired
    private PadraoService padraoService;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private ResponsaveisRepository responsaveisRepository;

    @Autowired
    private UsuarioAcessosSubunidadeRepository usuarioAcessosSubunidadeRepository;

    @Autowired
    private AcessosClienteSistemaServiceImpl acessosClienteSistemaServiceImpl;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    @Autowired
    private UnidadeService unidadeService;

    public List<UsuarioAcessos> buscarUsuarioPontoFocalPorSubunidade(Long idSubunidade) {
        return usuarioAcessosRepository.findUsuarioBySubunidadeIdAndAndPerfil("FKS.RESPONDENTE", "", idSubunidade);
    }

    public List<UsuarioAcessos> buscarUsuarioTecnicoPorSubunidade() {
        return usuarioAcessosRepository.findUsuarioBySubunidadeIdAndAndPerfil("FKS.TECNICO","FKS.EDICAO.TECNICO", unidadeService.getOneSubunidadePeloUsuarioCpf(usuarioLogadoUtil.getCpf()).getId());
    }

    String usuarioExisteNoBancoDados (List<UsuarioAcessoPerfilAcesso> usuarioPerfilBancoDadosList, UsuarioSiapeAcessoDTO usuarioSiapeAcessoDTO) {
        String existe = "NO";
        for (UsuarioAcessoPerfilAcesso usuarioPerfil : usuarioPerfilBancoDadosList) {
            if (usuarioSiapeAcessoDTO.getCpf().equals(usuarioPerfil.getUsuarioAcessos().getCpfUsuario())) {
                usuarioSiapeAcessoDTO.setAssinatura(usuarioPerfil.getAssinaturaUsuario());
                if (usuarioPerfil.getUsuarioAcessos().getUnidade() != null) {
                    existe = "Usuário atribuído à unidade: ".concat(usuarioPerfil.getUsuarioAcessos().getUnidade().getNomeUnidade().toUpperCase());
                }
                else {
                    existe = "Usuário sem atribuição";
                }
                usuarioPerfilBancoDadosList.remove(usuarioPerfil);
                break;
            }
        }
        return existe;
    }

    Boolean existeUsuarioDeAcessosNoBancoDados (String cpfUsuario, List<Object> usuarioAcessoList) {
        Boolean bool = false;
        for (Object usuarioSiapeObject : usuarioAcessoList) {
            UsuarioSiapeAcessoDTO usuarioAcesso = entityConverter.converter(usuarioSiapeObject, UsuarioSiapeAcessoDTO.class);
            if (cpfUsuario.equals(usuarioAcesso.getCpf())) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public UsuarioSiapeAcessoDTO getDadosUsuarioAcesso (String cpf) {
        List<Object> objectList = acessosClienteSistemaServiceImpl.buscarUsuarios(cpf, null, null, null, null,null, null, null, null);
        return objectList.isEmpty() ? new UsuarioSiapeAcessoDTO() : entityConverter.converter(objectList.get(0), UsuarioSiapeAcessoDTO.class);
    }

    public UsuarioPerfilAcessoDTO detalharUsuario (String cpf, String nomePerfil) {
        UsuarioPerfilAcessoDTO usuarioDetalhadoDto = new UsuarioPerfilAcessoDTO();
        UsuarioAcessos usuarioAcesso = usuarioAcessosRepository.findFirstByCpfUsuario(cpf);
        UsuarioSiapeAcessoDTO acesso = getDadosUsuarioAcesso(cpf);
        if (usuarioAcesso != null) {
            usuarioDetalhadoDto.setId(usuarioAcesso.getId());
            usuarioDetalhadoDto.setAssinatura(usuarioAcessoPerfilAcessoRepository.obterAssinatura(cpf, nomePerfil));
            if (acesso.getNome() == null) {
                acesso.setNome(usuarioAcesso.getNomeUsuario());
                acesso.setEmail(usuarioAcesso.getEmailUsuario());
                acesso.setTelefoneTrabalho(usuarioAcesso.getTelefoneUsuario());
            }
        }
        setProperties(cpf, nomePerfil, acesso, usuarioDetalhadoDto);
        getOrgaoUnidadeSubunidade(usuarioAcesso, usuarioDetalhadoDto);
        getAutoridade(usuarioAcesso, usuarioDetalhadoDto);
        getResponsavels(usuarioDetalhadoDto);
        getDadosFuncionais(usuarioDetalhadoDto);
        return usuarioDetalhadoDto;
    }

    private void setProperties (String cpf, String nomePerfil, UsuarioSiapeAcessoDTO acesso, UsuarioPerfilAcessoDTO usuarioDetalhadoDto) {
        usuarioDetalhadoDto.setCpf(cpf);
        usuarioDetalhadoDto.setNome(acesso.getNome());
        usuarioDetalhadoDto.setEmail(acesso.getEmail());
        String telefone1 = acesso.getTelefoneCelular() != null ? acesso.getTelefoneCelular().concat(", ") : "";
        String telefone2 = acesso.getTelefoneTrabalho() != null ? acesso.getTelefoneTrabalho() : "";
        usuarioDetalhadoDto.setTelefone(telefone1.concat(telefone2));
        usuarioDetalhadoDto.setPerfil(nomePerfil);
    }

    private void getAutoridade (UsuarioAcessos usuarioAcessos, UsuarioPerfilAcessoDTO usuarioDetalhadoDto) {
        Long unidadeId = 0L;
        UsuarioAcessoPerfilAcesso autoridadeHier = null;
        UsuarioAcessoPerfilAcesso autoridadeMaxi = null;
        if (usuarioAcessos != null && usuarioAcessos.getUnidade() != null) {
            unidadeId = usuarioAcessos.getUnidade().getId();
        } else if (usuarioDetalhadoDto.getPerfil().equals("FKS.ADMIN") || usuarioDetalhadoDto.getPerfil().equals("FKS.ATENDENTE.SIC")) {
            unidadeId = unidadeRepository.findByCodigoUnidade("0000").getId();
        }
        if (!unidadeId.equals(0L)) {

            autoridadeHier = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(unidadeId,"FKS.AUTORIDADE.HIERARQUICA");
            autoridadeMaxi = usuarioAcessoPerfilAcessoRepository.findFirstByUsuarioAcessosUnidadeIdAndPerfilAcessosNomePerfil(unidadeId,"FKS.AUTORIDADE.MAXIMA");
        }
        usuarioDetalhadoDto.setAutoridadeHier(autoridadeHier != null ? autoridadeHier.getUsuarioAcessos().getNomeUsuario() : "");
        usuarioDetalhadoDto.setAutoridadeMaxi(autoridadeMaxi != null ? autoridadeMaxi.getUsuarioAcessos().getNomeUsuario() : "");
    }

    private void getOrgaoUnidadeSubunidade (UsuarioAcessos usuarioAcesso, UsuarioPerfilAcessoDTO usuarioDetalhadoDto) {
        OrgaoSiorgDTO orgao = new OrgaoSiorgDTO();
        UnidadeDTO unidade = new UnidadeDTO();
        List<SubunidadeDTO> subunidadeList = new ArrayList<>();
        List<SubunidadeDTO> unidadeSubunidadeList = new ArrayList<>();
        if (usuarioAcesso != null && usuarioAcesso.getUnidade() != null) {
            getOrgao(usuarioAcesso, orgao);
            getUnidade(usuarioAcesso, unidade, unidadeSubunidadeList);
            getSubunidades(usuarioAcesso.getCpfUsuario(), subunidadeList);
        }
        usuarioDetalhadoDto.setOrgao(orgao);
        usuarioDetalhadoDto.setUnidade(unidade);
        usuarioDetalhadoDto.setUnidadeSubunidades(unidadeSubunidadeList);
        usuarioDetalhadoDto.setSubunidades(subunidadeList);
    }

    private void getResponsavels (UsuarioPerfilAcessoDTO usuarioDetalhadoDto) {
        Responsaveis responsaveis = responsaveisRepository.findTopByOrderByIdDesc();
        usuarioDetalhadoDto.setResponsavelRecurso3(responsaveis != null ? responsaveis.getResponsavelRecursoTerceiraInstancia() : "");
        usuarioDetalhadoDto.setResponsavelRecurso4(responsaveis != null ? responsaveis.getResponsavelRecursoQuartaInstancia() : "");
    }

    private void getDadosFuncionais (UsuarioPerfilAcessoDTO usuarioDetalhadoDto) {
        DadosFuncionais dadosFuncionais = padraoService.obterDadosFuncionais(usuarioDetalhadoDto.getCpf());
        usuarioDetalhadoDto.setCargo(dadosFuncionais != null ? dadosFuncionais.getNomeCargo() : "");
        usuarioDetalhadoDto.setFuncao(dadosFuncionais != null ? dadosFuncionais.getNomeFuncao() : "");
    }

    private void getOrgao (UsuarioAcessos usuarioAcessos, OrgaoSiorgDTO orgao) {
        orgao.setId(usuarioAcessos.getUnidade().getOrgaoSiorg().getId());
        orgao.setNomeUnidade(usuarioAcessos.getUnidade().getOrgaoSiorg().getNomeOrgao());
        orgao.setCodigoUnidade(usuarioAcessos.getUnidade().getOrgaoSiorg().getCodigoOrgao());
        orgao.setSiglaUnidade(usuarioAcessos.getUnidade().getOrgaoSiorg().getSiglaOrgao());
    }

    private void getUnidade (UsuarioAcessos usuarioAcessos, UnidadeDTO unidade, List<SubunidadeDTO> unidadeSubunidadeList) {
        unidade.setId(usuarioAcessos.getUnidade().getId());
        unidade.setNomeUnidade(usuarioAcessos.getUnidade().getNomeUnidade());
        unidade.setCodigoUnidade(usuarioAcessos.getUnidade().getCodigoUnidade());
        unidade.setSiglaUnidade(usuarioAcessos.getUnidade().getSiglaUnidade());
        usuarioAcessos.getUnidade().getSubunidade().forEach(s -> {
            SubunidadeDTO subunidadeDTO = new SubunidadeDTO();
            subunidadeDTO.setId(s.getId());
            subunidadeDTO.setNomeUnidade(s.getNomeSubunidade());
            subunidadeDTO.setSiglaUnidade(s.getSiglaSubunidade());
            subunidadeDTO.setCodigoUnidade(s.getCodigoSubunidade());
            unidadeSubunidadeList.add(subunidadeDTO);
        });
    }

    public void getSubunidades (String cpf, List<SubunidadeDTO> dtoList) {
        usuarioAcessosSubunidadeRepository.findAllByUsuarioAcessosCpfUsuario(cpf).forEach(us -> {
            SubunidadeDTO subunidadeDTO = new SubunidadeDTO();
            subunidadeDTO.setId(us.getSubunidade().getId());
            subunidadeDTO.setNomeUnidade(us.getSubunidade().getNomeSubunidade());
            subunidadeDTO.setSiglaUnidade(us.getSubunidade().getSiglaSubunidade());
            subunidadeDTO.setCodigoUnidade(us.getSubunidade().getCodigoSubunidade());
            dtoList.add(subunidadeDTO);
        });
    }

}

