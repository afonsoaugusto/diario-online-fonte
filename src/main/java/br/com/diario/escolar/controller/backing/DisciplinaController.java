package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Disciplina;
import br.com.diario.escolar.view.session.DisciplinaFacade;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;

@ManagedBean(name = "disciplinaController")
@ViewScoped
public class DisciplinaController extends AbstractController<Disciplina> {

    @EJB
    private DisciplinaFacade ejbFacade;

    /**
     * Initialize the concrete Disciplina controller bean. The
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
    }

    public DisciplinaController() {
        // Inform the Abstract parent controller of the concrete Disciplina?cap_first Entity
        super(Disciplina.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Fechamento entities that
     * are retrieved from Disciplina?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of Atividade entities that
     * are retrieved from Disciplina?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Atividade page
     */
    public String navigateAtividadeList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Atividade_items", this.getSelected().getAtividadeList());
        }
        return "/pages/prime/atividade/index";
    }

    /**
     * Sets the "items" attribute with a collection of Presenca entities that
     * are retrieved from Disciplina?cap_first and returns the navigation
     * outcome.
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
     * Sets the "items" attribute with a collection of AtuacaoProfessor entities
     * that are retrieved from Disciplina?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for AtuacaoProfessor page
     */
    public String navigateAtuacaoProfessorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("AtuacaoProfessor_items", this.getSelected().getAtuacaoProfessorList());
        }
        return "/pages/prime/atuacaoProfessor/index";
    }

    /**
     * Sets the "items" attribute with a collection of DisciplinaAno entities
     * that are retrieved from Disciplina?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DisciplinaAno page
     */
    public String navigateDisciplinaAnoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisciplinaAno_items", this.getSelected().getDisciplinaAnoList());
        }
        return "/pages/prime/disciplinaAno/index";
    }

}
