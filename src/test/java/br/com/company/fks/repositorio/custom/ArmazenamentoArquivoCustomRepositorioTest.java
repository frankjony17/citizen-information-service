package br.com.company.fks.repositorio.custom;

import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class ArmazenamentoArquivoCustomRepositorioTest {

    @InjectMocks
    private ArmazenamentoArquivoCustomRepositorio armazenamentoArquivoCustomRepositorio;

    @Mock
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Resource resource;

    @Test
    public void validaDiretorio(){
        armazenamentoArquivoCustomRepositorio.validaDiretorio();
    }

    @Test
    public void loadFile(){
        armazenamentoArquivoCustomRepositorio.loadFile("fileName");
    }

    @Test
    public void loadFile2(){
        when(resource.exists()).thenReturn(true);
        armazenamentoArquivoCustomRepositorio.loadFile("fileName");
    }

    @Test
    public void download(){
        armazenamentoArquivoCustomRepositorio.download("caminho", response);
    }

    @Test
    public void deleteAll(){
        armazenamentoArquivoCustomRepositorio.deleteAll();
    }

    @Test
    public void excluiArquivo(){
        armazenamentoArquivoCustomRepositorio.excluiArquivo("caminho");
    }

    @Test
    public void init(){
        armazenamentoArquivoCustomRepositorio.init();
    }

    @Test
    public void listaArquivos(){
        armazenamentoArquivoCustomRepositorio.listaArquivos("id", "tipo", "instancia");
    }

}