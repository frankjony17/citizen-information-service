package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Anexo.class)
public abstract class Anexo_ {

	public static volatile SingularAttribute<Anexo, String> extensao;
	public static volatile SingularAttribute<Anexo, Long> tamanho;
	public static volatile SingularAttribute<Anexo, Pedido> pedido;
	public static volatile SingularAttribute<Anexo, String> nome;
	public static volatile SingularAttribute<Anexo, Long> id;

}

