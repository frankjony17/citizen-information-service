package br.com.company.fks.servico;

import br.com.company.fks.repositorio.AndamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.command.RespostaRecursoCommandImpl;
import br.com.company.fks.modelo.AndamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.dto.RespostaRecursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespostaRecursoService {

    private static final String RESPOSTA_ASSINADA = "Recurso 1ª enviado como resposta assinada";

    @Autowired
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AndamentoRecursoRepository andamentoRecursoRepository;

    @Transactional
    public void enviar(RespostaRecursoDTO respostaRecursoDTO) {
        Recurso recurso = recursoRepository.findById(respostaRecursoDTO.getIdRecurso());
        if (respostaRecursoDTO.getObservacao() != null) {
            recurso.setObservacao(respostaRecursoDTO.getObservacao());
        }

        RespostaRecursoCommandImpl command = new RespostaRecursoCommandImpl();
        command.enviarMinhaRespostaRecurso(respostaRecursoDTO.getIdStatusSolicitacao(), recurso);

        recurso.setRespostaEsic(recurso.getRespostaEsic());
        historicoTratamentoRecursoService.gerarHistoricoTratamento(recurso, TipoTratamento.RESPOSTA_ASSINADA);
        andamentoRecursoService.gerarAndamentoRecurso(recurso, false, RESPOSTA_ASSINADA);
    }

    public Long verificarAndamentoRecurso(Long idRecurso) {
        List<AndamentoRecurso> andamentoRecursoList = andamentoRecursoRepository.recuperarAndamentoRecurso(idRecurso);
        return andamentoRecursoList.get(1).getStatusSolicitacaoRecurso().getId();
    }
}
