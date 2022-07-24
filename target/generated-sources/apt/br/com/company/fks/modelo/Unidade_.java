package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Unidade.class)
public abstract class Unidade_ {

	public static volatile SingularAttribute<Unidade, String> nomeUnidade;
	public static volatile ListAttribute<Unidade, Subunidade> subunidade;
	public static volatile SingularAttribute<Unidade, Boolean> statusUnidade;
	public static volatile SingularAttribute<Unidade, String> codigoUnidade;
	public static volatile SingularAttribute<Unidade, Long> id;
	public static volatile SingularAttribute<Unidade, String> siglaUnidade;
	public static volatile SingularAttribute<Unidade, OrgaoSiorg> orgaoSiorg;

}

