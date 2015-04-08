package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.PerfilFuncionalidadeAcao;
import br.com.diario.escolar.view.session.PerfilFuncionalidadeAcaoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "perfilFuncionalidadeAcaoController")
@ViewScoped
public class PerfilFuncionalidadeAcaoController extends AbstractController<PerfilFuncionalidadeAcao> {

    @Inject
    private PerfilFuncionalidadeAcaoFacade ejbFacade;
    private PerfilController seqPerfilController;
    private FuncionalidadeAcaoController seqFuncionalidadeAcaoController;

    /**
     * Initialize the concrete PerfilFuncionalidadeAcao controller bean. The
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
        seqPerfilController = context.getApplication().evaluateExpressionGet(context, "#{perfilController}", PerfilController.class);
        seqFuncionalidadeAcaoController = context.getApplication().evaluateExpressionGet(context, "#{funcionalidadeAcaoController}", FuncionalidadeAcaoController.class);
    }

    public PerfilFuncionalidadeAcaoController() {
        // Inform the Abstract parent controller of the concrete PerfilFuncionalidadeAcao?cap_first Entity
        super(PerfilFuncionalidadeAcao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqPerfilController.setSelected(null);
        seqFuncionalidadeAcaoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Perfil controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqPerfil(ActionEvent event) {
        if (this.getSelected() != null && seqPerfilController.getSelected() == null) {
            seqPerfilController.setSelected(this.getSelected().getSeqPerfil());
        }
    }

    /**
     * Sets the "selected" attribute of the FuncionalidadeAcao controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqFuncionalidadeAcao(ActionEvent event) {
        if (this.getSelected() != null && seqFuncionalidadeAcaoController.getSelected() == null) {
            seqFuncionalidadeAcaoController.setSelected(this.getSelected().getSeqFuncionalidadeAcao());
        }
    }
}
