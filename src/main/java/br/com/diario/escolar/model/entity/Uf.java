/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.util.Calendar;
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
@Table(name = "UF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u"),
    @NamedQuery(name = "Uf.findByCodUf", query = "SELECT u FROM Uf u WHERE u.codUf = :codUf"),
    @NamedQuery(name = "Uf.findBySigUf", query = "SELECT u FROM Uf u WHERE u.sigUf = :sigUf"),
    @NamedQuery(name = "Uf.findByNomUf", query = "SELECT u FROM Uf u WHERE u.nomUf = :nomUf"),
    @NamedQuery(name = "Uf.findBySitCancelado", query = "SELECT u FROM Uf u WHERE u.sitCancelado = :sitCancelado"),
    @NamedQuery(name = "Uf.findByDatAlteracao", query = "SELECT u FROM Uf u WHERE u.datAlteracao = :datAlteracao"),
    @NamedQuery(name = "Uf.findByNomUfFormatado", query = "SELECT u FROM Uf u WHERE u.nomUfFormatado = :nomUfFormatado")})
public class Uf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COD_UF")
    private String codUf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SIG_UF")
    private String sigUf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOM_UF")
    private String nomUf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIT_CANCELADO")
    private Character sitCancelado;
    @Column(name = "DAT_ALTERACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datAlteracao;
    @Size(max = 20)
    @Column(name = "NOM_UF_FORMATADO")
    private String nomUfFormatado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUf",fetch = FetchType.LAZY)
    private List<Municipio> municipioList;

    public Uf() {
        initUf();
    }

    public Uf(String codUf) {
        this.codUf = codUf;
        initUf();
    }

    public Uf(String codUf, String sigUf, String nomUf, Character sitCancelado) {
        initUf();
        this.codUf = codUf;
        this.sigUf = sigUf;
        this.nomUf = nomUf;
        this.sitCancelado = sitCancelado;
    }

    public String getCodUf() {
        return codUf;
    }

    public void setCodUf(String codUf) {
        this.codUf = codUf;
    }

    public String getSigUf() {
        return sigUf;
    }

    public void setSigUf(String sigUf) {
        this.sigUf = sigUf;
    }

    public String getNomUf() {
        return nomUf;
    }

    public void setNomUf(String nomUf) {
        this.nomUf = nomUf;
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

    public String getNomUfFormatado() {
        return nomUfFormatado;
    }

    public void setNomUfFormatado(String nomUfFormatado) {
        this.nomUfFormatado = nomUfFormatado;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUf != null ? codUf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        if ((this.codUf == null && other.codUf != null) || (this.codUf != null && !this.codUf.equals(other.codUf))) {
            return false;
        }
        return true;
    }
    
    private void initUf() {
        this.sitCancelado = 'N';
        this.datAlteracao = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Uf[ codUf=" + codUf + " ]";
    }
    
}
