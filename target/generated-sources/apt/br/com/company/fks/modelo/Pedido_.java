package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, String> observacao;
	public static volatile SingularAttribute<Pedido, String> resumoSolicitacao;
	public static volatile SingularAttribute<Pedido, Calendar> dataRegistro;
	public static volatile SingularAttribute<Pedido, String> codigoSiorgOrgaoSuperior;
	public static volatile SingularAttribute<Pedido, StatusTramitacao> statusTramitacao;
	public static volatile SetAttribute<Pedido, Anexo> anexos;
	public static volatile ListAttribute<Pedido, ClassificacaoResposta> classificacaoResposta;
	public static volatile SingularAttribute<Pedido, Boolean> statusVencimentoUnidadeProrrogado;
	public static volatile SingularAttribute<Pedido, Boolean> statusPrazoAtendimentoEsicProrrogado;
	public static volatile SingularAttribute<Pedido, String> orgaoVinculado;
	public static volatile SingularAttribute<Pedido, String> protocolo;
	public static volatile SingularAttribute<Pedido, Boolean> isEOuv;
	public static volatile SingularAttribute<Pedido, Calendar> dataEntradaProtocoloSistemaFKS;
	public static volatile SingularAttribute<Pedido, Boolean> isDevolver;
	public static volatile SingularAttribute<Pedido, Calendar> dataRespostaEsic;
	public static volatile SingularAttribute<Pedido, SituacaoPedido> situacaoPedido;
	public static volatile SingularAttribute<Pedido, Long> id;
	public static volatile SingularAttribute<Pedido, Calendar> dataUltimoReencaminhamento;
	public static volatile ListAttribute<Pedido, Subtema> subtemaList;
	public static volatile ListAttribute<Pedido, Andamento> andamentos;
	public static volatile SingularAttribute<Pedido, Boolean> statusRespostaAssinada;
	public static volatile SingularAttribute<Pedido, ClassificarRespostaSic> classificarRespostaSic;
	public static volatile SingularAttribute<Pedido, Boolean> isClassificacaoResposta;
	public static volatile SingularAttribute<Pedido, StatusSolicitacao> statusSolicitacao;
	public static volatile SingularAttribute<Pedido, Solicitante> solicitante;
	public static volatile SingularAttribute<Pedido, Pedido> pedidoDuplicado;
	public static volatile ListAttribute<Pedido, PalavraChave> palavraChaveList;
	public static volatile SingularAttribute<Pedido, String> orgaoSuperior;
	public static volatile SingularAttribute<Pedido, Calendar> prazoAtendimento;
	public static volatile SingularAttribute<Pedido, String> emAtendimento;
	public static volatile SingularAttribute<Pedido, Calendar> vencimentoUnidade;
	public static volatile SingularAttribute<Pedido, Tema> tema;
	public static volatile SingularAttribute<Pedido, String> descricaoPedido;
	public static volatile SingularAttribute<Pedido, String> respostaEsic;
	public static volatile SingularAttribute<Pedido, Integer> quantidadeAnexos;
	public static volatile SingularAttribute<Pedido, String> propostaResposta;
	public static volatile SingularAttribute<Pedido, StatusSituacao> statusSituacao;
	public static volatile SingularAttribute<Pedido, Calendar> dataProrrogacaoESic;
	public static volatile SingularAttribute<Pedido, String> formaRecebimento;
	public static volatile SingularAttribute<Pedido, String> situacaoStatus;
	public static volatile SingularAttribute<Pedido, Boolean> isClassificacaoRespostaSic;

}

