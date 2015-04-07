/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_NOTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findBySeqNotas", query = "SELECT n FROM Notas n WHERE n.seqNotas = :seqNotas"),
    @NamedQuery(name = "Notas.findByNumValor", query = "SELECT n FROM Notas n WHERE n.numValor = :numValor"),
    @NamedQuery(name = "Notas.findByDatLancamento", query = "SELECT n FROM Notas n WHERE n.datLancamento = :datLancamento")})
public class Notas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_NOTAS")
    private BigDecimal seqNotas;
    @Column(name = "NUM_VALOR")
    private Short numValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAT_LANCAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datLancamento;
    @JoinColumn(name = "SEQ_PESSOA", referencedColumnName = "SEQ_PESSOA")
    @ManyToOne(optional = false)
    private Pessoa seqPessoa;
    @JoinColumn(name = "SEQ_PARAME_PERIODO", referencedColumnName = "SEQ_PARAMETRIZACAO")
    @ManyToOne(optional = false)
    private Parametrizacao seqParamePeriodo;
    @JoinColumn(name = "SEQ_ATIVIDADE", referencedColumnName = "SEQ_ATIVIDADE")
    @ManyToOne(optional = false)
    private Atividade seqAtividade;
    @JoinColumn(name = "SEQ_ANO", referencedColumnName = "SEQ_ANO")
    @ManyToOne(optional = false)
    private Ano seqAno;
    @JoinColumn(name = "SEQ_ALUNO", referencedColumnName = "SEQ_ALUNO")
    @ManyToOne(optional = false)
    private Aluno seqAluno;

    public Notas() {
    }

    public Notas(BigDecimal seqNotas) {
        this.seqNotas = seqNotas;
    }

    public Notas(BigDecimal seqNotas, Date datLancamento) {
        this.seqNotas = seqNotas;
        this.datLancamento = datLancamento;
    }

    public BigDecimal getSeqNotas() {
        return seqNotas;
    }

    public void setSeqNotas(BigDecimal seqNotas) {
        this.seqNotas = seqNotas;
    }

    public Short getNumValor() {
        return numValor;
    }

    public void setNumValor(Short numValor) {
        this.numValor = numValor;
    }

    public Date getDatLancamento() {
        return datLancamento;
    }

    public void setDatLancamento(Date datLancamento) {
        this.datLancamento = datLancamento;
    }

    public Pessoa getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(Pessoa seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public Parametrizacao getSeqParamePeriodo() {
        return seqParamePeriodo;
    }

    public void setSeqParamePeriodo(Parametrizacao seqParamePeriodo) {
        this.seqParamePeriodo = seqParamePeriodo;
    }

    public Atividade getSeqAtividade() {
        return seqAtividade;
    }

    public void setSeqAtividade(Atividade seqAtividade) {
        this.seqAtividade = seqAtividade;
    }

    public Ano getSeqAno() {
        return seqAno;
    }

    public void setSeqAno(Ano seqAno) {
        this.seqAno = seqAno;
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
        hash += (seqNotas != null ? seqNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.seqNotas == null && other.seqNotas != null) || (this.seqNotas != null && !this.seqNotas.equals(other.seqNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Notas[ seqNotas=" + seqNotas + " ]";
    }
    
}
