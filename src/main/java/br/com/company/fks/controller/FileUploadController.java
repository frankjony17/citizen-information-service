package br.com.company.fks.controller;

import br.com.company.fks.repositorio.ArmazenamentoArquivoRepository;
import br.com.company.fks.modelo.dto.ArquivoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private ArmazenamentoArquivoRepository arquivoRepository;

    @RequestMapping(value = "/filesUpload/{pedido}/{tipo}/{instancia}", method = RequestMethod.POST)
    public void uploads(@RequestParam(value = "file") List<MultipartFile> files, @PathVariable String pedido, @PathVariable String tipo, @PathVariable String instancia) {
        arquivoRepository.store(files, pedido, tipo,instancia);
    }

    @RequestMapping(value = "/files/{filename}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource file = arquivoRepository.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteFile(@RequestParam("caminho") String caminho) {
        arquivoRepository.excluiArquivo(caminho);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/files/{filename:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = arquivoRepository.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(value = "/listaArquivos/{id}/{tipo}/{instancia}", method = RequestMethod.GET)
    public ResponseEntity listaArquivos(@PathVariable String id, @PathVariable String tipo, @PathVariable String instancia) {
        List<ArquivoDTO> arquivoDTOS = arquivoRepository.listaArquivos(id, tipo, instancia);
        return new ResponseEntity<>(arquivoDTOS, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam("caminho") String caminho, HttpServletResponse response) {
        arquivoRepository.download(caminho, response);
    }

}