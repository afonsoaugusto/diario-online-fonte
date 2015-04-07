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
import javax.persistence.Id;
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
@Table(name = "TBL_TURNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findBySeqTurno", query = "SELECT t FROM Turno t WHERE t.seqTurno = :seqTurno"),
    @NamedQuery(name = "Turno.findByDesTurno", query = "SELECT t FROM Turno t WHERE t.desTurno = :desTurno")})
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_TURNO")
    private BigDecimal seqTurno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DES_TURNO")
    private String desTurno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqTurno")
    private List<Turma> turmaList;

    public Turno() {
    }

    public Turno(BigDecimal seqTurno) {
        this.seqTurno = seqTurno;
    }

    public Turno(BigDecimal seqTurno, String desTurno) {
        this.seqTurno = seqTurno;
        this.desTurno = desTurno;
    }

    public BigDecimal getSeqTurno() {
        return seqTurno;
    }

    public void setSeqTurno(BigDecimal seqTurno) {
        this.seqTurno = seqTurno;
    }

    public String getDesTurno() {
        return desTurno;
    }

    public void setDesTurno(String desTurno) {
        this.desTurno = desTurno;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqTurno != null ? seqTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.seqTurno == null && other.seqTurno != null) || (this.seqTurno != null && !this.seqTurno.equals(other.seqTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Turno[ seqTurno=" + seqTurno + " ]";
    }
    
}
