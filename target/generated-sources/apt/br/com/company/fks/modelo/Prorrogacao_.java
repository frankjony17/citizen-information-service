package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Prorrogacao.class)
public abstract class Prorrogacao_ {

	public static volatile SingularAttribute<Prorrogacao, String> justificativaProrrogacao;
	public static volatile SingularAttribute<Prorrogacao, Boolean> eSic;
	public static volatile SingularAttribute<Prorrogacao, Pedido> pedido;
	public static volatile SingularAttribute<Prorrogacao, Long> id;
	public static volatile SingularAttribute<Prorrogacao, MotivoProrrogacao> motivoProrrogacao;

}

