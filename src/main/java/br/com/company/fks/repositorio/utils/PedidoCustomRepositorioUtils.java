package br.com.company.fks.repositorio.utils;

import java.util.List;

public final class PedidoCustomRepositorioUtils {

    private PedidoCustomRepositorioUtils() {}

    public static final String SELECT_PEDIDO = "SELECT pedido FROM Pedido pedido ";
    public static final String JOIN_FETCH = "JOIN FETCH pedido.solicitante ";
    public static final String JOIN_FETCH_STATUS_TRAMITACAO = "JOIN FETCH pedido.statusTramitacao ";
    public static final String LEFT_JOIN_SUBTEMA = "LEFT JOIN pedido.subtemaList ";
    public static final String WHERE_PEDIDO = "WHERE (1 = 1) ";
    public static final String JOIN_FETCH_STATUS_SOLICITACAO = "JOIN FETCH pedido.statusSolicitacao ";
    public static final String JOIN_FETCH_SITUACAO_PEDIDO = "JOIN FETCH pedido.situacaoPedido ";
    public static final String JOIN_FETCH_ANEXOS = "LEFT JOIN pedido.anexos ";
    public static final String WHERE_PEDIDOID = "WHERE pedido.id = :idPedido ";
    public static final String WHERE_TRAMITACAO_COMIGO_SIC = " AND  pedido.statusTramitacao.id in (1,4,6,7) or pedido.statusSolicitacao.id = 2 ";

    public static final String JOIN_SOLICITANTE = "join tb_solicitante s on p.id_solicitante = s.id_solicitante \n ";
    public static final String JOIN_PEDIDO_SUBTEMA = "left join tb_pedido_subtema ps on ps.id_pedido = p.id_pedido \n ";
    public static final String IGNORA_CLASULA_NOME_SOLICITANTE = "AND ('ignoraClausula' = :igNomeSolicitante OR UPPER(s.nm_nome) LIKE UPPER(:nomeSolicitante)) \n ";
    public static final String IGNORA_CLASULA_TIPO_PESSOA = "AND ('ignoraClausula' = :igTipoPessoa OR s.tp_tipo_nome = :tipoPessoa) \n ";
    public static final String IGNORA_CLASULA_STATUS_SOLICITACAO = "AND ('ignoraClausula' = :igIdStatusSolicitacao OR p.id_status_solicitacao = :idStatusSolicitacao) \n ";
    public static final String IGNORA_CLASULA_STATUS_SITUACAO = "AND ('ignoraClausula' = :igIdStatusSituacao OR p.id_status_situacao = :idStatusSituacao) \n ";
    public static final String IGNORA_CLASULA_SITUACAO_PEDIDO = "AND ('ignoraClausula' = :igIdSituacaoPedido OR p.id_situacao_pedido = :idSituacaoPedido) \n ";
    public static final String IGNORA_CLASULA_TEXTO_SOLICITACAO = "AND ('ignoraClausula' = :igTextoSolicitacao OR UPPER(p.ds_descricao) LIKE UPPER(:textoSolicitacao)) \n ";
    public static final String IGNORA_CLASULA_TEXTO_RESPOSTA = "AND ('ignoraClausula' = :igTextoResposta OR UPPER(p.ds_resposta_esic) LIKE UPPER(:textoResposta)) \n ";
    public static final String IGNORA_CLASULA_PRAZO_VENCIDO_FKS = "AND ('ignoraClausula' = :igPrazoVencidoFKS OR p.dt_vencimento_unidade < :prazoVencidoFKS) \n ";
    public static final String IGNORA_CLASULA_PRAZO_VENCIDOESIC = "AND ('ignoraClausula' = :igPrazoVencidoEsic OR p.dt_prazo_atendimento < :prazoVencidoEsic) \n ";
    public static final String IGNORA_CLASULA_PERIODO_INICIAL = "AND ('ignoraClausula' = :igPeriodoInicialVencimentoEsic OR p.dt_prazo_atendimento >= :periodoInicialVencimentoEsic) \n ";
    public static final String IGNORA_CLASULA_PERIODO_FINAL = "AND ('ignoraClausula' = :igPeriodoFinalVencimentoEsic OR p.dt_prazo_atendimento <= :periodoFinalVencimentoEsic) \n ";
    public static final String IGNORA_CLASULA_PRAZO_PRORROGADO_FKS = "AND ('ignoraClausula' = :igPrazoProrrogadoFKS OR p.st_vencimento_unidade_prorrog = :prazoProrrogadoFKS) \n ";
    public static final String SELECT_PEDIDO_ANDAMENTO = "\tselect p.id_pedido,max(id_andamento) as id_andamento from tb_andamento a \n ";
    public static final String JOIN_PEDIDO = "\tjoin tb_pedido p on a.id_pedido = p.id_pedido\n ";
    public static final String GROUP_BY_PEDIDO = "\tgroup by p.id_pedido\n ";
    public static final String ORDER_BY_PEDIDO = "\torder by id_pedido\n ";
    public static final String JOIN_ON_PEDIDO = "join tb_pedido p on a.id_pedido = p.id_pedido\n ";
    public static final String JOIN_STATUS_TRAMITACAO = "join tb_status_tramitacao st on p.id_status_tramitacao = st.id_status_tramitacao\n ";
    public static final String JOIN_ULTIMO_ANDAMENTO = "join tb_ultimo_andamento ua on a.id_andamento = ua.id_andamento \n ";
    public static final String LEFT_JOIN_UNIDADE = "left join tb_unidade un on a.id_unidade = un.id_unidade\n ";
    public static final String LEFT_JOIN_SUBUNIDADE = "left join tb_subunidade sub on sub.id_unidade = un.id_unidade ";
    public static final String JOIN_STATUS_SOLICITACAO = "join tb_status_solicitacao sol on p.id_status_solicitacao = sol.id_status_solicitacao ";

