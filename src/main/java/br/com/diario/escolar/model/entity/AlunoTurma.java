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
@Table(name = "TBL_ALUNO_TURMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoTurma.findAll", query = "SELECT a FROM AlunoTurma a"),
    @NamedQuery(name = "AlunoTurma.findBySeqAlunoTurma", query = "SELECT a FROM AlunoTurma a WHERE a.seqAlunoTurma = :seqAlunoTurma"),
    @NamedQuery(name = "AlunoTurma.findByFlgTurmaAtual", query = "SELECT a FROM AlunoTurma a WHERE a.flgTurmaAtual = :flgTurmaAtual")})
public class AlunoTurma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ALUNO_TURMA")
    private BigDecimal seqAlunoTurma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLG_TURMA_ATUAL")
    private Character flgTurmaAtual;
    @JoinColumn(name = "SEQ_TURMA", referencedColumnName = "SEQ_TURMA")
    @ManyToOne(optional = false)
    private Turma seqTurma;
    @JoinColumn(name = "SEQ_SITUACAO", referencedColumnName = "SEQ_SITUACAO")
    @ManyToOne(optional = false)
    private Situacao seqSituacao;
    @JoinColumn(name = "SEQ_ALUNO", referencedColumnName = "SEQ_ALUNO")
    @ManyToOne(optional = false)
    private Aluno seqAluno;

    public AlunoTurma() {
    }

    public AlunoTurma(BigDecimal seqAlunoTurma) {
        this.seqAlunoTurma = seqAlunoTurma;
    }

    public AlunoTurma(BigDecimal seqAlunoTurma, Character flgTurmaAtual) {
        this.seqAlunoTurma = seqAlunoTurma;
        this.flgTurmaAtual = flgTurmaAtual;
    }

    public BigDecimal getSeqAlunoTurma() {
        return seqAlunoTurma;
    }

    public void setSeqAlunoTurma(BigDecimal seqAlunoTurma) {
        this.seqAlunoTurma = seqAlunoTurma;
    }

    public Character getFlgTurmaAtual() {
        return flgTurmaAtual;
    }

    public void setFlgTurmaAtual(Character flgTurmaAtual) {
        this.flgTurmaAtual = flgTurmaAtual;
    }

    public Turma getSeqTurma() {
        return seqTurma;
    }

    public void setSeqTurma(Turma seqTurma) {
        this.seqTurma = seqTurma;
    }

    public Situacao getSeqSituacao() {
        return seqSituacao;
    }

    public void setSeqSituacao(Situacao seqSituacao) {
        this.seqSituacao = seqSituacao;
    }

    public Aluno getSeqAluno() {
        return seqAluno;
    }

    public void setSeqAluno(Aluno seqAluno) {
        this.seqAluno = seqAluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqAlunoTurma != null ? seqAlunoTurma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTurma)) {
            return false;
        }
        AlunoTurma other = (AlunoTurma) object;
        if ((this.seqAlunoTurma == null && other.seqAlunoTurma != null) || (this.seqAlunoTurma != null && !this.seqAlunoTurma.equals(other.seqAlunoTurma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.AlunoTurma[ seqAlunoTurma=" + seqAlunoTurma + " ]";
    }
    
}
