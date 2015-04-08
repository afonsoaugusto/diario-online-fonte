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
@Table(name = "TBL_ESCOLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escola.findAll", query = "SELECT e FROM Escola e"),
    @NamedQuery(name = "Escola.findBySeqEscola", query = "SELECT e FROM Escola e WHERE e.seqEscola = :seqEscola"),
    @NamedQuery(name = "Escola.findByDesNome", query = "SELECT e FROM Escola e WHERE e.desNome = :desNome"),
    @NamedQuery(name = "Escola.findByNumTel", query = "SELECT e FROM Escola e WHERE e.numTel = :numTel"),
    @NamedQuery(name = "Escola.findByDesSigla", query = "SELECT e FROM Escola e WHERE e.desSigla = :desSigla"),
    @NamedQuery(name = "Escola.findByDesRua", query = "SELECT e FROM Escola e WHERE e.desRua = :desRua"),
    @NamedQuery(name = "Escola.findByDesBairro", query = "SELECT e FROM Escola e WHERE e.desBairro = :desBairro"),
    @NamedQuery(name = "Escola.findByNumCep", query = "SELECT e FROM Escola e WHERE e.numCep = :numCep"),
    @NamedQuery(name = "Escola.findByNumEscola", query = "SELECT e FROM Escola e WHERE e.numEscola = :numEscola"),
    @NamedQuery(name = "Escola.findByNumCnpj", query = "SELECT e FROM Escola e WHERE e.numCnpj = :numCnpj")})
public class Escola implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ESCOLA")
    private BigDecimal seqEscola;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DES_NOME")
    private String desNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_TEL")
    private long numTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DES_SIGLA")
    private String desSigla;
    @Size(max = 255)
    @Column(name = "DES_RUA")
    private String desRua;
    @Size(max = 80)
    @Column(name = "DES_BAIRRO")
    private String desBairro;
    @Column(name = "NUM_CEP")
    private Integer numCep;
    @Column(name = "NUM_ESCOLA")
    private Short numEscola;
    @Column(name = "NUM_CNPJ")
    private Long numCnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqEscola",fetch = FetchType.LAZY)
    private List<Fechamento> fechamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqEscola",fetch = FetchType.LAZY)
    private List<Turma> turmaList;
    @JoinColumn(name = "SEQ_CIDADE", referencedColumnName = "COD_MUNICIPIO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Municipio seqCidade;

    public Escola() {
    }

    public Escola(BigDecimal seqEscola) {
        this.seqEscola = seqEscola;
    }

    public Escola(BigDecimal seqEscola, String desNome, long numTel, String desSigla) {
        this.seqEscola = seqEscola;
        this.desNome = desNome;
        this.numTel = numTel;
        this.desSigla = desSigla;
    }

    public BigDecimal getSeqEscola() {
        return seqEscola;
    }

    public void setSeqEscola(BigDecimal seqEscola) {
        this.seqEscola = seqEscola;
    }

    public String getDesNome() {
        return desNome;
    }

    public void setDesNome(String desNome) {
        this.desNome = desNome;
    }

    public long getNumTel() {
        return numTel;
    }

    public void setNumTel(long numTel) {
        this.numTel = numTel;
    }

    public String getDesSigla() {
        return desSigla;
    }

    public void setDesSigla(String desSigla) {
        this.desSigla = desSigla;
    }

    public String getDesRua() {
        return desRua;
    }

    public void setDesRua(String desRua) {
        this.desRua = desRua;
    }

    public String getDesBairro() {
        return desBairro;
    }

    public void setDesBairro(String desBairro) {
        this.desBairro = desBairro;
    }

    public Integer getNumCep() {
        return numCep;
    }

    public void setNumCep(Integer numCep) {
        this.numCep = numCep;
    }

    public Short getNumEscola() {
        return numEscola;
    }

    public void setNumEscola(Short numEscola) {
        this.numEscola = numEscola;
    }

    public Long getNumCnpj() {
        return numCnpj;
    }

    public void setNumCnpj(Long numCnpj) {
        this.numCnpj = numCnpj;
    }

    @XmlTransient
    public List<Fechamento> getFechamentoList() {
        return fechamentoList;
    }

    public void setFechamentoList(List<Fechamento> fechamentoList) {
        this.fechamentoList = fechamentoList;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    public Municipio getSeqCidade() {
        return seqCidade;
    }

    public void setSeqCidade(Municipio seqCidade) {
        this.seqCidade = seqCidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqEscola != null ? seqEscola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escola)) {
            return false;
        }
        Escola other = (Escola) object;
        if ((this.seqEscola == null && other.seqEscola != null) || (this.seqEscola != null && !this.seqEscola.equals(other.seqEscola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Escola[ seqEscola=" + seqEscola + " ]";
    }
    
}
