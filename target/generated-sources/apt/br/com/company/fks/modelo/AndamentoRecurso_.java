package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AndamentoRecurso.class)
public abstract class AndamentoRecurso_ {

	public static volatile SingularAttribute<AndamentoRecurso, Recurso> recurso;
	public static volatile SingularAttribute<AndamentoRecurso, StatusTramitacaoRecurso> statusTramitacaoRecurso;
	public static volatile SingularAttribute<AndamentoRecurso, String> observacao;
	public static volatile SingularAttribute<AndamentoRecurso, String> observacaoUsuario;
	public static volatile SingularAttribute<AndamentoRecurso, Calendar> dataFim;
	public static volatile SingularAttribute<AndamentoRecurso, Long> unidade;
	public static volatile SingularAttribute<AndamentoRecurso, StatusSolicitacaoRecurso> statusSolicitacaoRecurso;
	public static volatile SingularAttribute<AndamentoRecurso, String> justificativa;
	public static volatile SingularAttribute<AndamentoRecurso, UsuarioAcessos> usuarioAcessosAssinatura;
	public static volatile ListAttribute<AndamentoRecurso, UsuarioAcessos> usuarioAcessos;
	public static volatile SingularAttribute<AndamentoRecurso, Long> id;
	public static volatile SingularAttribute<AndamentoRecurso, Calendar> dataInicio;
	public static volatile SingularAttribute<AndamentoRecurso, String> responsavel;

}

