package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.AlunoTurma;
import br.com.diario.escolar.view.session.AlunoTurmaFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

@ManagedBean(name = "alunoTurmaController")
@ViewScoped
public class AlunoTurmaController extends AbstractController<AlunoTurma> {

    @EJB
    private AlunoTurmaFacade ejbFacade;
    private TurmaController seqTurmaController;
    private SituacaoController seqSituacaoController;
    private AlunoController seqAlunoController;

    /**
     * Initialize the concrete AlunoTurma controller bean. The
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
        seqSituacaoController = context.getApplication().evaluateExpressionGet(context, "#{situacaoController}", SituacaoController.class);
        seqAlunoController = context.getApplication().evaluateExpressionGet(context, "#{alunoController}", AlunoController.class);
    }

    public AlunoTurmaController() {
        // Inform the Abstract parent controller of the concrete AlunoTurma?cap_first Entity
        super(AlunoTurma.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqTurmaController.setSelected(null);
        seqSituacaoController.setSelected(null);
        seqAlunoController.setSelected(null);
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
     * Sets the "selected" attribute of the Situacao controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqSituacao(ActionEvent event) {
        if (this.getSelected() != null && seqSituacaoController.getSelected() == null) {
            seqSituacaoController.setSelected(this.getSelected().getSeqSituacao());
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
