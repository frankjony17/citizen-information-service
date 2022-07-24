package br.com.company.fks.servico;

import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.excecao.IntegracaoException;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;
import br.com.company.fks.modelo.TipoTratamento;
import br.com.company.fks.modelo.TipoTratamentoRecurso;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.PropostaRespostaRecursoDTO;
import br.com.company.fks.modelo.dto.RespostaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropostaRespostaRecursoService {

    private static final String PROPOSTA_RESPOSTA = "Recurso de 1ª encaminhado como proposta de resposta de Recurso";

    @Autowired
    private HistoricoTratamentoRecursoService historicoTratamentoRecursoService;

    @Autowired
    private AndamentoRecursoService andamentoRecursoService;

    @Autowired
    private RecursoRepository recursoRepository;

    @Transactional
    public void enviar(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO) throws IntegracaoException {
        verificarPreenchimentoCamposObrigatorios(propostaRespostaRecursoDTO);
        Recurso recurso = recursoRepository.findById(propostaRespostaRecursoDTO.getIdRecurso());
        if (propostaRespostaRecursoDTO.getObservacao() != null) {
            recurso.setObservacao(propostaRespostaRecursoDTO.getObservacao());
        }

        verificaRecurso1DistribuicaoOPF(recurso, propostaRespostaRecursoDTO);

        recurso.setPropostaResposta(recurso.getPropostaResposta());
        recurso.setRespostaEsic(recurso.getRespostaEsic());

        isNull(propostaRespostaRecursoDTO, recurso);
    }

    private void isNull(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO, Recurso recurso) {

        if (recurso.getPropostaResposta() != null) {
            historicoTratamentoRecursoService.gerarHistoricoTratamento(recurso, TipoTratamentoRecurso.PROPOSTA_RESPOSTA);
        }
        if (propostaRespostaRecursoDTO.getUsuarioAcessosList() != null) {
            if (propostaRespostaRecursoDTO.getUsuarioAcessosList().isEmpty()) {
                andamentoRecursoService.gerarAndamentoRecurso(recurso, false, PROPOSTA_RESPOSTA);
            } else {
                UsuarioAcessos usuarioAcessos = propostaRespostaRecursoDTO.getUsuarioAcessosList().get(0);
                andamentoRecursoService.reverterAndamentoRecurso(recurso, PROPOSTA_RESPOSTA, usuarioAcessos);
            }

        }
    }

    private void verificaRecurso2ParaEnvio(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO, Recurso recurso) {
        if (StatusSolicitacaoRecurso.RECURSO_2_PARA_ENVIO.equals(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso())) {
            recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
            recurso.getStatusSolicitacao().setId(StatusSolicitacaoRecurso.RECURSO_2_PARA_ENVIO);
            recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
            recurso.getStatusTramitacao().setId(StatusTramitacaoRecurso.RESPONDIDO);
        }
    }

    private void verificaRecurso2Producao(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO, Recurso recurso) {
        if (StatusSolicitacaoRecurso.RECURSO_2_PRODUCAO.equals(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso())) {
            recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
            recurso.getStatusSolicitacao().setId(StatusSolicitacaoRecurso.RECURSO_2_PRODUCAO);
            recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
            recurso.getStatusTramitacao().setId(StatusTramitacaoRecurso.ANDAMENTO);
        }
        verificaRecurso2ParaEnvio(propostaRespostaRecursoDTO, recurso);
    }

    private void verificaRecurso2DistribuicaoOPF(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO, Recurso recurso) {
        if (StatusSolicitacaoRecurso.RECURSO_2_DISTRIBUICAO_PF.equals(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso())) {
            recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
            recurso.getStatusSolicitacao().setId(StatusSolicitacaoRecurso.RECURSO_2_DISTRIBUICAO_PF);
            recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
            recurso.getStatusTramitacao().setId(StatusTramitacaoRecurso.ANDAMENTO);
        }
        verificaRecurso2Producao(propostaRespostaRecursoDTO, recurso);
    }

    private void verificaRecurso1ParaEnvio(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO, Recurso recurso) {
        if (StatusSolicitacaoRecurso.RECURSO_1_PARA_ENVIO.equals(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso())) {
            recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
            recurso.getStatusSolicitacao().setId(StatusSolicitacaoRecurso.RECURSO_1_PARA_ENVIO);
            recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
            recurso.getStatusTramitacao().setId(StatusTramitacaoRecurso.RESPONDIDO);
        }
        verificaRecurso2DistribuicaoOPF(propostaRespostaRecursoDTO, recurso);
    }

    private void verificaRecurso1Producao(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO, Recurso recurso) {
        if (StatusSolicitacaoRecurso.RECURSO_1_PRODUCAO.equals(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso())) {
            recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
            recurso.getStatusSolicitacao().setId(StatusSolicitacaoRecurso.RECURSO_1_PRODUCAO);
            recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
            recurso.getStatusTramitacao().setId(StatusTramitacaoRecurso.ANDAMENTO);

        }
        verificaRecurso1ParaEnvio(propostaRespostaRecursoDTO, recurso);
    }

    private void verificaRecurso1DistribuicaoOPF(Recurso recurso, PropostaRespostaRecursoDTO propostaRespostaRecursoDTO) {
        if (StatusSolicitacaoRecurso.RECURSO_1_DISTRIBUICAO_PF.equals(propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso())) {
            recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
            recurso.getStatusSolicitacao().setId(StatusSolicitacaoRecurso.RECURSO_1_DISTRIBUICAO_PF);
            recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
            recurso.getStatusTramitacao().setId(StatusTramitacaoRecurso.ANDAMENTO);
        }
        verificaRecurso1Producao(propostaRespostaRecursoDTO, recurso);
    }

    private void verificarPreenchimentoCamposObrigatorios(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO) throws IntegracaoException {
        if (propostaRespostaRecursoDTO.getIdStatusSolicitacaoRecurso() == null) {
            throw new IntegracaoException("O campo 'Status da solicitação' é de preenchimento obrigatório.");
        }
    }

    public void excluirRespostaRecurso(Long id) {
        Recurso recurso = recursoRepository.findById(id);
        recurso.setPropostaResposta(null);
        recursoRepository.save(recurso);
    }

    @Transactional
    public void salvar(PropostaRespostaRecursoDTO propostaRespostaRecursoDTO) throws IntegracaoException {
        Recurso recurso = recursoRepository.findById(propostaRespostaRecursoDTO.getIdRecurso());//
        recurso.setPropostaResposta(propostaRespostaRecursoDTO.getPropostaResposta());
        if (recurso.getRespostaEsic() == null) {
            recurso.setRespostaEsic(propostaRespostaRecursoDTO.getPropostaResposta());
            historicoTratamentoRecursoService.gerarHistoricoTratamento(recurso, TipoTratamento.RESPOSTA);
        } else {
            recurso.setRespostaEsic(propostaRespostaRecursoDTO.getPropostaResposta());
            historicoTratamentoRecursoService.gerarHistoricoTratamento(recurso, TipoTratamento.RESPOSTA_EDITADA);
        }
        recursoRepository.save(recurso);
    }


    public RespostaDTO buscarResposta(Long id) {
        Recurso recurso = recursoRepository.findById(id);
        RespostaDTO respostaDTO = new RespostaDTO();
        respostaDTO.setResposta(recurso.getPropostaResposta());
        return respostaDTO;
    }

    public Long buscarinstancia(Long id) {
        Recurso recurso = recursoRepository.findById(id);
        return recurso.getInstanciaRecurso().getId();

    }
}
