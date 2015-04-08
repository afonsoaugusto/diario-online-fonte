/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_FECHAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fechamento.findAll", query = "SELECT f FROM Fechamento f"),
    @NamedQuery(name = "Fechamento.findBySeqFechamento", query = "SELECT f FROM Fechamento f WHERE f.seqFechamento = :seqFechamento"),
    @NamedQuery(name = "Fechamento.findByNumQtdAulasPrevistas", query = "SELECT f FROM Fechamento f WHERE f.numQtdAulasPrevistas = :numQtdAulasPrevistas"),
    @NamedQuery(name = "Fechamento.findByNumQtdAulasDadas", query = "SELECT f FROM Fechamento f WHERE f.numQtdAulasDadas = :numQtdAulasDadas"),
    @NamedQuery(name = "Fechamento.findByNumQtdAlunosCMedia", query = "SELECT f FROM Fechamento f WHERE f.numQtdAlunosCMedia = :numQtdAlunosCMedia"),
    @NamedQuery(name = "Fechamento.findByNumQtdAlunoSMedia", query = "SELECT f FROM Fechamento f WHERE f.numQtdAlunoSMedia = :numQtdAlunoSMedia"),
    @NamedQuery(name = "Fechamento.findByDatFechamento", query = "SELECT f FROM Fechamento f WHERE f.datFechamento = :datFechamento")})
public class Fechamento implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_FECHAMENTO")
    private BigDecimal seqFechamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QTD_AULAS_PREVISTAS")
    private short numQtdAulasPrevistas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QTD_AULAS_DADAS")
    private short numQtdAulasDadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QTD_ALUNOS_C_MEDIA")
    private short numQtdAlunosCMedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QTD_ALUNO_S_MEDIA")
    private short numQtdAlunoSMedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAT_FECHAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datFechamento;
    @JoinColumn(name = "SEQ_TURMA", referencedColumnName = "SEQ_TURMA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Turma seqTurma;
    @JoinColumn(name = "SEQ_PESSOA", referencedColumnName = "SEQ_PESSOA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Pessoa seqPessoa;
    @JoinColumn(name = "SEQ_PESSOA_FECHAMENTO", referencedColumnName = "SEQ_PESSOA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Pessoa seqPessoaFechamento;
    @JoinColumn(name = "SEQ_ESCOLA", referencedColumnName = "SEQ_ESCOLA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Escola seqEscola;
    @JoinColumn(name = "SEQ_DISCIPLINA", referencedColumnName = "SEQ_DISCIPLINA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Disciplina seqDisciplina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqFechamento",fetch = FetchType.LAZY)
    private List<FechamentoAluno> fechamentoAlunoList;

    public Fechamento() {
    }

    public Fechamento(BigDecimal seqFechamento) {
        this.seqFechamento = seqFechamento;
    }

    public Fechamento(BigDecimal seqFechamento, short numQtdAulasPrevistas, short numQtdAulasDadas, short numQtdAlunosCMedia, short numQtdAlunoSMedia, Date datFechamento) {
        this.seqFechamento = seqFechamento;
        this.numQtdAulasPrevistas = numQtdAulasPrevistas;
        this.numQtdAulasDadas = numQtdAulasDadas;
        this.numQtdAlunosCMedia = numQtdAlunosCMedia;
        this.numQtdAlunoSMedia = numQtdAlunoSMedia;
        this.datFechamento = datFechamento;
    }

    public BigDecimal getSeqFechamento() {
        return seqFechamento;
    }

    public void setSeqFechamento(BigDecimal seqFechamento) {
        this.seqFechamento = seqFechamento;
    }

    public short getNumQtdAulasPrevistas() {
        return numQtdAulasPrevistas;
    }

    public void setNumQtdAulasPrevistas(short numQtdAulasPrevistas) {
        this.numQtdAulasPrevistas = numQtdAulasPrevistas;
    }

    public short getNumQtdAulasDadas() {
        return numQtdAulasDadas;
    }

    public void setNumQtdAulasDadas(short numQtdAulasDadas) {
        this.numQtdAulasDadas = numQtdAulasDadas;
    }

    public short getNumQtdAlunosCMedia() {
        return numQtdAlunosCMedia;
    }

    public void setNumQtdAlunosCMedia(short numQtdAlunosCMedia) {
        this.numQtdAlunosCMedia = numQtdAlunosCMedia;
    }

    public short getNumQtdAlunoSMedia() {
        return numQtdAlunoSMedia;
    }

    public void setNumQtdAlunoSMedia(short numQtdAlunoSMedia) {
        this.numQtdAlunoSMedia = numQtdAlunoSMedia;
    }

    public Date getDatFechamento() {
        return datFechamento;
    }

    public void setDatFechamento(Date datFechamento) {
        this.datFechamento = datFechamento;
    }

    public Turma getSeqTurma() {
        return seqTurma;
    }

    public void setSeqTurma(Turma seqTurma) {
        this.seqTurma = seqTurma;
    }

    public Pessoa getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(Pessoa seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public Pessoa getSeqPessoaFechamento() {
        return seqPessoaFechamento;
    }

    public void setSeqPessoaFechamento(Pessoa seqPessoaFechamento) {
        this.seqPessoaFechamento = seqPessoaFechamento;
    }

    public Escola getSeqEscola() {
        return seqEscola;
    }

    public void setSeqEscola(Escola seqEscola) {
        this.seqEscola = seqEscola;
    }

    public Disciplina getSeqDisciplina() {
        return seqDisciplina;
    }

    public void setSeqDisciplina(Disciplina seqDisciplina) {
        this.seqDisciplina = seqDisciplina;
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
        hash += (seqFechamento != null ? seqFechamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechamento)) {
            return false;
        }
        Fechamento other = (Fechamento) object;
        if ((this.seqFechamento == null && other.seqFechamento != null) || (this.seqFechamento != null && !this.seqFechamento.equals(other.seqFechamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Fechamento[ seqFechamento=" + seqFechamento + " ]";
    }
    
}
