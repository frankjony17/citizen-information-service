package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EOuv.class)
public abstract class EOuv_ {

	public static volatile SingularAttribute<EOuv, Boolean> restricaoConteudo;
	public static volatile SingularAttribute<EOuv, TipoManifestacao> tipoManifestacao;
	public static volatile SingularAttribute<EOuv, SubCategoria> subcategoria;
	public static volatile SingularAttribute<EOuv, Categoria> categoria;
	public static volatile SingularAttribute<EOuv, Pedido> pedido;
	public static volatile SingularAttribute<EOuv, Long> id;
	public static volatile SingularAttribute<EOuv, TipoTratamento> tipoTratamento;

}

