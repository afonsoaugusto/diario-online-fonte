package br.com.diario.escolar.controller.backing;

import br.com.diario.escolar.model.entity.Pessoa;
import br.com.diario.escolar.view.session.PessoaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "pessoaController")
@ViewScoped
public class PessoaController extends AbstractController<Pessoa> {

    @EJB
    private PessoaFacade ejbFacade;
    private MunicipioController seqCidadeController;
    //private UsuarioController usuarioController;

    /**
     * Initialize the concrete Pessoa controller bean. The AbstractController
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
        seqCidadeController = context.getApplication().evaluateExpressionGet(context, "#{municipioController}", MunicipioController.class);
       // usuarioController = context.getApplication().evaluateExpressionGet(context, "#{usuarioController}", UsuarioController.class);
    }

    public PessoaController() {
        // Inform the Abstract parent controller of the concrete Pessoa?cap_first Entity
        super(Pessoa.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        seqCidadeController.setSelected(null);
        //usuarioController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Fechamento entities that
     * are retrieved from Pessoa?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Fechamento entities that
     * are retrieved from Pessoa?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Fechamento page
     */
    public String navigateFechamentoList1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Fechamento_items", this.getSelected().getFechamentoList1());
        }
        return "/pages/prime/fechamento/index";
    }

    /**
     * Sets the "selected" attribute of the Municipio controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSeqCidade(ActionEvent event) {
        if (this.getSelected() != null && seqCidadeController.getSelected() == null) {
            seqCidadeController.setSelected(this.getSelected().getSeqCidade());
        }
    }

    /**
     * Sets the "items" attribute with a collection of DisciplinaProfessor
     * entities that are retrieved from Pessoa?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DisciplinaProfessor page
     */
    public String navigateDisciplinaProfessorList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisciplinaProfessor_items", this.getSelected().getDisciplinaProfessorList());
        }
        return "/pages/prime/disciplinaProfessor/index";
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsuario(ActionEvent event) {
       // if (this.getSelected() != null && usuarioController.getSelected() == null) {
       //     usuarioController.setSelected(this.getSelected().getUsuario());
       // }
    }

    /**
     * Sets the "items" attribute with a collection of Turma entities that are
     * retrieved from Pessoa?cap_first and returns the navigation outcome.
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
     * retrieved from Pessoa?cap_first and returns the navigation outcome.
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
