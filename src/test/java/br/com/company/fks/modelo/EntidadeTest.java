package br.com.company.fks.modelo;

import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by christian-tavares on 21/03/18.
 */
public class EntidadeTest {

    Set<Class<? extends Serializable>> allClasses;
    GetterAndSetterTester tester;

    @Before
    public void setUp() {
        tester = new GetterAndSetterTester();
        Reflections reflections = new Reflections("br.gov.mpog.fks.modelo");
        allClasses = reflections.getSubTypesOf(Serializable.class);
    }

    @Test
    public void testarTodasEntidades() {
        for (Class<? extends Object> clazz : allClasses)
            tester.testClass(clazz);
    }
}
