package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrgaoSiorg.class)
public abstract class OrgaoSiorg_ {

	public static volatile SingularAttribute<OrgaoSiorg, String> nomeOrgao;
	public static volatile SingularAttribute<OrgaoSiorg, String> siglaOrgao;
	public static volatile SingularAttribute<OrgaoSiorg, String> codigoOrgao;
	public static volatile ListAttribute<OrgaoSiorg, Unidade> unidades;
	public static volatile SingularAttribute<OrgaoSiorg, Long> id;
	public static volatile SingularAttribute<OrgaoSiorg, Boolean> statusOrgao;

}

