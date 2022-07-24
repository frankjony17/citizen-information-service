package br.com.company.fks.repositorio;

import br.com.company.fks.modelo.dto.ArquivoDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface ArmazenamentoArquivoRepository {

    void store(List<MultipartFile> files, String pedido, String tipo, String instancia);

    Resource loadFile(String fileName);

    List<ArquivoDTO> listaArquivos(String id, String tipo, String instancia);

    void deleteAll();

    void excluiArquivo(String caminho);

    void init();

    Stream<Path> loadFiles(String pedido);

    void download(String caminho, HttpServletResponse response);
}
