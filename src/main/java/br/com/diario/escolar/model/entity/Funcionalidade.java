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
@Table(name = "TBL_FUNCIONALIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionalidade.findAll", query = "SELECT f FROM Funcionalidade f"),
    @NamedQuery(name = "Funcionalidade.findBySeqFuncionalidade", query = "SELECT f FROM Funcionalidade f WHERE f.seqFuncionalidade = :seqFuncionalidade"),
    @NamedQuery(name = "Funcionalidade.findByCodFuncionalidade", query = "SELECT f FROM Funcionalidade f WHERE f.codFuncionalidade = :codFuncionalidade"),
    @NamedQuery(name = "Funcionalidade.findByDesFuncionalidade", query = "SELECT f FROM Funcionalidade f WHERE f.desFuncionalidade = :desFuncionalidade")})
public class Funcionalidade implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_FUNCIONALIDADE")
    private BigDecimal seqFuncionalidade;
    @Size(max = 25)
    @Column(name = "COD_FUNCIONALIDADE")
    private String codFuncionalidade;
    @Size(max = 200)
    @Column(name = "DES_FUNCIONALIDADE")
    private String desFuncionalidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqFuncionalidade")
    private List<FuncionalidadeAcao> funcionalidadeAcaoList;

    public Funcionalidade() {
    }

    public Funcionalidade(BigDecimal seqFuncionalidade) {
        this.seqFuncionalidade = seqFuncionalidade;
    }

    public BigDecimal getSeqFuncionalidade() {
        return seqFuncionalidade;
    }

    public void setSeqFuncionalidade(BigDecimal seqFuncionalidade) {
        this.seqFuncionalidade = seqFuncionalidade;
    }

    public String getCodFuncionalidade() {
        return codFuncionalidade;
    }

    public void setCodFuncionalidade(String codFuncionalidade) {
        this.codFuncionalidade = codFuncionalidade;
    }

    public String getDesFuncionalidade() {
        return desFuncionalidade;
    }

    public void setDesFuncionalidade(String desFuncionalidade) {
        this.desFuncionalidade = desFuncionalidade;
    }

    @XmlTransient
    public List<FuncionalidadeAcao> getFuncionalidadeAcaoList() {
        return funcionalidadeAcaoList;
    }

    public void setFuncionalidadeAcaoList(List<FuncionalidadeAcao> funcionalidadeAcaoList) {
        this.funcionalidadeAcaoList = funcionalidadeAcaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqFuncionalidade != null ? seqFuncionalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionalidade)) {
            return false;
        }
        Funcionalidade other = (Funcionalidade) object;
        if ((this.seqFuncionalidade == null && other.seqFuncionalidade != null) || (this.seqFuncionalidade != null && !this.seqFuncionalidade.equals(other.seqFuncionalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Funcionalidade[ seqFuncionalidade=" + seqFuncionalidade + " ]";
    }
    
}
