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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_FUNCIONALIDADE_ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionalidadeAcao.findAll", query = "SELECT f FROM FuncionalidadeAcao f"),
    @NamedQuery(name = "FuncionalidadeAcao.findBySeqFuncionalidadeAcao", query = "SELECT f FROM FuncionalidadeAcao f WHERE f.seqFuncionalidadeAcao = :seqFuncionalidadeAcao")})
public class FuncionalidadeAcao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_FUNCIONALIDADE_ACAO")
    private BigDecimal seqFuncionalidadeAcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqFuncionalidadeAcao")
    private List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaoList;
    @JoinColumn(name = "SEQ_FUNCIONALIDADE", referencedColumnName = "SEQ_FUNCIONALIDADE")
    @ManyToOne(optional = false)
    private Funcionalidade seqFuncionalidade;
    @JoinColumn(name = "SEQ_ACAO", referencedColumnName = "SEQ_ACAO")
    @ManyToOne(optional = false)
    private Acao seqAcao;

    public FuncionalidadeAcao() {
    }

    public FuncionalidadeAcao(BigDecimal seqFuncionalidadeAcao) {
        this.seqFuncionalidadeAcao = seqFuncionalidadeAcao;
    }

    public BigDecimal getSeqFuncionalidadeAcao() {
        return seqFuncionalidadeAcao;
    }

    public void setSeqFuncionalidadeAcao(BigDecimal seqFuncionalidadeAcao) {
        this.seqFuncionalidadeAcao = seqFuncionalidadeAcao;
    }

    @XmlTransient
    public List<PerfilFuncionalidadeAcao> getPerfilFuncionalidadeAcaoList() {
        return perfilFuncionalidadeAcaoList;
    }

    public void setPerfilFuncionalidadeAcaoList(List<PerfilFuncionalidadeAcao> perfilFuncionalidadeAcaoList) {
        this.perfilFuncionalidadeAcaoList = perfilFuncionalidadeAcaoList;
    }

    public Funcionalidade getSeqFuncionalidade() {
        return seqFuncionalidade;
    }

    public void setSeqFuncionalidade(Funcionalidade seqFuncionalidade) {
        this.seqFuncionalidade = seqFuncionalidade;
    }

    public Acao getSeqAcao() {
        return seqAcao;
    }

    public void setSeqAcao(Acao seqAcao) {
        this.seqAcao = seqAcao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqFuncionalidadeAcao != null ? seqFuncionalidadeAcao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionalidadeAcao)) {
            return false;
        }
        FuncionalidadeAcao other = (FuncionalidadeAcao) object;
        if ((this.seqFuncionalidadeAcao == null && other.seqFuncionalidadeAcao != null) || (this.seqFuncionalidadeAcao != null && !this.seqFuncionalidadeAcao.equals(other.seqFuncionalidadeAcao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.FuncionalidadeAcao[ seqFuncionalidadeAcao=" + seqFuncionalidadeAcao + " ]";
    }
    
}
