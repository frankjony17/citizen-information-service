package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClassificarRespostaSic.class)
public abstract class ClassificarRespostaSic_ {

	public static volatile SingularAttribute<ClassificarRespostaSic, Boolean> restricaoConteudo;
	public static volatile SingularAttribute<ClassificarRespostaSic, SubCategoria> subcategoria;
	public static volatile SingularAttribute<ClassificarRespostaSic, Long> numeroPagina;
	public static volatile SingularAttribute<ClassificarRespostaSic, Categoria> categoria;
	public static volatile SingularAttribute<ClassificarRespostaSic, ClassificacaoTipoResposta> classificacaoTipoResposta;
	public static volatile ListAttribute<ClassificarRespostaSic, ClassificacaoResposta> classificacaoResposta;
	public static volatile SingularAttribute<ClassificarRespostaSic, Long> id;
	public static volatile SingularAttribute<ClassificarRespostaSic, TipoResposta> tipoResposta;

}

