/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AFONSO
 */
@Entity
@Table(name = "TBL_PARAMETRIZACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrizacao.findAll", query = "SELECT p FROM Parametrizacao p"),
    @NamedQuery(name = "Parametrizacao.findBySeqParametrizacao", query = "SELECT p FROM Parametrizacao p WHERE p.seqParametrizacao = :seqParametrizacao"),
    @NamedQuery(name = "Parametrizacao.findByDesValorParametro", query = "SELECT p FROM Parametrizacao p WHERE p.desValorParametro = :desValorParametro"),
    @NamedQuery(name = "Parametrizacao.findByNumValorParametro", query = "SELECT p FROM Parametrizacao p WHERE p.numValorParametro = :numValorParametro"),
    @NamedQuery(name = "Parametrizacao.findByCodParametro", query = "SELECT p FROM Parametrizacao p WHERE p.codParametro = :codParametro")})
public class Parametrizacao implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PARAMETRIZACAO")
    private BigDecimal seqParametrizacao;
    @Size(max = 200)
    @Column(name = "DES_VALOR_PARAMETRO")
    private String desValorParametro;
    @Column(name = "NUM_VALOR_PARAMETRO")
    private BigInteger numValorParametro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "COD_PARAMETRO")
    private String codParametro;
    @OneToMany(mappedBy = "seqParametrizacaoPai")
    private List<Parametrizacao> parametrizacaoList;
    @JoinColumn(name = "SEQ_PARAMETRIZACAO_PAI", referencedColumnName = "SEQ_PARAMETRIZACAO")
    @ManyToOne
    private Parametrizacao seqParametrizacaoPai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqParameTipo")
    private List<Atividade> atividadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqParameNivelEscolar")
    private List<Ano> anoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqParamePeriodo")
    private List<Notas> notasList;

    public Parametrizacao() {
    }

    public Parametrizacao(BigDecimal seqParametrizacao) {
        this.seqParametrizacao = seqParametrizacao;
    }

    public Parametrizacao(BigDecimal seqParametrizacao, String codParametro) {
        this.seqParametrizacao = seqParametrizacao;
        this.codParametro = codParametro;
    }

    public BigDecimal getSeqParametrizacao() {
        return seqParametrizacao;
    }

    public void setSeqParametrizacao(BigDecimal seqParametrizacao) {
        this.seqParametrizacao = seqParametrizacao;
    }

    public String getDesValorParametro() {
        return desValorParametro;
    }

    public void setDesValorParametro(String desValorParametro) {
        this.desValorParametro = desValorParametro;
    }

    public BigInteger getNumValorParametro() {
        return numValorParametro;
    }

    public void setNumValorParametro(BigInteger numValorParametro) {
        this.numValorParametro = numValorParametro;
    }

    public String getCodParametro() {
        return codParametro;
    }

    public void setCodParametro(String codParametro) {
        this.codParametro = codParametro;
    }

    @XmlTransient
    public List<Parametrizacao> getParametrizacaoList() {
        return parametrizacaoList;
    }

    public void setParametrizacaoList(List<Parametrizacao> parametrizacaoList) {
        this.parametrizacaoList = parametrizacaoList;
    }

    public Parametrizacao getSeqParametrizacaoPai() {
        return seqParametrizacaoPai;
    }

    public void setSeqParametrizacaoPai(Parametrizacao seqParametrizacaoPai) {
        this.seqParametrizacaoPai = seqParametrizacaoPai;
    }

    @XmlTransient
    public List<Atividade> getAtividadeList() {
        return atividadeList;
    }

    public void setAtividadeList(List<Atividade> atividadeList) {
        this.atividadeList = atividadeList;
    }

    @XmlTransient
    public List<Ano> getAnoList() {
        return anoList;
    }

    public void setAnoList(List<Ano> anoList) {
        this.anoList = anoList;
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
        hash += (seqParametrizacao != null ? seqParametrizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametrizacao)) {
            return false;
        }
        Parametrizacao other = (Parametrizacao) object;
        if ((this.seqParametrizacao == null && other.seqParametrizacao != null) || (this.seqParametrizacao != null && !this.seqParametrizacao.equals(other.seqParametrizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Parametrizacao[ seqParametrizacao=" + seqParametrizacao + " ]";
    }
    
}
