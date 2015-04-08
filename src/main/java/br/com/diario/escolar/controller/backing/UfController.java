package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Uf;
import br.com.diario.escolar.view.session.UfFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "ufController")
@ViewScoped
public class UfController extends AbstractController<Uf> {

    @Inject
    private UfFacade ejbFacade;

    /**
     * Initialize the concrete Uf controller bean. The AbstractController
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

    public UfController() {
        // Inform the Abstract parent controller of the concrete Uf?cap_first Entity
        super(Uf.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Municipio entities that
     * are retrieved from Uf?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Municipio page
     */
    public String navigateMunicipioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Municipio_items", this.getSelected().getMunicipioList());
        }
        return "/pages/prime/municipio/index";
    }

}
