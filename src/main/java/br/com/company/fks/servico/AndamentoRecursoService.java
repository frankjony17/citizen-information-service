package br.com.company.fks.servico;

import br.com.company.fks.servico.usuario.UsuarioService;
import br.com.company.fks.modelo.AndamentoRecurso;
import br.com.company.fks.modelo.Pedido;
import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.Unidade;
import br.com.company.fks.modelo.UsuarioAcessos;
import br.com.company.fks.modelo.dto.AndamentoRecursoDTO;
import br.com.company.fks.repositorio.AndamentoRecursoRepository;
import br.com.company.fks.repositorio.AndamentoRepository;
import br.com.company.fks.repositorio.PedidoRepository;
import br.com.company.fks.repositorio.RecursoRepository;
import br.com.company.fks.repositorio.UsuarioAcessosRepository;
import br.com.company.fks.utils.UsuarioLogadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class AndamentoRecursoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AndamentoRecursoRepository andamentoRecursoRepository;

    @Autowired
    private AndamentoRepository andamentoRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private RecursoService recursoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UsuarioAcessosRepository usuarioAcessosRepository;

    @Autowired
    private UsuarioLogadoUtil usuarioLogadoUtil;

    @Transactional
    public void gerarAndamentoRecurso(Recurso recurso, Boolean isFluxoDeImportacaoRecurso, String observacao) {
        if (isFluxoDeImportacaoRecurso) {
            AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
            andamentoRecurso.setUnidade(buscarUltimaUnidadePedido(recurso.getProtocoloPedido()));
            andamentoRecurso.setDataInicio(Calendar.getInstance());
            andamentoRecurso.setDataFim(null);
            andamentoRecurso.setResponsavel(observacao);
            andamentoRecurso.setObservacao(null);
            andamentoRecurso.setRecurso(recurso);
            andamentoRecurso.setStatusTramitacaoRecurso(recurso.getStatusTramitacao());
            StatusSolicitacaoRecurso statusSolicitacaoRecurso = recurso.getStatusSolicitacao();
            if (statusSolicitacaoRecurso.getId() != null) {
                andamentoRecurso.setStatusSolicitacaoRecurso(recurso.getStatusSolicitacao());
            }
            andamentoRecursoRepository.save(andamentoRecurso);
        } else {
            reverterAndamentoRecurso(recurso, observacao);
        }
    }

    public void reverterAndamentoRecurso(Recurso recurso, String observacao) {
        List<AndamentoRecurso> listaAndamentoRecurso = andamentoRecursoRepository.recuperarAndamentoRecurso(recurso.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        AndamentoRecurso ultimoAndamento = listaAndamentoRecurso.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);

        AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
        andamentoRecurso.setUsuarioAcessosAssinatura(usuarioLogadoUtil.getUsuario());
        andamentoRecurso.setUnidade(buscarUltimaUnidadePedido(recurso.getProtocoloPedido()));
        andamentoRecurso.setDataInicio(dataNovoAndamento);
        andamentoRecurso.setDataFim(null);
        andamentoRecurso.setResponsavel(usuarioLogadoUtil.getNome());
        andamentoRecurso.setObservacao(observacao);
        andamentoRecurso.setObservacaoUsuario(recurso.getObservacao());
        andamentoRecurso.setRecurso(recurso);
        andamentoRecurso.setStatusTramitacaoRecurso(recurso.getStatusTramitacao());
        andamentoRecurso.setStatusSolicitacaoRecurso(recurso.getStatusSolicitacao());
        andamentoRecursoRepository.save(andamentoRecurso);
    }

    public void reverterAndamentoRecurso(Recurso recurso, String observacao, UsuarioAcessos usuarioAcessos) {
        UsuarioAcessos usuarioAcessosAssinatura = usuarioAcessosRepository.findFirstByCpfUsuario(usuarioLogadoUtil.getCpf());
        List<AndamentoRecurso> listaAndamentoRecurso = andamentoRecursoRepository.recuperarAndamentoRecurso(recurso.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        AndamentoRecurso ultimoAndamento = listaAndamentoRecurso.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);

        AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
        andamentoRecurso.setUsuarioAcessosAssinatura(usuarioAcessosAssinatura);
        andamentoRecurso.setUnidade(buscarUltimaUnidadePedido(recurso.getProtocoloPedido()));
        andamentoRecurso.setDataInicio(dataNovoAndamento);
        andamentoRecurso.setDataFim(null);
        andamentoRecurso.setResponsavel(usuarioLogadoUtil.getNome());
        andamentoRecurso.setObservacao(observacao);
        andamentoRecurso.setObservacaoUsuario(recurso.getObservacao());
        andamentoRecurso.setRecurso(recurso);
        andamentoRecurso.setUsuarioAcessos(Arrays.asList(usuarioAcessos));
        andamentoRecurso.setStatusTramitacaoRecurso(recurso.getStatusTramitacao());
        andamentoRecurso.setStatusSolicitacaoRecurso(recurso.getStatusSolicitacao());
        andamentoRecursoRepository.save(andamentoRecurso);
    }

    public void reverterAndamentoRecurso(Recurso recurso, String observacao, String justificativa) {
        List<AndamentoRecurso> listaAndamentoRecurso = andamentoRecursoRepository.recuperarAndamentoRecurso(recurso.getId());
        Calendar dataNovoAndamento = Calendar.getInstance();
        AndamentoRecurso ultimoAndamento = listaAndamentoRecurso.get(0);
        ultimoAndamento.setDataFim(dataNovoAndamento);

        AndamentoRecurso andamentoRecurso = new AndamentoRecurso();
        andamentoRecurso.setUsuarioAcessosAssinatura(usuarioLogadoUtil.getUsuario());
        andamentoRecurso.setUnidade(buscarUltimaUnidadePedido(recurso.getProtocoloPedido()));
        andamentoRecurso.setDataInicio(dataNovoAndamento);
        andamentoRecurso.setDataFim(null);
        andamentoRecurso.setResponsavel(usuarioLogadoUtil.getNome());
        andamentoRecurso.setObservacao(observacao);
        andamentoRecurso.setObservacaoUsuario(recurso.getObservacao());
        andamentoRecurso.setRecurso(recurso);
        andamentoRecurso.setStatusTramitacaoRecurso(recurso.getStatusTramitacao());
        andamentoRecurso.setStatusSolicitacaoRecurso(recurso.getStatusSolicitacao());
        andamentoRecurso.setJustificativa(justificativa);
        andamentoRecursoRepository.save(andamentoRecurso);
    }

    public Page<AndamentoRecursoDTO> consultarAndamentoRecurso(Long idRecurso, Integer offset, Integer limit) {
        Pageable pageable = new PageRequest(offset, limit);

        return andamentoRecursoRepository.recuperarAndamentoRecursoEStatusTramitacao(recursoRepository.findById(idRecurso), pageable);
    }

    public String buscarObservacaoAndamentoRecurso(Long idRecurso) {
        List<AndamentoRecurso> listaAndamento = andamentoRecursoRepository.findByPedido(idRecurso);
        AndamentoRecurso andamentoRecurso = listaAndamento.get(listaAndamento.size() - 1);
        return andamentoRecurso.getObservacaoUsuario();
    }

    private Long buscarUltimaUnidadePedido(String protocolo){
        Pedido pedido = pedidoRepository.findByProtocolo(protocolo);
        Unidade unidade =  pedidoService.buscarUltimaUnidade(pedido.getId());
        return unidade.getId();
    }

    public String buscarUsuario(Long id){
        Recurso recurso = recursoRepository.findById(id);
        UsuarioAcessos usuarioAcessos = andamentoRecursoRepository.buscarUsuario(recurso);
        return usuarioAcessos.getNomeUsuario();
    }


}
