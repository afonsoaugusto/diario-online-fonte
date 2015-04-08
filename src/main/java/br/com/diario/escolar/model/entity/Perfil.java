/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findBySeqPerfil", query = "SELECT p FROM Perfil p WHERE p.seqPerfil = :seqPerfil"),
    @NamedQuery(name = "Perfil.findByNomPerfil", query = "SELECT p FROM Perfil p WHERE p.nomPerfil = :nomPerfil"),
    @NamedQuery(name = "Perfil.findByDesPerfil", query = "SELECT p FROM Perfil p WHERE p.desPerfil = :desPerfil")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PERFIL")
    private BigDecimal seqPerfil;
    @Size(max = 255)
    @Column(name = "NOM_PERFIL")
    private String nomPerfil;
    @Size(max = 255)
    @Column(name = "DES_PERFIL")
    private String desPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPerfil",fetch = FetchType.LAZY)
    private List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPerfil",fetch = FetchType.LAZY)
    private List<UsuarioPerfil> usuarioPerfilList;

    public Perfil() {
    }

    public Perfil(BigDecimal seqPerfil) {
        this.seqPerfil = seqPerfil;
    }

    public BigDecimal getSeqPerfil() {
        return seqPerfil;
    }

    public void setSeqPerfil(BigDecimal seqPerfil) {
        this.seqPerfil = seqPerfil;
    }

    public String getNomPerfil() {
        return nomPerfil;
    }

    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
    }

    public String getDesPerfil() {
        return desPerfil;
    }

    public void setDesPerfil(String desPerfil) {
        this.desPerfil = desPerfil;
    }

    @XmlTransient
    public List<PerfilFuncionalidadeAcao> getPerfilFuncionalidadeAcaoList() {
        return perfilFuncionalidadeAcaoList;
    }

    public void setPerfilFuncionalidadeAcaoList(List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaoList) {
        this.perfilFuncionalidadeAcaoList = perfilFuncionalidadeAcaoList;
    }

    @XmlTransient
    public List<UsuarioPerfil> getUsuarioPerfilList() {
        return usuarioPerfilList;
    }

    public void setUsuarioPerfilList(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfilList = usuarioPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqPerfil != null ? seqPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.seqPerfil == null && other.seqPerfil != null) || (this.seqPerfil != null && !this.seqPerfil.equals(other.seqPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Perfil[ seqPerfil=" + seqPerfil + " ]";
    }
    
}
