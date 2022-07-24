package br.com.company.fks.servico;

import br.com.company.fks.repositorio.HistoricoTratamentoRecursoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.modelo.HistoricoTratamentoRecurso;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.TipoTratamentoRecurso;
import br.com.company.fks.modelo.dto.ConsultaHistoricoRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class HistoricoTratamentoRecursoService {

    @Autowired
    private HistoricoTratamentoRecursoRepository historicoTratamentoRecursoRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Autowired
    private RecursoRepository recursoRepository;

    @Transactional
    public void gerarHistoricoTratamento(Recurso recurso, Long idTipoTratamento) {
        HistoricoTratamentoRecurso historicoTratamentoRecurso = new HistoricoTratamentoRecurso();
        historicoTratamentoRecurso.setData(Calendar.getInstance());
        historicoTratamentoRecurso.setRecurso(recurso);
        historicoTratamentoRecurso.setTipoTratamentoRecurso(new TipoTratamentoRecurso());
        historicoTratamentoRecurso.getTipoTratamentoRecurso().setId(idTipoTratamento);
        historicoTratamentoRecurso.setRespostaRecurso(recurso.getRespostaEsic());
        historicoTratamentoRecurso.setNomeResponsavel(usuarioLogadoUtil.getNome());
        historicoTratamentoRecursoRepository.save(historicoTratamentoRecurso);
    }

    public Page<ConsultaHistoricoRecursoDTO> consultarHistoricoRecurso(Long idRecurso, Integer offset, Integer limit) {
        Pageable pageable = new PageRequest(offset, limit);
        return historicoTratamentoRecursoRepository.recuperarHistoricoRecurso(recursoRepository.findById(idRecurso), pageable);
    }

    public RespostaDTO buscarRespostaHistorico(Long id) {
        RespostaDTO respostaDTO = new RespostaDTO();
        HistoricoTratamentoRecurso historicoTratamentoRecurso = historicoTratamentoRecursoRepository.findOne(id);
        respostaDTO.setResposta(historicoTratamentoRecurso.getRespostaRecurso());
        return respostaDTO;
    }

    public Calendar consultarDataRespostaRecurso(Long id) {
        Calendar dataRespostaRecurso;
        List<HistoricoTratamentoRecurso> listaHistoricoTratamentoRecurso = historicoTratamentoRecursoRepository.findAll();
        HistoricoTratamentoRecurso historicoTratamentoRecurso;
        if (listaHistoricoTratamentoRecurso.size() > 0) {
            historicoTratamentoRecurso = listaHistoricoTratamentoRecurso.get(listaHistoricoTratamentoRecurso.size() - 1);
            dataRespostaRecurso = historicoTratamentoRecurso.getData();
            return dataRespostaRecurso;
        }
        return null;
    }

    public String recuperarRespostaRecurso(Long idRecurso) {
        List<HistoricoTratamentoRecurso> listaHistoricoTratamentoRecurso;
        listaHistoricoTratamentoRecurso = historicoTratamentoRecursoRepository.recuperarRespostaHistoricoPorIdRecurso(idRecurso);
        if (listaHistoricoTratamentoRecurso.size() > 0) {
            HistoricoTratamentoRecurso ultimoHistoricoTratamentoRecurso = listaHistoricoTratamentoRecurso.get(listaHistoricoTratamentoRecurso.size() - 1);
            return ultimoHistoricoTratamentoRecurso.getRespostaRecurso();
        }
        return null;
    }
}
