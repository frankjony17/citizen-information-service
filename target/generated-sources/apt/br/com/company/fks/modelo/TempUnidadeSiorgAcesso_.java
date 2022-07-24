package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TempUnidadeSiorgAcesso.class)
public abstract class TempUnidadeSiorgAcesso_ {

	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, Boolean> ativo;
	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, String> sigla;
	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, TempOrgaoSiorgAcesso> tempOrgaoSiorgAcesso;
	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, String> nome;
	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, Long> unidadePaiId;
	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, Long> id;
	public static volatile SingularAttribute<TempUnidadeSiorgAcesso, String> codigoUg;

}

