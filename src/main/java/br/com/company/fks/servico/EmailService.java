package br.com.company.fks.servico;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.excecao.FKSException;
import br.com.company.fks.modelo.Email;
import br.com.company.fks.modelo.EmailPerfilAcesso;
import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.dto.EmailDTO;
import br.com.company.fks.modelo.dto.EmailFiltroDTO;
import br.com.company.fks.modelo.dto.PerfilDTO;
import br.com.company.fks.modelo.enums.PerfilAcessoEnum;
import br.com.company.fks.modelo.enums.TipoAcaoExecutadaPedidoEnum;
import br.com.company.fks.modelo.enums.TipoAcaoExecutadaRecursoEnum;
import br.com.company.fks.modelo.enums.TipoAlertaEnum;
import br.com.company.fks.modelo.enums.TipoDataEnum;
import br.com.company.fks.modelo.enums.TipoSolicitacaoEnum;
import br.com.company.fks.repositorio.EmailPerfisRepository;
import br.com.company.fks.repositorio.EmailRepository;
import br.com.company.fks.repositorio.PerfilAcessosRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRecursoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private PerfilAcessosRepository perfilAcessosRepository;

    @Autowired
    private EmailPerfisRepository emailPerfisRepository;

    @Autowired
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Autowired
    private StatusSolicitacaoRecursoRepository statusSolicitacaoRecursoRepository;

    @Transactional
    public void salvar(EmailDTO emailDTO) {
        Email email = new Email();
        email.setId(emailDTO.getId());
        email.setTipoAlerta(emailDTO.getTipoAlerta());
        email.setTipoSolicitacao(emailDTO.getTipoSolicitacao());
        if (email.getTipoAlerta().equals(TipoAlertaEnum.TIPO_ALERTA_POR_DATA.getId())) {
            setPorData(email, emailDTO);
        } else {
            email.setAcaoExecutada(emailDTO.getAcaoExecutada());
        }
        email.setAssuntoEmail(emailDTO.getAssuntoEmail());
        email.setConteudoEmail(emailDTO.getConteudoEmail());
        email = emailRepository.save(email);
        List<EmailPerfilAcesso> perfis = emailPerfisRepository.findAllByEmailId(email.getId());
        List<PerfilDTO> perfisEnviados = emailDTO.getDestinatarios();
        removePerfis(perfis, perfisEnviados);
        adicionaPerfil(emailDTO.getDestinatarios(), email, perfis);
    }

    private void removePerfis(List<EmailPerfilAcesso> perfis, List<PerfilDTO> perfisEnviados) {
        perfis.forEach(perfil -> {
            boolean possuiPerfil = perfisEnviados.stream().anyMatch(perfilEnviado -> Objects.equals(perfilEnviado.getId(), perfil.getPerfilAcessos().getId()));
            if (!possuiPerfil) {
                emailPerfisRepository.delete(perfil);
            }
        });
    }

    public Resposta<List<EmailDTO>> obterEmailDataBase (EmailFiltroDTO parms) {
        List<EmailDTO> emailList = new ArrayList<>();
        Resposta<List<EmailDTO>> resposta = new Resposta<>();
        List<Long> longList = destinatarios(parms.getDestinatarios());

        emailRepository.findEmailPerfis(parms.getTipoSolicitacao(), parms.getTipoAlerta(), parms.getAssuntoEmail(), longList.isEmpty() ? null : longList, new PageRequest(parms.getOffset(), parms.getLimit())).forEach(e -> {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setId(e.getId());
            emailDTO.setDescricaoTipoSolicitacao(TipoSolicitacaoEnum.getValor(e.getTipoSolicitacao()));
            emailDTO.setDescricaoTipoAlerta(TipoAlertaEnum.getValor(e.getTipoAlerta()));
            emailDTO.setAssuntoEmail(e.getAssuntoEmail());
            emailDTO.setDestinatarios(getPerfilsDTOS(e.getPerfis()));
            emailList.add(emailDTO);
        });
        resposta.setResultado(emailList);
        resposta.setTotalElementos(emailRepository.countEmailPerfis(parms.getTipoSolicitacao(), parms.getTipoAlerta(), parms.getAssuntoEmail(), longList.isEmpty() ? null : longList));
        return resposta;
    }

    public EmailDTO buscaEmailPorId(Long id) {
        Email email = emailRepository.findOne(id);
        if (email == null) {
            throw new FKSException("Email não encotrado!");
        }
        List<EmailPerfilAcesso> emailPerfilAcessos = emailPerfisRepository.findAllByEmailId(email.getId());
        return convertEmailParaDTO(email, emailPerfilAcessos);
    }

    private EmailDTO convertEmailParaDTO(Email email, List<EmailPerfilAcesso> listaEmailPerfilAcessos) {
        EmailDTO dto = new EmailDTO();
        dto.setId(email.getId());
        dto.setTipoSolicitacao(email.getTipoSolicitacao());
        dto.setTipoAlerta(email.getTipoAlerta());
        dto.setDataReferencia(email.getDataReferencia());
        dto.setDataEnvioEmail(email.getDataEnvioEmail());
        dto.setStatusDemanda(email.getStatusDemanda());
        dto.setDiasAnteDataReferencia(email.getDiasAnteDataReferencia());
        dto.setDiasAposDataReferencia(email.getDiasAposDataReferencia());
        dto.setReenviarAteAlteracaoDoStatus(email.getReenviarAteAlteracaoDoStatus());
        dto.setAcaoExecutada(email.getAcaoExecutada());
        dto.setAssuntoEmail(email.getAssuntoEmail());
        dto.setConteudoEmail(email.getConteudoEmail());
        List<PerfilDTO> perfilsDTO = getPerfilsDTOS(listaEmailPerfilAcessos);
        dto.setDestinatarios(perfilsDTO);
        return dto;
    }

    private List<PerfilDTO> getPerfilsDTOS(List<EmailPerfilAcesso> listaEmailPerfilAcessos) {
        List<PerfilDTO> perfisDTO = new ArrayList<>();
        listaEmailPerfilAcessos.forEach(item -> {
            PerfilAcessos perfilAcessos = item.getPerfilAcessos();
            PerfilDTO perfilDTO = new PerfilDTO();
            perfilDTO.setId(perfilAcessos.getId());
            perfilDTO.setNome(perfilAcessos.getNomePerfil());
            perfilAcessos.setDescricaoPerfil(perfilAcessos.getDescricaoPerfil());
            perfisDTO.add(perfilDTO);
        });
        return perfisDTO;
    }

    public List<String> obterAssunto () {
        return emailRepository.findAssuntoEmail();
    }

    private void setPorData(Email email, EmailDTO emailDTO) {
        email.setDataReferencia(emailDTO.getDataReferencia());
        email.setDataEnvioEmail(emailDTO.getDataEnvioEmail());
        email.setStatusDemanda(emailDTO.getStatusDemanda());
        if (emailDTO.getDataEnvioEmail().equals(TipoDataEnum.DIAS_ANTES_DATA_REFERENCIA.getId())) {
            email.setDiasAnteDataReferencia((emailDTO.getDiasAnteDataReferencia()));
        } else if (emailDTO.getDataEnvioEmail().equals(TipoDataEnum.DIAS_APOS_A_DATA_REFERENCIA.getId())) {
            email.setDiasAposDataReferencia(emailDTO.getDiasAposDataReferencia());
            email.setReenviarAteAlteracaoDoStatus(emailDTO.getReenviarAteAlteracaoDoStatus());
        }
    }

    private void adicionaPerfil(List<PerfilDTO> perfisEnviados, Email email, List<EmailPerfilAcesso> perfisCadastrados) {
        perfisEnviados.forEach(perfilDTO -> {
            PerfilAcessos novoPerfil = getPerfil(perfilDTO);
            boolean possuiPerfil = perfisCadastrados.stream().anyMatch(perfil -> Objects.equals(perfil.getPerfilAcessos().getId(), novoPerfil.getId()));
            if (!possuiPerfil) {
                EmailPerfilAcesso emailPerfilAcesso = new EmailPerfilAcesso();
                emailPerfilAcesso.setEmail(email);
                emailPerfilAcesso.setPerfilAcessos(novoPerfil);
                emailPerfilAcesso.setTipoSolicitacao(email.getTipoSolicitacao());
                emailPerfisRepository.save(emailPerfilAcesso);
            }
        });
    }

    private PerfilAcessos getPerfil(PerfilDTO perfilDTO) {
        return perfilAcessosRepository.findByNomePerfil(PerfilAcessoEnum.getPerfilById(perfilDTO.getId().intValue()));
    }

    public List<TipoDataEnum> listaTipoDataPorTipoSolicitacao(Integer tipoSolicitacao) {
        if (tipoSolicitacao.equals(TipoSolicitacaoEnum.TIPO_SOLICITACAO_PEDIDO.getId())) {
            return Arrays.asList(
                    TipoDataEnum.DATA_FIM_PRAZO_ATENDIMIENTO_E_SIC,
                    TipoDataEnum.DATA_FIM_PRAZO_ATENDIMIENTO_UNIDADE,
                    TipoDataEnum.DATA_FIM_PARA_SUGESTAO_ENCAMINHAMENTO_E_OUV,
                    TipoDataEnum.DATA_FIM_ENVIO_PARA_E_OUV);
        } else if (tipoSolicitacao.equals(TipoSolicitacaoEnum.TIPO_SOLICITACAO_RECURSO.getId())) {
            return Arrays.asList(
                    TipoDataEnum.DATA_FIM_PRAZO_ATENDIMIENTO_E_SIC,
                    TipoDataEnum.DATA_FIM_PRAZO_ATENDIMIENTO_UNIDADE);
        }
        return new ArrayList<>();
    }

    public List<TipoDataEnum> listaTipoDataEnvio() {
        return Arrays.asList(
                TipoDataEnum.NA_DATA_REFERENCIA,
                TipoDataEnum.DIAS_ANTES_DATA_REFERENCIA,
                TipoDataEnum.DIAS_APOS_A_DATA_REFERENCIA);
    }

    public List<StatusSolicitacao> listaStatusDemandaPedido() {
        return statusSolicitacaoRepository.findAll();
    }

    public List<StatusSolicitacaoRecurso> listaStatusDemandaRecurso() {
        return statusSolicitacaoRecursoRepository.findAll();
    }

    public List<TipoAcaoExecutadaPedidoEnum> listaAcoesExecutadasPedido() {
        return Arrays.asList(TipoAcaoExecutadaPedidoEnum.values());
    }

    public List<TipoAcaoExecutadaRecursoEnum> listaAcoesExecutadasRecurso() {
        return Arrays.asList(TipoAcaoExecutadaRecursoEnum.values());
    }

    public List<PerfilAcessoEnum> listaPerfilPorTipoSolicitacao(Integer tipoSolicitacao) {
        if (tipoSolicitacao.equals(TipoSolicitacaoEnum.TIPO_SOLICITACAO_PEDIDO.getId())) {
            return Arrays.asList(
                    PerfilAcessoEnum.ADMIN,
                    PerfilAcessoEnum.ATENDENTE_SIC,
                    PerfilAcessoEnum.PONTO_FOCAL,
                    PerfilAcessoEnum.RESPONDENTE,
                    PerfilAcessoEnum.TECNICO);
        } else if (tipoSolicitacao.equals(TipoSolicitacaoEnum.TIPO_SOLICITACAO_RECURSO.getId())) {
            return Arrays.asList(
                    PerfilAcessoEnum.ADMIN,
                    PerfilAcessoEnum.ATENDENTE_SIC,
                    PerfilAcessoEnum.AUTORIDADE_HIERARQUICA,
                    PerfilAcessoEnum.AUTORIDADE_MAXIMA,
                    PerfilAcessoEnum.PONTO_FOCAL_AUTORIDADE_MAXIMA);
        }
        return new ArrayList<>();
    }

    @Transactional
    public void deletarEmail(Long id) {
        emailRepository.delete(id);
    }

    private List<Long> destinatarios (List<PerfilDTO> destinatarios) {
        return destinatarios.stream().map(PerfilDTO::getId).collect(Collectors.toList());
    }
}
