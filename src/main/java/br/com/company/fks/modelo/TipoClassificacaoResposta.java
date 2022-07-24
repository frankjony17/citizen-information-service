package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_tipo_classificacao_resposta", schema = "fks")
public class TipoClassificacaoResposta implements Serializable {
    @Id
    @Column(name = "id_tipo_classificacao")
    private Long id;

    @Column(name = "ds_descricao")
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoClassificacaoResposta", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ClassificacaoResposta> classificacaoRespostas;

}
