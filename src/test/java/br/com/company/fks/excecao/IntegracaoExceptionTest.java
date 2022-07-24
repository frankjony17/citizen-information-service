package br.com.company.fks.excecao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.swing.*;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IntegracaoExceptionTest extends Exception{



    @Test
    public void IntegracaoExceptionTest2() {
        Exception teste = new IntegracaoException("tey");
        assertNotNull(teste);
    }

    @Test
    public void IntegracaoExceptionTest3() {
        Exception teste = new IntegracaoException("tey");
        Exception teste2 = new IntegracaoException("tey",teste);
        assertNotNull(teste2);
    }

}
