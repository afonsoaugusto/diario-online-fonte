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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_ATIVIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findBySeqAtividade", query = "SELECT a FROM Atividade a WHERE a.seqAtividade = :seqAtividade"),
    @NamedQuery(name = "Atividade.findByNomAtividade", query = "SELECT a FROM Atividade a WHERE a.nomAtividade = :nomAtividade"),
    @NamedQuery(name = "Atividade.findByNumValor", query = "SELECT a FROM Atividade a WHERE a.numValor = :numValor"),
    @NamedQuery(name = "Atividade.findByDatAplicacao", query = "SELECT a FROM Atividade a WHERE a.datAplicacao = :datAplicacao")})
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ATIVIDADE")
    private BigDecimal seqAtividade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOM_ATIVIDADE")
    private String nomAtividade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "NUM_VALOR")
    private String numValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAT_APLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datAplicacao;
    @JoinColumn(name = "SEQ_PARAME_TIPO", referencedColumnName = "SEQ_PARAMETRIZACAO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Parametrizacao seqParameTipo;
    @JoinColumn(name = "SEQ_DISCIPLINA", referencedColumnName = "SEQ_DISCIPLINA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Disciplina seqDisciplina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAtividade",fetch = FetchType.LAZY)
    private List<Notas> notasList;

    public Atividade() {
    }

    public Atividade(BigDecimal seqAtividade) {
        this.seqAtividade = seqAtividade;
    }

    public Atividade(BigDecimal seqAtividade, String nomAtividade, String numValor, Date datAplicacao) {
        this.seqAtividade = seqAtividade;
        this.nomAtividade = nomAtividade;
        this.numValor = numValor;
        this.datAplicacao = datAplicacao;
    }

    public BigDecimal getSeqAtividade() {
        return seqAtividade;
    }

    public void setSeqAtividade(BigDecimal seqAtividade) {
        this.seqAtividade = seqAtividade;
    }

    public String getNomAtividade() {
        return nomAtividade;
    }

    public void setNomAtividade(String nomAtividade) {
        this.nomAtividade = nomAtividade;
    }

    public String getNumValor() {
        return numValor;
    }

    public void setNumValor(String numValor) {
        this.numValor = numValor;
    }

    public Date getDatAplicacao() {
        return datAplicacao;
    }

    public void setDatAplicacao(Date datAplicacao) {
        this.datAplicacao = datAplicacao;
    }

    public Parametrizacao getSeqParameTipo() {
        return seqParameTipo;
    }

    public void setSeqParameTipo(Parametrizacao seqParameTipo) {
        this.seqParameTipo = seqParameTipo;
    }

    public Disciplina getSeqDisciplina() {
        return seqDisciplina;
    }

    public void setSeqDisciplina(Disciplina seqDisciplina) {
        this.seqDisciplina = seqDisciplina;
    }

    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqAtividade != null ? seqAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.seqAtividade == null && other.seqAtividade != null) || (this.seqAtividade != null && !this.seqAtividade.equals(other.seqAtividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Atividade[ seqAtividade=" + seqAtividade + " ]";
    }
    
}
