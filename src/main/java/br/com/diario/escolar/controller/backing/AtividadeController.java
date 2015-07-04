package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Atividade;
import br.com.diario.escolar.controller.session.AtividadeFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

@ManagedBean(name = "atividadeController")
@ViewScoped
public class AtividadeController extends AbstractController<Atividade> {

    @EJB
    private AtividadeFacade ejbFacade;
    private ParametrizacaoController seqParameTipoController;
    private DisciplinaAnoController seqDisciplinaAnoController;

    /**
     * Initialize the concrete Atividade controller bean. The AbstractController
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
        seqParameTipoController = context.getApplication().evaluateExpressionGet(context, "#{parametrizacaoController}", ParametrizacaoController.class);
        seqDisciplinaAnoController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaAnoController}", DisciplinaAnoController.class);
    }

    public AtividadeController() {
        // Inform the Abstract parent controller of the concrete Atividade?cap_first Entity
        super(Atividade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqParameTipoController.setSelected(null);
        seqDisciplinaAnoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Parametrizacao controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqParameTipo(ActionEvent event) {
        if (this.getSelected() != null && seqParameTipoController.getSelected() == null) {
            seqParameTipoController.setSelected(this.getSelected().getSeqParameTipo());
        }
    }

    /**
     * Sets the "selected" attribute of the Disciplina controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqDisciplinaAno(ActionEvent event) {
        if (this.getSelected() != null && seqDisciplinaAnoController.getSelected() == null) {
            seqDisciplinaAnoController.setSelected(this.getSelected().getSeqDisciplinaAno());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Notas entities that are
     * retrieved from Atividade?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Notas page
     */
    public String navigateNotasList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Notas_items", this.getSelected().getNotasList());
        }
        return "/pages/prime/notas/index";
    }

}
