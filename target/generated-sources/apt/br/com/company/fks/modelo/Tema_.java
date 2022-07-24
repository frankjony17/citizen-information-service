package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tema.class)
public abstract class Tema_ {

	public static volatile SingularAttribute<Tema, String> nomeTema;
	public static volatile ListAttribute<Tema, Subtema> subtemas;
	public static volatile SingularAttribute<Tema, Long> id;

}

