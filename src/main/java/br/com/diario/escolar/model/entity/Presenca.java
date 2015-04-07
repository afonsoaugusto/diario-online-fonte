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
@Table(name = "TBL_PRESENCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presenca.findAll", query = "SELECT p FROM Presenca p"),
    @NamedQuery(name = "Presenca.findBySeqPresenca", query = "SELECT p FROM Presenca p WHERE p.seqPresenca = :seqPresenca"),
    @NamedQuery(name = "Presenca.findByFlgPresente", query = "SELECT p FROM Presenca p WHERE p.flgPresente = :flgPresente"),
    @NamedQuery(name = "Presenca.findByDatDataPresenca", query = "SELECT p FROM Presenca p WHERE p.datDataPresenca = :datDataPresenca")})
public class Presenca implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PRESENCA")
    private BigDecimal seqPresenca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLG_PRESENTE")
    private Character flgPresente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAT_DATA_PRESENCA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datDataPresenca;
    @JoinColumn(name = "SEQ_DISCIPLINA", referencedColumnName = "SEQ_DISCIPLINA")
    @ManyToOne(optional = false)
    private Disciplina seqDisciplina;
    @JoinColumn(name = "SEQ_ALUNO", referencedColumnName = "SEQ_ALUNO")
    @ManyToOne(optional = false)
    private Aluno seqAluno;

    public Presenca() {
    }

    public Presenca(BigDecimal seqPresenca) {
        this.seqPresenca = seqPresenca;
    }

    public Presenca(BigDecimal seqPresenca, Character flgPresente, Date datDataPresenca) {
        this.seqPresenca = seqPresenca;
        this.flgPresente = flgPresente;
        this.datDataPresenca = datDataPresenca;
    }

    public BigDecimal getSeqPresenca() {
        return seqPresenca;
    }

    public void setSeqPresenca(BigDecimal seqPresenca) {
        this.seqPresenca = seqPresenca;
    }

    public Character getFlgPresente() {
        return flgPresente;
    }

    public void setFlgPresente(Character flgPresente) {
        this.flgPresente = flgPresente;
    }

    public Date getDatDataPresenca() {
        return datDataPresenca;
    }

    public void setDatDataPresenca(Date datDataPresenca) {
        this.datDataPresenca = datDataPresenca;
    }

    public Disciplina getSeqDisciplina() {
        return seqDisciplina;
    }

    public void setSeqDisciplina(Disciplina seqDisciplina) {
        this.seqDisciplina = seqDisciplina;
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
        hash += (seqPresenca != null ? seqPresenca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presenca)) {
            return false;
        }
        Presenca other = (Presenca) object;
        if ((this.seqPresenca == null && other.seqPresenca != null) || (this.seqPresenca != null && !this.seqPresenca.equals(other.seqPresenca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Presenca[ seqPresenca=" + seqPresenca + " ]";
    }
    
}
