package br.com.company.fks.excecao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ObjectMapperExceptionTest {

    @Test
    public void ObjectMapperExceptionTest(){
        Exception teste = new ObjectMapperException("tow");
        assertNotNull(teste);
    }
    @Test
    public void ObjectMapperExceptionTest2(){
        Exception teste = new ObjectMapperException("tow");
        Exception teste1 = new ObjectMapperException("tow1",teste);
        assertNotNull(teste1);
    }

}
