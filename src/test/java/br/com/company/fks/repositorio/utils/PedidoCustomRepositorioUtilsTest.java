package br.com.company.fks.repositorio.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoCustomRepositorioUtilsTest {

    @InjectMocks
    private PedidoCustomRepositorioUtils utils;

    @Test
    public void getconcatenarQuery()  {
        List<String> queries = new ArrayList<>();
        String newBase = new String();
        String query = new String();
        utils.equals(true);

    }



}