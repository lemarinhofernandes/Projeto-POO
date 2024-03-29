/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;

import com.mycompany.conexao.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author duduy
 */
@Entity
@Table(name = "reldeposito")
@NamedQueries({
    @NamedQuery(name = "Reldeposito.findAll", query = "SELECT r FROM Reldeposito r")})
public class Reldeposito implements Serializable, EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Conta contaId;
    @JoinColumn(name = "deposito_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Deposito depositoId;

    public Reldeposito() {
    }

    public Reldeposito(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conta getContaId() {
        return contaId;
    }

    public void setContaId(Conta contaId) {
        this.contaId = contaId;
    }

    public Deposito getDepositoId() {
        return depositoId;
    }

    public void setDepositoId(Deposito depositoId) {
        this.depositoId = depositoId;
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
        if (!(object instanceof Reldeposito)) {
            return false;
        }
        Reldeposito other = (Reldeposito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.classes.Reldeposito[ id=" + id + " ]";
    }
    
}
