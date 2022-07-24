package br.com.company.fks.controller;

import br.com.company.fks.repositorio.custom.ArmazenamentoArquivoCustomRepositorio;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileUploadControllerTest {

    @InjectMocks
    private FileUploadController controller;

    @Mock
    private ArmazenamentoArquivoCustomRepositorio armazenamento;

    @Mock
    private Resource file;

    @Test
    public void uploads() {
        List<MultipartFile> files = new ArrayList<>();
        controller.uploads(files, "12","","");
    }

    @Test
    public void downloadFile() {
        when(armazenamento.loadFile(anyString())).thenReturn(file);
        controller.downloadFile("file");
    }

    @Test
    public void deleteFile() {
        controller.deleteFile(anyString());
    }

    @Test
    public void getFile() {
        when(armazenamento.loadFile(anyString())).thenReturn(file);
        Assert.notNull(controller.getFile(anyString()).getBody());
    }

    @Test
    public void listaArquivos(){
        controller.listaArquivos("id", "tipo", "instancia");
    }

    @Test
    public void download(){
        HttpServletResponse response = new MockHttpServletResponse();
        controller.download("caminho", response);
    }
}

