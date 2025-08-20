package br.com.miranda.loja_virtual.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")

//você precisa remover a anotação @PrimaryKeyJoinColumn da classe PessoaFisica, pois ela não é necessária quando se usa TABLE_PER_CLASS
//@PrimaryKeyJoinColumn(name = "id") /*id de pessoa*/
public class PessoaJuridica extends  Pessoa{

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String inscEstadual;

    //@Column(nullable = false)
    private String inscMunicipal;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String categoria;




    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInsc_estadual() {
        return inscEstadual;
    }

    public void setInsc_estadual(String insc_estadual) {
        this.inscEstadual = insc_estadual;
    }

    public String getInsc_municipal() {
        return inscMunicipal;
    }

    public void setInsc_municipal(String insc_municipal) {
        this.inscMunicipal = insc_municipal;
    }

    public String getNome_fantasia() {
        return nomeFantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nomeFantasia = nome_fantasia;
    }

    public String getRazao_social() {
        return razaoSocial;
    }

    public void setRazao_social(String razao_social) {
        this.razaoSocial = razao_social;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
