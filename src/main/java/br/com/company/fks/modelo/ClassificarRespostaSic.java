package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_classificar_resposta_sic")
public class ClassificarRespostaSic implements Serializable {
    @Id
    @Column(name = "id_classificar_resposta_sic")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_classificar_resposta_sic", name = "seq_tb_classificar_resposta_sic")
    @GeneratedValue(generator = "seq_tb_classificar_resposta_sic", strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sub_categoria")
    private SubCategoria subcategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_resposta")
    private TipoResposta tipoResposta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_classificacao_tipo_resposta")
    private ClassificacaoTipoResposta classificacaoTipoResposta;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_pedido_classificacao_resp",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_classificacao"))
    private List<ClassificacaoResposta> classificacaoResposta;

    @Column(name = "num_pagina")
    private Long numeroPagina;

    @Column(name = "st_restricao_conteudo")
    private Boolean restricaoConteudo;

}
