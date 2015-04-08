/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_USUARIO_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u"),
    @NamedQuery(name = "UsuarioPerfil.findBySeqUsuarioPerfil", query = "SELECT u FROM UsuarioPerfil u WHERE u.seqUsuarioPerfil = :seqUsuarioPerfil")})
public class UsuarioPerfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_USUARIO_PERFIL")
    private BigDecimal seqUsuarioPerfil;
    @JoinColumn(name = "SEQ_USUARIO", referencedColumnName = "SEQ_USUARIO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Usuario seqUsuario;
    @JoinColumn(name = "SEQ_PERFIL", referencedColumnName = "SEQ_PERFIL")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Perfil seqPerfil;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(BigDecimal seqUsuarioPerfil) {
        this.seqUsuarioPerfil = seqUsuarioPerfil;
    }

    public BigDecimal getSeqUsuarioPerfil() {
        return seqUsuarioPerfil;
    }

    public void setSeqUsuarioPerfil(BigDecimal seqUsuarioPerfil) {
        this.seqUsuarioPerfil = seqUsuarioPerfil;
    }

    public Usuario getSeqUsuario() {
        return seqUsuario;
    }

    public void setSeqUsuario(Usuario seqUsuario) {
        this.seqUsuario = seqUsuario;
    }

    public Perfil getSeqPerfil() {
        return seqPerfil;
    }

    public void setSeqPerfil(Perfil seqPerfil) {
        this.seqPerfil = seqPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqUsuarioPerfil != null ? seqUsuarioPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPerfil)) {
            return false;
        }
        UsuarioPerfil other = (UsuarioPerfil) object;
        if ((this.seqUsuarioPerfil == null && other.seqUsuarioPerfil != null) || (this.seqUsuarioPerfil != null && !this.seqUsuarioPerfil.equals(other.seqUsuarioPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.UsuarioPerfil[ seqUsuarioPerfil=" + seqUsuarioPerfil + " ]";
    }
    
}
