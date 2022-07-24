package br.com.company.fks.command;

import br.com.company.fks.modelo.Recurso;
import br.com.company.fks.modelo.dto.DevolveRecursoDTO;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DevolveConsultaStatusRecursoCommandImpl {
    private static final Map<Long, IDevolveConsultaStausRecursoCommand> ID_SOLICITACAO;

    static {
        final Map<Long, IDevolveConsultaStausRecursoCommand> IdSolicitacao = new HashMap<>();
        IdSolicitacao.put(4L, new IDevolveConsultaStausRecursoCommand() {
            @Override
            public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
                devolveRecursoDTO.setNomeStatusSolicitacao("Recurso 1ª Produção");
            }
        });
        IdSolicitacao.put(5L, new IDevolveConsultaStausRecursoCommand() {
            @Override
            public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
                devolveRecursoDTO.setNomeStatusSolicitacao("Recurso 1ª Assinado");
            }
        });
        IdSolicitacao.put(6L, new IDevolveConsultaStausRecursoCommand() {
            @Override
            public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
                devolveRecursoDTO.setNomeStatusSolicitacao("Recurso 1ª Respondido");
            }
        });
        IdSolicitacao.put(12L, new IDevolveConsultaStausRecursoCommand() {
            @Override
            public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
                devolveRecursoDTO.setNomeStatusSolicitacao("Recurso 2ª Produção");
            }
        });
        IdSolicitacao.put(13L, new IDevolveConsultaStausRecursoCommand() {
            @Override
            public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
                devolveRecursoDTO.setNomeStatusSolicitacao("Recurso 2ª Assinado");
            }
        });
        IdSolicitacao.put(14L, new IDevolveConsultaStausRecursoCommand() {
            @Override
            public void consultarStatusRecurso(Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
                devolveRecursoDTO.setNomeStatusSolicitacao("Recurso 2ª Respondido");
            }
        });

        ID_SOLICITACAO = Collections.unmodifiableMap(IdSolicitacao);

    }

    public void minhaConsultarStatusRecurso(Long idSolicitacao, Recurso recurso, DevolveRecursoDTO devolveRecursoDTO) {
        IDevolveConsultaStausRecursoCommand command = ID_SOLICITACAO.get(idSolicitacao);

        if (command == null) {
            throw new IllegalArgumentException("Perfil inválido");
        }

        command.consultarStatusRecurso(recurso, devolveRecursoDTO);
    }


}

