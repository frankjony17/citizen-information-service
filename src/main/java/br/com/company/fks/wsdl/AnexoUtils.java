package br.com.company.fks.wsdl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

@Component
public class AnexoUtils {

    private static final Logger LOGGER = Logger.getLogger(AnexoUtils.class);

    @Value( "${upload.path}" )
    private String uploadPath;

    public void dezipaSalva(byte[] bytesZip, String protocolo, String nomeArquivo) throws
            IOException {
        OutputStream out = null;
        try {
            criarDiretorio(uploadPath + "/" + protocolo);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytesZip);
            GZIPInputStream gzipInputStream = new GZIPInputStream(bais);
            out = new FileOutputStream(uploadPath + "/" + protocolo + "/" + nomeArquivo);
            byte[] buf = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            gzipInputStream.close();
        } catch (IOException e) {
            LOGGER.error("ERRO AO TENTAR DEZIPAR E SALVAR ARQUIVO", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void criarDiretorio(String pathname) throws IOException {
        File file = new File(pathname);
        if (!file.exists() && !file.mkdir()) {
            throw new IOException("Problema ao criar o diretório: " + pathname);
        }
    }

    public File getFile(String protocolo, String nomeArquivo) {
        return new File(uploadPath + "/" + protocolo + "/" + nomeArquivo);
    }
}