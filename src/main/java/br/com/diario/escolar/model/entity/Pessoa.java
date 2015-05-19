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
import javax.persistence.OneToOne;
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
@Table(name = "TBL_PESSOA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findBySeqPessoa", query = "SELECT p FROM Pessoa p WHERE p.seqPessoa = :seqPessoa"),
    @NamedQuery(name = "Pessoa.findByDesNome", query = "SELECT p FROM Pessoa p WHERE p.desNome = :desNome"),
    @NamedQuery(name = "Pessoa.findByCodCpf", query = "SELECT p FROM Pessoa p WHERE p.codCpf = :codCpf"),
    @NamedQuery(name = "Pessoa.findByDesRua", query = "SELECT p FROM Pessoa p WHERE p.desRua = :desRua"),
    @NamedQuery(name = "Pessoa.findByDesBairro", query = "SELECT p FROM Pessoa p WHERE p.desBairro = :desBairro"),
    @NamedQuery(name = "Pessoa.findByNumCep", query = "SELECT p FROM Pessoa p WHERE p.numCep = :numCep"),
    @NamedQuery(name = "Pessoa.findByNumCasa", query = "SELECT p FROM Pessoa p WHERE p.numCasa = :numCasa"),
    @NamedQuery(name = "Pessoa.findByNumTel", query = "SELECT p FROM Pessoa p WHERE p.numTel = :numTel"),
    @NamedQuery(name = "Pessoa.findByNumCel", query = "SELECT p FROM Pessoa p WHERE p.numCel = :numCel"),
    @NamedQuery(name = "Pessoa.findByFlgAtivo", query = "SELECT p FROM Pessoa p WHERE p.flgAtivo = :flgAtivo")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_PESSOA")
    private BigDecimal seqPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "DES_NOME")
    private String desNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CPF")
    private long codCpf;
    @Size(max = 255)
    @Column(name = "DES_RUA")
    private String desRua;
    @Size(max = 80)
    @Column(name = "DES_BAIRRO")
    private String desBairro;
    @Column(name = "NUM_CEP")
    private Integer numCep;
    @Column(name = "NUM_CASA")
    private Short numCasa;
    @Column(name = "NUM_TEL")
    private Long numTel;
    @Column(name = "NUM_CEL")
    private Long numCel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLG_ATIVO")
    private Character flgAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPessoa",fetch = FetchType.LAZY)
    private List<Fechamento> fechamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPessoaFechamento",fetch = FetchType.LAZY)
    private List<Fechamento> fechamentoList1;
    @JoinColumn(name = "SEQ_CIDADE", referencedColumnName = "COD_MUNICIPIO")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Municipio seqCidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPessoa",fetch = FetchType.LAZY)
    private List<DisciplinaProfessor> disciplinaProfessorList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seqPessoa",fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPessoa",fetch = FetchType.LAZY)
    private List<Turma> turmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqPessoa",fetch = FetchType.LAZY)
    private List<Notas> notasList;

    public Pessoa() {
        initPessoa();
    }

    public Pessoa(BigDecimal seqPessoa) {
        this.seqPessoa = seqPessoa;
        initPessoa();
    }

    public Pessoa(BigDecimal seqPessoa, String desNome, long codCpf, Character flgAtivo) {
        initPessoa();
        this.seqPessoa = seqPessoa;
        this.desNome = desNome;
        this.codCpf = codCpf;
        this.flgAtivo = flgAtivo;
    }

    public BigDecimal getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(BigDecimal seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    public String getDesNome() {
        return desNome;
    }

    public void setDesNome(String desNome) {
        this.desNome = desNome;
    }

    public long getCodCpf() {
        return codCpf;
    }

    public void setCodCpf(long codCpf) {
        this.codCpf = codCpf;
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

    public Short getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(Short numCasa) {
        this.numCasa = numCasa;
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

    public Character getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Character flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    @XmlTransient
    public List<Fechamento> getFechamentoList() {
        return fechamentoList;
    }

    public void setFechamentoList(List<Fechamento> fechamentoList) {
        this.fechamentoList = fechamentoList;
    }

    @XmlTransient
    public List<Fechamento> getFechamentoList1() {
        return fechamentoList1;
    }

    public void setFechamentoList1(List<Fechamento> fechamentoList1) {
        this.fechamentoList1 = fechamentoList1;
    }

    public Municipio getSeqCidade() {
        return seqCidade;
    }

    public void setSeqCidade(Municipio seqCidade) {
        this.seqCidade = seqCidade;
    }

    @XmlTransient
    public List<DisciplinaProfessor> getDisciplinaProfessorList() {
        return disciplinaProfessorList;
    }

    public void setDisciplinaProfessorList(List<DisciplinaProfessor> disciplinaProfessorList) {
        this.disciplinaProfessorList = disciplinaProfessorList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqPessoa != null ? seqPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.seqPessoa == null && other.seqPessoa != null) || (this.seqPessoa != null && !this.seqPessoa.equals(other.seqPessoa))) {
            return false;
        }
        return true;
    }

        private void initPessoa() {
        this.flgAtivo = 'S';
    }

    
    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Pessoa[ seqPessoa=" + seqPessoa + " ]";
    }
    
}
