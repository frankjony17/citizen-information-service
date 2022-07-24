package br.com.company.fks.utils;

import lombok.NonNull;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by Maicon Godoy - FKSolutions Tecnologia on 17/10/18.
 */
public final class ArquivoUtils {

    private ArquivoUtils() {
    }

    private static final Logger LOGGER = Logger.getLogger(ArquivoUtils.class);

    public static String arquivoToString(String path) {
        String content = null;
        BufferedReader buffer = null;
        InputStream in = null;
        try {
            String subReportPath = Paths.get(path).toString();
            in = new ClassPathResource(subReportPath).getInputStream();
            buffer = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            content = buffer.lines().collect(Collectors.joining("\n"));

        } catch (IOException e) {
            LOGGER.error(Level.ERROR, e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(buffer);
        }
        return content;
    }

    public static Boolean salvar(byte[] bytes, String diretorioArquivo, String nome) {
        try {
            criaDiretorioSeNaoExiste(diretorioArquivo);
            Path pathArquivo = Paths.get(diretorioArquivo, nome);
            Files.write(pathArquivo, bytes);
            return Boolean.TRUE;
        } catch (IOException e) {
            LOGGER.error("ERRO SALVAR ARQUIVO", e);
            return Boolean.FALSE;
        }
    }

    public static void criaDiretorioSeNaoExiste(@NonNull String path) throws IOException {
        Path diretorio = Paths.get(path);
        Files.createDirectories(diretorio);
    }

    public static Boolean remover(String diretorio, String nome) {
        Path path = Paths.get(diretorio + nome);
        try {
            Files.delete(path);
            return Boolean.TRUE;
        } catch (IOException e) {
            LOGGER.error("ERRO REMOVER ARQUIVO",e);
            return Boolean.FALSE;
        }
    }

    public static String getExtencao(String contentType, String separador) {
        String[] extensao = contentType.split(separador);
        if (extensao.length > 1) {
            return "." + extensao[extensao.length - 1];
        }
        return StringUtils.EMPTY;
    }


    public static void gravarArquivo(byte[] bytes, String diretorioArquivo) throws IOException {
        Path pathArquivo = Paths.get(verificaSeDiretorioHome(diretorioArquivo));
        Files.write(pathArquivo, bytes);
    }

    private static String verificaSeDiretorioHome(String diretorioArquivo) {
        String s = Constants.TIL + File.separator;

        if (diretorioArquivo.startsWith(s)) {
            return diretorioArquivo.replaceFirst(
                    Constants.DIRETORIO_HOME, System.getProperty("user.home"));
        }

        return diretorioArquivo;
    }

    public static byte[] buscarArquivo(String diretorioArquivo) {
        byte[] bytes = null;
        try {
            Path pathArquivo = Paths.get(verificaSeDiretorioHome(diretorioArquivo));
            bytes = Files.readAllBytes(pathArquivo);
        } catch (IOException e) {
            LOGGER.error("ERRO AO LER ARQUIVO", e);
        }
        return bytes;
    }

}
