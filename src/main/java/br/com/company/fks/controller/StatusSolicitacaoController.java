package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.StatusSolicitacaoDTO;
import br.com.company.fks.servico.StatusSolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/statusSolicitacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StatusSolicitacaoController {

    @Autowired
    private StatusSolicitacaoService statusSolicitacaoService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<StatusSolicitacaoDTO>> consultaStatusSolicitacao() {
        List<StatusSolicitacaoDTO> listaStatusSolicitacoesDTO = statusSolicitacaoService.consultarStatusSolicitacao();
        return new ResponseEntity<>(listaStatusSolicitacoesDTO, HttpStatus.OK);
    }
}
