package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Perfil;
import br.com.diario.escolar.view.session.PerfilFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "perfilController")
@ViewScoped
public class PerfilController extends AbstractController<Perfil> {

    @Inject
    private PerfilFacade ejbFacade;

    /**
     * Initialize the concrete Perfil controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     * <p>
     * In addition, this controller also requires references to controllers for
     * parent entities in order to display their information from a context
     * menu.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        FacesContext context = FacesContext.getCurrentInstance();
    }

    public PerfilController() {
        // Inform the Abstract parent controller of the concrete Perfil?cap_first Entity
        super(Perfil.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of PerfilFuncionalidadeAcao
     * entities that are retrieved from Perfil?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for PerfilFuncionalidadeAcao page
     */
    public String navigatePerfilFuncionalidadeAcaoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PerfilFuncionalidadeAcao_items", this.getSelected().getPerfilFuncionalidadeAcaoList());
        }
        return "/pages/prime/perfilFuncionalidadeAcao/index";
    }

    /**
     * Sets the "items" attribute with a collection of UsuarioPerfil entities
     * that are retrieved from Perfil?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for UsuarioPerfil page
     */
    public String navigateUsuarioPerfilList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("UsuarioPerfil_items", this.getSelected().getUsuarioPerfilList());
        }
        return "/pages/prime/usuarioPerfil/index";
    }

}
