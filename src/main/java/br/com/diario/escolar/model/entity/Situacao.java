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
@Table(name = "TBL_SITUACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s"),
    @NamedQuery(name = "Situacao.findBySeqSituacao", query = "SELECT s FROM Situacao s WHERE s.seqSituacao = :seqSituacao"),
    @NamedQuery(name = "Situacao.findByDesSituacao", query = "SELECT s FROM Situacao s WHERE s.desSituacao = :desSituacao")})
public class Situacao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_SITUACAO")
    private BigDecimal seqSituacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DES_SITUACAO")
    private String desSituacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqSituacao")
    private List<AlunoTurma> alunoTurmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqSituacao")
    private List<FechamentoAluno> fechamentoAlunoList;

    public Situacao() {
    }

    public Situacao(BigDecimal seqSituacao) {
        this.seqSituacao = seqSituacao;
    }

    public Situacao(BigDecimal seqSituacao, String desSituacao) {
        this.seqSituacao = seqSituacao;
        this.desSituacao = desSituacao;
    }

    public BigDecimal getSeqSituacao() {
        return seqSituacao;
    }

    public void setSeqSituacao(BigDecimal seqSituacao) {
        this.seqSituacao = seqSituacao;
    }

    public String getDesSituacao() {
        return desSituacao;
    }

    public void setDesSituacao(String desSituacao) {
        this.desSituacao = desSituacao;
    }

    @XmlTransient
    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
    }

    @XmlTransient
    public List<FechamentoAluno> getFechamentoAlunoList() {
        return fechamentoAlunoList;
    }

    public void setFechamentoAlunoList(List<FechamentoAluno> fechamentoAlunoList) {
        this.fechamentoAlunoList = fechamentoAlunoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqSituacao != null ? seqSituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.seqSituacao == null && other.seqSituacao != null) || (this.seqSituacao != null && !this.seqSituacao.equals(other.seqSituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Situacao[ seqSituacao=" + seqSituacao + " ]";
    }
    
}
