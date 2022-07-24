package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recurso.class)
public abstract class Recurso_ {

	public static volatile SingularAttribute<Recurso, Boolean> statusRespostaAssinada;
	public static volatile SingularAttribute<Recurso, TipoRecurso> tipoRecurso;
	public static volatile SingularAttribute<Recurso, TipoRespostaRecurso> tipoRespostaRecurso;
	public static volatile SingularAttribute<Recurso, String> observacao;
	public static volatile SingularAttribute<Recurso, String> observacaoRespostaEnviada;
	public static volatile SingularAttribute<Recurso, StatusSolicitacaoRecurso> statusSolicitacao;
	public static volatile SingularAttribute<Recurso, StatusTramitacaoRecurso> statusTramitacao;
	public static volatile SingularAttribute<Recurso, Calendar> dataPrazoAtendimento;
	public static volatile SingularAttribute<Recurso, Calendar> dataAbertura;
	public static volatile SingularAttribute<Recurso, Calendar> vencimentoUnidade;
	public static volatile SingularAttribute<Recurso, String> respostaEsic;
	public static volatile SingularAttribute<Recurso, Integer> quantidadeAnexos;
	public static volatile SingularAttribute<Recurso, String> propostaResposta;
	public static volatile SingularAttribute<Recurso, Pedido> pedido;
	public static volatile SingularAttribute<Recurso, Long> id;
	public static volatile SingularAttribute<Recurso, String> descricaoJustificativa;
	public static volatile SingularAttribute<Recurso, SituacaoRecurso> situacaoRecurso;
	public static volatile SingularAttribute<Recurso, String> descricaoJustificativaDevolver;
	public static volatile SingularAttribute<Recurso, InstanciaRecurso> instanciaRecurso;
	public static volatile SingularAttribute<Recurso, String> protocoloPedido;

}

