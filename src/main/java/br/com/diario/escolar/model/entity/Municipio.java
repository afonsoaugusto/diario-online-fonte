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
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByCodMunicipio", query = "SELECT m FROM Municipio m WHERE m.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "Municipio.findByNomMunicipio", query = "SELECT m FROM Municipio m WHERE m.nomMunicipio = :nomMunicipio"),
    @NamedQuery(name = "Municipio.findBySitCancelado", query = "SELECT m FROM Municipio m WHERE m.sitCancelado = :sitCancelado"),
    @NamedQuery(name = "Municipio.findByDatAlteracao", query = "SELECT m FROM Municipio m WHERE m.datAlteracao = :datAlteracao"),
    @NamedQuery(name = "Municipio.findByNumLonSede", query = "SELECT m FROM Municipio m WHERE m.numLonSede = :numLonSede"),
    @NamedQuery(name = "Municipio.findByNumLatSede", query = "SELECT m FROM Municipio m WHERE m.numLatSede = :numLatSede"),
    @NamedQuery(name = "Municipio.findByCodUnidadeArrecadacao", query = "SELECT m FROM Municipio m WHERE m.codUnidadeArrecadacao = :codUnidadeArrecadacao"),
    @NamedQuery(name = "Municipio.findBySeqUnidadeArrecadacao", query = "SELECT m FROM Municipio m WHERE m.seqUnidadeArrecadacao = :seqUnidadeArrecadacao"),
    @NamedQuery(name = "Municipio.findByNomMunicipioFormatado", query = "SELECT m FROM Municipio m WHERE m.nomMunicipioFormatado = :nomMunicipioFormatado")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "COD_MUNICIPIO")
    private String codMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM_MUNICIPIO")
    private String nomMunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIT_CANCELADO")
    private Character sitCancelado;
    @Column(name = "DAT_ALTERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datAlteracao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NUM_LON_SEDE")
    private BigDecimal numLonSede;
    @Column(name = "NUM_LAT_SEDE")
    private BigDecimal numLatSede;
    @Column(name = "COD_UNIDADE_ARRECADACAO")
    private Short codUnidadeArrecadacao;
    @Column(name = "SEQ_UNIDADE_ARRECADACAO")
    private Short seqUnidadeArrecadacao;
    @Size(max = 40)
    @Column(name = "NOM_MUNICIPIO_FORMATADO")
    private String nomMunicipioFormatado;
    @JoinColumn(name = "COD_UF", referencedColumnName = "COD_UF")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Uf codUf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqCidade",fetch = FetchType.LAZY)
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqCidade",fetch = FetchType.LAZY)
    private List<Escola> escolaList;

    public Municipio() {
    }

    public Municipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Municipio(String codMunicipio, String nomMunicipio, Character sitCancelado) {
        this.codMunicipio = codMunicipio;
        this.nomMunicipio = nomMunicipio;
        this.sitCancelado = sitCancelado;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    public Character getSitCancelado() {
        return sitCancelado;
    }

    public void setSitCancelado(Character sitCancelado) {
        this.sitCancelado = sitCancelado;
    }

    public Date getDatAlteracao() {
        return datAlteracao;
    }

    public void setDatAlteracao(Date datAlteracao) {
        this.datAlteracao = datAlteracao;
    }

    public BigDecimal getNumLonSede() {
        return numLonSede;
    }

    public void setNumLonSede(BigDecimal numLonSede) {
        this.numLonSede = numLonSede;
    }

    public BigDecimal getNumLatSede() {
        return numLatSede;
    }

    public void setNumLatSede(BigDecimal numLatSede) {
        this.numLatSede = numLatSede;
    }

    public Short getCodUnidadeArrecadacao() {
        return codUnidadeArrecadacao;
    }

    public void setCodUnidadeArrecadacao(Short codUnidadeArrecadacao) {
        this.codUnidadeArrecadacao = codUnidadeArrecadacao;
    }

    public Short getSeqUnidadeArrecadacao() {
        return seqUnidadeArrecadacao;
    }

    public void setSeqUnidadeArrecadacao(Short seqUnidadeArrecadacao) {
        this.seqUnidadeArrecadacao = seqUnidadeArrecadacao;
    }

    public String getNomMunicipioFormatado() {
        return nomMunicipioFormatado;
    }

    public void setNomMunicipioFormatado(String nomMunicipioFormatado) {
        this.nomMunicipioFormatado = nomMunicipioFormatado;
    }

    public Uf getCodUf() {
        return codUf;
    }

    public void setCodUf(Uf codUf) {
        this.codUf = codUf;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @XmlTransient
    public List<Escola> getEscolaList() {
        return escolaList;
    }

    public void setEscolaList(List<Escola> escolaList) {
        this.escolaList = escolaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMunicipio != null ? codMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codMunicipio == null && other.codMunicipio != null) || (this.codMunicipio != null && !this.codMunicipio.equals(other.codMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Municipio[ codMunicipio=" + codMunicipio + " ]";
    }
    
}
