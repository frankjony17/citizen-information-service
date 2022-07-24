package br.com.company.fks.modelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AndamentoTest {
    @InjectMocks
    private Andamento andamento;
    @Mock
    private Calendar dataInicio;
    @Mock
    private Calendar dataFim;

    @Test
    public void andamentoTest(){
        UsuarioAcessos usuarioAcessosAssinatura = new UsuarioAcessos();
        Unidade unidade = new Unidade();
        Pedido pedido = new Pedido();
        andamento.getUsuarioAcessos();
        andamento.setUsuarioAcessosAssinatura(usuarioAcessosAssinatura);
        andamento.getUnidade();
        andamento.setUnidade(unidade);
        andamento.getDataInicio();
        andamento.setDataInicio(dataInicio);
        andamento.getDataFim();
        andamento.setDataFim(dataFim);
        andamento.getPedido();
        andamento.setPedido(pedido);
        andamento.getObservacao();
        andamento.setObservacao("observacao");

    }

}