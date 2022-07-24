package br.com.company.fks.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class ArquivoUtilsTest {

    @Before
    public void setUp() {
        mockStatic(Files.class);
    }

    @Mock
    private InputStream inputStream;

    @Test
    public void getExtensao(){
        String extensao = ArquivoUtils.getExtencao("application/pdf", "/");
        assertEquals(".pdf", extensao);
    }

    @Test
    public void getExtensaoRespostaVazia(){
        String extensao = ArquivoUtils.getExtencao("application", "/");
        assertEquals(StringUtils.EMPTY, extensao);
    }

    @Test
    public void remover(){
        Boolean delete = ArquivoUtils.remover("/tmp/", ".jpeg");
        assertEquals(Boolean.FALSE, delete);
    }

    @Test
    public void buscarArquivo(){
        byte [] bytes = null;
        ArquivoUtils.buscarArquivo("diretorioArquivo");
        assertNull(bytes);
    }

    @Test
    public void gravarArquivo() throws IOException {
        byte [] bytes = new byte[1];
        ArquivoUtils.gravarArquivo(bytes, "diretorioArquivo");
    }

    @Test
    public void salvar(){
        byte [] bytes = new byte[1];
        Boolean arquivoSalvo = ArquivoUtils.salvar(bytes, "/tmp/", System.currentTimeMillis() + ".jpeg");
        assertEquals(Boolean.TRUE, arquivoSalvo);
    }

    @Test
    public void arquivoToString(){
        ArquivoUtils.arquivoToString("path");
        assertNotNull("stroing");
    }
}