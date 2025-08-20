package br.com.miranda.loja_virtual.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)

/*
    Vou implementar uma interface UserDetails, para que o springboot security
    Vai te obrigar a implementar alguns métodos
*/
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_atual_senha;

    //Não esquecer de ir na Pessoa e criar a lista
    @ManyToOne(targetEntity = Pessoa.class)//referente a esta classe
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    /*FetchType.LAZY - para carregar os acessos apenas quando precisar*/
    @OneToMany(fetch = FetchType.LAZY)
    //usuario_acesso - vai ser uma nova tabela
    @JoinTable(name = "usuario_acesso", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"}, name = "unique_acesso_user"),
        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuario", unique = false,
        foreignKey = @ForeignKey(name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
        inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false, referencedColumnName = "id", table = "acesso",
        foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Acesso> acessos;

    /*Autoridades = São os acessos, ou seja ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acessos; //Retorna os acessos da lista
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return UserDetails.super.isEnabled();
        return true;
    }


}
