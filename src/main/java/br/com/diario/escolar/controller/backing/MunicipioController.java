package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Municipio;
import br.com.diario.escolar.view.session.MunicipioFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "municipioController")
@ViewScoped
public class MunicipioController extends AbstractController<Municipio> {

    @Inject
    private MunicipioFacade ejbFacade;
    private UfController codUfController;

    /**
     * Initialize the concrete Municipio controller bean. The AbstractController
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
        codUfController = context.getApplication().evaluateExpressionGet(context, "#{ufController}", UfController.class);
    }

    public MunicipioController() {
        // Inform the Abstract parent controller of the concrete Municipio?cap_first Entity
        super(Municipio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codUfController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Uf controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodUf(ActionEvent event) {
        if (this.getSelected() != null && codUfController.getSelected() == null) {
            codUfController.setSelected(this.getSelected().getCodUf());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Pessoa entities that are
     * retrieved from Municipio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Pessoa page
     */
    public String navigatePessoaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pessoa_items", this.getSelected().getPessoaList());
        }
        return "/pages/prime/pessoa/index";
    }

    /**
     * Sets the "items" attribute with a collection of Escola entities that are
     * retrieved from Municipio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Escola page
     */
    public String navigateEscolaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Escola_items", this.getSelected().getEscolaList());
        }
        return "/pages/prime/escola/index";
    }

}
