package br.com.company.fks.controller;

import br.com.company.fks.modelo.dto.ReencaminharSolicitacaoDTO;
import br.com.company.fks.servico.ReencaminharSolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reencaminharSolicitacao", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReencaminharSolicitacaoController {

    @Autowired
    private ReencaminharSolicitacaoService reencaminharSolicitacaoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> salvar(@RequestBody ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO) {
        reencaminharSolicitacaoService.salvar(reencaminharSolicitacaoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarReencaminhamentoParaOrgao/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<ReencaminharSolicitacaoDTO> buscarReencaminhamentoParaOrgao(@PathVariable Long idPedido) {
        ReencaminharSolicitacaoDTO reencaminharSolicitacaoDTO = reencaminharSolicitacaoService.buscarReencaminhamentoParaOrgao(idPedido);
        return new ResponseEntity<>(reencaminharSolicitacaoDTO, HttpStatus.OK);
    }
}
