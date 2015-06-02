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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_TURMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findBySeqTurma", query = "SELECT t FROM Turma t WHERE t.seqTurma = :seqTurma"),
    @NamedQuery(name = "Turma.findByNumTumra", query = "SELECT t FROM Turma t WHERE t.numTumra = :numTumra"),
    @NamedQuery(name = "Turma.findByFlgTurmaFechada", query = "SELECT t FROM Turma t WHERE t.flgTurmaFechada = :flgTurmaFechada")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_TURMA")
    private BigDecimal seqTurma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NUM_TUMRA")
    private String numTumra;
    @Column(name = "FLG_TURMA_FECHADA")
    private Character flgTurmaFechada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqTurma",fetch = FetchType.LAZY)
    private List<Fechamento> fechamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqTurma",fetch = FetchType.LAZY)
    private List<AlunoTurma> alunoTurmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqTurma",fetch = FetchType.LAZY)
    private List<PlanoEnsino> planoEnsinoList;
    @JoinColumn(name = "SEQ_TURNO", referencedColumnName = "SEQ_TURNO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Turno seqTurno;
    @JoinColumn(name = "SEQ_PESSOA", referencedColumnName = "SEQ_PESSOA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Pessoa seqPessoa;
    @JoinColumn(name = "SEQ_ESCOLA", referencedColumnName = "SEQ_ESCOLA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Escola seqEscola;
    @JoinColumn(name = "SEQ_ANO", referencedColumnName = "SEQ_ANO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Ano seqAno;

    public Turma() {
        initTurma();
    }

    public Turma(BigDecimal seqTurma) {
        this.seqTurma = seqTurma;
        initTurma();
    }

    public Turma(BigDecimal seqTurma, String numTumra) {
        this.seqTurma = seqTurma;
        this.numTumra = numTumra;
        initTurma();
    }

    public BigDecimal getSeqTurma() {
        return seqTurma;
    }

    public void setSeqTurma(BigDecimal seqTurma) {
        this.seqTurma = seqTurma;
    }

    public String getNumTumra() {
        return numTumra;
    }

    public void setNumTumra(String numTumra) {
        this.numTumra = numTumra;
    }

    public Character getFlgTurmaFechada() {
        return flgTurmaFechada;
    }

    public void setFlgTurmaFechada(Character flgTurmaFechada) {
        this.flgTurmaFechada = flgTurmaFechada;
    }

    @XmlTransient
    public List<Fechamento> getFechamentoList() {
        return fechamentoList;
    }

    public void setFechamentoList(List<Fechamento> fechamentoList) {
        this.fechamentoList = fechamentoList;
    }

    @XmlTransient
    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
    }

    @XmlTransient
    public List<PlanoEnsino> getPlanoEnsinoList() {
        return planoEnsinoList;
    }

    public void setPlanoEnsinoList(List<PlanoEnsino> planoEnsinoList) {
        this.planoEnsinoList = planoEnsinoList;
    }

    public Turno getSeqTurno() {
        return seqTurno;
    }

    public void setSeqTurno(Turno seqTurno) {
        this.seqTurno = seqTurno;
    }

    public Pessoa getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(Pessoa seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public Escola getSeqEscola() {
        return seqEscola;
    }

    public void setSeqEscola(Escola seqEscola) {
        this.seqEscola = seqEscola;
    }

    public Ano getSeqAno() {
        return seqAno;
    }

    public void setSeqAno(Ano seqAno) {
        this.seqAno = seqAno;
    }
    
      private void initTurma() {
        this.flgTurmaFechada = 'N';
    }
      
    public String getTurmaFormatada(){
        return this.numTumra + " - "+ this.seqAno.getNivelFormatado();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqTurma != null ? seqTurma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.seqTurma == null && other.seqTurma != null) || (this.seqTurma != null && !this.seqTurma.equals(other.seqTurma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Turma[ seqTurma=" + seqTurma + " ]";
    }
    
}
