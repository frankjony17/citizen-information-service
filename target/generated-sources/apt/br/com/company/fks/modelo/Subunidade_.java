package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subunidade.class)
public abstract class Subunidade_ {

	public static volatile SingularAttribute<Subunidade, String> siglaSubunidade;
	public static volatile SingularAttribute<Subunidade, Boolean> statusSubunidade;
	public static volatile SingularAttribute<Subunidade, String> codigoSubunidade;
	public static volatile SingularAttribute<Subunidade, Unidade> unidade;
	public static volatile SingularAttribute<Subunidade, Long> id;
	public static volatile SingularAttribute<Subunidade, String> nomeSubunidade;

}

