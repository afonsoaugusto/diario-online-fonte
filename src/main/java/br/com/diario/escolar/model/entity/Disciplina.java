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
import javax.persistence.Lob;
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
@Table(name = "TBL_DISCIPLINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findBySeqDisciplina", query = "SELECT d FROM Disciplina d WHERE d.seqDisciplina = :seqDisciplina"),
    @NamedQuery(name = "Disciplina.findByDesNomeDisciplina", query = "SELECT d FROM Disciplina d WHERE d.desNomeDisciplina = :desNomeDisciplina")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_DISCIPLINA")
    private BigDecimal seqDisciplina;
    @Size(max = 60)
    @Column(name = "DES_NOME_DISCIPLINA")
    private String desNomeDisciplina;
    @Lob
    @Column(name = "DES_CONTEUDO")
    private String desConteudo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqDisciplina",fetch = FetchType.LAZY)
    private List<Fechamento> fechamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqDisciplina",fetch = FetchType.LAZY)
    private List<Atividade> atividadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqDisciplina",fetch = FetchType.LAZY)
    private List<Presenca> presencaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqDisciplina",fetch = FetchType.LAZY)
    private List<AtuacaoProfessor> atuacaoProfessorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblDisciplinaSeqDisciplina",fetch = FetchType.LAZY)
    private List<DisciplinaAno> disciplinaAnoList;

    public Disciplina() {
    }

    public Disciplina(BigDecimal seqDisciplina) {
        this.seqDisciplina = seqDisciplina;
    }

    public BigDecimal getSeqDisciplina() {
        return seqDisciplina;
    }

    public void setSeqDisciplina(BigDecimal seqDisciplina) {
        this.seqDisciplina = seqDisciplina;
    }

    public String getDesNomeDisciplina() {
        return desNomeDisciplina;
    }

    public void setDesNomeDisciplina(String desNomeDisciplina) {
        this.desNomeDisciplina = desNomeDisciplina;
    }

    public String getDesConteudo() {
        return desConteudo;
    }

    public void setDesConteudo(String desConteudo) {
        this.desConteudo = desConteudo;
    }

    @XmlTransient
    public List<Fechamento> getFechamentoList() {
        return fechamentoList;
    }

    public void setFechamentoList(List<Fechamento> fechamentoList) {
        this.fechamentoList = fechamentoList;
    }

    @XmlTransient
    public List<Atividade> getAtividadeList() {
        return atividadeList;
    }

    public void setAtividadeList(List<Atividade> atividadeList) {
        this.atividadeList = atividadeList;
    }

    @XmlTransient
    public List<Presenca> getPresencaList() {
        return presencaList;
    }

    public void setPresencaList(List<Presenca> presencaList) {
        this.presencaList = presencaList;
    }

    @XmlTransient
    public List<AtuacaoProfessor> getAtuacaoProfessorList() {
        return atuacaoProfessorList;
    }

    public void setAtuacaoProfessorList(List<AtuacaoProfessor> atuacaoProfessorList) {
        this.atuacaoProfessorList = atuacaoProfessorList;
    }

    @XmlTransient
    public List<DisciplinaAno> getDisciplinaAnoList() {
        return disciplinaAnoList;
    }

    public void setDisciplinaAnoList(List<DisciplinaAno> disciplinaAnoList) {
        this.disciplinaAnoList = disciplinaAnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqDisciplina != null ? seqDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.seqDisciplina == null && other.seqDisciplina != null) || (this.seqDisciplina != null && !this.seqDisciplina.equals(other.seqDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Disciplina[ seqDisciplina=" + seqDisciplina + " ]";
    }
    
}
