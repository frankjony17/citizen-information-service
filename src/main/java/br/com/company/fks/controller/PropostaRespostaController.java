package br.com.company.fks.controller;

import br.com.company.fks.controller.builder.Resposta;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.modelo.EOuv;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.PropostaRespostaDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.servico.PropostaRespostaService;
import org.apache.log4j.Logger;
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
@RequestMapping(value = "/propostaResposta")
public class PropostaRespostaController {

    @Autowired
    private PropostaRespostaService propostaRespostaService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Resposta<EOuv>> enviar(@RequestBody PropostaRespostaDTO propostaRespostaDTO) {
        propostaRespostaService.enviar(propostaRespostaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/excluirRespostaFKS/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> excluirRespostaFKS(@PathVariable Long id) {
        propostaRespostaService.excluirRespostaFKS(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarDadosEncaminhamento/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<PropostaRespostaDTO> buscarDadosEncaminhamento(@PathVariable Long idPedido) {
        PropostaRespostaDTO propostaRespostaDTO = propostaRespostaService.buscarDadosEncaminhamento(idPedido);
        return new ResponseEntity(propostaRespostaDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/obterAssinatura/{idPedido}", method=RequestMethod.GET, produces=MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> obterAssinatura(@PathVariable Long idPedido) {
        String assinaturas = propostaRespostaService.obterAssinatura(idPedido);
        return new ResponseEntity(assinaturas, HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarRespostaFKSSalva/{idPedido}", method = RequestMethod.GET)
    public ResponseEntity<RespostaDTO> buscarRespostaFKS(@PathVariable Long idPedido) {
        Pedido pedido =  pedidoRepository.findById(idPedido);
        String resposta = pedido.getRespostaEsic();
        RespostaDTO respostaDTO  = new RespostaDTO();
        respostaDTO.setResposta(resposta);
        return new ResponseEntity (respostaDTO, HttpStatus.OK);
    }
}
