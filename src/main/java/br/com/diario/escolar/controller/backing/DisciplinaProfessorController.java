package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.DisciplinaProfessor;
import br.com.diario.escolar.view.session.DisciplinaProfessorFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "disciplinaProfessorController")
@ViewScoped
public class DisciplinaProfessorController extends AbstractController<DisciplinaProfessor> {

    @EJB
    private DisciplinaProfessorFacade ejbFacade;
    private PessoaController seqPessoaController;
    private DisciplinaAnoController seqDisciplinaAnoController;

    /**
     * Initialize the concrete DisciplinaProfessor controller bean. The
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
        seqPessoaController = context.getApplication().evaluateExpressionGet(context, "#{pessoaController}", PessoaController.class);
        seqDisciplinaAnoController = context.getApplication().evaluateExpressionGet(context, "#{disciplinaAnoController}", DisciplinaAnoController.class);
    }

    public DisciplinaProfessorController() {
        // Inform the Abstract parent controller of the concrete DisciplinaProfessor?cap_first Entity
        super(DisciplinaProfessor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqPessoaController.setSelected(null);
        seqDisciplinaAnoController.setSelected(null);
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
     * Sets the "selected" attribute of the DisciplinaAno controller in order to
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
     * Sets the "items" attribute with a collection of AtuacaoProfessor entities
     * that are retrieved from DisciplinaProfessor?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for AtuacaoProfessor page
     */
    public String navigateAtuacaoProfessorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AtuacaoProfessor_items", this.getSelected().getAtuacaoProfessorList());
        }
        return "/pages/prime/atuacaoProfessor/index";
    }

}
