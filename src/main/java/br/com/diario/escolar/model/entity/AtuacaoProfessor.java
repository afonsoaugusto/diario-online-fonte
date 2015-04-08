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
@Table(name = "TBL_ATUACAO_PROFESSOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtuacaoProfessor.findAll", query = "SELECT a FROM AtuacaoProfessor a"),
    @NamedQuery(name = "AtuacaoProfessor.findBySeqAtuacaoProfessor", query = "SELECT a FROM AtuacaoProfessor a WHERE a.seqAtuacaoProfessor = :seqAtuacaoProfessor")})
public class AtuacaoProfessor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ATUACAO_PROFESSOR")
    private BigDecimal seqAtuacaoProfessor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAtuacaoProfessor",fetch = FetchType.LAZY)
    private List<PlanoEnsino> planoEnsinoList;
    @JoinColumn(name = "SEQ_DISCIPLINA_PROFESSOR", referencedColumnName = "SEQ_DISCIPLINA_PROFESSOR")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private DisciplinaProfessor seqDisciplinaProfessor;
    @JoinColumn(name = "SEQ_DISCIPLINA", referencedColumnName = "SEQ_DISCIPLINA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Disciplina seqDisciplina;

    public AtuacaoProfessor() {
    }

    public AtuacaoProfessor(BigDecimal seqAtuacaoProfessor) {
        this.seqAtuacaoProfessor = seqAtuacaoProfessor;
    }

    public BigDecimal getSeqAtuacaoProfessor() {
        return seqAtuacaoProfessor;
    }

    public void setSeqAtuacaoProfessor(BigDecimal seqAtuacaoProfessor) {
        this.seqAtuacaoProfessor = seqAtuacaoProfessor;
    }

    @XmlTransient
    public List<PlanoEnsino> getPlanoEnsinoList() {
        return planoEnsinoList;
    }

    public void setPlanoEnsinoList(List<PlanoEnsino> planoEnsinoList) {
        this.planoEnsinoList = planoEnsinoList;
    }

    public DisciplinaProfessor getSeqDisciplinaProfessor() {
        return seqDisciplinaProfessor;
    }

    public void setSeqDisciplinaProfessor(DisciplinaProfessor seqDisciplinaProfessor) {
        this.seqDisciplinaProfessor = seqDisciplinaProfessor;
    }

    public Disciplina getSeqDisciplina() {
        return seqDisciplina;
    }

    public void setSeqDisciplina(Disciplina seqDisciplina) {
        this.seqDisciplina = seqDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqAtuacaoProfessor != null ? seqAtuacaoProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtuacaoProfessor)) {
            return false;
        }
        AtuacaoProfessor other = (AtuacaoProfessor) object;
        if ((this.seqAtuacaoProfessor == null && other.seqAtuacaoProfessor != null) || (this.seqAtuacaoProfessor != null && !this.seqAtuacaoProfessor.equals(other.seqAtuacaoProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.AtuacaoProfessor[ seqAtuacaoProfessor=" + seqAtuacaoProfessor + " ]";
    }
    
}