    public static final String WITH_TB_ULTIMO_ANDAMENTO = "with tb_ultimo_andamento as (\n";
    public static final String IGNORA_CLAUSULA_IDENTIDADE_PRESERVADA = "AND ('ignoraClausula' = :igIdentidadePreservada OR s.nm_nome ~ ('^[0-9\\.]+$')) ";
    public static final String IGNORA_CLAUSULA_STATUS_TRAMITACAO = "AND ('ignoraClausula' = :igIdStatusTramitacao OR p.id_status_tramitacao = :idStatusTramitacao) ";
    public static final String IGNORA_CLAUSULA_ID_TEMA = "AND ('ignoraClausula' = :igIdTema OR p.id_tema = :idTema) ";
    public static final String IGNORA_CLAUSULA_PROTOCOLO = "AND ('ignoraClausula' = :igProtocolo OR p.cd_protocolo = :protocolo) ";
    public static final String IGNORA_CLAUSULA_PERIODO_INICIAL_DA_ABERTURA = "AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR p.dt_data_registro >= :periodoInicialDataAbertura) ";
    public static final String IGNORA_CLAUSULA_PERIODO_FINAL_DATA_ABERTURA = "AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR p.dt_data_registro <= :periodoFinalDataAbertura) ";
    public static final String IGNORA_CLAUSULA_PERIODO_INICIAL_PRAZO_ATENDIMENTO = "AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR p.dt_vencimento_unidade >= :periodoInicialPrazoAtendimento) ";
    public static final String IGNORA_CLAUSULA_PERIODO_FINAL_PRAZO_ATENDIMENTO = "AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR p.dt_vencimento_unidade <= :periodoFinalPrazoAtendimento) ";
    public static final String IGNORA_CLAUSULA_PRAZO_PRORROGADO_ESIC = "AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR p.st_prazo_atendimento_esic_pror = :prazoProrrogadoEsic) ";

