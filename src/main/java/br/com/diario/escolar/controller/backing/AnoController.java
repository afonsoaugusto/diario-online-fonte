package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Ano;
import br.com.diario.escolar.view.session.AnoFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@ManagedBean(name = "anoController")
@ViewScoped
public class AnoController extends AbstractController<Ano> {

    @Inject
    private AnoFacade ejbFacade;
    private ParametrizacaoController seqParameNivelEscolarController;

    /**
     * Initialize the concrete Ano controller bean. The AbstractController
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
        seqParameNivelEscolarController = context.getApplication().evaluateExpressionGet(context, "#{parametrizacaoController}", ParametrizacaoController.class);
    }

    public AnoController() {
        // Inform the Abstract parent controller of the concrete Ano?cap_first Entity
        super(Ano.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqParameNivelEscolarController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of FechamentoAluno entities
     * that are retrieved from Ano?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for FechamentoAluno page
     */
    public String navigateFechamentoAlunoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FechamentoAluno_items", this.getSelected().getFechamentoAlunoList());
        }
        return "/pages/prime/fechamentoAluno/index";
    }

    /**
     * Sets the "selected" attribute of the Parametrizacao controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqParameNivelEscolar(ActionEvent event) {
        if (this.getSelected() != null && seqParameNivelEscolarController.getSelected() == null) {
            seqParameNivelEscolarController.setSelected(this.getSelected().getSeqParameNivelEscolar());
        }
    }

    /**
     * Sets the "items" attribute with a collection of DisciplinaAno entities
     * that are retrieved from Ano?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for DisciplinaAno page
     */
    public String navigateDisciplinaAnoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisciplinaAno_items", this.getSelected().getDisciplinaAnoList());
        }
        return "/pages/prime/disciplinaAno/index";
    }

    /**
     * Sets the "items" attribute with a collection of Turma entities that are
     * retrieved from Ano?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Turma page
     */
    public String navigateTurmaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Turma_items", this.getSelected().getTurmaList());
        }
        return "/pages/prime/turma/index";
    }

    /**
     * Sets the "items" attribute with a collection of Notas entities that are
     * retrieved from Ano?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Notas page
     */
    public String navigateNotasList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Notas_items", this.getSelected().getNotasList());
        }
        return "/pages/prime/notas/index";
    }

}
