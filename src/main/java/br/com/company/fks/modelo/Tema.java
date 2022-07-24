package br.com.company.fks.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="tb_tema" )
public class Tema implements Serializable {

    @Id
    @Column(name = "id_tema")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_tema", name = "seq_tb_tema")
    @GeneratedValue(generator = "seq_tb_tema", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nm_tema")
    private String nomeTema;

    @OneToMany(mappedBy = "tema")
    @JsonIgnore
    private List<Subtema> subtemas;
}
