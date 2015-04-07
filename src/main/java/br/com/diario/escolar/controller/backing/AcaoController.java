package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Acao;
import br.com.diario.escolar.view.session.AcaoFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

@ManagedBean(name = "acaoController")
@ViewScoped
public class AcaoController extends AbstractController<Acao> {

    @EJB
    private AcaoFacade ejbFacade;

    /**
     * Initialize the concrete Acao controller bean. The AbstractController
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

    public AcaoController() {
        // Inform the Abstract parent controller of the concrete Acao?cap_first Entity
        super(Acao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of FuncionalidadeAcao
     * entities that are retrieved from Acao?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for FuncionalidadeAcao page
     */
    public String navigateFuncionalidadeAcaoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FuncionalidadeAcao_items", this.getSelected().getFuncionalidadeAcaoList());
        }
        return "/pages/prime/funcionalidadeAcao/index";
    }
}
