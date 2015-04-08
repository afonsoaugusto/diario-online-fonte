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
@Table(name = "TBL_ACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acao.findAll", query = "SELECT a FROM Acao a"),
    @NamedQuery(name = "Acao.findBySeqAcao", query = "SELECT a FROM Acao a WHERE a.seqAcao = :seqAcao"),
    @NamedQuery(name = "Acao.findByCodAcao", query = "SELECT a FROM Acao a WHERE a.codAcao = :codAcao"),
    @NamedQuery(name = "Acao.findByDesAcao", query = "SELECT a FROM Acao a WHERE a.desAcao = :desAcao")})
public class Acao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ACAO")
    private BigDecimal seqAcao;
    @Size(max = 25)
    @Column(name = "COD_ACAO")
    private String codAcao;
    @Size(max = 200)
    @Column(name = "DES_ACAO")
    private String desAcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAcao",fetch = FetchType.LAZY)
    private List<FuncionalidadeAcao> funcionalidadeAcaoList;

    public Acao() {
    }

    public Acao(BigDecimal seqAcao) {
        this.seqAcao = seqAcao;
    }

    public BigDecimal getSeqAcao() {
        return seqAcao;
    }

    public void setSeqAcao(BigDecimal seqAcao) {
        this.seqAcao = seqAcao;
    }

    public String getCodAcao() {
        return codAcao;
    }

    public void setCodAcao(String codAcao) {
        this.codAcao = codAcao;
    }

    public String getDesAcao() {
        return desAcao;
    }

    public void setDesAcao(String desAcao) {
        this.desAcao = desAcao;
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
        hash += (seqAcao != null ? seqAcao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acao)) {
            return false;
        }
        Acao other = (Acao) object;
        if ((this.seqAcao == null && other.seqAcao != null) || (this.seqAcao != null && !this.seqAcao.equals(other.seqAcao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Acao[ seqAcao=" + seqAcao + " ]";
    }
    
}
