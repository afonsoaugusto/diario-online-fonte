package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Turno;
import br.com.diario.escolar.view.session.TurnoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "turnoController")
@ViewScoped
public class TurnoController extends AbstractController<Turno> {

    @EJB
    private TurnoFacade ejbFacade;

    /**
     * Initialize the concrete Turno controller bean. The AbstractController
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

    public TurnoController() {
        // Inform the Abstract parent controller of the concrete Turno?cap_first Entity
        super(Turno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Turma entities that are
     * retrieved from Turno?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Turma page
     */
    public String navigateTurmaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Turma_items", this.getSelected().getTurmaList());
        }
        return "/pages/prime/turma/index";
    }

}
