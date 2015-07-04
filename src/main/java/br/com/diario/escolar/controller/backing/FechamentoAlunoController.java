package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.FechamentoAluno;
import br.com.diario.escolar.controller.session.FechamentoAlunoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "fechamentoAlunoController")
@ViewScoped
public class FechamentoAlunoController extends AbstractController<FechamentoAluno> {

    @EJB
    private FechamentoAlunoFacade ejbFacade;
    private SituacaoController seqSituacaoController;
    private FechamentoController seqFechamentoController;
    private AnoController seqAnoController;
    private AlunoController seqAlunoController;

    /**
     * Initialize the concrete FechamentoAluno controller bean. The
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
        seqSituacaoController = context.getApplication().evaluateExpressionGet(context, "#{situacaoController}", SituacaoController.class);
        seqFechamentoController = context.getApplication().evaluateExpressionGet(context, "#{fechamentoController}", FechamentoController.class);
        seqAnoController = context.getApplication().evaluateExpressionGet(context, "#{anoController}", AnoController.class);
        seqAlunoController = context.getApplication().evaluateExpressionGet(context, "#{alunoController}", AlunoController.class);
    }

    public FechamentoAlunoController() {
        // Inform the Abstract parent controller of the concrete FechamentoAluno?cap_first Entity
        super(FechamentoAluno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqSituacaoController.setSelected(null);
        seqFechamentoController.setSelected(null);
        seqAnoController.setSelected(null);
        seqAlunoController.setSelected(null);
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
     * Sets the "selected" attribute of the Fechamento controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqFechamento(ActionEvent event) {
        if (this.getSelected() != null && seqFechamentoController.getSelected() == null) {
            seqFechamentoController.setSelected(this.getSelected().getSeqFechamento());
        }
    }

    /**
     * Sets the "selected" attribute of the Ano controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAno(ActionEvent event) {
        if (this.getSelected() != null && seqAnoController.getSelected() == null) {
            seqAnoController.setSelected(this.getSelected().getSeqAno());
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
