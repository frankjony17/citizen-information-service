package br.com.company.fks.servico;

import br.com.company.fks.modelo.Andamento;
import br.com.company.fks.modelo.AndamentoRecurso;
import br.com.company.fks.modelo.Email;
import br.com.company.fks.modelo.EmailPerfilAcesso;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.PerfilAcessos;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.UsuarioAcessoPerfilAcesso;
import br.com.company.fks.repositorio.AndamentoRecursoRepository;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.EmailPerfisRepository;
import br.com.company.fks.repositorio.EmailRepository;
import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.UsuarioAcessoPerfilAcessoRepository;
import br.com.company.fks.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EmailNotificacaoService {

    private final Calendar hoje = clear(Calendar.getInstance());

    private Pedido pedido;
    private Recurso recurso;
    private String protocolo = "";
    private String dataReferencia = "";

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FeriadoRepository feriadoRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private EmailPerfisRepository emailPerfisRepository;

    @Autowired
    private AndamentoRecursoRepository andamentoRecursoRepository;

    @Autowired
    private UsuarioAcessoPerfilAcessoRepository usuarioAcessoPerfilAcessoRepository;

    /**
     * Obter e aplicar todas as regras associadas aos E-mail = tipoAlerta = data.
     */
    public void enviarEmailsPorData() {
        List<Email> emailList = emailRepository.findAllByTipoAlerta(1);
        for (Email email : emailList) {
            if (email.getTipoSolicitacao().equals(1)) {
                protocoloPedido(email);
            } else {
                protocoloRecurso(email);
            }
        }
    }

    /**
     * Obter Pedidos pelo StatusSolicitacao.
     *
     * @param email Email.
     */
    private void protocoloPedido(Email email) {
        List<Pedido> pedidoList = pedidoRepository.findAllByStatusSolicitacaoId(email.getStatusDemanda().longValue());
        for (Pedido p : pedidoList) {
            setPedidoRecurso(p, null);
            Calendar dataEnvio = obterDataEnvioValida(email);
            regraDataEnvioEmail(email, dataEnvio);
        }
    }

    /**
     * Obter Recursos pelo StatusSolicitacao.
     *
     * @param email Email.
     */
    private void protocoloRecurso(Email email) {
        List<Recurso> recursoList = recursoRepository.findAllByStatusSolicitacaoId(email.getStatusDemanda().longValue());
        for (Recurso r : recursoList) {
            setPedidoRecurso(null, r);
            Calendar dataEnvio = obterDataEnvioValida(email);
            regraDataEnvioEmail(email, dataEnvio);
        }
    }

    /**
     * Enviar emils.
     *
     * @param email Email.
     */
    private void enviarEmail(Email email) {
        List<UsuarioAcessoPerfilAcesso> usuarioAcessoPerfilAcessos = null;
        List<EmailPerfilAcesso> emailPerfilAcessoList = emailPerfisRepository.findAllByEmailId(email.getId());
        if (this.pedido != null) {
            usuarioAcessoPerfilAcessos = obterPedidoUsuarioPerfilList(emailPerfilAcessoList, email.getStatusDemanda().longValue());
        }
        if (this.recurso != null) {
            usuarioAcessoPerfilAcessos = obterRecursoUsuarioPerfilList(emailPerfilAcessoList, email.getStatusDemanda().longValue());
        }
        for (UsuarioAcessoPerfilAcesso usuarioAcessoPerfilAcesso : usuarioAcessoPerfilAcessos) {
            sendMailService.enviarHtmlMail(
                    email.getAssuntoEmail(),
                    email.getConteudoEmail().replace("{{#NO-PROTOCOLO#}}", this.protocolo).replace("{{#DATA-REFERENCIA#}}", this.dataReferencia),
                    usuarioAcessoPerfilAcesso.getUsuarioAcessos().getEmailUsuario()
            );
        }
    }

    /**
     * Obter data válida de acordo com dataReferencia do e-mail.
     * case 1: // Data de fim do prazo de atendimiento e-sic.
     * case 2: // Data de fim do prazo de atendimiento da Unidade.
     * case 3: // Data de fim para sugestão de encaminhamento e-OUV.
     * default: // 4 = Data de fim de envio para e-OUV.
     *
     * @param email Email.
     * @return Calendar dataEnvio.
     */
    private Calendar obterDataEnvioValida (Email email) {
        Calendar dataEnvio;
        List<Calendar> calendarList = obterData();
        switch (email.getDataReferencia()) {
            case 1:
                dataEnvio = calendarList.get(0);
                this.dataReferencia = DataUtil.getDataFormatada(calendarList.get(0)); break;
            case 2:
                dataEnvio = calendarList.get(1);
                this.dataReferencia = DataUtil.getDataFormatada(calendarList.get(1)); break;
            case 3:
                dataEnvio = dataEncaminhamentoEOUV(calendarList.get(2));
                this.dataReferencia = DataUtil.getDataFormatada(calendarList.get(2)); break;
            default:
                dataEnvio = dataEnvioEOUV(calendarList.get(2));
                this.dataReferencia = DataUtil.getDataFormatada(calendarList.get(2)); break;
        }
        return clear(dataEnvio);
    }

    /**
     * Obter data fim para sugestão de encaminhamento e-OUV.
     *
     * @param dataRegistro data do Pedido. (dataRegistro + 5 dias - 1 dia;)
     * @return Calendar.
     */
    private Calendar dataEncaminhamentoEOUV(Calendar dataRegistro) {
        Calendar novadataRegistro = DataUtil.addDays(dataRegistro, 4);
        return dataEnvioEmail(novadataRegistro, "-");
    }

    /**
     * Obter data fim de envio para o e-OUV.
     *
     * @param dataRegistro data do Pedido. (dataRegistro + 5 dias;)
     * @return Calendar.
     */
    private Calendar dataEnvioEOUV(Calendar dataRegistro) {
        Calendar novadataRegistro = DataUtil.addDays(dataRegistro, 5);
        return dataEnvioEmail(novadataRegistro, "+");
    }

    /**
     * Obtenha uma data válida que não seja sábado, domingo ou feriado, apenas dias úteis.
     *
     * @param dataReferencia Data do referência.
     * @param operacao       '+' o '-', depende da regra.
     * @return Calendar.
     */
    private Calendar dataEnvioEmail(Calendar dataReferencia, String operacao) {
        Calendar temp = dataReferencia;
        while (true) {
            Long feriado = feriadoRepository.countByDataFeriado(dataReferencia);
            if (dataReferencia.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && dataReferencia.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && feriado.intValue() == 0) {
                break;
            } else {
                temp = obterNewData(dataReferencia, operacao);
            }
        }
        return temp;
    }

    /**
     * Procurar dia útil, dependendo da 'operacao' procuro antes ou depois da data de referência.
     *
     * @param dataReferencia Data de referência.
     * @param operacao       '+' o '-', depende da regra.
     * @return Calendar.
     */
    private Calendar obterNewData(Calendar dataReferencia, String operacao) {
        Calendar novadataReferencia = null;
        if ("+".equals(operacao)) {
            novadataReferencia = DataUtil.addDays(dataReferencia, 1);
        } else {
            novadataReferencia = DataUtil.addDays(dataReferencia, -1);
        }
        return novadataReferencia;
    }

    /**
     * Aplicar regra de envio de e-mail, se for cumprida, o e-mail é enviado.
     * case 5: // NA_DATA_REFERENCIA(5, "Na data de referência").
     * case 6: // DIAS_ANTES_DATA_REFERENCIA(6, "Dias antes da data de referência").
     * default: // DIAS_APOS_A_DATA_REFERENCIA(7, "Dias após a data de referência").
     *
     * @param email     Email.
     * @param dataEnvio Data do envio.
     */
    private void regraDataEnvioEmail(Email email, Calendar dataEnvio) {
        Calendar newData = dataEnvio;
        switch (email.getDataEnvioEmail()) {
            case 5:
                if (regraNaDataReferencia(newData)) {
                    enviarEmail(email);
                }
                break;
            case 6:
                newData = regraDiasAntesDataReferencia(email, newData);
                if (esMesmaData(newData)) {
                    enviarEmail(email);
                }
                break;
            default:
                newData = regraDiasAposDataReferencia(email, newData);
                if (esMesmaData(newData)) {
                    enviarEmail(email);
                }
                break;
        }
    }

    /**
     * Regra: Na data de referência.
     *
     * @param dataEnvio Data envio.
     * @return Boolean.
     */
    private Boolean regraNaDataReferencia(Calendar dataEnvio) {
        return esMesmaData(dataEnvio);
    }

    /**
     * Regra: Dias antes da data de referência.
     *
     * @param email     Email.
     * @param dataEnvio Data do envio.
     * @return Calendar.
     */
    private Calendar regraDiasAntesDataReferencia(Email email, Calendar dataEnvio) {
        Calendar novadataEnvio = DataUtil.addDays(dataEnvio, -email.getDiasAnteDataReferencia().intValue());
        return dataEnvioEmail(novadataEnvio, "-");
    }

    /**
     * Regra: Dias após a data de referência.
     *
     * @param email     Email.
     * @param dataEnvio Data do envio.
     * @return Calendar.
     */
    private Calendar regraDiasAposDataReferencia(Email email, Calendar dataEnvio) {
        Calendar novadataEnvio = null;
        novadataEnvio = DataUtil.addDays(dataEnvio, email.getDiasAposDataReferencia());
        novadataEnvio = dataEnvioEmail(novadataEnvio, "+");
        if (email.getReenviarAteAlteracaoDoStatus() && (dataEnvio.getTime().before(hoje.getTime()))) {
            novadataEnvio = hoje;
        }
        return novadataEnvio;
    }

    /**
     * Comparar a data de envio com a data atual (hoje).
     *
     * @param dataEnvio data do envio.
     * @return Boolean.
     */
    private Boolean esMesmaData(Calendar dataEnvio) {
        Boolean bool = false;
        if (dataEnvio.getTime().equals(hoje.getTime())) {
            bool = true;
        }
        return bool;
    }

    /**
     * Obter data do Pedido e Recurso.
     *
     * @return List<Calendar>.
     */
    private List<Calendar> obterData() {
        List<Calendar> calendarList = new ArrayList<>(3);
        if (this.pedido != null) {
            calendarList.add(this.pedido.getPrazoAtendimento());
            calendarList.add(this.pedido.getVencimentoUnidade());
            calendarList.add(this.pedido.getDataRegistro());
        }
        if (this.recurso != null) {
            calendarList.add(this.recurso.getDataPrazoAtendimento());
            calendarList.add(this.recurso.getVencimentoUnidade());
            calendarList.add(Calendar.getInstance());
        }
        return calendarList;
    }

    /**
     * Troco valor do Pedido e Recurso.
     *
     * @param pedido  Pedido ou null.
     * @param recurso Recurso ou null.
     */
    private void setPedidoRecurso(Pedido pedido, Recurso recurso) {
        this.pedido = pedido;
        this.recurso = recurso;
        this.protocolo = "";
        if (this.pedido != null) {
            this.protocolo = this.pedido.getProtocolo();
        }
        if (this.recurso != null) {
            this.protocolo = this.recurso.getProtocoloPedido();
        }
    }

    /**
     * Obter Calendar sem tempo.
     *
     * @param date Calendar.
     * @return Calendar sem tempo.
     */
    private Calendar clear(Calendar date) {
        date.set(Calendar.HOUR, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }

    /**
     * Obter usuarios pelo perfis e unidade vinculado no Pedido.
     *
     * @param emailPerfilAcessoList Lista de EmailPerfilAcessos.
     * @param idStatusDemanda       ID StatusDemanda = StatusSolicitacao.
     * @return List<UsuarioAcessoPerfilAcesso>.
     */
    private List<UsuarioAcessoPerfilAcesso> obterPedidoUsuarioPerfilList(List<EmailPerfilAcesso> emailPerfilAcessoList, Long idStatusDemanda) {
        List<UsuarioAcessoPerfilAcesso> usuarioAcessoPerfilAcessos = new ArrayList<>();
        Andamento andamento = andamentoRepository.findTopByPedidoIdAndStatusSolicitacaoId(this.pedido.getId(), idStatusDemanda);
        if (andamento != null) {
            usuarioAcessoPerfilAcessos = usuarioAcessoPerfilAcessoRepository.findAllByUsuarioAcessosUnidadeIdAndPerfilAcessosIn(
                    andamento.getUnidade().getId(),
                    obterTudosOsPerfis(emailPerfilAcessoList)
            );
        }
        return usuarioAcessoPerfilAcessos;
    }

    /**
     * Obter usuarios pelo perfis e unidade vinculado no Recurso.
     *
     * @param emailPerfilAcessoList Lista de EmailPerfilAcessos.
     * @param idStatusDemanda       ID StatusDemanda = StatusSolicitacao.
     * @return List<UsuarioAcessoPerfilAcesso>
     */
    private List<UsuarioAcessoPerfilAcesso> obterRecursoUsuarioPerfilList(List<EmailPerfilAcesso> emailPerfilAcessoList, Long idStatusDemanda) {
        List<UsuarioAcessoPerfilAcesso> usuarioAcessoPerfilAcessos = new ArrayList<>();
        AndamentoRecurso andamentoRecurso = andamentoRecursoRepository.findTopByRecursoIdAndStatusSolicitacaoRecursoId(this.recurso.getId(), idStatusDemanda);
        if (andamentoRecurso != null) {
            usuarioAcessoPerfilAcessos = usuarioAcessoPerfilAcessoRepository.findAllByUsuarioAcessosUnidadeIdAndPerfilAcessosIn(
                    andamentoRecurso.getUnidade(),
                    obterTudosOsPerfis(emailPerfilAcessoList)
            );
        }
        return usuarioAcessoPerfilAcessos;
    }

    /**
     * Obter tudos os destinatarios (PerfilAcesso).
     *
     * @param emailPerfilAcessoList List<EmailPerfilAcesso>.
     * @return List<PerfilAcesso>.
     */
    private List<PerfilAcessos> obterTudosOsPerfis(List<EmailPerfilAcesso> emailPerfilAcessoList) {
        List<PerfilAcessos> perfilAcessosList = new ArrayList<>();
        for (EmailPerfilAcesso emailPerfilAcesso : emailPerfilAcessoList) {
            perfilAcessosList.add(emailPerfilAcesso.getPerfilAcessos());
        }
        return perfilAcessosList;
    }
}
