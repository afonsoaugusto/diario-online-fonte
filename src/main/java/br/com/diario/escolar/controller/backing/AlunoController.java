package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Aluno;
import br.com.diario.escolar.view.session.AlunoFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

@ManagedBean(name = "alunoController")
@ViewScoped
public class AlunoController extends AbstractController<Aluno> {

    @EJB
    private AlunoFacade ejbFacade;

    /**
     * Initialize the concrete Aluno controller bean. The AbstractController
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

    public AlunoController() {
        // Inform the Abstract parent controller of the concrete Aluno?cap_first Entity
        super(Aluno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of AlunoTurma entities that
     * are retrieved from Aluno?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Presenca entities that
     * are retrieved from Aluno?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Presenca page
     */
    public String navigatePresencaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Presenca_items", this.getSelected().getPresencaList());
        }
        return "/pages/prime/presenca/index";
    }

    /**
     * Sets the "items" attribute with a collection of FechamentoAluno entities
     * that are retrieved from Aluno?cap_first and returns the navigation
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

    /**
     * Sets the "items" attribute with a collection of Notas entities that are
     * retrieved from Aluno?cap_first and returns the navigation outcome.
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
