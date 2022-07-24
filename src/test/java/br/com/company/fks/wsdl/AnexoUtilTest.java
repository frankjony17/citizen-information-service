package br.com.company.fks.wsdl;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.zip.GZIPInputStream;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AnexoUtils.class)
public class AnexoUtilTest {

    @Mock
    private ByteArrayInputStream byteArrayInputStream;
    @Mock
    private GZIPInputStream gzipInputStream;
    @Mock
    private File file;


    @Test
    @SneakyThrows
    public void TestDezipSalva(){

//        when(new GZIPInputStream(any())).thenReturn(gzipInputStream);
        PowerMockito.whenNew(GZIPInputStream.class).withAnyArguments().thenReturn(gzipInputStream);
        PowerMockito.whenNew(ByteArrayInputStream.class).withAnyArguments().thenReturn(byteArrayInputStream);
        AnexoUtils anexoUtils = new AnexoUtils();
        ReflectionTestUtils.setField(anexoUtils, "uploadPath", System.getProperty("java.io.tmpdir"));
        anexoUtils.dezipaSalva( new byte[1024],"98234567","teste");

    }

    @Test
    @SneakyThrows
    public void TestDezipSalvaException(){
        PowerMockito.whenNew(GZIPInputStream.class).withAnyArguments().thenReturn(gzipInputStream);
        PowerMockito.whenNew(ByteArrayInputStream.class).withAnyArguments().thenReturn(byteArrayInputStream);
        AnexoUtils anexoUtils = new AnexoUtils();
        anexoUtils.dezipaSalva( new byte[1024],null,"teste");

    }

    @Test
    @SneakyThrows
    public void TestGetFile(){

//        when(new GZIPInputStream(any())).thenReturn(gzipInputStream);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        AnexoUtils anexoUtils = new AnexoUtils();
        File retorno = anexoUtils.getFile("98234567","teste");

        Assert.assertEquals(retorno, file);

    }

}
