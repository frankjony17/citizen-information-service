package br.com.company.fks.servico;

import br.com.company.fks.modelo.Email;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.repositorio.EmailRepository;
import br.com.company.fks.repositorio.FeriadoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class EmailNotificacaoServiceTest {

    @InjectMocks
    private EmailNotificacaoService emailNotificacaoService;

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private Email email;

    @Mock
    private RecursoRepository recursoRepository;

    @Mock
    private Recurso recurso;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private Pedido pedido;

    @Mock
    private Calendar calendar;

    @Mock
    private FeriadoRepository feriadoRepository;

    @Test
    public void enviarEmailsPorData(){
        List<Email> emailList = new ArrayList<>();
        when(emailRepository.findAllByTipoAlerta(1)).thenReturn(emailList);
        emailNotificacaoService.enviarEmailsPorData();
    }

    @Test
    public void enviarEmailsPorData2(){
        List<Email> emailList = new ArrayList<>();
        emailList.add(email);
        when(emailRepository.findAllByTipoAlerta(1)).thenReturn(emailList);
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(recursoRepository.findAllByStatusSolicitacaoId(1L)).thenReturn(recursoList);
        emailNotificacaoService.enviarEmailsPorData();
    }

    @Test
    public void enviarEmailsPorDataIguala1(){
        List<Email> emailList = new ArrayList<>();
        emailList.add(email);
        when(emailRepository.findAllByTipoAlerta(1)).thenReturn(emailList);
        List<Recurso> recursoList = new ArrayList<>();
        recursoList.add(recurso);
        when(recursoRepository.findAllByStatusSolicitacaoId(1L)).thenReturn(recursoList);
        when(email.getTipoSolicitacao()).thenReturn(1);
        emailNotificacaoService.enviarEmailsPorData();
    }

    @Test
    @Ignore
    public void protocoloPedidoTest() throws Exception {
        List<Pedido> lista = new ArrayList<>();
        lista.add(pedido);
        lista.add(pedido);
        lista.add(pedido);

        EmailNotificacaoService emailSpy = Mockito.spy(emailNotificacaoService);

//        Mockito.doReturn(calendar).when(emailSpy).obterDataEnvioValida(email);
//        Mockito.doNothing().when(emailSpy).regraDataEnvioEmail(email, calendar);

        when(email.getStatusDemanda()).thenReturn(Integer.valueOf(1));
        when(pedidoRepository.findAllByStatusSolicitacaoId(1L)).thenReturn(lista);
        when(feriadoRepository.countByDataFeriado(any(Calendar.class))).thenReturn(0L);
        when(calendar.get(anyInt())).thenReturn(5);

        PowerMockito.when(emailSpy, "obterDataEnvioValida", email).thenReturn(calendar);
        PowerMockito.doNothing().when(emailSpy, "regraDataEnvioEmail", email, calendar);


        Method method = EmailNotificacaoService.class.getDeclaredMethod("protocoloPedido", Email.class);
        method.setAccessible(true);
        method.invoke(emailSpy, email);

        Mockito.verify(pedido, Mockito.times(4)).getProtocolo();
    }

    @Test
    public void obterData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = EmailNotificacaoService.class.getDeclaredMethod("obterData");
        method.setAccessible(true);
        Assert.assertNotNull(method.invoke(emailNotificacaoService));
    }

    @Test
    @Ignore
    public void regraDataEnvioEmail() throws Exception {
        EmailNotificacaoService emailNotificacaoServiceSpy = PowerMockito.spy(emailNotificacaoService);


        Method clear = EmailNotificacaoService.class.getDeclaredMethod("clear", Calendar.class);
        clear.setAccessible(true);
        Calendar hoje = (Calendar) clear.invoke(emailNotificacaoServiceSpy, Calendar.getInstance());


        when(email.getDataEnvioEmail()).thenReturn(5);
        when(calendar.getTime()).thenReturn(hoje.getTime());

        PowerMockito.when(emailNotificacaoServiceSpy, "esMesmaData", hoje).thenReturn(true);
        Method method = EmailNotificacaoService.class.getDeclaredMethod("regraDataEnvioEmail", Email.class, Calendar.class);
        method.setAccessible(true);
        method.invoke(emailNotificacaoServiceSpy, email, calendar);
    }

}