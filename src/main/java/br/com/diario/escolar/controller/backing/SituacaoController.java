package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Situacao;
import br.com.diario.escolar.controller.session.SituacaoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

@ManagedBean(name = "situacaoController")
@ViewScoped
public class SituacaoController extends AbstractController<Situacao> {

    @EJB
    private SituacaoFacade ejbFacade;

    /**
     * Initialize the concrete Situacao controller bean. The AbstractController
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
    }

    public SituacaoController() {
        // Inform the Abstract parent controller of the concrete Situacao?cap_first Entity
        super(Situacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of AlunoTurma entities that
     * are retrieved from Situacao?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of FechamentoAluno entities
     * that are retrieved from Situacao?cap_first and returns the navigation
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
