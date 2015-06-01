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
@Table(name = "TBL_ANO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ano.findAll", query = "SELECT a FROM Ano a"),
    @NamedQuery(name = "Ano.findBySeqAno", query = "SELECT a FROM Ano a WHERE a.seqAno = :seqAno"),
    @NamedQuery(name = "Ano.findByNumAno", query = "SELECT a FROM Ano a WHERE a.numAno = :numAno"),
    @NamedQuery(name = "Ano.findByNumAnoVigente", query = "SELECT a FROM Ano a WHERE a.numAnoVigente = :numAnoVigente")})
public class Ano implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ANO")
    private BigDecimal seqAno;
    @Column(name = "NUM_ANO")
    private Short numAno;
    @Column(name = "NUM_ANO_VIGENTE")
    private Short numAnoVigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAno",fetch = FetchType.LAZY)
    private List<FechamentoAluno> fechamentoAlunoList;
    @JoinColumn(name = "SEQ_PARAME_NIVEL_ESCOLAR", referencedColumnName = "SEQ_PARAMETRIZACAO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Parametrizacao seqParameNivelEscolar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAnoSeqAno",fetch = FetchType.LAZY)
    private List<DisciplinaAno> disciplinaAnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAno",fetch = FetchType.LAZY)
    private List<Turma> turmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAno",fetch = FetchType.LAZY)
    private List<Notas> notasList;

    public Ano() {
    }

    public Ano(BigDecimal seqAno) {
        this.seqAno = seqAno;
    }

    public BigDecimal getSeqAno() {
        return seqAno;
    }

    public void setSeqAno(BigDecimal seqAno) {
        this.seqAno = seqAno;
    }

    public Short getNumAno() {
        return numAno;
    }

    public void setNumAno(Short numAno) {
        this.numAno = numAno;
    }

    public Short getNumAnoVigente() {
        return numAnoVigente;
    }

    public void setNumAnoVigente(Short numAnoVigente) {
        this.numAnoVigente = numAnoVigente;
    }

    @XmlTransient
    public List<FechamentoAluno> getFechamentoAlunoList() {
        return fechamentoAlunoList;
    }

    public void setFechamentoAlunoList(List<FechamentoAluno> fechamentoAlunoList) {
        this.fechamentoAlunoList = fechamentoAlunoList;
    }

    public Parametrizacao getSeqParameNivelEscolar() {
        return seqParameNivelEscolar;
    }

    public void setSeqParameNivelEscolar(Parametrizacao seqParameNivelEscolar) {
        this.seqParameNivelEscolar = seqParameNivelEscolar;
    }

    @XmlTransient
    public List<DisciplinaAno> getDisciplinaAnoList() {
        return disciplinaAnoList;
    }

    public void setDisciplinaAnoList(List<DisciplinaAno> disciplinaAnoList) {
        this.disciplinaAnoList = disciplinaAnoList;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
    }
    
    public String getAnoFormatado(){
        //return tblAnoSeqAno.getNumAnoVigente() + '.'+ tblDisciplinaSeqDisciplina.getDesNomeDisciplina();
        return this.getNumAnoVigente() +" - "+ this.seqParameNivelEscolar.getDesValorParametro();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqAno != null ? seqAno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ano)) {
            return false;
        }
        Ano other = (Ano) object;
        if ((this.seqAno == null && other.seqAno != null) || (this.seqAno != null && !this.seqAno.equals(other.seqAno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Ano[ seqAno=" + seqAno + " ]";
    }
    
}
