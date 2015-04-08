package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Fechamento;
import br.com.diario.escolar.view.session.FechamentoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "fechamentoController")
@ViewScoped
public class FechamentoController extends AbstractController<Fechamento> {

    @Inject
    private FechamentoFacade ejbFacade;
    private TurmaController seqTurmaController;
    private PessoaController seqPessoaController;
    private PessoaController seqPessoaFechamentoController;
    private EscolaController seqEscolaController;
    private DisciplinaController seqDisciplinaController;

    /**
     * Initialize the concrete Fechamento controller bean. The
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
        seqPessoaController = context.getApplication().evaluateExpressionGet(context, "#{pessoaController}", PessoaController.class);
        seqPessoaFechamentoController = context.getApplication().evaluateExpressionGet(context, "#{pessoaController}", PessoaController.class);
        seqEscolaController = context.getApplication().evaluateExpressionGet(context, "#{escolaController}", EscolaController.class);
        seqDisciplinaController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaController}", DisciplinaController.class);
    }

    public FechamentoController() {
        // Inform the Abstract parent controller of the concrete Fechamento?cap_first Entity
        super(Fechamento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqTurmaController.setSelected(null);
        seqPessoaController.setSelected(null);
        seqPessoaFechamentoController.setSelected(null);
        seqEscolaController.setSelected(null);
        seqDisciplinaController.setSelected(null);
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
     * Sets the "selected" attribute of the Pessoa controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqPessoa(ActionEvent event) {
        if (this.getSelected() != null && seqPessoaController.getSelected() == null) {
            seqPessoaController.setSelected(this.getSelected().getSeqPessoa());
        }
    }

    /**
     * Sets the "selected" attribute of the Pessoa controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqPessoaFechamento(ActionEvent event) {
        if (this.getSelected() != null && seqPessoaFechamentoController.getSelected() == null) {
            seqPessoaFechamentoController.setSelected(this.getSelected().getSeqPessoaFechamento());
        }
    }

    /**
     * Sets the "selected" attribute of the Escola controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqEscola(ActionEvent event) {
        if (this.getSelected() != null && seqEscolaController.getSelected() == null) {
            seqEscolaController.setSelected(this.getSelected().getSeqEscola());
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

    /**
     * Sets the "items" attribute with a collection of FechamentoAluno entities
     * that are retrieved from Fechamento?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for FechamentoAluno page
     */
    public String navigateFechamentoAlunoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FechamentoAluno_items", this.getSelected().getFechamentoAlunoList());
        }
        return "/pages/prime/fechamentoAluno/index";
    }

}
