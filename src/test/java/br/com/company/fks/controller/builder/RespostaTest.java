package br.com.company.fks.controller.builder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RespostaTest {

    @Test
    public void test() {
        Resposta r = new Resposta();
        r.setTotalElementos(10L);
        r.setErros(Arrays.asList("Erro1", "erro2"));
        r.setMensagens(Arrays.asList("msg1", "msg2"));
        r.setTotalPaginas(1);
        r.setResultado(new Object());
        Assert.assertNotNull(r.getErros());
        Assert.assertNotNull(r.getMensagens());
        Assert.assertNotNull(r.getTotalElementos());
        Assert.assertNotNull(r.getTotalPaginas());
        Assert.assertNotNull(r.getResultado());
    }
}
