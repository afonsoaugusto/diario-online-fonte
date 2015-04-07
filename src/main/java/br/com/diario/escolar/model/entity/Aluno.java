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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "TBL_ALUNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findBySeqAluno", query = "SELECT a FROM Aluno a WHERE a.seqAluno = :seqAluno"),
    @NamedQuery(name = "Aluno.findByNomAluno", query = "SELECT a FROM Aluno a WHERE a.nomAluno = :nomAluno"),
    @NamedQuery(name = "Aluno.findByDatNascimento", query = "SELECT a FROM Aluno a WHERE a.datNascimento = :datNascimento"),
    @NamedQuery(name = "Aluno.findByNumTel", query = "SELECT a FROM Aluno a WHERE a.numTel = :numTel"),
    @NamedQuery(name = "Aluno.findByNumCel", query = "SELECT a FROM Aluno a WHERE a.numCel = :numCel"),
    @NamedQuery(name = "Aluno.findByNomContato", query = "SELECT a FROM Aluno a WHERE a.nomContato = :nomContato"),
    @NamedQuery(name = "Aluno.findByNumTelContato", query = "SELECT a FROM Aluno a WHERE a.numTelContato = :numTelContato"),
    @NamedQuery(name = "Aluno.findByFlgAtivo", query = "SELECT a FROM Aluno a WHERE a.flgAtivo = :flgAtivo")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_ALUNO")
    private BigDecimal seqAluno;
    @Size(max = 255)
    @Column(name = "NOM_ALUNO")
    private String nomAluno;
    @Column(name = "DAT_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datNascimento;
    @Column(name = "NUM_TEL")
    private Long numTel;
    @Column(name = "NUM_CEL")
    private Long numCel;
    @Lob
    @Column(name = "DES_OBSERVACAO")
    private String desObservacao;
    @Size(max = 100)
    @Column(name = "NOM_CONTATO")
    private String nomContato;
    @Column(name = "NUM_TEL_CONTATO")
    private Long numTelContato;
    @Column(name = "FLG_ATIVO")
    private Character flgAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAluno")
    private List<AlunoTurma> alunoTurmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAluno")
    private List<Presenca> presencaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAluno")
    private List<FechamentoAluno> fechamentoAlunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqAluno")
    private List<Notas> notasList;

    public Aluno() {
    }

    public Aluno(BigDecimal seqAluno) {
        this.seqAluno = seqAluno;
    }

    public BigDecimal getSeqAluno() {
        return seqAluno;
    }

    public void setSeqAluno(BigDecimal seqAluno) {
        this.seqAluno = seqAluno;
    }

    public String getNomAluno() {
        return nomAluno;
    }

    public void setNomAluno(String nomAluno) {
        this.nomAluno = nomAluno;
    }

    public Date getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(Date datNascimento) {
        this.datNascimento = datNascimento;
    }

    public Long getNumTel() {
        return numTel;
    }

    public void setNumTel(Long numTel) {
        this.numTel = numTel;
    }

    public Long getNumCel() {
        return numCel;
    }

    public void setNumCel(Long numCel) {
        this.numCel = numCel;
    }

    public String getDesObservacao() {
        return desObservacao;
    }

    public void setDesObservacao(String desObservacao) {
        this.desObservacao = desObservacao;
    }

    public String getNomContato() {
        return nomContato;
    }

    public void setNomContato(String nomContato) {
        this.nomContato = nomContato;
    }

    public Long getNumTelContato() {
        return numTelContato;
    }

    public void setNumTelContato(Long numTelContato) {
        this.numTelContato = numTelContato;
    }

    public Character getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Character flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    @XmlTransient
    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
    }

    @XmlTransient
    public List<Presenca> getPresencaList() {
        return presencaList;
    }

    public void setPresencaList(List<Presenca> presencaList) {
        this.presencaList = presencaList;
    }

    @XmlTransient
    public List<FechamentoAluno> getFechamentoAlunoList() {
        return fechamentoAlunoList;
    }

    public void setFechamentoAlunoList(List<FechamentoAluno> fechamentoAlunoList) {
        this.fechamentoAlunoList = fechamentoAlunoList;
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
        hash += (seqAluno != null ? seqAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.seqAluno == null && other.seqAluno != null) || (this.seqAluno != null && !this.seqAluno.equals(other.seqAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Aluno[ seqAluno=" + seqAluno + " ]";
    }
    
}
