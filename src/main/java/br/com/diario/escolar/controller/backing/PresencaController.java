package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Presenca;
import br.com.diario.escolar.view.session.PresencaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "presencaController")
@ViewScoped
public class PresencaController extends AbstractController<Presenca> {

    @EJB
    private PresencaFacade ejbFacade;
    private DisciplinaController seqDisciplinaController;
    private AlunoController seqAlunoController;

    /**
     * Initialize the concrete Presenca controller bean. The AbstractController
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
        seqDisciplinaController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaController}", DisciplinaController.class);
        seqAlunoController = context.getApplication().evaluateExpressionGet(context, "#{alunoController}", AlunoController.class);
    }

    public PresencaController() {
        // Inform the Abstract parent controller of the concrete Presenca?cap_first Entity
        super(Presenca.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqDisciplinaController.setSelected(null);
        seqAlunoController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Aluno controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAluno(ActionEvent event) {
        if (this.getSelected() != null && seqAlunoController.getSelected() == null) {
            seqAlunoController.setSelected(this.getSelected().getSeqAluno());
        }
    }
}
