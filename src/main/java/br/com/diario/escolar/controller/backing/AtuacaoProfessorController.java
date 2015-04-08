package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.AtuacaoProfessor;
import br.com.diario.escolar.view.session.AtuacaoProfessorFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "atuacaoProfessorController")
@ViewScoped
public class AtuacaoProfessorController extends AbstractController<AtuacaoProfessor> {

    @Inject
    private AtuacaoProfessorFacade ejbFacade;
    private DisciplinaProfessorController seqDisciplinaProfessorController;
    private DisciplinaController seqDisciplinaController;

    /**
     * Initialize the concrete AtuacaoProfessor controller bean. The
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
        seqDisciplinaProfessorController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaProfessorController}", DisciplinaProfessorController.class);
        seqDisciplinaController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaController}", DisciplinaController.class);
    }

    public AtuacaoProfessorController() {
        // Inform the Abstract parent controller of the concrete AtuacaoProfessor?cap_first Entity
        super(AtuacaoProfessor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqDisciplinaProfessorController.setSelected(null);
        seqDisciplinaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of PlanoEnsino entities that
     * are retrieved from AtuacaoProfessor?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for PlanoEnsino page
     */
    public String navigatePlanoEnsinoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PlanoEnsino_items", this.getSelected().getPlanoEnsinoList());
        }
        return "/pages/prime/planoEnsino/index";
    }

    /**
     * Sets the "selected" attribute of the DisciplinaProfessor controller in
     * order to display its data in a dialog. This is reusing existing the
     * existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqDisciplinaProfessor(ActionEvent event) {
        if (this.getSelected() != null && seqDisciplinaProfessorController.getSelected() == null) {
            seqDisciplinaProfessorController.setSelected(this.getSelected().getSeqDisciplinaProfessor());
        }
    }

    /**
     * Sets the "selected" attribute of the Disciplina controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqDisciplina(ActionEvent event) {
        if (this.getSelected() != null && seqDisciplinaController.getSelected() == null) {
            seqDisciplinaController.setSelected(this.getSelected().getSeqDisciplina());
        }
    }
}
