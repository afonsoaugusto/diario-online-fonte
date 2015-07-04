package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Menu;
import br.com.diario.escolar.controller.session.MenuFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "menuController")
@ViewScoped
public class MenuController extends AbstractController<Menu> {

    @EJB
    private MenuFacade ejbFacade;
    //private MenuController seqMenuPaiController;

    /**
     * Initialize the concrete Menu controller bean. The AbstractController
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
        //seqMenuPaiController = context.getApplication().evaluateExpressionGet(context, "#{menuController}", MenuController.class);
    }

    public MenuController() {
        // Inform the Abstract parent controller of the concrete Menu?cap_first Entity
        super(Menu.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        //seqMenuPaiController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Menu entities that are
     * retrieved from Menu?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Menu page
     */
    public String navigateTblMenuCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Menu_items", this.getSelected().getTblMenuCollection());
        }
        return "/pages/prime/menu/index";
    }

    /**
     * Sets the "selected" attribute of the Menu controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqMenuPai(ActionEvent event) {
        //if (this.getSelected() != null && seqMenuPaiController.getSelected() == null) {
        //    seqMenuPaiController.setSelected(this.getSelected().getSeqMenuPai());
       // }
    }
}
