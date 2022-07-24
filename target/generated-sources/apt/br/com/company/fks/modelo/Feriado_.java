package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Feriado.class)
public abstract class Feriado_ {

	public static volatile SingularAttribute<Feriado, Integer> ano;
	public static volatile SingularAttribute<Feriado, String> nome;
	public static volatile SingularAttribute<Feriado, Long> id;
	public static volatile SingularAttribute<Feriado, Calendar> dataFeriado;
	public static volatile SingularAttribute<Feriado, String> descricao;

}

