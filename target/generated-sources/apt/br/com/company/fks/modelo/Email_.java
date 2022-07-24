package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Email.class)
public abstract class Email_ {

	public static volatile SingularAttribute<Email, Integer> dataReferencia;
	public static volatile SingularAttribute<Email, Integer> statusDemanda;
	public static volatile SingularAttribute<Email, Integer> diasAposDataReferencia;
	public static volatile SingularAttribute<Email, Integer> tipoAlerta;
	public static volatile SingularAttribute<Email, Integer> dataEnvioEmail;
	public static volatile SingularAttribute<Email, Integer> tipoSolicitacao;
	public static volatile SingularAttribute<Email, Integer> diasAnteDataReferencia;
	public static volatile SingularAttribute<Email, String> assuntoEmail;
	public static volatile SingularAttribute<Email, Long> id;
	public static volatile SingularAttribute<Email, Boolean> reenviarAteAlteracaoDoStatus;
	public static volatile SingularAttribute<Email, Integer> acaoExecutada;
	public static volatile SingularAttribute<Email, String> conteudoEmail;

}

