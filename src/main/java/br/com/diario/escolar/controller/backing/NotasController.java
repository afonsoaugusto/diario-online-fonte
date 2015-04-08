package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Notas;
import br.com.diario.escolar.view.session.NotasFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "notasController")
@ViewScoped
public class NotasController extends AbstractController<Notas> {

    @Inject
    private NotasFacade ejbFacade;
    private PessoaController seqPessoaController;
    private ParametrizacaoController seqParamePeriodoController;
    private AtividadeController seqAtividadeController;
    private AnoController seqAnoController;
    private AlunoController seqAlunoController;

    /**
     * Initialize the concrete Notas controller bean. The AbstractController
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
        seqPessoaController = context.getApplication().evaluateExpressionGet(context, "#{pessoaController}", PessoaController.class);
        seqParamePeriodoController = context.getApplication().evaluateExpressionGet(context, "#{parametrizacaoController}", ParametrizacaoController.class);
        seqAtividadeController = context.getApplication().evaluateExpressionGet(context, "#{atividadeController}", AtividadeController.class);
        seqAnoController = context.getApplication().evaluateExpressionGet(context, "#{anoController}", AnoController.class);
        seqAlunoController = context.getApplication().evaluateExpressionGet(context, "#{alunoController}", AlunoController.class);
    }

    public NotasController() {
        // Inform the Abstract parent controller of the concrete Notas?cap_first Entity
        super(Notas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqPessoaController.setSelected(null);
        seqParamePeriodoController.setSelected(null);
        seqAtividadeController.setSelected(null);
        seqAnoController.setSelected(null);
        seqAlunoController.setSelected(null);
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
     * Sets the "selected" attribute of the Parametrizacao controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqParamePeriodo(ActionEvent event) {
        if (this.getSelected() != null && seqParamePeriodoController.getSelected() == null) {
            seqParamePeriodoController.setSelected(this.getSelected().getSeqParamePeriodo());
        }
    }

    /**
     * Sets the "selected" attribute of the Atividade controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqAtividade(ActionEvent event) {
        if (this.getSelected() != null && seqAtividadeController.getSelected() == null) {
            seqAtividadeController.setSelected(this.getSelected().getSeqAtividade());
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
