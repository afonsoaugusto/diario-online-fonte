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
@Table(name = "TBL_PERFIL_FUNCIONALIDADE_ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilFuncionalidadeAcao.findAll", query = "SELECT p FROM PerfilFuncionalidadeAcao p"),
    @NamedQuery(name = "PerfilFuncionalidadeAcao.findBySeqPerfilFuncionalidadeAcao", query = "SELECT p FROM PerfilFuncionalidadeAcao p WHERE p.seqPerfilFuncionalidadeAcao = :seqPerfilFuncionalidadeAcao")})
public class PerfilFuncionalidadeAcao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PERFIL_FUNCIONALIDADE_ACAO")
    private BigDecimal seqPerfilFuncionalidadeAcao;
    @JoinColumn(name = "SEQ_PERFIL", referencedColumnName = "SEQ_PERFIL")
    @ManyToOne(optional = false)
    private Perfil seqPerfil;
    @JoinColumn(name = "SEQ_FUNCIONALIDADE_ACAO", referencedColumnName = "SEQ_FUNCIONALIDADE_ACAO")
    @ManyToOne(optional = false)
    private FuncionalidadeAcao seqFuncionalidadeAcao;

    public PerfilFuncionalidadeAcao() {
    }

    public PerfilFuncionalidadeAcao(BigDecimal seqPerfilFuncionalidadeAcao) {
        this.seqPerfilFuncionalidadeAcao = seqPerfilFuncionalidadeAcao;
    }

    public BigDecimal getSeqPerfilFuncionalidadeAcao() {
        return seqPerfilFuncionalidadeAcao;
    }

    public void setSeqPerfilFuncionalidadeAcao(BigDecimal seqPerfilFuncionalidadeAcao) {
        this.seqPerfilFuncionalidadeAcao = seqPerfilFuncionalidadeAcao;
    }

    public Perfil getSeqPerfil() {
        return seqPerfil;
    }

    public void setSeqPerfil(Perfil seqPerfil) {
        this.seqPerfil = seqPerfil;
    }

    public FuncionalidadeAcao getSeqFuncionalidadeAcao() {
        return seqFuncionalidadeAcao;
    }

    public void setSeqFuncionalidadeAcao(FuncionalidadeAcao seqFuncionalidadeAcao) {
        this.seqFuncionalidadeAcao = seqFuncionalidadeAcao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqPerfilFuncionalidadeAcao != null ? seqPerfilFuncionalidadeAcao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilFuncionalidadeAcao)) {
            return false;
        }
        PerfilFuncionalidadeAcao other = (PerfilFuncionalidadeAcao) object;
        if ((this.seqPerfilFuncionalidadeAcao == null && other.seqPerfilFuncionalidadeAcao != null) || (this.seqPerfilFuncionalidadeAcao != null && !this.seqPerfilFuncionalidadeAcao.equals(other.seqPerfilFuncionalidadeAcao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.PerfilFuncionalidadeAcao[ seqPerfilFuncionalidadeAcao=" + seqPerfilFuncionalidadeAcao + " ]";
    }
    
}
