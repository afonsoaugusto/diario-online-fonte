package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Turma;
import br.com.diario.escolar.view.session.TurmaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "turmaController")
@ViewScoped
public class TurmaController extends AbstractController<Turma> {

    @Inject
    private TurmaFacade ejbFacade;
    private TurnoController seqTurnoController;
    private PessoaController seqPessoaController;
    private EscolaController seqEscolaController;
    private AnoController seqAnoController;

    /**
     * Initialize the concrete Turma controller bean. The AbstractController
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
        seqTurnoController = context.getApplication().evaluateExpressionGet(context, "#{turnoController}", TurnoController.class);
        seqPessoaController = context.getApplication().evaluateExpressionGet(context, "#{pessoaController}", PessoaController.class);
        seqEscolaController = context.getApplication().evaluateExpressionGet(context, "#{escolaController}", EscolaController.class);
        seqAnoController = context.getApplication().evaluateExpressionGet(context, "#{anoController}", AnoController.class);
    }

    public TurmaController() {
        // Inform the Abstract parent controller of the concrete Turma?cap_first Entity
        super(Turma.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqTurnoController.setSelected(null);
        seqPessoaController.setSelected(null);
        seqEscolaController.setSelected(null);
        seqAnoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Fechamento entities that
     * are retrieved from Turma?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Fechamento page
     */
    public String navigateFechamentoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Fechamento_items", this.getSelected().getFechamentoList());
        }
        return "/pages/prime/fechamento/index";
    }

    /**
     * Sets the "items" attribute with a collection of AlunoTurma entities that
     * are retrieved from Turma?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for AlunoTurma page
     */
    public String navigateAlunoTurmaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AlunoTurma_items", this.getSelected().getAlunoTurmaList());
        }
        return "/pages/prime/alunoTurma/index";
    }

    /**
     * Sets the "items" attribute with a collection of PlanoEnsino entities that
     * are retrieved from Turma?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Turno controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqTurno(ActionEvent event) {
        if (this.getSelected() != null && seqTurnoController.getSelected() == null) {
            seqTurnoController.setSelected(this.getSelected().getSeqTurno());
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
}
