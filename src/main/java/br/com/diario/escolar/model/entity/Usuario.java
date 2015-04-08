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
@Table(name = "TBL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findBySeqUsuario", query = "SELECT u FROM Usuario u WHERE u.seqUsuario = :seqUsuario"),
    @NamedQuery(name = "Usuario.findByDesLogin", query = "SELECT u FROM Usuario u WHERE u.desLogin = :desLogin"),
    @NamedQuery(name = "Usuario.findByDesPassword", query = "SELECT u FROM Usuario u WHERE u.desPassword = :desPassword"),
    @NamedQuery(name = "Usuario.findByDesDica", query = "SELECT u FROM Usuario u WHERE u.desDica = :desDica")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_USUARIO")
    private BigDecimal seqUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DES_LOGIN")
    private String desLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DES_PASSWORD")
    private String desPassword;
    @Size(max = 40)
    @Column(name = "DES_DICA")
    private String desDica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seqUsuario",fetch = FetchType.LAZY)
    private List<UsuarioPerfil> usuarioPerfilList;
    @JoinColumn(name = "SEQ_PESSOA", referencedColumnName = "SEQ_PESSOA")
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    private Pessoa seqPessoa;

    public Usuario() {
    }

    public Usuario(BigDecimal seqUsuario) {
        this.seqUsuario = seqUsuario;
    }

    public Usuario(BigDecimal seqUsuario, String desLogin, String desPassword) {
        this.seqUsuario = seqUsuario;
        this.desLogin = desLogin;
        this.desPassword = desPassword;
    }

    public BigDecimal getSeqUsuario() {
        return seqUsuario;
    }

    public void setSeqUsuario(BigDecimal seqUsuario) {
        this.seqUsuario = seqUsuario;
    }

    public String getDesLogin() {
        return desLogin;
    }

    public void setDesLogin(String desLogin) {
        this.desLogin = desLogin;
    }

    public String getDesPassword() {
        return desPassword;
    }

    public void setDesPassword(String desPassword) {
        this.desPassword = desPassword;
    }

    public String getDesDica() {
        return desDica;
    }

    public void setDesDica(String desDica) {
        this.desDica = desDica;
    }

    @XmlTransient
    public List<UsuarioPerfil> getUsuarioPerfilList() {
        return usuarioPerfilList;
    }

    public void setUsuarioPerfilList(List<UsuarioPerfil> usuarioPerfilList) {
        this.usuarioPerfilList = usuarioPerfilList;
    }

    public Pessoa getSeqPessoa() {
        return seqPessoa;
    }

    public void setSeqPessoa(Pessoa seqPessoa) {
        this.seqPessoa = seqPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqUsuario != null ? seqUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.seqUsuario == null && other.seqUsuario != null) || (this.seqUsuario != null && !this.seqUsuario.equals(other.seqUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diario.escolar.model.entity.Usuario[ seqUsuario=" + seqUsuario + " ]";
    }
    
}