    public static final String DEMANDAS_COMIGO_UNIDADE_SIC_COUNT;
    public static final String DEMANDAS_COMIGO_UNIDADE_SIC;
    public static final String PEDIDO_TECNICO_COUNT;
    public static final String PEDIDO_PF;
    public static final String PEDIDO_PF_COUNT;
    public static final String PEDIDO_TECNICO;
    public static final String PEDIDO_RESPONDENTE_COUNT;
    static {
        DEMANDAS_COMIGO_UNIDADE_SIC_COUNT = "select count (*) from tb_pedido p\n" +
                JOIN_SOLICITANTE +
                "join tb_andamento a on a.id_pedido = p.id_pedido\n" +
                "join tb_status_tramitacao t on t.id_status_tramitacao = p.id_status_tramitacao\n" +
                JOIN_PEDIDO_SUBTEMA +
                WHERE_PEDIDO +
                "AND ('ignoraClausula' = :igDemandasComigo OR p.id_status_tramitacao = :idStatusTramitacao) \n" +
                "AND ('ignoraClausula' = :igUnidade OR a.id_unidade = :idUnidade) \n" +
                "AND ('ignoraClausula' = :igIdStatusTramitacao OR p.id_status_tramitacao = :idStatusTramitacao) \n" +
                "AND ('ignoraClausula' = :igIdTema OR p.id_tema = :idTema) \n" +
                "AND ('ignoraClausula' = :igProtocolo OR p.cd_protocolo = :protocolo) \n" +
                "AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR p.dt_data_registro >= :periodoInicialDataAbertura) \n" +
                "AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR p.dt_data_registro <= :periodoFinalDataAbertura) \n" +
                "AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR p.dt_vencimento_unidade >= :periodoInicialPrazoAtendimento) \n" +
                "AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR p.dt_vencimento_unidade <= :periodoFinalPrazoAtendimento) \n" +
                IGNORA_CLASULA_NOME_SOLICITANTE +
                IGNORA_CLASULA_TIPO_PESSOA +
                IGNORA_CLASULA_STATUS_SOLICITACAO +
                IGNORA_CLASULA_STATUS_SITUACAO +
                IGNORA_CLASULA_SITUACAO_PEDIDO +
                IGNORA_CLASULA_TEXTO_SOLICITACAO +
                IGNORA_CLASULA_TEXTO_RESPOSTA +
                IGNORA_CLASULA_PRAZO_VENCIDO_FKS +
                IGNORA_CLASULA_PRAZO_VENCIDOESIC +
                IGNORA_CLASULA_PERIODO_INICIAL +
                IGNORA_CLASULA_PERIODO_FINAL +
                IGNORA_CLASULA_PRAZO_PRORROGADO_FKS +
                "AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR p.st_prazo_atendimento_esic_pror = :prazoProrrogadoEsic) \n" +
                IGNORA_CLAUSULA_IDENTIDADE_PRESERVADA;

        DEMANDAS_COMIGO_UNIDADE_SIC = "select p.id_pedido, p.id_solicitante, p.cd_protocolo, \n" +
                "\tp.ds_descricao, p.cd_codigo_siorg_orgao_superior, \n" +
                "\tp.nm_orgao_superior, p.nm_orgao_vinculado, p.ds_forma_recebimento, \n" +
                "\tp.st_situacao, p.st_situacao_status, p.st_em_atendimento, \n" +
                "\tp.qt_quantidade_anexo, p.id_status_tramitacao, p.id_status_solicitacao, \n" +
                "\tp.id_situacao_pedido, p.ds_resumo_solicitacao, p.ds_observacao, p.ds_resposta_esic, \n" +
                "\tp.dt_data_registro, p.dt_prazo_atendimento, p.dt_entrada_protocolo_fks, \n" +
                "\tp.dt_data_ultimo_reencaminham, p.dt_vencimento_unidade, p.dt_resposta_esic, \n" +
                "\tp.dt_prorrogacao_esic, p.st_vencimento_unidade_prorrog, p.st_prazo_atendimento_esic_pror, \n" +
                "\tp.is_eouv, p.is_devolver, p.ds_proposta_resposta, p.id_classificar_resposta_sic, \n" +
                "\tp.id_tema, p.st_status_resposta_assinada, p.id_pedido_duplicado, p.id_status_situacao, \n" +
                "\tp.is_classificacao_resposta, p.is_classificacao_resposta_sic \n" +
                "from tb_pedido p\n" +
                JOIN_SOLICITANTE +
                "join tb_andamento a on a.id_pedido = p.id_pedido\n" +
                "join tb_status_tramitacao t on t.id_status_tramitacao = p.id_status_tramitacao\n" +
                JOIN_PEDIDO_SUBTEMA +
                WHERE_PEDIDO +
                "AND ('ignoraClausula' = :igDemandasComigo OR p.id_status_tramitacao = :idStatusTramitacao) \n" +
                "AND ('ignoraClausula' = :igUnidade OR a.id_unidade = :idUnidade) \n" +
                "AND ('ignoraClausula' = :igIdStatusTramitacao OR p.id_status_tramitacao = :idStatusTramitacao) \n" +
                "AND ('ignoraClausula' = :igIdTema OR p.id_tema = :idTema) \n" +
                "AND ('ignoraClausula' = :igProtocolo OR p.cd_protocolo = :protocolo) \n" +
                "AND ('ignoraClausula' = :igPeriodoInicialDataAbertura OR p.dt_data_registro >= :periodoInicialDataAbertura) \n" +
                "AND ('ignoraClausula' = :igPeriodoFinalDataAbertura OR p.dt_data_registro <= :periodoFinalDataAbertura) \n" +
                "AND ('ignoraClausula' = :igPeriodoInicialPrazoAtendimento OR p.dt_vencimento_unidade >= :periodoInicialPrazoAtendimento) \n" +
                "AND ('ignoraClausula' = :igPeriodoFinalPrazoAtendimento OR p.dt_vencimento_unidade <= :periodoFinalPrazoAtendimento) \n" +
                IGNORA_CLASULA_NOME_SOLICITANTE +
                IGNORA_CLASULA_TIPO_PESSOA +
                IGNORA_CLASULA_STATUS_SOLICITACAO +
                IGNORA_CLASULA_STATUS_SITUACAO +
                IGNORA_CLASULA_SITUACAO_PEDIDO +
                IGNORA_CLASULA_TEXTO_SOLICITACAO +
                IGNORA_CLASULA_TEXTO_RESPOSTA +
                IGNORA_CLASULA_PRAZO_VENCIDO_FKS +
                IGNORA_CLASULA_PRAZO_VENCIDOESIC +
                IGNORA_CLASULA_PERIODO_INICIAL +
                IGNORA_CLASULA_PERIODO_FINAL +
                IGNORA_CLASULA_PRAZO_PRORROGADO_FKS +
                "AND ('ignoraClausula' = :igPrazoProrrogadoEsic OR p.st_prazo_atendimento_esic_pror = :prazoProrrogadoEsic) \n" +
                IGNORA_CLAUSULA_IDENTIDADE_PRESERVADA;

        PEDIDO_TECNICO_COUNT = WITH_TB_ULTIMO_ANDAMENTO +
                SELECT_PEDIDO_ANDAMENTO +
                JOIN_PEDIDO +
                GROUP_BY_PEDIDO +
                ORDER_BY_PEDIDO +
                ")select count(*) from tb_andamento a \n" +
                JOIN_ON_PEDIDO +
                JOIN_SOLICITANTE +
                JOIN_STATUS_TRAMITACAO +
                JOIN_PEDIDO_SUBTEMA +
                "join tb_andamento_usuario_acessos au on a.id_andamento = au.id_andamento \n" +
                JOIN_ULTIMO_ANDAMENTO +
                "join tb_andamento_usuario_acessos aua on aua.id_andamento = ua.id_andamento\n" +
                "join tb_usuario_acessos acc on acc.id_usuario_acessos = aua.id_usuario_acessos\n" +
                WHERE_PEDIDO +
                "AND acc.id_usuario_acessos = :perfil";

        PEDIDO_PF = WITH_TB_ULTIMO_ANDAMENTO +
                SELECT_PEDIDO_ANDAMENTO +
                JOIN_PEDIDO +
                GROUP_BY_PEDIDO +
                ORDER_BY_PEDIDO +
                ")select DISTINCT on (p.cd_protocolo) p.id_pedido,  \n" +
                "            p.id_classificar_resposta_sic,  \n" +
                "            p.cd_protocolo , \n" +
                "              p.cd_codigo_siorg_orgao_superior, \n" +
                "            p.dt_data_registro ,\n" +
                "            p.dt_prazo_atendimento ,\n" +
                "            p.id_situacao_pedido ,\n" +
                "            s.nm_nome ,\n" +
                "            p.ds_descricao ,\n" +
                "            p.dt_entrada_protocolo_fks, \n" +
                "            p.ds_resumo_solicitacao ,\n" +
                "            p.dt_resposta_esic ,\n" +
                "            p.dt_prorrogacao_esic,  \n" +
                "            p.dt_data_registro,  \n" +
                "            p.dt_data_ultimo_reencaminham,  \n" +
                "            p.st_em_atendimento,  \n" +
                "            p.ds_forma_recebimento,  \n" +
                "            p.is_classificacao_resposta,  \n" +
                "            p.is_classificacao_resposta_sic,  \n" +
                "            p.is_devolver,  \n" +
                "            p.is_eouv,  \n" +
                "            p.ds_observacao,  \n" +
                "            p.nm_orgao_superior,  \n" +
                "            p.nm_orgao_vinculado,  \n" +
                "            p.id_pedido_duplicado,  \n" +
                "            p.ds_proposta_resposta,  \n" +
                "            p.qt_quantidade_anexo,  \n" +
                "            p.ds_resposta_esic,  \n" +
                "            p.st_situacao_status,  \n" +
                "            s.id_solicitante,  \n" +
                "            p.st_prazo_atendimento_esic_pror,  \n" +
                "            p.st_status_resposta_assinada,  \n" +
                "            p.id_status_situacao,  \n" +
                "            sol.id_status_solicitacao,  \n" +
                "            st.id_status_tramitacao,  \n" +
                "            p.st_vencimento_unidade_prorrog,  \n" +
                "            tem.id_tema,  \n" +
                "            p.dt_vencimento_unidade,  \n" +
                "            acc.nm_nome_usuario  \n" +
                "from tb_andamento a \n" +
                JOIN_ON_PEDIDO +
                LEFT_JOIN_UNIDADE +
                LEFT_JOIN_SUBUNIDADE +
                JOIN_SOLICITANTE +
                JOIN_STATUS_TRAMITACAO +
                JOIN_STATUS_SOLICITACAO +
                JOIN_PEDIDO_SUBTEMA +
                "left join tb_andamento_usuario_acessos au on a.id_andamento = au.id_andamento \n" +
                "left join tb_usuario_acessos acc on acc.id_usuario_acessos = au.id_usuario_acessos\n" +
                "left join tb_tema tem on tem.id_tema = p.id_tema \n" +
                WHERE_PEDIDO +
                "AND ('ignoraClausula' = :igRespondente OR sol.id_status_solicitacao in (3,6,11))" +
                "AND ('ignoraClausula' = :igSubunidade OR a.id_subunidade = :idSubunidade ) " +
                "AND ('ignoraClausula' = :igUnidade OR a.id_unidade = :idUnidade OR sub.id_unidade = :idUnidade OR a.id_usuario_acessos = :idUsuarioAcessos) " +
                IGNORA_CLAUSULA_STATUS_TRAMITACAO +
                IGNORA_CLAUSULA_ID_TEMA +
                IGNORA_CLAUSULA_PROTOCOLO +
                IGNORA_CLAUSULA_PERIODO_INICIAL_DA_ABERTURA +
                IGNORA_CLAUSULA_PERIODO_FINAL_DATA_ABERTURA +
                IGNORA_CLAUSULA_PERIODO_INICIAL_PRAZO_ATENDIMENTO +
                IGNORA_CLAUSULA_PERIODO_FINAL_PRAZO_ATENDIMENTO +
                IGNORA_CLASULA_NOME_SOLICITANTE +
                IGNORA_CLASULA_TIPO_PESSOA +
                IGNORA_CLASULA_STATUS_SOLICITACAO +
                IGNORA_CLASULA_STATUS_SITUACAO +
                IGNORA_CLASULA_SITUACAO_PEDIDO +
                IGNORA_CLASULA_TEXTO_SOLICITACAO +
                IGNORA_CLASULA_TEXTO_RESPOSTA +
                IGNORA_CLASULA_PRAZO_VENCIDO_FKS +
                IGNORA_CLASULA_PRAZO_VENCIDOESIC +
                IGNORA_CLASULA_PERIODO_INICIAL +
                IGNORA_CLASULA_PERIODO_FINAL +
                IGNORA_CLASULA_PRAZO_PRORROGADO_FKS +
                IGNORA_CLAUSULA_PRAZO_PRORROGADO_ESIC +
                IGNORA_CLAUSULA_IDENTIDADE_PRESERVADA +
                "ORDER BY p.cd_protocolo, p.is_eouv, p.dt_vencimento_unidade ASC ";


        PEDIDO_PF_COUNT = WITH_TB_ULTIMO_ANDAMENTO +
                SELECT_PEDIDO_ANDAMENTO +
                JOIN_PEDIDO +
                GROUP_BY_PEDIDO +
                ORDER_BY_PEDIDO +
                ")select count(distinct p.id_pedido) from tb_andamento a \n" +
                LEFT_JOIN_UNIDADE +
                LEFT_JOIN_SUBUNIDADE +
                JOIN_ON_PEDIDO +
                JOIN_SOLICITANTE +
                JOIN_STATUS_TRAMITACAO +
                JOIN_STATUS_SOLICITACAO +
                JOIN_PEDIDO_SUBTEMA +
                "left join tb_andamento_usuario_acessos au on a.id_andamento = au.id_andamento \n" +
                "left join tb_usuario_acessos acc on acc.id_usuario_acessos = au.id_usuario_acessos\n" +
                WHERE_PEDIDO +
                "AND (a.id_unidade = :idUnidade OR sub.id_unidade = :idUnidade OR a.id_usuario_acessos = :idUsuarioAcessos ) " +
                "AND ('ignoraClausula' = :igRespondente OR sol.id_status_solicitacao in (3,6,11))" +
                "AND ('ignoraClausula' = :igSubunidade OR a.id_subunidade = :idSubunidade ) " +
                "AND ('ignoraClausula' = :igUnidade OR a.id_unidade = :idUnidade OR sub.id_unidade = :idUnidade OR a.id_usuario_acessos = :idUsuarioAcessos) " +
                IGNORA_CLAUSULA_STATUS_TRAMITACAO +
                IGNORA_CLAUSULA_ID_TEMA +
                IGNORA_CLAUSULA_PROTOCOLO +
                IGNORA_CLAUSULA_PERIODO_INICIAL_DA_ABERTURA +
                IGNORA_CLAUSULA_PERIODO_FINAL_DATA_ABERTURA +
                IGNORA_CLAUSULA_PERIODO_INICIAL_PRAZO_ATENDIMENTO +
                IGNORA_CLAUSULA_PERIODO_FINAL_PRAZO_ATENDIMENTO +
                IGNORA_CLASULA_NOME_SOLICITANTE +
                IGNORA_CLASULA_TIPO_PESSOA +
                IGNORA_CLASULA_STATUS_SOLICITACAO +
                IGNORA_CLASULA_STATUS_SITUACAO +
                IGNORA_CLASULA_SITUACAO_PEDIDO +
                IGNORA_CLASULA_TEXTO_SOLICITACAO +
                IGNORA_CLASULA_TEXTO_RESPOSTA +
                IGNORA_CLASULA_PRAZO_VENCIDO_FKS +
                IGNORA_CLASULA_PRAZO_VENCIDOESIC +
                IGNORA_CLASULA_PERIODO_INICIAL +
                IGNORA_CLASULA_PERIODO_FINAL +
                IGNORA_CLASULA_PRAZO_PRORROGADO_FKS +
                IGNORA_CLAUSULA_PRAZO_PRORROGADO_ESIC +
                IGNORA_CLAUSULA_IDENTIDADE_PRESERVADA;

        PEDIDO_TECNICO = WITH_TB_ULTIMO_ANDAMENTO +
                SELECT_PEDIDO_ANDAMENTO +
                JOIN_PEDIDO +
                GROUP_BY_PEDIDO +
                ORDER_BY_PEDIDO +
                ")select \n" +
                "p.id_pedido, " +
                "id_classificar_resposta_sic, " +
                "\tp.cd_protocolo , \n" +
                "\t  p.cd_codigo_siorg_orgao_superior, \t\n" +
                "\tp.dt_data_registro ,\n" +
                "\tp.dt_prazo_atendimento ,\n" +
                "\tp.id_situacao_pedido ,\n" +
                "\ts.nm_nome ,\n" +
                "\tp.ds_descricao ,\n" +
                "\tp.dt_entrada_protocolo_fks, \n" +
                "\tp.ds_resumo_solicitacao ,\n" +
                "\tp.dt_resposta_esic ,\n" +
                "\tp.dt_prorrogacao_esic, " +
                "\tp.dt_data_registro, " +
                "\tp.dt_data_ultimo_reencaminham, " +
                "\tp.st_em_atendimento, " +
                "\tp.ds_forma_recebimento, " +
                "\tp.is_classificacao_resposta, " +
                "\tp.is_classificacao_resposta_sic, " +
                "\tp.is_devolver, " +
                "\tp.is_eouv, " +
                "\tp.ds_observacao, " +
                "\tp.nm_orgao_superior, " +
                "\tp.nm_orgao_vinculado, " +
                "\tp.id_pedido_duplicado, " +
                "\tp.ds_proposta_resposta, " +
                "\tp.qt_quantidade_anexo, " +
                "\tp.ds_resposta_esic, " +
                "\tp.st_situacao_status, " +
                "\ts.id_solicitante, " +
                "\tp.st_prazo_atendimento_esic_pror, " +
                "\tp.st_status_resposta_assinada, " +
                "\tp.id_status_situacao, " +
                "\tsol.id_status_solicitacao, " +
                "\tst.id_status_tramitacao, " +
                "\tp.st_vencimento_unidade_prorrog, " +
                "\ttem.id_tema, " +
                "\tp.dt_vencimento_unidade, " +
                "\tacc.nm_nome_usuario\n " +
                "from tb_andamento a \n" +
                LEFT_JOIN_UNIDADE +
                LEFT_JOIN_SUBUNIDADE +
                JOIN_ON_PEDIDO +
                JOIN_SOLICITANTE +
                JOIN_STATUS_TRAMITACAO +
                JOIN_PEDIDO_SUBTEMA +
                JOIN_ULTIMO_ANDAMENTO +
                "left join tb_andamento_usuario_acessos aua on aua.id_andamento = ua.id_andamento\n" +
                "left join tb_usuario_acessos acc on acc.id_usuario_acessos = aua.id_usuario_acessos \n" +
                "join tb_status_solicitacao sol on sol.id_status_solicitacao = p.id_status_solicitacao " +
                "left join tb_tema tem on tem.id_tema = p.id_tema " +
                WHERE_PEDIDO +
                "AND ('ignoraClausula' = :igRespondente OR sol.id_status_solicitacao in (7,11,6))" +
                "AND ('ignoraClausula' = :igSubunidade OR a.id_usuario_acessos = :idUsuarioAcessos ) " +
                "AND ('ignoraClausula' = :igUnidade OR acc.id_unidade = :idUnidade) " +
                "AND ('ignoraClausula' = :igPerfil OR acc.id_usuario_acessos = :perfil) " +
                IGNORA_CLAUSULA_STATUS_TRAMITACAO +
                IGNORA_CLAUSULA_ID_TEMA +
                IGNORA_CLAUSULA_PROTOCOLO +
                IGNORA_CLAUSULA_PERIODO_INICIAL_DA_ABERTURA +
                IGNORA_CLAUSULA_PERIODO_FINAL_DATA_ABERTURA +
                IGNORA_CLAUSULA_PERIODO_INICIAL_PRAZO_ATENDIMENTO +
                IGNORA_CLAUSULA_PERIODO_FINAL_PRAZO_ATENDIMENTO +
                IGNORA_CLASULA_NOME_SOLICITANTE +
                IGNORA_CLASULA_TIPO_PESSOA +
                IGNORA_CLASULA_STATUS_SOLICITACAO +
                IGNORA_CLASULA_STATUS_SITUACAO +
                IGNORA_CLASULA_SITUACAO_PEDIDO +
                IGNORA_CLASULA_TEXTO_SOLICITACAO +
                IGNORA_CLASULA_TEXTO_RESPOSTA +
                IGNORA_CLASULA_PRAZO_VENCIDO_FKS +
                IGNORA_CLASULA_PRAZO_VENCIDOESIC +
                IGNORA_CLASULA_PERIODO_INICIAL +
                IGNORA_CLASULA_PERIODO_FINAL +
                IGNORA_CLASULA_PRAZO_PRORROGADO_FKS +
                IGNORA_CLAUSULA_PRAZO_PRORROGADO_ESIC +
                IGNORA_CLAUSULA_IDENTIDADE_PRESERVADA +
                "ORDER BY p.is_eouv, p.dt_vencimento_unidade ASC ";


        PEDIDO_RESPONDENTE_COUNT = WITH_TB_ULTIMO_ANDAMENTO +
                SELECT_PEDIDO_ANDAMENTO +
                JOIN_PEDIDO +
                GROUP_BY_PEDIDO +
                ORDER_BY_PEDIDO +
                ")select count(*) from tb_andamento a \n" +
                JOIN_ON_PEDIDO +
                JOIN_SOLICITANTE +
                JOIN_STATUS_TRAMITACAO +
                "left join tb_pedido_subtema ps on ps.id_pedido = p.id_pedido\n" +
                "join tb_andamento_usuario_acessos au on a.id_andamento = au.id_andamento \n" +
                JOIN_ULTIMO_ANDAMENTO +
                "join tb_andamento_usuario_acessos aua on aua.id_andamento = ua.id_andamento\n" +
                "join tb_usuario_acessos acc on acc.id_usuario_acessos = aua.id_usuario_acessos\n " +
                JOIN_STATUS_SOLICITACAO +
                WHERE_PEDIDO +
                "AND a.id_usuario_acessos = :idUsuarioAcessos " +
                "AND ('ignoraClausula' = :igRespondente OR sol.id_status_solicitacao in (7,11,6))" +
                "AND ('ignoraClausula' = :igPerfil OR acc.id_usuario_acessos = :perfil) ";
    }

    public static final String ID_USUARIO_ACESSOS = "idUsuarioAcessos";
    public static final String ID_UNIDADE = "idUnidade";
    public static final String IG_UNIDADE = "igUnidade";
    public static final String IG_RESPONDENTE = "igRespondente";
    public static final String ID_SUBUNIDADE = "idSubunidade";
    public static final String IG_SUBUNIDADE = "igSubunidade";
    public static final String IGNORA_CLAUSULA = "ignoraClausula";
    public static final String ID_STATUS_TRAMITACAO = "idStatusTramitacao";
    public static final String IG_DEMANDAS_COMIGO = "igDemandasComigo";
    public static final String IG_IDENTIDADE_PRESERVADA = "igIdentidadePreservada";


    public static String concatenarQuery(String base, List<String> queries) {
        String newBase = base;
        for (String query : queries) {
            newBase = newBase.concat(query);
        }
        return newBase;
    }
}
