package br.com.company.fks.excecao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FKSExceptionTest {

    @Test
    public void FKSException(){
        Exception teste = new FKSException("texc");
        assertNotNull(teste);
    }

    @Test
    public void FKSException1(){
        Exception teste = new FKSException("texc");
        Exception teste2 = new FKSException("texc2",teste);
        assertNotNull(teste2);
    }

}