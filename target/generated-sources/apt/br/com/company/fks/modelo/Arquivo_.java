package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Arquivo.class)
public abstract class Arquivo_ {

	public static volatile SingularAttribute<Arquivo, String> extensao;
	public static volatile SingularAttribute<Arquivo, Long> tamanho;
	public static volatile SingularAttribute<Arquivo, String> diretorioArquivo;
	public static volatile SingularAttribute<Arquivo, byte[]> binario;
	public static volatile SingularAttribute<Arquivo, Pedido> pedido;
	public static volatile SingularAttribute<Arquivo, String> nome;
	public static volatile SingularAttribute<Arquivo, Long> id;
	public static volatile SingularAttribute<Arquivo, String> contentType;
	public static volatile SingularAttribute<Arquivo, String> nomeIdentificador;

}

