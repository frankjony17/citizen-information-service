package br.com.company.fks.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_solicitante")
public class Solicitante implements Serializable {

    @Id
    @Column(name = "id_solicitante")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "fks.seq_tb_solicitante", name = "seq_tb_solicitante")
    @GeneratedValue(generator = "seq_tb_solicitante", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tp_tipo_nome")
    private String tipoPessoa;

    @Column(name = "nm_nome")
    private String nome;

    @Column(name = "cd_cpf")
    private String cpfOuCnpj;

    @Column(name = "ds_documento_identificacao")
    private String documentoIdentificacao;

    @Column(name = "sg_sexo")
    private String sexo;

    @Column(name = "ds_profissao")
    private String profissao;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "num_ddd")
    private String ddd;

    @Column(name = "num_telefone")
    private String telefone;

    @Column(name = "ed_endereco")
    private String endereco;

    @Column(name = "sg_uf")
    private String uf;

    @Column(name = "ed_pais")
    private String pais;

    @Column(name = "ed_cidade")
    private String cidade;

    @Column(name = "ed_cep")
    private String cep;
}
