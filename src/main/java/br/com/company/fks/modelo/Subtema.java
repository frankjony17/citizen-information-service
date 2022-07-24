package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
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
@Table(name = "tb_subtema")
public class Subtema implements Serializable {

    @Id
    @Column(name = "id_subtema")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_subtema", name = "seq_tb_subtema")
    @GeneratedValue(generator = "seq_tb_subtema", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_subtema")
    private String nomeSubtema;

    @ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "tb_subtema_palavra_chave",
            joinColumns = @JoinColumn(name = "id_subtema"),
            inverseJoinColumns = @JoinColumn(name = "id_palavra_chave"))
    private List<PalavraChave> palavrasChaves;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema",nullable=false)
    @JsonManagedReference
    private Tema tema;
}
