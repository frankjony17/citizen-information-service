package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistoricoTratamento.class)
public abstract class HistoricoTratamento_ {

	public static volatile SingularAttribute<HistoricoTratamento, Boolean> statusRespostaAssinada;
	public static volatile SingularAttribute<HistoricoTratamento, Calendar> data;
	public static volatile SingularAttribute<HistoricoTratamento, Pedido> pedido;
	public static volatile SingularAttribute<HistoricoTratamento, Long> id;
	public static volatile SingularAttribute<HistoricoTratamento, String> respostaPedido;
	public static volatile SingularAttribute<HistoricoTratamento, String> nomeResponsavel;
	public static volatile SingularAttribute<HistoricoTratamento, TipoTratamento> tipoTratamento;

}

