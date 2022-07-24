package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subtema.class)
public abstract class Subtema_ {

	public static volatile SingularAttribute<Subtema, String> nomeSubtema;
	public static volatile SingularAttribute<Subtema, Tema> tema;
	public static volatile ListAttribute<Subtema, PalavraChave> palavrasChaves;
	public static volatile SingularAttribute<Subtema, Long> id;

}

