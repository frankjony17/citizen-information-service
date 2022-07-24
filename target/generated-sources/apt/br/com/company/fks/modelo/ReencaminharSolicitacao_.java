package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReencaminharSolicitacao.class)
public abstract class ReencaminharSolicitacao_ {

	public static volatile SingularAttribute<ReencaminharSolicitacao, String> notificacaoEnviadaSolicitante;
	public static volatile SingularAttribute<ReencaminharSolicitacao, Orgao> orgao;
	public static volatile SingularAttribute<ReencaminharSolicitacao, Pedido> pedido;
	public static volatile SingularAttribute<ReencaminharSolicitacao, Long> id;
	public static volatile SingularAttribute<ReencaminharSolicitacao, String> notificacaoEnviadaDestinatario;

}

