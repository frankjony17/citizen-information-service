package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.EmailDTO;
import br.com.company.fks.modelo.dto.EmailFiltroDTO;
import br.com.company.fks.modelo.enums.TipoDataEnum;
import br.com.company.fks.servico.EmailService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailControllerTest {

    @InjectMocks
    private EmailController emailController;

    @Mock
    private EmailService emailService;

    @Mock
    private EmailFiltroDTO emailFiltroDTO;

    @Mock
    private EmailDTO emailDTO;

    @Test
    public void listTipDataPorSolicitacao(){
        List<TipoDataEnum> dataEnumList = new ArrayList<>();
        when(emailService.listaTipoDataPorTipoSolicitacao(1)).thenReturn(dataEnumList);
        emailController.listTipDataPorSolicitacao(1);
    }

    @Test
    public void listaTipoDataEnvio(){
        emailController.listaTipoDataEnvio();
    }

    @Test
    public void listaStatusDemandaPedido(){
        emailController.listaStatusDemandaPedido();
    }

    @Test
    public void listaStatusDemandaRecurso(){
        emailController.listaStatusDemandaRecurso();
    }

    @Test
    public void listaAcoesExecutadasPedido(){
        emailController.listaAcoesExecutadasPedido();
    }

    @Test
    public void listaAcoesExecutadasRecurso(){
        emailController.listaAcoesExecutadasRecurso();
    }

    @Test
    public void listaPerfilPorTipoSolicitacao(){
        emailController.listaPerfilPorTipoSolicitacao(1);
    }

    @Test
    public void deletarEmail(){
        emailController.deletarEmail(1L);
    }

    @Test
    public void buscaPorId(){
        emailController.buscaPorId(1L);
    }

    @Test
    public void listarAssunto(){
        emailController.listarAssunto();
    }

    @Test
    public void listarEmail(){
        emailController.listarEmail("filtro");
    }

    @Test
    @SneakyThrows
    public void listarEmailCatch(){
        emailController.listarEmail("filtro");
    }

    @Test
    public void salvar(){
        emailController.salvar(emailDTO);
    }
}