package br.com.company.fks.modelo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class PedidoTest {

    @InjectMocks
    private Pedido pedido;

    @Mock
    private Anexo anexo;

    @Test
    public void addAnexo(){
        pedido.addAnexo(anexo);
    }

}