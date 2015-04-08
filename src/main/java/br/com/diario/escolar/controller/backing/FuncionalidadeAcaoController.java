package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.FuncionalidadeAcao;
import br.com.diario.escolar.view.session.FuncionalidadeAcaoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "funcionalidadeAcaoController")
@ViewScoped
public class FuncionalidadeAcaoController extends AbstractController<FuncionalidadeAcao> {

    @Inject
    private FuncionalidadeAcaoFacade ejbFacade;
    private FuncionalidadeController seqFuncionalidadeController;
    private AcaoController seqAcaoController;

    /**
     * Initialize the concrete FuncionalidadeAcao controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
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
        seqFuncionalidadeController = context.getApplication().evaluateExpressionGet(context, "#{funcionalidadeController}", FuncionalidadeController.class);
        seqAcaoController = context.getApplication().evaluateExpressionGet(context, "#{acaoController}", AcaoController.class);
    }

    public FuncionalidadeAcaoController() {
        // Inform the Abstract parent controller of the concrete FuncionalidadeAcao?cap_first Entity
        super(FuncionalidadeAcao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqFuncionalidadeController.setSelected(null);
        seqAcaoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PerfilFuncionalidadeAcao
     * entities that are retrieved from FuncionalidadeAcao?cap_first and returns
     * the navigation outcome.
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
     * Sets the "selected" attribute of the Funcionalidade controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqFuncionalidade(ActionEvent event) {
        if (this.getSelected() != null && seqFuncionalidadeController.getSelected() == null) {
            seqFuncionalidadeController.setSelected(this.getSelected().getSeqFuncionalidade());
        }
    }

    /**
     * Sets the "selected" attribute of the Acao controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAcao(ActionEvent event) {
        if (this.getSelected() != null && seqAcaoController.getSelected() == null) {
            seqAcaoController.setSelected(this.getSelected().getSeqAcao());
        }
    }
}
