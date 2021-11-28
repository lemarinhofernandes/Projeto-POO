/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import com.mycompany.conexao.EntidadeBase;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author duduy
 */
@Entity
@Table(name = "conta")
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c")})
public class Conta implements Serializable, EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "tipo")
    private Integer tipo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaId")
    private Collection<Reltransf> reltransfCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaId")
    private Collection<Reldeposito> reldepositoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaId")
    private Collection<Relsaque> relsaqueCollection;

    public Conta() {
    }

    public Conta(Integer id) {
        this.id = id;
    }

    public Conta(Integer id, String numero, String nome) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Reltransf> getReltransfCollection() {
        return reltransfCollection;
    }

    public void setReltransfCollection(Collection<Reltransf> reltransfCollection) {
        this.reltransfCollection = reltransfCollection;
    }

    public Collection<Reldeposito> getReldepositoCollection() {
        return reldepositoCollection;
    }

    public void setReldepositoCollection(Collection<Reldeposito> reldepositoCollection) {
        this.reldepositoCollection = reldepositoCollection;
    }

    public Collection<Relsaque> getRelsaqueCollection() {
        return relsaqueCollection;
    }

    public void setRelsaqueCollection(Collection<Relsaque> relsaqueCollection) {
        this.relsaqueCollection = relsaqueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.classes.Conta[ id=" + id + " ]";
    }
    
}
