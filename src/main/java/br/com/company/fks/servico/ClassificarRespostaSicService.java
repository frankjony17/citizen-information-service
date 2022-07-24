package br.com.company.fks.servico;

import br.com.company.fks.repositorio.ClassificarRespostaSicRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.ClassificarRespostaSic;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.dto.ClassificarRespostaSicDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassificarRespostaSicService {

    @Autowired
    private ClassificarRespostaSicRepository classificarRespostaSicRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void salvar(ClassificarRespostaSicDTO classificarRespostaSicDTO) {
        Pedido pedido = pedidoRepository.findById(classificarRespostaSicDTO.getId());
        ClassificarRespostaSic classificarRespostaSic;
        if (pedido.getClassificarRespostaSic() == null) {
            classificarRespostaSic = new ClassificarRespostaSic();
        } else {
            classificarRespostaSic = classificarRespostaSicRepository.findById(pedido.getClassificarRespostaSic().getId());
        }
        classificarRespostaSic.setRestricaoConteudo(classificarRespostaSicDTO.getRestricaoConteudo());
        classificarRespostaSic.setSubcategoria(classificarRespostaSicDTO.getSubcategoria());
        classificarRespostaSic.setTipoResposta(classificarRespostaSicDTO.getTipoResposta());
        classificarRespostaSic.setCategoria(classificarRespostaSicDTO.getCategoria());
        classificarRespostaSic.setNumeroPagina(classificarRespostaSicDTO.getNumeroPagina());
        classificarRespostaSic.setClassificacaoTipoResposta(classificarRespostaSicDTO.getClassificacaoTipoResposta());
        pedido.setClassificarRespostaSic(classificarRespostaSic);
        pedido.setIsClassificacaoRespostaSic(true);
        pedidoRepository.save(pedido);
        classificarRespostaSicRepository.save(classificarRespostaSic);
    }

    public RespostaDTO buscarResposta(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setResposta(pedido.getRespostaEsic());
        return respostaDTO;
    }

    public ClassificarRespostaSic buscarClassificacaoRespostaSic(Long id) {
        return classificarRespostaSicRepository.findById(id);
    }


    @Transactional
    public void editarClassificacaoSic(ClassificarRespostaSic classificarRespostaSic) throws IntegracaoException {
        classificarRespostaSicRepository.save(classificarRespostaSic);
    }


    public ClassificarRespostaSic buscarClassificacaoRespostaESic(Long id) {
        Pedido pedido = pedidoRepository.findById(id);
        return pedido.getClassificarRespostaSic();

    }
}
