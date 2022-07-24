package br.com.company.fks.servico;

import br.com.company.fks.excecao.FKSException;
import br.com.company.fks.modelo.Email;
import br.com.company.fks.modelo.EmailPerfilAcesso;
import br.com.company.fks.modelo.StatusSolicitacao;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.dto.EmailDTO;
import br.com.company.fks.modelo.dto.EmailFiltroDTO;
import br.com.company.fks.modelo.dto.PerfilDTO;
import br.com.company.fks.repositorio.EmailPerfisRepository;
import br.com.company.fks.repositorio.EmailRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRecursoRepository;
import br.com.company.fks.repositorio.StatusSolicitacaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class EmailServiceTest {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private EmailPerfisRepository emailPerfisRepository;

    @Mock
    private EmailPerfilAcesso emailPerfilAcesso;

    @Mock
    private Email email;

    @Mock
    private StatusSolicitacaoRepository statusSolicitacaoRepository;

    @Mock
    private StatusSolicitacao statusSolicitacao;

    @Mock
    private StatusSolicitacaoRecursoRepository statusSolicitacaoRecursoRepository;

    @Mock
    private StatusSolicitacaoRecurso statusSolicitacaoRecurso;

    @Mock
    private EmailFiltroDTO emailFiltroDTO;

    @Mock
    private PerfilDTO perfilDTO;

    @Mock
    private EmailDTO emailDTO;

    @Test
    public void buscaEmailPorId(){
        when(emailRepository.findOne(1L)).thenReturn(email);
        emailService.buscaEmailPorId(1L);
    }

    @Test(expected = FKSException.class)
    public void buscaEmailPorIdException(){
        when(emailRepository.findOne(1L)).thenReturn(null);
        emailService.buscaEmailPorId(1L);
    }

    @Test
    public void obterAssunto(){
        emailService.obterAssunto();
    }

    @Test
    public void obterAssuntoIf(){
        List<String> emailList = new ArrayList<>();
        emailList.add("qwerty");
        when(emailRepository.findAssuntoEmail()).thenReturn(emailList);
        emailService.obterAssunto();
    }

    @Test
    public void listaTipoDataPorTipoSolicitacao(){
        emailService.listaTipoDataPorTipoSolicitacao(0);
    }

    @Test
    public void listaTipoDataPorTipoSolicitacaoIf(){
        emailService.listaTipoDataPorTipoSolicitacao(1);
    }

    @Test
    public void listaTipoDataPorTipoSolicitacaoElseIf(){
        emailService.listaTipoDataPorTipoSolicitacao(2);
    }

    @Test
    public void listaTipoDataEnvio(){
        emailService.listaTipoDataEnvio();
    }

    @Test
    public void listaStatusDemandaPedido(){
        List<StatusSolicitacao> statusSolicitacaosList = new ArrayList<>();
        statusSolicitacaosList.add(statusSolicitacao);
        when(statusSolicitacaoRepository.findAll()).thenReturn(statusSolicitacaosList);
        emailService.listaStatusDemandaPedido();
    }

    @Test
    public void listaStatusDemandaRecurso(){
        List<StatusSolicitacaoRecurso> statusSolicitacaoRecursoList = new ArrayList<>();
        statusSolicitacaoRecursoList.add(statusSolicitacaoRecurso);
        when(statusSolicitacaoRecursoRepository.findAll()).thenReturn(statusSolicitacaoRecursoList);
        emailService.listaStatusDemandaRecurso();
    }

    @Test
    public void listaAcoesExecutadasPedido(){
        emailService.listaAcoesExecutadasPedido();
    }

    @Test
    public void listaAcoesExecutadasRecurso(){
        emailService.listaAcoesExecutadasRecurso();
    }

    @Test
    public void listaPerfilPorTipoSolicitacao(){
        emailService.listaPerfilPorTipoSolicitacao(3);
    }

    @Test
    public void listaPerfilPorTipoSolicitacaoIf(){
        emailService.listaPerfilPorTipoSolicitacao(1);
    }

    @Test
    public void listaPerfilPorTipoSolicitacaoElseIf(){
        emailService.listaPerfilPorTipoSolicitacao(2);
    }

    @Test
    public void deletarEmail(){
        emailService.deletarEmail(1L);
    }

    @Test
    public void deletarEmailNull(){
        emailService.deletarEmail(null);
    }

}