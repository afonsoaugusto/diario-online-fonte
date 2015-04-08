package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.DisciplinaAno;
import br.com.diario.escolar.view.session.DisciplinaAnoFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "disciplinaAnoController")
@ViewScoped
public class DisciplinaAnoController extends AbstractController<DisciplinaAno> {

    @Inject
    private DisciplinaAnoFacade ejbFacade;
    private DisciplinaController tblDisciplinaSeqDisciplinaController;
    private AnoController tblAnoSeqAnoController;

    /**
     * Initialize the concrete DisciplinaAno controller bean. The
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
        tblDisciplinaSeqDisciplinaController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaController}", DisciplinaController.class);
        tblAnoSeqAnoController = context.getApplication().evaluateExpressionGet(context, "#{anoController}", AnoController.class);
    }

    public DisciplinaAnoController() {
        // Inform the Abstract parent controller of the concrete DisciplinaAno?cap_first Entity
        super(DisciplinaAno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tblDisciplinaSeqDisciplinaController.setSelected(null);
        tblAnoSeqAnoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DisciplinaProfessor
     * entities that are retrieved from DisciplinaAno?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DisciplinaProfessor page
     */
    public String navigateDisciplinaProfessorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisciplinaProfessor_items", this.getSelected().getDisciplinaProfessorList());
        }
        return "/pages/prime/disciplinaProfessor/index";
    }

    /**
     * Sets the "selected" attribute of the Disciplina controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTblDisciplinaSeqDisciplina(ActionEvent event) {
        if (this.getSelected() != null && tblDisciplinaSeqDisciplinaController.getSelected() == null) {
            tblDisciplinaSeqDisciplinaController.setSelected(this.getSelected().getTblDisciplinaSeqDisciplina());
        }
    }

    /**
     * Sets the "selected" attribute of the Ano controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTblAnoSeqAno(ActionEvent event) {
        if (this.getSelected() != null && tblAnoSeqAnoController.getSelected() == null) {
            tblAnoSeqAnoController.setSelected(this.getSelected().getTblAnoSeqAno());
        }
    }
}
