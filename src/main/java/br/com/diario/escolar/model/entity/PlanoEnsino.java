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
import javax.persistence.Lob;
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
@Table(name = "TBL_PLANO_ENSINO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanoEnsino.findAll", query = "SELECT p FROM PlanoEnsino p"),
    @NamedQuery(name = "PlanoEnsino.findBySeqPlanoEnsino", query = "SELECT p FROM PlanoEnsino p WHERE p.seqPlanoEnsino = :seqPlanoEnsino"),
    @NamedQuery(name = "PlanoEnsino.findByDatPlano", query = "SELECT p FROM PlanoEnsino p WHERE p.datPlano = :datPlano")})
public class PlanoEnsino implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PLANO_ENSINO")
    private BigDecimal seqPlanoEnsino;
    @Lob
    @Column(name = "DES_CONTEUDO")
    private String desConteudo;
    @Column(name = "DAT_PLANO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datPlano;
    @Lob
    @Column(name = "DES_ANEXO")
    private Serializable desAnexo;
    //private File desAnexo;
    @JoinColumn(name = "SEQ_TURMA", referencedColumnName = "SEQ_TURMA")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Turma seqTurma;
    @JoinColumn(name = "SEQ_ATUACAO_PROFESSOR", referencedColumnName = "SEQ_ATUACAO_PROFESSOR")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private AtuacaoProfessor seqAtuacaoProfessor;

    public PlanoEnsino() {
    }

    public PlanoEnsino(BigDecimal seqPlanoEnsino) {
        this.seqPlanoEnsino = seqPlanoEnsino;
    }

    public BigDecimal getSeqPlanoEnsino() {
        return seqPlanoEnsino;
    }

    public void setSeqPlanoEnsino(BigDecimal seqPlanoEnsino) {
        this.seqPlanoEnsino = seqPlanoEnsino;
    }

    public String getDesConteudo() {
        return desConteudo;
    }

    public void setDesConteudo(String desConteudo) {
        this.desConteudo = desConteudo;
    }

    public Date getDatPlano() {
        return datPlano;
    }

    public void setDatPlano(Date datPlano) {
        this.datPlano = datPlano;
    }

    public Serializable getDesAnexo() {
        return desAnexo;
    }

    public void setDesAnexo(Serializable desAnexo) {
        this.desAnexo = desAnexo;
    }

    public Turma getSeqTurma() {
        return seqTurma;
    }

    public void setSeqTurma(Turma seqTurma) {
        this.seqTurma = seqTurma;
    }

    public AtuacaoProfessor getSeqAtuacaoProfessor() {
        return seqAtuacaoProfessor;
    }

    public void setSeqAtuacaoProfessor(AtuacaoProfessor seqAtuacaoProfessor) {
        this.seqAtuacaoProfessor = seqAtuacaoProfessor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqPlanoEnsino != null ? seqPlanoEnsino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoEnsino)) {
            return false;
        }
        PlanoEnsino other = (PlanoEnsino) object;
        if ((this.seqPlanoEnsino == null && other.seqPlanoEnsino != null) || (this.seqPlanoEnsino != null && !this.seqPlanoEnsino.equals(other.seqPlanoEnsino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.PlanoEnsino[ seqPlanoEnsino=" + seqPlanoEnsino + " ]";
    }
    
}
