package br.com.company.fks.command;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.StatusSolicitacaoRecurso;
import br.com.company.fks.modelo.StatusTramitacaoRecurso;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RespostaRecursoCommandImpl{
    private static final Map<Long, IRespostaRecursoCommand> RECURSOS;

    static {
        final Map<Long, IRespostaRecursoCommand> recursos = new HashMap<>();
        recursos.put(StatusSolicitacaoRecurso.RECURSO_1_RESPONDIDO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_1_ASSINADO, StatusTramitacaoRecurso.ANDAMENTO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_1_ASSINADO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_1_ASSINADO, StatusTramitacaoRecurso.ANDAMENTO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_1_PARA_REVISAO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_1_PARA_REVISAO, StatusTramitacaoRecurso.RESPONDIDO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_1_ENVIADO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_1_ENVIADO, StatusTramitacaoRecurso.ENVIADO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_2_RESPONDIDO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_2_RESPONDIDO, StatusTramitacaoRecurso.RESPONDIDO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_2_ASSINADO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_2_ASSINADO, StatusTramitacaoRecurso.ANDAMENTO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_2_PARA_REVISAO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_2_PARA_REVISAO, StatusTramitacaoRecurso.RESPONDIDO);
            }
        });

        recursos.put(StatusSolicitacaoRecurso.RECURSO_2_ENVIADO, new IRespostaRecursoCommand() {
            @Override
            public void enviarRespostaRecurso(Recurso recurso) {
                setRecursos(recurso, StatusSolicitacaoRecurso.RECURSO_2_ENVIADO, StatusTramitacaoRecurso.ENVIADO);
            }
        });

        RECURSOS = Collections.unmodifiableMap(recursos);
    }


        public void enviarMinhaRespostaRecurso(Long statusSolicitacaoRecurso, Recurso recurso) {
            IRespostaRecursoCommand command = RECURSOS.get(statusSolicitacaoRecurso);

            if (command == null) {
                throw new IllegalArgumentException("Status invalido: "
                        + statusSolicitacaoRecurso);
            }

            command.enviarRespostaRecurso(recurso);
        }

    private static void setRecursos (Recurso recurso, Long statusSolicitacaoRecurso, Long statusTramitacaoRecurso) {
        recurso.setStatusSolicitacao(new StatusSolicitacaoRecurso());
        recurso.setStatusTramitacao(new StatusTramitacaoRecurso());
        recurso.getStatusSolicitacao().setId(statusSolicitacaoRecurso);
        recurso.getStatusTramitacao().setId(statusTramitacaoRecurso);
    }

}


