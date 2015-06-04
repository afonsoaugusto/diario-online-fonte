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
@Table(name = "TBL_DISCIPLINA_PROFESSOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaProfessor.findAll", query = "SELECT d FROM DisciplinaProfessor d"),
    @NamedQuery(name = "DisciplinaProfessor.findBySeqDisciplinaProfessor", query = "SELECT d FROM DisciplinaProfessor d WHERE d.seqDisciplinaProfessor = :seqDisciplinaProfessor")})
public class DisciplinaProfessor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_DISCIPLINA_PROFESSOR")
    private BigDecimal seqDisciplinaProfessor;
    @JoinColumn(name = "SEQ_PESSOA", referencedColumnName = "SEQ_PESSOA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Pessoa seqPessoa;
    @JoinColumn(name = "SEQ_DISCIPLINA_ANO", referencedColumnName = "SEQ_DISCIPLINA_ANO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private DisciplinaAno seqDisciplinaAno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqDisciplinaProfessor",fetch = FetchType.LAZY)    
    private List<PlanoEnsino> planoEnsinoList;

    public DisciplinaProfessor() {
    }

    public DisciplinaProfessor(BigDecimal seqDisciplinaProfessor) {
        this.seqDisciplinaProfessor = seqDisciplinaProfessor;
    }

    public BigDecimal getSeqDisciplinaProfessor() {
        return seqDisciplinaProfessor;
    }

    public void setSeqDisciplinaProfessor(BigDecimal seqDisciplinaProfessor) {
        this.seqDisciplinaProfessor = seqDisciplinaProfessor;
    }

    public Pessoa getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(Pessoa seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public DisciplinaAno getSeqDisciplinaAno() {
        return seqDisciplinaAno;
    }

    public void setSeqDisciplinaAno(DisciplinaAno seqDisciplinaAno) {
        this.seqDisciplinaAno = seqDisciplinaAno;
    }

    @XmlTransient
    public List<PlanoEnsino> getPlanoEnsinoList() {
        return planoEnsinoList;
    }

    public void setPlanoEnsinoList(List<PlanoEnsino> planoEnsinoList) {
        this.planoEnsinoList = planoEnsinoList;
    }
    
    public String getDisciplinaProfessorFormatado(){
        return this.seqPessoa.getDesNome() + " - " + this.seqDisciplinaAno.getDisciplinaAnoFormatado();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqDisciplinaProfessor != null ? seqDisciplinaProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaProfessor)) {
            return false;
        }
        DisciplinaProfessor other = (DisciplinaProfessor) object;
        if ((this.seqDisciplinaProfessor == null && other.seqDisciplinaProfessor != null) || (this.seqDisciplinaProfessor != null && !this.seqDisciplinaProfessor.equals(other.seqDisciplinaProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.DisciplinaProfessor[ seqDisciplinaProfessor=" + seqDisciplinaProfessor + " ]";
    }
    
}
