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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "TBL_FECHAMENTO_ALUNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FechamentoAluno.findAll", query = "SELECT f FROM FechamentoAluno f"),
    @NamedQuery(name = "FechamentoAluno.findBySeqFechamentoAluno", query = "SELECT f FROM FechamentoAluno f WHERE f.seqFechamentoAluno = :seqFechamentoAluno"),
    @NamedQuery(name = "FechamentoAluno.findByDatLancamento", query = "SELECT f FROM FechamentoAluno f WHERE f.datLancamento = :datLancamento"),
    @NamedQuery(name = "FechamentoAluno.findByFlgFechamentoAtual", query = "SELECT f FROM FechamentoAluno f WHERE f.flgFechamentoAtual = :flgFechamentoAtual"),
    @NamedQuery(name = "FechamentoAluno.findByNumNota", query = "SELECT f FROM FechamentoAluno f WHERE f.numNota = :numNota"),
    @NamedQuery(name = "FechamentoAluno.findByNumQtdPresenca", query = "SELECT f FROM FechamentoAluno f WHERE f.numQtdPresenca = :numQtdPresenca")})
public class FechamentoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_FECHAMENTO_ALUNO")
    private BigDecimal seqFechamentoAluno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAT_LANCAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datLancamento;
    @Column(name = "FLG_FECHAMENTO_ATUAL")
    private Character flgFechamentoAtual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_NOTA")
    private short numNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_QTD_PRESENCA")
    private short numQtdPresenca;
    @JoinColumn(name = "SEQ_SITUACAO", referencedColumnName = "SEQ_SITUACAO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Situacao seqSituacao;
    @JoinColumn(name = "SEQ_FECHAMENTO", referencedColumnName = "SEQ_FECHAMENTO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Fechamento seqFechamento;
    @JoinColumn(name = "SEQ_ANO", referencedColumnName = "SEQ_ANO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Ano seqAno;
    @JoinColumn(name = "SEQ_ALUNO", referencedColumnName = "SEQ_ALUNO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Aluno seqAluno;

    public FechamentoAluno() {
    }

    public FechamentoAluno(BigDecimal seqFechamentoAluno) {
        this.seqFechamentoAluno = seqFechamentoAluno;
    }

    public FechamentoAluno(BigDecimal seqFechamentoAluno, Date datLancamento, short numNota, short numQtdPresenca) {
        this.seqFechamentoAluno = seqFechamentoAluno;
        this.datLancamento = datLancamento;
        this.numNota = numNota;
        this.numQtdPresenca = numQtdPresenca;
    }

    public BigDecimal getSeqFechamentoAluno() {
        return seqFechamentoAluno;
    }

    public void setSeqFechamentoAluno(BigDecimal seqFechamentoAluno) {
        this.seqFechamentoAluno = seqFechamentoAluno;
    }

    public Date getDatLancamento() {
        return datLancamento;
    }

    public void setDatLancamento(Date datLancamento) {
        this.datLancamento = datLancamento;
    }

    public Character getFlgFechamentoAtual() {
        return flgFechamentoAtual;
    }

    public void setFlgFechamentoAtual(Character flgFechamentoAtual) {
        this.flgFechamentoAtual = flgFechamentoAtual;
    }

    public short getNumNota() {
        return numNota;
    }

    public void setNumNota(short numNota) {
        this.numNota = numNota;
    }

    public short getNumQtdPresenca() {
        return numQtdPresenca;
    }

    public void setNumQtdPresenca(short numQtdPresenca) {
        this.numQtdPresenca = numQtdPresenca;
    }

    public Situacao getSeqSituacao() {
        return seqSituacao;
    }

    public void setSeqSituacao(Situacao seqSituacao) {
        this.seqSituacao = seqSituacao;
    }

    public Fechamento getSeqFechamento() {
        return seqFechamento;
    }

    public void setSeqFechamento(Fechamento seqFechamento) {
        this.seqFechamento = seqFechamento;
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
        hash += (seqFechamentoAluno != null ? seqFechamentoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechamentoAluno)) {
            return false;
        }
        FechamentoAluno other = (FechamentoAluno) object;
        if ((this.seqFechamentoAluno == null && other.seqFechamentoAluno != null) || (this.seqFechamentoAluno != null && !this.seqFechamentoAluno.equals(other.seqFechamentoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.FechamentoAluno[ seqFechamentoAluno=" + seqFechamentoAluno + " ]";
    }
    
}
