package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClassificacaoResposta.class)
public abstract class ClassificacaoResposta_ {

	public static volatile SingularAttribute<ClassificacaoResposta, Boolean> statusClassificacaoResposta;
	public static volatile SingularAttribute<ClassificacaoResposta, Long> id;
	public static volatile SingularAttribute<ClassificacaoResposta, TipoClassificacaoResposta> tipoClassificacaoResposta;
	public static volatile SingularAttribute<ClassificacaoResposta, String> descricao;

}

