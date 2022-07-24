package br.com.company.fks.servico;

import br.com.company.fks.repositorio.AndamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.command.DevolveConsultaStatusRecursoCommandImpl;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.dto.DevolveRecursoDTO;
import br.com.company.fks.command.DevolveRecursoCommandImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DevolveRecursoService {

    private static final String DEVOLVIDA = "Recurso 1ª Devolvido";

    @Autowired
    private AndamentoRecursoRepository andamentoRecursoRepository;

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    @Autowired
    private RecursoRepository recursoRepository;

    @Transactional
    public void reverterAndamentoRecurso(DevolveRecursoDTO devolveRecursoDTO) throws IntegracaoException {
        Recurso recurso = recursoRepository.buscarRecursoEStatusSolicitacao(devolveRecursoDTO.getIdRecurso());
        int numeroStatusSolicitacaoRecurso = recurso.getStatusSolicitacao().getId().intValue();
        StatusTramitacaoRecurso statusTramitacaoRecurso = new StatusTramitacaoRecurso();
        StatusSolicitacaoRecurso statusSolicitacaoRecurso = new StatusSolicitacaoRecurso();

        DevolveRecursoCommandImpl command = new DevolveRecursoCommandImpl();
        command.minhaReversaoAndamentoRecurso(numeroStatusSolicitacaoRecurso, recurso, statusSolicitacaoRecurso, statusTramitacaoRecurso);

        recurso.setObservacao(devolveRecursoDTO.getJustificativa());
        andamentoRecursoService.reverterAndamentoRecurso(recurso, DEVOLVIDA);
        recursoRepository.save(recurso);
    }

    public DevolveRecursoDTO consultarStatusRecurso(Long idRecurso) {
        Recurso recurso = recursoRepository.buscarRecursoEStatusSolicitacao(idRecurso);
        DevolveRecursoDTO devolveRecursoDTO = new DevolveRecursoDTO();

        DevolveConsultaStatusRecursoCommandImpl command = new DevolveConsultaStatusRecursoCommandImpl();
        command.minhaConsultarStatusRecurso(recurso.getStatusSolicitacao().getId(), recurso, devolveRecursoDTO);
        return devolveRecursoDTO;
    }
}
