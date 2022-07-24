package br.com.company.fks.command;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DevolveRecursoCommandImpl {
    private static final Map<Integer, IDevolveRecursoCommand> PERFIS;

    static{
        final Map<Integer, IDevolveRecursoCommand> perfis = new HashMap<>();
        perfis.put(4, new IDevolveRecursoCommand() {
            @Override
            public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
                reverterAndamento(2L, 3L, recurso, statusTramitacaoRecurso, statusSolicitacaoRecurso);
            }
        });
        perfis.put(5, new IDevolveRecursoCommand() {
            @Override
            public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
                reverterAndamento(2L, 4L, recurso, statusTramitacaoRecurso, statusSolicitacaoRecurso);
            }
        });
        perfis.put(6, new IDevolveRecursoCommand() {
            @Override
            public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
                reverterAndamento(3L, 5L, recurso, statusTramitacaoRecurso, statusSolicitacaoRecurso);
            }
        });
        perfis.put(12, new IDevolveRecursoCommand() {
            @Override
            public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
                reverterAndamento(2L, 11L, recurso, statusTramitacaoRecurso, statusSolicitacaoRecurso);
            }
        });
        perfis.put(13, new IDevolveRecursoCommand() {
            @Override
            public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
                reverterAndamento(2L, 12L, recurso, statusTramitacaoRecurso, statusSolicitacaoRecurso);

            }
        });
        perfis.put(14, new IDevolveRecursoCommand() {
            @Override
            public void reverteAndamentoDoRecurso(Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
                reverterAndamento(3L, 13L, recurso, statusTramitacaoRecurso, statusSolicitacaoRecurso);
            }
        });

        PERFIS = Collections.unmodifiableMap(perfis);

    }

    public void minhaReversaoAndamentoRecurso(int perfil, Recurso recurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso, StatusTramitacaoRecurso statusTramitacaoRecurso) {
        IDevolveRecursoCommand command = PERFIS.get(perfil);

        if (command == null) {
            throw new IllegalArgumentException("Perfil inválido");
        }

        command.reverteAndamentoDoRecurso(recurso, statusSolicitacaoRecurso, statusTramitacaoRecurso);
    }

    public static void reverterAndamento(Long idStatusTramitacao, Long idStatusSolicitacao, Recurso recurso, StatusTramitacaoRecurso statusTramitacaoRecurso, StatusSolicitacaoRecurso statusSolicitacaoRecurso){
        statusTramitacaoRecurso.setId(idStatusTramitacao);
        statusSolicitacaoRecurso.setId(idStatusSolicitacao);
        recurso.setStatusTramitacao(statusTramitacaoRecurso);
        recurso.setStatusSolicitacao(statusSolicitacaoRecurso);
    }
}

