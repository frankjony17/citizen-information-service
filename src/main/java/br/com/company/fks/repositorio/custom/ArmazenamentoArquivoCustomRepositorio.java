package br.com.company.fks.repositorio.custom;

import br.com.company.fks.excecao.FKSException;
import br.com.company.fks.modelo.dto.ArquivoDTO;
import br.com.company.fks.repositorio.ArmazenamentoArquivoRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Service
public class ArmazenamentoArquivoCustomRepositorio implements ArmazenamentoArquivoRepository {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private static final String PATH = "media/filestorage/";

    private Path rootLocation = Paths.get("media/filestorage");

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    private String devolver;
    private String subDiretorio;
    private List<ArquivoDTO> listaArquivos;

    @Override
    public void store(List<MultipartFile> files, String pedido, String tipo, String instancia) {
        this.defineSubDiretorio(tipo, instancia);
        setRootLocation(Paths.get(PATH + subDiretorio + "/" + pedido + "/" + usuarioLogadoUtil.getUsuario().getId()));
        for (MultipartFile file : files) {
            try {
                validaDocumento(file, pedido);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Erro no upload de arquivos!!", e) ;
            } catch (FKSException fks) {
                LOGGER.log(Level.WARNING, fks.getMessage(), fks) ;
            }
        }
    }

    private void validaDocumento(MultipartFile file, String pedido) throws IOException {
        validaDiretorio();
        String[] extensao = file.getOriginalFilename().split("\\.");
        if (existFile(file.getOriginalFilename(), pedido)) {
            throw new FKSException(file.getOriginalFilename() + " já existe no servidor de arquivos");
        }
        if (fileCount(Paths.get(PATH + subDiretorio + "/" + pedido)) + 1 > 10) {
            throw new FKSException("Limite máximo de 10 arquivos atingido");
        }
        if (!extensoesPermitidas().contains(extensao[extensao.length - 1].toLowerCase())) {
            throw new FKSException("Extensão de Arquivo não permitido : " + file.getOriginalFilename());
        }
        if ((file.getSize() + getSizeFilesByPedido(pedido)) / 1024 / 1024 > 30) {
            throw new FKSException("Tamanho máximo de 30Mb excedido");
        }
        if (loadFile(file.getOriginalFilename()) == null) {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        }
    }


    public void validaDiretorio() {
        if (!Files.exists(getRootLocation())) {
            try {
                Files.createDirectories(getRootLocation());
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "erro ao criar diretório: {}", e);
            }
        }
    }

    private void defineSubDiretorio(String tipo, String instancia) {
        if (tipo.equals("PEDIDO")) {
            subDiretorio = "pedido";
        } else if (tipo.equals("RECURSO")) {
            subDiretorio = "recurso" + "/" + instancia;
        }
    }

    private List extensoesPermitidas() {
        return Arrays.asList("bmp", "csv", "doc", "docx", "gif", "jpg", "pdf", "png", "ppt", "pptx", "rtf", "odt", "ods", "odp", "sxw", "tif", "txt", "xlm", "xls", "xlsx", "zip");
    }

    private long fileCount(Path dir) throws IOException {
        try (
                Stream<Path> stream = Files.walk(dir)
                        .parallel()
                        .filter(p -> !p.toFile().isDirectory())
        ) {
            return stream.count();
        }
    }

    @Override
    public Resource loadFile(String fileName) {

        Path file = rootLocation.resolve(fileName);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            throw new FKSException("Erro ao carregar os arquivos ! :", e);
        }
    }


    private boolean existFile(String fileName, String pedido) throws IOException {
        Path rootLocationLoad = Paths.get(PATH + subDiretorio);
        try (Stream<Path> ret = Files.walk(rootLocationLoad.resolve(pedido), Integer.MAX_VALUE)
                .filter(path -> !path.equals(rootLocationLoad.resolve(pedido)))
                .filter(files -> files.endsWith(fileName))) {
            return ret.toArray().length > 0;
        }
    }


    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void excluiArquivo(String caminho) {
        try {
            Path path = Paths.get(caminho);
            Files.delete(path);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Erro ao excluir arquivo: {}" + caminho, e);
        }
    }

    @Override
    public void init() {
        try {
            if (rootLocation.toFile().exists()) {
                Files.createDirectories(rootLocation);
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING,"Não é possivel inicializar o armazenamento!" + e);
        }
    }

    private Long getSizeFilesByPedido(String pedido) {
        Stream<Path> arquivos = loadFiles(pedido);
        List<Path> paths = arquivos.collect(Collectors.toList());

        if (!paths.isEmpty()) {
            Path path = Paths.get((getRootLocation().toString()));
            final AtomicLong size = new AtomicLong(0);
            try {
                getSizeFilesByPedidoSobrescritas(path, size);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, " exceção encontrada ", e);
                throw new AssertionError("walkFileTree não lancará IOException sem o FileVisitor",e);
            }
            return size.get();
        }
        return 0L;
    }

    private void getSizeFilesByPedidoSobrescritas(Path path, AtomicLong size) throws IOException{
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                size.addAndGet(attrs.size());
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Override
    public Stream<Path> loadFiles(String pedido) {
        try {
            Path rootLocationLoad = Paths.get(PATH + subDiretorio);
            return Files.walk(rootLocationLoad.resolve(pedido), Integer.MAX_VALUE)
                    .filter(path -> !path.equals(rootLocationLoad.resolve(pedido)))
                    .map(rootLocationLoad.resolve(pedido)::relativize);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, " IOException jogada " , e);
            throw new FKSException("Exceção do Sdsci",e);
        }
    }

    @Override
    public void download(String caminho, HttpServletResponse response) {
        try (InputStream inputStream = new FileInputStream(new File(caminho))) {
            response.setContentType("application/octet-stream");
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Não foi possível realizar o download do arquivo", e);
        }
    }

    public List<ArquivoDTO> listaArquivos(String id, String tipo, String instancia) {
        this.defineSubDiretorio(tipo, instancia);
        listaArquivos = new ArrayList<>();
        carregaArquivos(PATH + subDiretorio + "/" + id);
        return listaArquivos;
    }

    private void carregaArquivos(String path) {
        File pasta = new File(path);
        File[] lista = pasta.listFiles();
        if (lista == null) {
            return;
        }
        for (File file : lista) {
            if (file.isDirectory()) {
                carregaArquivos(file.getAbsolutePath());
            } else {
                ArquivoDTO dto = new ArquivoDTO();
                dto.setNome(file.getName());
                dto.setCaminho(file.getAbsolutePath());
                dto.setTamanho(file.length());
                listaArquivos.add(dto);
            }
        }
    }

}
