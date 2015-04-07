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
@Table(name = "TBL_DISCIPLINA_ANO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaAno.findAll", query = "SELECT d FROM DisciplinaAno d"),
    @NamedQuery(name = "DisciplinaAno.findBySeqDisciplinaAno", query = "SELECT d FROM DisciplinaAno d WHERE d.seqDisciplinaAno = :seqDisciplinaAno")})
public class DisciplinaAno implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_DISCIPLINA_ANO")
    private BigDecimal seqDisciplinaAno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqDisciplinaAno")
    private List<DisciplinaProfessor> disciplinaProfessorList;
    @JoinColumn(name = "TBL_DISCIPLINA_SEQ_DISCIPLINA", referencedColumnName = "SEQ_DISCIPLINA")
    @ManyToOne(optional = false)
    private Disciplina tblDisciplinaSeqDisciplina;
    @JoinColumn(name = "TBL_ANO_SEQ_ANO", referencedColumnName = "SEQ_ANO")
    @ManyToOne(optional = false)
    private Ano tblAnoSeqAno;

    public DisciplinaAno() {
    }

    public DisciplinaAno(BigDecimal seqDisciplinaAno) {
        this.seqDisciplinaAno = seqDisciplinaAno;
    }

    public BigDecimal getSeqDisciplinaAno() {
        return seqDisciplinaAno;
    }

    public void setSeqDisciplinaAno(BigDecimal seqDisciplinaAno) {
        this.seqDisciplinaAno = seqDisciplinaAno;
    }

    @XmlTransient
    public List<DisciplinaProfessor> getDisciplinaProfessorList() {
        return disciplinaProfessorList;
    }

    public void setDisciplinaProfessorList(List<DisciplinaProfessor> disciplinaProfessorList) {
        this.disciplinaProfessorList = disciplinaProfessorList;
    }

    public Disciplina getTblDisciplinaSeqDisciplina() {
        return tblDisciplinaSeqDisciplina;
    }

    public void setTblDisciplinaSeqDisciplina(Disciplina tblDisciplinaSeqDisciplina) {
        this.tblDisciplinaSeqDisciplina = tblDisciplinaSeqDisciplina;
    }

    public Ano getTblAnoSeqAno() {
        return tblAnoSeqAno;
    }

    public void setTblAnoSeqAno(Ano tblAnoSeqAno) {
        this.tblAnoSeqAno = tblAnoSeqAno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqDisciplinaAno != null ? seqDisciplinaAno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaAno)) {
            return false;
        }
        DisciplinaAno other = (DisciplinaAno) object;
        if ((this.seqDisciplinaAno == null && other.seqDisciplinaAno != null) || (this.seqDisciplinaAno != null && !this.seqDisciplinaAno.equals(other.seqDisciplinaAno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.DisciplinaAno[ seqDisciplinaAno=" + seqDisciplinaAno + " ]";
    }
    
}
