package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Andamento.class)
public abstract class Andamento_ {

	public static volatile SingularAttribute<Andamento, Boolean> statusRespostaAssinada;
	public static volatile SingularAttribute<Andamento, String> observacao;
	public static volatile SingularAttribute<Andamento, String> observacaoUsuario;
	public static volatile SingularAttribute<Andamento, StatusSolicitacao> statusSolicitacao;
	public static volatile SingularAttribute<Andamento, Calendar> dataFim;
	public static volatile ListAttribute<Andamento, Unidade> listaUnidade;
	public static volatile SingularAttribute<Andamento, StatusTramitacao> statusTramitacao;
	public static volatile ListAttribute<Andamento, Subunidade> listaSubunidade;
	public static volatile SingularAttribute<Andamento, Unidade> unidade;
	public static volatile SingularAttribute<Andamento, Subunidade> subunidade;
	public static volatile SingularAttribute<Andamento, String> justificativa;
	public static volatile SingularAttribute<Andamento, Pedido> pedido;
	public static volatile SingularAttribute<Andamento, UsuarioAcessos> usuarioAcessosAssinatura;
	public static volatile ListAttribute<Andamento, UsuarioAcessos> usuarioAcessos;
	public static volatile SingularAttribute<Andamento, Long> id;
	public static volatile SingularAttribute<Andamento, Calendar> dataInicio;
	public static volatile SingularAttribute<Andamento, String> responsavel;

}

