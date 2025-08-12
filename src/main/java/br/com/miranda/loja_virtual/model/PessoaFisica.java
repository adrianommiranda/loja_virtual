package br.com.miranda.loja_virtual.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")

//você precisa remover a anotação @PrimaryKeyJoinColumn da classe PessoaFisica, pois ela não é necessária quando se usa TABLE_PER_CLASS
//@PrimaryKeyJoinColumn(name = "id")/*id de pessoa*/
public class PessoaFisica extends Pessoa{

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
