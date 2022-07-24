

insert into fks.tb_solicitante (id_solicitante,tp_tipo_nome,nm_nome,cd_cpf,ds_documento_identificacao,sg_sexo,ds_profissao,ds_email,num_ddd,
num_telefone,ed_endereco,sg_uf,ed_pais,ed_cidade,ed_cep) values (5,'a','b','c','d','e','f','g','h','i','j','k','l','m','n');

insert into fks.tb_status_tramitacao(id_status_tramitacao,nm_nome) values (3,'testd');
insert into fks.tb_status_solicitacao(id_status_solicitacao,nm_nome) values (7,'ted');
insert into fks.tb_situacao_pedido(id_situacao_pedido,nm_nome)values(5,'tef');

insert into fks.tb_pedido(id_pedido,cd_protocolo,dt_data_registro,ds_descricao,cd_codigo_siorg_orgao_superior,nm_orgao_superior,nm_orgao_vinculado,
dt_prazo_atendimento,ds_forma_recebimento,st_situacao_status,st_em_atendimento,qt_quantidade_anexo,dt_entrada_protocolo_fks,
dt_data_ultimo_reencaminham,ds_resumo_solicitacao,dt_vencimento_unidade,ds_observacao,ds_resposta_esic,st_vencimento_unidade_prorrog,
st_prazo_atendimento_esic_pror,is_devolver,dt_resposta_esic,dt_prorrogacao_esic,id_solicitante,id_status_tramitacao,id_status_solicitacao,
id_situacao_pedido,is_eouv)  values (1,'teste',now() ,'teste2','teste3','teste4','teste5',now(),'teste6','teste7','teste8',5,now(),now(),
'teste9',now(),'teste10','teste11',false,true,true,now(),now(),5,3,7,5,true);

insert into fks.tb_andamento(id_andamento,nm_unidade,dt_data_inicio,dt_data_fim,nm_responsavel,ds_observacao,id_pedido,id_status_tramitacao,
id_status_solicitacao) values(7,'a',now(),now(),'b','c',1,3,7)
