package br.com.company.fks.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HistoricoTratamentoRecurso.class)
public abstract class HistoricoTratamentoRecurso_ {

	public static volatile SingularAttribute<HistoricoTratamentoRecurso, String> respostaRecurso;
	public static volatile SingularAttribute<HistoricoTratamentoRecurso, Recurso> recurso;
	public static volatile SingularAttribute<HistoricoTratamentoRecurso, Calendar> data;
	public static volatile SingularAttribute<HistoricoTratamentoRecurso, Long> id;
	public static volatile SingularAttribute<HistoricoTratamentoRecurso, TipoTratamentoRecurso> tipoTratamentoRecurso;
	public static volatile SingularAttribute<HistoricoTratamentoRecurso, String> nomeResponsavel;

}

