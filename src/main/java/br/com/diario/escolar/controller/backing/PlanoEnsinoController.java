package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.PlanoEnsino;
import br.com.diario.escolar.view.session.PlanoEnsinoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "planoEnsinoController")
@ViewScoped
public class PlanoEnsinoController extends AbstractController<PlanoEnsino> {

    @EJB
    private PlanoEnsinoFacade ejbFacade;
    private TurmaController seqTurmaController;
    private AtuacaoProfessorController seqAtuacaoProfessorController;

    /**
     * Initialize the concrete PlanoEnsino controller bean. The
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
        seqTurmaController = context.getApplication().evaluateExpressionGet(context, "#{turmaController}", TurmaController.class);
        seqAtuacaoProfessorController = context.getApplication().evaluateExpressionGet(context, "#{atuacaoProfessorController}", AtuacaoProfessorController.class);
    }

    public PlanoEnsinoController() {
        // Inform the Abstract parent controller of the concrete PlanoEnsino?cap_first Entity
        super(PlanoEnsino.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqTurmaController.setSelected(null);
        seqAtuacaoProfessorController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Turma controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqTurma(ActionEvent event) {
        if (this.getSelected() != null && seqTurmaController.getSelected() == null) {
            seqTurmaController.setSelected(this.getSelected().getSeqTurma());
        }
    }

    /**
     * Sets the "selected" attribute of the AtuacaoProfessor controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAtuacaoProfessor(ActionEvent event) {
        if (this.getSelected() != null && seqAtuacaoProfessorController.getSelected() == null) {
            seqAtuacaoProfessorController.setSelected(this.getSelected().getSeqAtuacaoProfessor());
        }
    }
}