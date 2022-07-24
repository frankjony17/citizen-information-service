package br.com.company.fks.command;

import br.com.company.fks.modelo.TipoRecurso;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImportacaoRecursoServiceCommandImpl {
    private static final Map<String, IImportacaoRecursoServiceCommand> TIPO_RECURSO;

    static {
        final Map<String, IImportacaoRecursoServiceCommand> recursos = new HashMap<>();
        recursos.put(TipoRecurso.AUSENCIA_DE_JUSTIFICATIVA_LEGAL_PARA_CLASSIFICACAO, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(1L);
            }
        });
        recursos.put(TipoRecurso.AUTORIDADE_CLASSIFICADORA_NAO_INFORMADA, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(2L);
            }
        });
        recursos.put(TipoRecurso.DATA_DA_CLASSIFICACAO_DE_INICIO_OU_FIM_NAO_INFORMADA, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(3L);
            }
        });
        recursos.put(TipoRecurso.DEFERIMENTO_DE_PEDIDO_DE_REVISAO_PARA_TRANSFORMAR_PEDIDO_EM_MANIFESTACAO, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(4L);
            }
        });
        recursos.put(TipoRecurso.GRAU_DE_CLASSIFICACAO_INEXISTENTE, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(5L);
            }
        });
        recursos.put(TipoRecurso.GRAU_DE_SIGILO_NAO_INFORMADO, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(6L);
            }
        });
        recursos.put(TipoRecurso.INFORMACAO_CLASSIFICADA_POR_AUTORIDADE_SEM_COMPETENCIA, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(7L);
            }
        });
        recursos.put(TipoRecurso.INFORMACAO_INCOMPLETA, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(8L);
            }
        });
        recursos.put(TipoRecurso.INFORMACAO_RECEBIDA_NAO_CORRESPONDE_A_SOLICITADA, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(9L);
            }
        });
        recursos.put(TipoRecurso.INFORMACAO_RECEBIDA_POR_MEIO_DIFERENTE_DO_SOLICITADO, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(10L);
            }
        });
        recursos.put(TipoRecurso.JUSTIFICATIVA_PARA_O_SIGILO_INSATISFATORIA_NAO_INFORMADA, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(11L);
            }
        });
        recursos.put(TipoRecurso.OUTROS, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(12L);
            }
        });
        recursos.put(TipoRecurso.PRAZO_DE_CLASSIFICACAO_INADEQUADO_PARA_O_GRAU_DE_SIGILO, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(13L);
            }
        });
        recursos.put(TipoRecurso.RESPOSTA_NAO_FOI_DADA_NO_PRAZO, new IImportacaoRecursoServiceCommand() {
            @Override
            public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
                tipoRecurso.setId(14L);
            }
        });
        TIPO_RECURSO = Collections.unmodifiableMap(recursos);
    }

    public void definirTipoRecurso(String tipo, TipoRecurso tipoRecurso) {
        IImportacaoRecursoServiceCommand command = TIPO_RECURSO.get(tipo);
        if (command == null) {
            throw new IllegalArgumentException("Tipo inválido");
        }
        command.definirTipoRecurso(tipo, tipoRecurso);
    }
}

