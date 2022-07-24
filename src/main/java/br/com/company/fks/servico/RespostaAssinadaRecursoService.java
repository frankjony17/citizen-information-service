package br.com.company.fks.servico;

import br.com.company.fks.repositorio.HistoricoTratamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.HistoricoTratamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.dto.RespostaAssinadaRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespostaAssinadaRecursoService {

    @Autowired
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Autowired
    private HistoricoTratamentoRecursoRepository historicoTratamentoRecursoRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    public RespostaDTO buscarRespostaRecurso(Long idRecurso) {
        RespostaDTO respostaDTO = new RespostaDTO();
        List<HistoricoTratamentoRecurso> listaHistoricoTratamentoRecurso;
        listaHistoricoTratamentoRecurso = historicoTratamentoRecursoRepository.recuperarRespostaHistoricoPorIdRecurso(idRecurso);
        if (listaHistoricoTratamentoRecurso.size() > 0) {
            HistoricoTratamentoRecurso ultimoHistoricoTratamentoRecurso = listaHistoricoTratamentoRecurso.get(listaHistoricoTratamentoRecurso.size() - 1);
            respostaDTO.setResposta(ultimoHistoricoTratamentoRecurso.getRespostaRecurso());
            return respostaDTO;
        }
        return null;
    }

    @Transactional
    public void salvarRespostaRecurso(RespostaAssinadaRecursoDTO respostaAssinadaRecursoDTO) throws IntegracaoException {
        Recurso recurso = recursoRepository.findById(respostaAssinadaRecursoDTO.getIdRecurso());
        if (recurso.getRespostaEsic() == null) {
            recurso.setStatusRespostaAssinada(true);
            recursoRepository.save(recurso);
            recurso.setRespostaEsic(respostaAssinadaRecursoDTO.getRespostaRecurso());
            historicoTratamentoRecursoService.gerarHistoricoTratamento(recurso, TipoTratamento.RESPOSTA);
        } else {
            if (recurso.getStatusRespostaAssinada() == false) {
                recurso.setStatusRespostaAssinada(true);
                recursoRepository.save(recurso);
            }
            recurso.setRespostaEsic(respostaAssinadaRecursoDTO.getRespostaRecurso());
            historicoTratamentoRecursoService.gerarHistoricoTratamento(recurso, TipoTratamento.RESPOSTA_EDITADA);
        }
        recursoRepository.save(recurso);
    }
}
