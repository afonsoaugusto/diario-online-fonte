/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diario.escolar.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author afonso.rodrigues
 */
@Entity
@Table(name = "TBL_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT t FROM Menu t"),
    @NamedQuery(name = "Menu.findBySeqMenu", query = "SELECT t FROM Menu t WHERE t.seqMenu = :seqMenu"),
    @NamedQuery(name = "Menu.findByNumOrdem", query = "SELECT t FROM Menu t WHERE t.numOrdem = :numOrdem"),
    @NamedQuery(name = "Menu.findByTxtTitulo", query = "SELECT t FROM Menu t WHERE t.txtTitulo = :txtTitulo"),
    @NamedQuery(name = "Menu.findByTxtAcesso", query = "SELECT t FROM Menu t WHERE t.txtAcesso = :txtAcesso"),
    @NamedQuery(name = "Menu.findByTxtVisao", query = "SELECT t FROM Menu t WHERE t.txtVisao = :txtVisao"),
    @NamedQuery(name = "Menu.findBySitAtivo", query = "SELECT t FROM Menu t WHERE t.sitAtivo = :sitAtivo"),
    @NamedQuery(name = "Menu.findByTxtUrl", query = "SELECT t FROM Menu t WHERE t.txtUrl = :txtUrl")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEQ_MENU")
    private Integer seqMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ORDEM")
    private int numOrdem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "TXT_TITULO")
    private String txtTitulo;
    @Size(max = 255)
    @Column(name = "TXT_ACESSO")
    private String txtAcesso;
    @Size(max = 80)
    @Column(name = "TXT_VISAO")
    private String txtVisao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIT_ATIVO")
    private Character sitAtivo;
    @Size(max = 255)
    @Column(name = "TXT_URL")
    private String txtUrl;
    @OneToMany(mappedBy = "seqMenuPai")
    private Collection<Menu> tblMenuCollection;
    @JoinColumn(name = "SEQ_MENU_PAI", referencedColumnName = "SEQ_MENU")
    @ManyToOne
    private Menu seqMenuPai;

    public Menu() {
    }

    public Menu(Integer seqMenu) {
        this.seqMenu = seqMenu;
    }

    public Menu(Integer seqMenu, int numOrdem, String txtTitulo, Character sitAtivo) {
        this.seqMenu = seqMenu;
        this.numOrdem = numOrdem;
        this.txtTitulo = txtTitulo;
        this.sitAtivo = sitAtivo;
    }

    public Integer getSeqMenu() {
        return seqMenu;
    }

    public void setSeqMenu(Integer seqMenu) {
        this.seqMenu = seqMenu;
    }

    public int getNumOrdem() {
        return numOrdem;
    }

    public void setNumOrdem(int numOrdem) {
        this.numOrdem = numOrdem;
    }

    public String getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(String txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public String getTxtAcesso() {
        return txtAcesso;
    }

    public void setTxtAcesso(String txtAcesso) {
        this.txtAcesso = txtAcesso;
    }

    public String getTxtVisao() {
        return txtVisao;
    }

    public void setTxtVisao(String txtVisao) {
        this.txtVisao = txtVisao;
    }

    public Character getSitAtivo() {
        return sitAtivo;
    }

    public void setSitAtivo(Character sitAtivo) {
        this.sitAtivo = sitAtivo;
    }

    public String getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(String txtUrl) {
        this.txtUrl = txtUrl;
    }

    @XmlTransient
    public Collection<Menu> getTblMenuCollection() {
        return tblMenuCollection;
    }

    public void setTblMenuCollection(Collection<Menu> tblMenuCollection) {
        this.tblMenuCollection = tblMenuCollection;
    }

    public Menu getSeqMenuPai() {
        return seqMenuPai;
    }

    public void setSeqMenuPai(Menu seqMenuPai) {
        this.seqMenuPai = seqMenuPai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqMenu != null ? seqMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.seqMenu == null && other.seqMenu != null) || (this.seqMenu != null && !this.seqMenu.equals(other.seqMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.diario.escolar.model.entity.Menu[ seqMenu=" + seqMenu + " ]";
    }
    
}
